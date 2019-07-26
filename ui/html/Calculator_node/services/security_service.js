const Service = require('../services/user_service').Service;
const service = new Service();

//validate function
const validate = (rq, rs, next) => {
    const token = rq.headers.token;
    if (token) {
        const isValid = service.validToken(token);
        if (isValid) {
            next();
        } else {
            rs.redirect('/unauthorize');

        }
    } else {
        rs.redirect('/unauthorize');
    }
}

module.exports.validate = validate;