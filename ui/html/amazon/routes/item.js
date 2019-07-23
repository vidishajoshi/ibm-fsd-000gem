//dependencies
const routes = require('express').Router();
const Service = require('../services/item_service').Service;
const service = new Service();

//status api
routes.get('/status', (rq, rs) => {
    rs.status(200).json({
        message: 'User Service is running'
    });
});

//api for display all the items
routes.get('/display', (rq, rs) => {
    rs.status(200).json({
        value: 'item',
        item: service.getAllItem()
    });

});

module.exports.itemRoutes = routes;