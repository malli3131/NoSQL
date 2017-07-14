

```python
import pymongo as pm
```


```python
mongo = pm.MongoClient("mongodb://localhost:27017")
```


```python
database = mongo.get_database("nyse")
```


```python
col = database.get_collection("stocks")
```


```python
print database.name
```

    nyse



```python
print col.name
```

    stocks



```python
file = "/Users/nagainelu/bigdata/jobs/stocks"
```


```python
fr = open(file, 'r')
data = fr.readlines()
```


```python
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
```


```python
cursor = database.stocks.aggregate([{"$group":{"_id":"$stock", "aggvolume":{"$sum":"$volume"}}}])
```


```python
fw = open("/Users/nagainelu/bigdata/jobs/aggvolume", "w")
for line in cursor:
    record = line.get("_id") + "\t" + str(line.get("aggvolume")) + "\n"
    fw.write(record)
```


```python

```
