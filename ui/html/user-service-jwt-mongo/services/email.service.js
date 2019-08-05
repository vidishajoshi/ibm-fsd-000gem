const nodemailer = require('nodemailer');
const utilEmail = require('./emailUtil').emailUtil;

class Email {
    constructor() {
        this.smtpSetup = {
                service: utilEmail.smtp.provider,
                auth: {
                    user: utilEmail.smtp.address,
                    pass: utilEmail.smtp.password
                }
            }
            // configure the smtp settings
        this.mailer = nodemailer.createTransport(this.smtpSetup);
    }
    emailSend(userObj) {
        console.log(userObj);
        // in case sender isnt mentioned
        if (userObj.from == null) {
            userObj.from = utilEmail.smtp.address;
        }
        this.mailer.sendMail({
            from: userObj.from,
            to: userObj.to,
            subject: userObj.subject,
            html: userObj.body,
        }, (err, response) => {
            if (err) {
                console.log(err);
                return "Unable to send email";
            } else {
                console.log('Email Sent');
                return "Email Sent Successfully";
            }
        })
    }
}
module.exports.emailService = Email;