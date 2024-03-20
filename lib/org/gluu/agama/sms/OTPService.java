package org.gluu.agama.sms;

import org.gluu.agama.sms.jans.JansOTPService;

import java.util.HashMap;


public abstract class OTPService {

    public abstract boolean validateCreds(String username, String password);

    public abstract String sendOTPCode(String username);

    public abstract boolean validateOTPCode(String username, String code);

    public static OTPService getInstance(HashMap config){
        return  new JansOTPService(config);
    }
}

