const client = require('mongodb').MongoClient;
const UserConstants = require('./util.service').UserConstants;

class Service {
    // get all products
    fetchProducts(callback) {
            const _url = UserConstants.mongo.url + UserConstants.mongo.port;
            client.connect(_url, (err, connection) => {
                connection
                    .db(UserConstants.mongo.db)
                    .collection(UserConstants.mongo.collections.product)
                    .find()
                    .toArray((error, response) => {
                        callback(error, response);
                    });
            });
        } // end of fetch product

    //add products
    addProducts(_product, callback) {
        const _url = UserConstants.mongo.url + UserConstants.mongo.port;
        client.connect(_url, (err, connection) => {
            connection.db(UserConstants.mongo.db).collection(UserConstants.mongo.collections.product)
                .insert(_product, (err, resp) => {
                    callback(err, resp);

                })
        })
    }
}

module.exports = {
    ProductService: Service
}