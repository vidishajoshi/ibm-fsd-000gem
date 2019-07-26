const User = require('../db/user').User;
const jwt = require('jsonwebtoken');
const key = require('../keys/private').private_key;

class Service {
    constructor() {
        this.userTokens = new Map();
        this.User = User;
    }
    isUser(username, pass) {
        return this.User.find((u) => {
            return u.username == username && u.pass == pass;
        });
    }
    generateToken(User) {
        const data = {
            username: User.username,
            pass: User.pass
        }
        const token = jwt.sign(data, key, { expiresIn: '2m' })

        return token;
    }
    validToken(token) {
        let isValid = false;
        try {
            isValid = jwt.verify(token, key);
        } catch (error) {
            console.error(error);
        }
        return isValid;
    }

}

module.exports.Service = Service;