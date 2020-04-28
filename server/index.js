
const fs = require('fs');
const express = require('express');
const router = express.Router();
const bodyParser = require('body-parser');

/**
 * Load users.json
 */
var users = JSON.parse(fs.readFileSync('users.json', 'utf-8'));

router.get('/user/all', function (req, res, next) {
    res.status(200).json(users);
});

router.get('/user/:id', function (req, res, next) {

    var header = req.header('Content-Type');

    if (header != "application/json") {
        return res.status(406).json({});
    }

    var id = req.params.id;

    if (isEmpty(id)) {
        return res.status(500).json({error: 'id is empty'});
    }

    var user = findBy('_id', id);

    if (isEmpty(user)) {
        res.status(404).json({error: 'user not found'});
    }

    res.status(200).json(user);
});

router.post('/user', function (req, res, next) {
    var newuser = req.body;

    console.log(newuser);

    if (isEmpty(newuser)) {

    }

    if (isEmpty(newuser.email)) {

    }

    newuser._id = nextObjectId();

    users.push(newuser);

    res.status(201).json(newuser);
});

router.put('/user/:id', function (req, res, next) {
    var user = req.body;

    var id = req.params.id;

    if (isEmpty(id)) {
        return res.status(500).json({error: 'id is empty'});
    }

    res.status(201).json(newuser);
});

router.delete('/user/:id', function (req, res, next) {

    var id = req.params.id;

    if (isEmpty(id)) {
        return res.status(500).json({error: 'id is empty'});
    }

    res.status(200).json({});
});

function findBy(key, value) {
    var user = null;

    for (var i = 0, count = users.length; i < count; i++) {
        var u = users[i];
        if (u && u[key] == value) {
            user = u;
            break;
        }
    }

    return user;
}

/**
 * Genarate next ObjectId
 *
 * Thanks to: Grant Carthew, https://stackoverflow.com/questions/10593337/is-there-any-way-to-create-mongodb-like-id-strings-without-mongodb
 *
 */
function nextObjectId() {
    function objectId () {
        return hex(Date.now() / 1000) +
            ' '.repeat(16).replace(/./g, () => hex(Math.random() * 16))
    }

    function hex (value) {
        return Math.floor(value).toString(16)
    }

    return objectId();
}

/**
 * Validate value is null or empty string
 *
 * @param value
 * @returns {boolean}
 */
function isEmpty(value) {
    if (value == null) {
        return true;
    }

    if (typeof value === 'string' && value.length == 0) {
        return true;
    }

    if (value instanceof Date ) {
        if (value == 'Invalid Date') {
            return true;
        }
    }

    return false;
}

/**
 * Create app
 */
const app = express();

/**
 * Setup
 */
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

/**
 * Setup routes
 */
app.use('/api', router);

/**
 * Setup port
 */
const port = process.env.PORT || '3000';

/**
 * Start server
 */
app.listen(port, function () {
    console.log("Server listening on port " + port + " ...");
});