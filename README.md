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
Third Party Accounts: A Twilio Account with access to the settings.


## Supported IDPs

| IDP           | Description   |
| ------------- | ------------- |
| Jans Auth Server  | https://docs.jans.io/v1.1.0/admin/planning/  |


## Flows

| Qualified Name| Description   |
| ------------- | ------------- |
| org.gluu.agama.sms.main  | This is the main flow, it control the first factor of the authentication and trigger the second factor.|
| org.gluu.agama.sms.otp  | This flow collect OTP code from user and perform validation. When validation is done the result is send back to the main flow |


## Configuration

| Flow          | Property      | Value Description      |
| ------------- | ------------- |----------------------- | 
| org.gluu.agama.sms.main  | ACCOUNT_SID|Your twilio ACCOUNT_SID (available in your twilio account settings page)|
| org.gluu.agama.sms.main  | AUTH_TOKEN|Your twilio AUTH_TOKEN (available in your twilio account settings page)|
| org.gluu.agama.sms.main  | FROM_NUMBER|Your twilio FROM_NUMBER (available in your twilio account settings page)|

Sample JSON:

    ```
        {
            "org.gluu.agama.sms.otp": {},
            "org.gluu.agama.sms.main": {
              "ACCOUNT_SID": "PUT_YOUR_TWILIO_ACCOUNT_SID_HERE",
              "AUTH_TOKEN": "PUT_YOUR_TWILIO_AUTH_TOKEN_HERE",
              "FROM_NUMBER": "PUT_YOUR_TWILIO_FROM_NUMBER_HERE"
            }
        }

## Demo


## Contributors

<table>
 <tr>
  <td align="center" style="word-wrap: break-word; width: 150.0; height: 150.0">
    <a href=https://github.com/syntrydy>
        <img src="https://avatars.githubusercontent.com/u/7513418?v=4" width="100;"  style="border-radius:50%;align-items:center;justify-content:center;overflow:hidden;padding-top:10px" alt=Thomas Gasmyr>
        <br />
        <sub style="font-size:14px"><b>Mougang Gasmyr</b></sub>
    </a>
  </td>
 </tr>
</table>


## License

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
