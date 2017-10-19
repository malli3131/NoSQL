1. Query a point with in Polygon:

```
   db.polygons.find({geometry:{$geoIntersects:{$geometry:{type:"Point", coordinates:[77.669735, 12.909188]}}}})
```
