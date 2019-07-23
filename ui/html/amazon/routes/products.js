//dependencies
const routes = require('express').Router();
const Service = require('../services/item_service').Service;
const service = new Service();

//api for add the products
routes.post('/add', (rq, rs) => {
    rs.status(200).json({
        value: 'product',
        products: service._add(data)
    });

});

//api for display all the products
routes.get('/display', (rq, rs) => {
    rs.status(200).json({
        value: 'products',
        products: service.getAllProducts()
    });

});

//products next_api
routes.get('/nextId', (req, res) => {
    setContentHeader(res);
    res.end({
        nextId: service._nextId()
    });
});

module.exports.productRoutes = routes;