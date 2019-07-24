//dependencies
const routes = require('express').Router();
const Service = require('../services/item_service').Service;
const products = require('../db/products').products;
const service = new Service();

//api for add the products
routes.post('/add', (rq, rs) => {
    // rs.end(JSON.stringify(rq.body));
    rs.end(JSON.stringify({
        products: service._add(rq.body)
    }));
    // console.log(products);

});

//api for display all the products
routes.get('/display', (rq, rs) => {
    rs.end(JSON.stringify({
        products: service.getAllProducts()
    }));

});

//products next_api
routes.get('/nextId', (req, res) => {
    setContentHeader(res);
    res.end({
        nextId: service._nextId()
    });
});

//update cart api
routes.get('/update', (rq, rs) => {
    setContentHeader(rs);
    rs.end(JSON.stringify({
        products: service._update(rq.body)
    }));
})

module.exports.productRoutes = routes;