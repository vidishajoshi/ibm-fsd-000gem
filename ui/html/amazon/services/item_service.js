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
    _add(products) {
        this.products.push(products);
        // console.log(products);
        return this.products;

    }
    _nextId() {
        return this.products.length + 1;
    }
    getAllProducts() {
        return this.products;
    }
    _update() {

    }
}

module.exports.Service = Service;