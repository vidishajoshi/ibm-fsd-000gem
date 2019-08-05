const server = require('express').Router();
const PService = require('../services/product.service').ProductService;
const pService = new PService();

// apis
server.get('/status', (rq, rs) => {
    rs.status(200).json({
        message: 'Product Service is Running'
    });
});

server.get('/', (rq, rs) => {
    pService.fetchProducts((err, products) => {
        if (err) {
            rs.status(500).json({
                message: 'Unable to process your request'
            });
        } else {
            rs.status(200).json({
                products: products
            });
        }
    })
});

server.post('/addProducts', (rq, rs) => {
    pService.addProducts(rq.body, (error, res) => {
        if (error) {
            rs.status(500).json({
                message: 'Product can not be added'
            });

        } else {
            rs.status(200).json({
                products: res
            })
        }
    })
})
module.exports = {
    server
}