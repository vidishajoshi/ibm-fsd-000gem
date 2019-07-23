//dependencies
const express = require('express');
const parser = require('body-parser');
const itemRoutes = require('./routes/item').itemRoutes;
const productRoutes = require('./routes/products').productRoutes;
const setContentHeader = require('./services/util').setContentHeader;
const cors = require('cors');

//creating server
const server = express();

//injecting the parser 
server.use(parser.json());

//cors using
server.use(cors());

//adding status api
server.get('/status', (req, res) => {
    setContentHeader(res);
    res.end(JSON.stringify({
        message: 'server is started'
    }));
});

//mapping routers
server.use('/item', itemRoutes);
server.use('/products', productRoutes);

//port binding
const PORT = 3476;
server.listen(PORT, () => {
    console.log(`server is started at ${PORT}`);
})