//dependencies
const express = require('express');
const parser = require('body-parser');
const cors = require('cors');
const calcRoutes = require('./routes/calc').calcRoutes;
const useRoutes = require('./routes/user').useRoutes;
//creating server
const server = express();

//injecting the parser
server.use(parser.json());

//adding cors to the server
server.use(cors());

//mapping routes
server.use('/calc', calcRoutes);
server.use('/user', useRoutes);

//adding status api 
server.get('/status', (req, res) => {
    res.setHeader('content-type', 'application/json');
    res.end(JSON.stringify({
        message: 'Server is running !'
    }));
});

//unauthorized acess
server.get('/unauthorize', (rq, rs) => {
    rs.status(401).json({
        message: 'Unauthorize Access'
    });
});

//validating token api
server.use('/validate', (rq, rs, next) => {
    Validite(rq, rs, next);
});

//port binding
const port1 = 2564;
server.listen(port1, () => {
    console.log(`Server is started at port :${port1}`);
})