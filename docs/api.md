API Documentation
=================

A variable, or parameter is described as :name:, and for all calls
to the API an optional forward-slash at the end can be added, hence:
```
api/last/5/measurements
```
is equal to
```
api/last/5/measurements/
```

api/since/:unixtime:
--------------------

```
api/since/:unixtime:
```

### Example
```
curl http://veiset.org:4567/api/since/1303034030000
[{"time":1353929840931,"weight":109},{"time":1353929841930,"weight":108},...,{"time":1353929845930,"weight":108},{"time":1353929846930,"weight":105},{"time":1353929847930,"weight":106}]
```

api/last/:number:/:unit:
------------------------

```
api/last/:number:
```

```
api/last/:number:/measurements
```

```
api/last/:number:/seconds
```

```
api/last/:number:/minutes
```

```
api/last/:number:/hours
```

```
api/last/:number:/days
```


### Example
```
curl http://veiset.org:4567/api/last/3/measurements
[{"time":1353929983930,"weight":104},{"time":1353929982930,"weight":104},{"time":1353929981930,"weight":104}]
```
