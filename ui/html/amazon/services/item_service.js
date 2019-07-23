//dependencies
const item = require('../db/item').item;
const products = require('../db/products').products;

//class service for basic functionalities
class Service {
    constructor() {
        this.item = item;
        this.products = products;
    }
    getAllItem() {
        return this.item;
    }
    _add(product) {
        this.products.push(product);
        return this.products;
    }
    _nextId() {
        return this.products.length + 1;
    }
    getAllProducts() {
        return this.products;
    }
}

module.exports.Service = Service;