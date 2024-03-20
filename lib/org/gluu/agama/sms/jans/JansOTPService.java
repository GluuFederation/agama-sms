package org.gluu.agama.sms.jans;

import com.twilio.Twilio;
import org.gluu.agama.sms.OTPService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import io.jans.as.common.model.common.User;
import io.jans.as.common.service.common.EncryptionService;
import io.jans.as.common.service.common.UserService;
import io.jans.service.cdi.util.CdiUtil;
import io.jans.as.server.service.AuthenticationService;
import io.jans.agama.engine.service.FlowService;

import java.security.SecureRandom;
import java.util.HashMap;

public class JansOTPService extends OTPService {

    private static final Logger logger = LoggerFactory.getLogger(FlowService.class);
    private static AuthenticationService authenticationService = CdiUtil.bean(AuthenticationService.class);
    private HashMap<String, String> userCodes = new HashMap<>();
    private HashMap<String, String> flowConfig;
    private static UserService userService = CdiUtil.bean(UserService.class);
    private static final String USERNAME = "uid";

    public static final int OTP_CODE_LENGTH = 6;

    public JansOTPService(HashMap config) {
        flowConfig = config;
        logger.debug("Flow config provided is  {}.", config);
    }

    public JansOTPService() {
    }

    @Override
    public boolean validateCreds(String username, String password) {
        logger.info("Validating user credentials {}.", username);
        return authenticationService.authenticate(username, password);
    }

    @Override
    public String sendOTPCode(String username) {
        try {
            logger.info("Sending OTP Code via SMS to {}.", username);
            String phone = getUserPhoneNumber(username);
            String maskedPone = maskPhone(phone);
            String otpCode = generateOTpCode(OTP_CODE_LENGTH);
            logger.info("Generated OTP code is {}.", otpCode);
            String message = "Hi " + username + ", Welcome to AgamaLab. This is your OTP Code to complete your login process: " + otpCode;
            associateGeneratedCodeToUser(username, otpCode);
            sendTwilioSms(username, phone, message);
            return maskedPone;
        } catch (Exception exception) {
            logger.error("Error occur while sending  OTP code via SMS to {}. Error {}.", username, exception);
            return null;
        }
    }

    @Override
    public boolean validateOTPCode(String username, String code) {
        try {
            logger.info("Validating OTP code {} provided by {}.", code, username);
            String storeCode = userCodes.getOrDefault(username, "NULL");
            if (storeCode.equalsIgnoreCase(code)) {
                userCodes.remove(username);
                return true;
            }
            return false;
        } catch (Exception exception) {
            logger.info("OTP code {} provided by {} is not valid. Error: {} ", code, username, exception);
            return false;
        }
    }

    private String generateOTpCode(int codeLength) {
        String numbers = "0123456789";
        SecureRandom random = new SecureRandom();
        char[] otp = new char[codeLength];
        for (int i = 0; i < codeLength; i++) {
            otp[i] = numbers.charAt(random.nextInt(numbers.length()));
        }
        return new String(otp);
    }

    private String getUserPhoneNumber(String username) {
        User currentUser = getUser(USERNAME, username);
        String phoneNumber = currentUser.getAttribute("mobile");
        if (phoneNumber == null) {
            phoneNumber = currentUser.getAttribute("telephoneNumber");
        }
        return phoneNumber;
    }

    private User getUser(String attributeName, String value) {
        return userService.getUserByAttribute(attributeName, value, true);
    }

    private boolean associateGeneratedCodeToUser(String username, String code) {
        try {
            userCodes.put(username, code);
            return true;
        } catch (Exception exception) {
            logger.error("Error associating OTP SMS code to user {}, error: {} .", username, exception);
            return false;
        }
    }

    private String maskPhone(String phone) {
        if (phone == null) {
            return null;
        }
        int maskLength = phone.length() - 6;
        if (maskLength <= 0)
            return phone;
        return phone.substring(0, 4) + "x".repeat(maskLength) + phone.substring(phone.length() - 3);
    }

    private boolean sendTwilioSms(String userName, String phone, String message) {
        try {
            PhoneNumber FROM_NUMBER = new com.twilio.type.PhoneNumber(flowConfig.get("FROM_NUMBER"));
            PhoneNumber TO_NUMBER = new com.twilio.type.PhoneNumber(phone);
            Twilio.init(flowConfig.get("ACCOUNT_SID"), flowConfig.get("AUTH_TOKEN"));
            Message.creator(TO_NUMBER, FROM_NUMBER, message).create();
            logger.info("OTP code has been successfully send to {} on phone number {} .", userName, phone);
            return true;
        } catch (Exception exception) {
            logger.error("Error sending OTP code to user {} on pone number {} : error {} .", userName, phone, exception);
            return false;
        }
    }

}
