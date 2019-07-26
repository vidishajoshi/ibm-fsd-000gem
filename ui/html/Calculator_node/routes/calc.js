//dependencies
const routes = require('express').Router();
const Calculator = require('../services/calc_service').Calculator;
const calc = new Calculator();
const Service = require('../services/user_service').Service;
const service = new Service();
const validate = require('../services/security_service').validate;

//status api
routes.get('/status', (rq, rs) => {
    rs.status(200).json({
        message: 'User Service is running'
    });
});

routes.use('/add/:num1/:num2', (rq, rs, next) => {
        validate(rq, rs, next);
    })
    //add api
routes.get('/add/:num1/:num2', (rq, rs) => {
    rs.setHeader('content-type', 'application/json');
    rs.end(JSON.stringify({
        result: calc._add(parseInt(rq.params.num1), parseInt(rq.params.num2))
    }))
})

routes.use('/diff/:num1/:num2', (rq, rs, next) => {
    validate(rq, rs, next);
})

//add api
routes.get('/diff/:num1/:num2', (rq, rs) => {
    rs.setHeader('content-type', 'application/json');
    rs.end(JSON.stringify({
        result: calc._sub(parseInt(rq.params.num1), parseInt(rq.params.num2))
    }))
})

routes.use('/mul/:num1/:num2', (rq, rs, next) => {
    validate(rq, rs, next);
})

//mul api
routes.get('/mul/:num1/:num2', (rq, rs) => {
    rs.setHeader('content-type', 'application/json');
    rs.end(JSON.stringify({
        result: calc._mul(parseInt(rq.params.num1), parseInt(rq.params.num2))
    }))
})

module.exports.calcRoutes = routes;