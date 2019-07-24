//dependencies
const express = require('express');
const parser = require('body-parser');
const itemRoutes = require('./routes/item').itemRoutes;
const productRoutes = require('./routes/products').productRoutes;
const setContentHeader = require('./services/util').setContentHeader;
const cors = require('cors');
const Email = require('./services/email_services').Email;
const email_services = new Email();

//creating server
const server = express();

//injecting the parser 
server.use(parser.json());

//cors using
server.use(cors());

//api for email 
server.post('/email', (rq, rs) => {
    setContentHeader(rs);
    console.log(rq.body);
    email_services.emailWithAttachment(rq.body);
    rs.status(200).json({
        message: 'Service is running'
    });
});

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