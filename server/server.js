var express = require('express');
var bodyParser = require('body-parser');
var fs = require('fs');

const PRELOAD_JSON = 'data/preload.json';
const TREES_JSON = 'data/trees.json';

var app = express();
app.use(bodyParser.json())
app.listen(3000, () => {
    console.log("Server running on port 3000");
});

app.get("/preload", (req, res, next) => {
    var data = JSON.parse(fs.readFileSync(PRELOAD_JSON, 'utf8'));

    res.json(data);
});

app.get("/getTreesByIds", (req, res, next) => {
    var data = JSON.parse(fs.readFileSync(TREES_JSON, 'utf8'));
    var ids = req.body.ids;

    var filteredData = data.filter(item => ids.includes(item.id));

    res.json(filteredData);
});
