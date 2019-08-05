const client = require('mongodb').MongoClient;
const UserConstants = require('./util.service').UserConstants;
const jwt = require('jsonwebtoken');

class Service {
    // authorize
    authorize(request, response, next) {
            const _token = request.headers.token;
            // const _per = request.headers.permission;
            if (!_token) {
                // stop access
                response.redirect('/auth/unauthorize');
            } else {
                const _tokenDetails = this.verifyToken(_token);
                if (_tokenDetails) {
                    // continue the flow
                    const _path = request.baseUrl + request.path;
                    if (_tokenDetails.permission == _path) {
                        next();
                    } else {
                        response.redirect('/auth/unauthorize');
                    }

                } else {
                    // stop access
                    response.redirect('/auth/unauthorize');
                }
            }
        }
        // verify token
    verifyToken(_token) {
            let validToken = false;
            try {
                const isValid = jwt.verify(_token, UserConstants.jwt.key);
                if (isValid) {
                    validToken = isValid;
                }
            } catch (error) {

            }
            return validToken;
        }
        // create jwt token 
    generateToken(email, permission) {
        const _token = jwt.sign({
                email: email,
                permission: permission
            },
            UserConstants.jwt.key, {
                expiresIn: '1200000ms'
            });
        return _token;
    }
    saveToken(_user, callback) {
            const _url = UserConstants.mongo.url + UserConstants.mongo.port;
            client.connect(_url, (err, connection) => {
                const id = _user.id;
                delete _user.id;
                connection
                    .db(UserConstants.mongo.db)
                    .collection(UserConstants.mongo.collections.security)
                    .update({ _id: id }, { $set: _user }, { upsert: true },
                        (error, response) => {
                            callback(error, response);
                        });
            });
        } // end of save Token

    // refresh an existing token if valid
    refreshToken(_token, callback) {
            const _user = this.verifyToken(_token);
            if (_user) {
                this.fetchTokenDetails(_token, _user.email, (err, data) => {
                    callback(err, data);
                });
            }
        } // end of refresh Token
    fetchTokenDetails(_token, _email, callback) {
        client.connect(UserConstants.mongo.url + UserConstants.mongo.port, (err, conn) => {
            conn
                .db(UserConstants.mongo.db)
                .collection(UserConstants.mongo.collections.security)
                .find({ _token: _token, email: _email })
                .toArray((error, data) => {
                    callback(error, data);
                });
        });
    }
}

module.exports = {
    SecurityService: Service
}