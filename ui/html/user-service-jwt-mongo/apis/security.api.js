const server = require('express').Router();
const UserService = require('../services/user.service').UserService;
const userService = new UserService();
const SecurityService = require('../services/security.service').SecurityService;
const securityService = new SecurityService();
const emailService = require('../services/email.service').emailService;
const emailObj = new emailService();
// apis
server.get('/status', (rq, rs) => {
    rs.status(200).json({
        message: 'Security Service is Running'
    });
});
// sign up
server.post('/register', (rq, rs) => {
    let user = rq.body;
    console.log(user);
    let date = new Date();
    const endTime = date.getMilliseconds() + 30000;

    const endTimeOtp = {
        endTimeOtp: endTime
    }

    const status = {
        status: 'invalid'
    }

    let _code = '!' + user.email[0] + '&' + user.name[0] + '@' + "879698";

    const code = {
        code: _code
    }

    user = Object.assign(user, endTimeOtp, status, code)
        //addUser
    userService.addUser(user, (err, res) => {
        if (err) {
            rs.status(402).json({
                message: 'Unable to proceess the request',
                trace: err
            });
        } else {

            let userObj = {
                from: null,
                to: rq.body.email,
                subject: 'Otp verification',
                body: `<div><h1>Welcome to the otp verification</h1><h3>Hey ${rq.body.name}, welcome to this
                otp verification.
                <br>Your Otp is : ${_code}.
                <br>Thank you for your time</h3>`
            }
            emailObj.emailSend(userObj);
            rs.status(200).json({
                message: 'User created successfully',
                users: res
            });
        }
    });
});

//generate new password 
server.post('/otp', (rq, rs) => {
    let email = rq.body.email;
    let code = rq.body.code;
    userService.accessUser(email, (err, res) => {
        if (err) {
            rs.status(401).json({
                message: 'Invalid id'
            })
        } else {
            let date = new Date();
            let currTime = date.getMilliseconds();
            if (res[0].code == code) {
                if (parseInt(res[0].endTimeOtp) >= parseInt(currTime)) {
                    userService.updateDetails(email, (err, response) => {
                        rs.status(200).json({
                            message: 'verification is done'
                        })
                    })
                } else {
                    rs.status(402).json({
                        message: 'time expired'
                    })
                }
            } else {
                rs.status(402).json({
                    message: 'wrong Otp'
                })
            }
        }
    })

})

// generate new token
server.post('/token', (rq, rs) => {
    if (rq.body.email == undefined || rq.body.password == undefined) {
        rs.status(401).json({
            message: 'Please specify valid credentials'
        });
    } else {
        userService.fetchUser(rq.body.email, rq.body.password, (err, res) => {
            if (err) {
                rs.status(401).json({
                    message: 'Please specify valid credentials'
                });
            } else {
                if (res) {
                    // generate jwt token
                    const _token = securityService.generateToken(rq.body.email, rq.body.permission);
                    const _user = {
                        id: 1,
                        token: _token,
                        email: rq.body.email,
                        permission: rq.body.permission
                    }
                    securityService.saveToken(_user, (err, data) => {
                        if (err) {
                            rs.status(401).json({
                                message: 'Unable to process your request'
                            });
                        } else {
                            rs.status(200).json({
                                message: 'Token Generated Successfully',
                                token: _token
                            });
                        }
                    });
                } else {
                    rs.status(401).json({
                        message: 'Please specify valid credentials'
                    });
                }
            }
        });
    }
});

server.post('/token/refresh', (rq, rs) => {
    if (rq.body.token == undefined) {
        rs.status(401).json({
            message: 'Please specify a valid token'
        });
    } else {
        securityService.refreshToken(rq.body.token, (err, data) => {
            if (err) {
                rs.status(403).json({
                    message: 'Token expired or Invalid'
                });
            } else {
                // generate jwt token
                const _token = securityService.generateToken(data.email);
                const _user = {
                    id: 1,
                    token: _token,
                    email: data.email
                }
                securityService.saveToken(_user, (err, data) => {
                    if (err) {
                        rs.status(401).json({
                            message: 'Unable to process your request'
                        });
                    } else {
                        rs.status(200).json({
                            message: 'Token refreshed Successfully',
                            refreshToken: _token
                        });
                    }
                });
            }
        });
    }
});

//password set api
server.post('/password', (rq, rs) => {
        userService.updatePassword(rq.body, (err, resp) => {
            rs.status(200).json({
                message: 'Password generated',
                data: resp
            })
        })
    })
    // redirect in case of invalid / no access
server.get('/unauthorize', (rq, rs) => {
    rs.status(403).json({
        message: 'Unauthorize Access'
    });
});

module.exports = {
    server
}