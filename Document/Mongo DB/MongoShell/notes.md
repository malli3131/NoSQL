## Java Script Mongo Database Examples:
```javascript
var map = function() {emit(this.stock, this.volume)};
var reduce = function(key, values){ var total = 0; for(var i = 0; i < values.length; i++){ total += values[i] } return total }
db.stocks.mapReduce(map, reduce, {"out" : "volume"})
db.volume.find().sort({"value":-1}).limit(10)
```
