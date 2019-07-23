//file for setting header to json 
const setContentHeader = (res) => {
    res.setHeader('content-type', 'application/json');
};

module.exports.setContentHeader = setContentHeader;