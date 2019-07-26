const router = require('express').Router();
const Service = require('../services/user_service').Service;
const service = new Service();

router.get('/status', (rq, rs) => {
    rs.status(200).json({
        message: 'User Service is running'
    });
});

//login api
router.get('/login', (rq, rs) => {
    rs.status(200).json({
        message: 'user logged in successfully!'
    });
});

//generate token
router.post('/token', (rq, rs) => {
    const userExists = service.isUser(rq.body.username, rq.body.pass);
    if (userExists) {
        const token = service.generateToken(userExists);
        rs.status(200).json({
            message: 'Token Generated successfully',
            token: token
        })
    } else {
        rs.status(400).json({
            message: 'Invalid User credentials'
        });
    }
});

module.exports.useRoutes = router;