# Agama SMS

<!-- These are statistics for this repository-->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![Apache License][license-shield]][license-url]

This Agama Project uses OTP SMS to helps enhance security, reduce the risk of unauthorized access and fraud, and ensure compliance with regulatory requirements in various online services and transactions.
For more information you can also see: 
  - https://www.solutions4mobiles.com/product/mobile-number-verification


## Requirements

Agama Dependency: No dependency
Third Party Accounts: A Twilio Account with access to the settings


## Supported IDPs

## Flows

## Configuration

## Demo

Download the latest [agama-sms.gama](https://github.com/GluuFederation/agama-sms/releases/latest/download/agama-sms.gama) file and deploy it in Auth Sever.

Follow the steps below:

- Copy (SCP/SFTP) the agama-sms.gama file of this project to a location in your `Jans Server`
- Connect (SSH) to your `Jans Server` and open TUI: `python3 /opt/jans/jans-cli/jans_cli_tui.py`
- Navigate to the `Agama` tab and then select `"Upload project"`. Choose the gama file
- Wait for about one minute and then select the row in the table corresponding to this project
- Press `d` and ensure there were not deployment errors
- Pres `ESC` to close the dialog

## Configure Agama SMS 

- Create a json file(agama-sms-conf.json) somewhere on Jans Server with the following contains
    ```
        {
            "org.gluu.agama.sms.otp": {},
            "org.gluu.agama.sms.main": {
              "ACCOUNT_SID": "PUT_YOUR_TWILIO_ACCOUNT_SID_HERE",
              "AUTH_TOKEN": "PUT_YOUR_TWILIO_AUTH_TOKEN_HERE",
              "FROM_NUMBER": "PUT_YOUR_TWILIO_FROM_NUMBER_HERE"
            }
        }
    ```
- Fill the twilio settings accordingly
- Save the file
- Open TUI and navigate to `Agama`
- Select the deployed project(agama-sms) and hit `c`
- Select `Import sample configuration` and select a directory and a filename
- Select the config file edited above(agama-sms-conf.json)
- Press Ok

## Testing

[Jans-tarp](https://github.com/JanssenProject/jans/tree/main/demos/jans-tarp) can be used for a quick test

## Demonstration

# License

This project is licensed under the [Apache 2.0](https://github.com/GluuFederation/agama-sms/blob/main/LICENSE)

<!-- This are stats url reference for this repository -->

[contributors-shield]: https://img.shields.io/github/contributors/GluuFederation/agama-sms.svg?style=for-the-badge

[contributors-url]: https://github.com/GluuFederation/agama-sms/graphs/contributors

[forks-shield]: https://img.shields.io/github/forks/GluuFederation/agama-sms.svg?style=for-the-badge

[forks-url]: https://github.com/GluuFederation/agama-sms/network/members

[stars-shield]: https://img.shields.io/github/stars/GluuFederation/agama-sms?style=for-the-badge

[stars-url]: https://github.com/GluuFederation/agama-sms/stargazers

[issues-shield]: https://img.shields.io/github/issues/GluuFederation/agama-sms.svg?style=for-the-badge

[issues-url]: https://github.com/GluuFederation/agama-sms/issues

[license-shield]: https://img.shields.io/github/license/GluuFederation/agama-sms.svg?style=for-the-badge

[license-url]: https://github.com/GluuFederation/agama-sms/blob/main/LICENSE
