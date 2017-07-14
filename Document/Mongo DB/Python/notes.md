

```python
import pymongo as pm
from bson.code import Code

mongo = pm.MongoClient("mongodb://localhost:27017")
database = mongo.get_database("nyse")
col = database.get_collection("stocks")
print database.name
print col.name
file = "/Users/nagainelu/bigdata/jobs/stocks"
fr = open(file, 'r')
data = fr.readlines()
i = 0
for line in data:
    cols = line.split("\t")
    if len(cols) == 9:
        #print("The length :{}".format(len(cols)))
        i = i + 1
        document = {}
        document['_id'] = i
        document['market'] = cols[0]
        document['stock'] = cols[1]
        document['date'] = cols[2]
        document['open'] = float(cols[3])
        document['high'] = float(cols[4])
        document['low'] = float(cols[5])
        document['close'] = float(cols[6])
        document['volume'] = int(cols[7])
        document['adj_close'] = float(cols[8])
        col.insert_one(document)
# Aggregations using aggregate
cursor = database.stocks.aggregate([{"$group":{"_id":"$stock", "aggvolume":{"$sum":"$volume"}}}])
fw = open("/Users/nagainelu/bigdata/jobs/aggvolume", "w")
for line in cursor:
    record = line.get("_id") + "\t" + str(line.get("aggvolume")) + "\n"
    fw.write(record)
# Aggregations using mapreduce
map = Code("""function(){emit(this.stock, this.volume)}""")
reduce = Code("""function(key, values) { var total = 0; for(var i = 0; i < values.length; i++){ total += values[i]} return total }""")
result = database.stocks.map_reduce(map, reduce, "myresults")

# Reading data from myresults collection
records = database.get_collection("myresults").find().sort([('value', pm.ASCENDING)])
for record in records:
    print record
```
