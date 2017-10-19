1. Query a point with in Polygon:

```
> db.polygons.find({geometry:{$geoIntersects:{$geometry:{type:"Point", coordinates:[77.669735, 12.909188]}}}})
> db.geoPolygons.update({geometry:{$geoIntersects:{$geometry:{type:"Point", coordinates:[77.669735, 12.909188]}}}, "vehicleId":"e123", "status":true, "current_status":"inside"}, {"current_status":"outside"}, {"upsert":true})

> db.geoPolygons.find({geometry:{$geoIntersects:{$geometry:{type:"Point", coordinates:[77.669735, 12.909188]}}}, "vehicleId":"e123", "status":true, "current_status":"inside"})
```
