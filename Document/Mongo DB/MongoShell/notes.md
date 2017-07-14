## Java Script Mongo Database Examples:
```javascript
db.stocks.count()
db.stocks.find({open : {$gt: 30.0}})
db.stocks.find({open : {$gt: 30.0, $lt : 35.0}})
db.stocks.find({}, {stock:1, volume:1})
db.stocks.find({stock:"CLI"}, {stock:1, volume:1, _id:0})
db.stocks.find({stock:"CLI", open: {$gt: 10.0}}, {stock:1, volume:1, _id:0})
db.stocks.find({$or:[{stock:"CLI"}, {open: {$gt: 60.0}}]}, {stock:1, volume:1, _id:0, open:1})
db.stocks.find({stock: {$regex: /CA/}})
db.stocks.find({stock: {$regex: /^CA/}})
db.stocks.distinct("stock")
db.stocks.find({}).limit(10)
db.stocks.find({}).limit(10).skip(5)


var map = function() {emit(this.stock, this.volume)};
var reduce = function(key, values){ var total = 0; for(var i = 0; i < values.length; i++){ total += values[i] } return total }
db.stocks.mapReduce(map, reduce, {"out" : "volume"})
db.volume.find().sort({"value":-1}).limit(10)
```
