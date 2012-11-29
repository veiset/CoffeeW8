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

API Calls
---------

```
API Call:    api/since/:unixtime:
 Example:    api/since/1303034030000
 Returns:    [{"time":1353929840931,"weight":109},..,{"time":1353929847930,"weight":106}]
    Type:    Array of (Unixtime, Int) tuples
```

```
API Call:    api/last/:measurements:
 Example:    api/last/2
 Returns:    [{"time":1353929983930,"weight":104},{"time":1353929982930,"weight":104}]
    Type:    Array of (Unixtime, Int) tuples
```

```
API Call:    api/last/:measurements:/measurements
 Example:    api/last/2/measurements
 Returns:    [{"time":1353929983930,"weight":104},{"time":1353929982930,"weight":104}]
    Type:    Array of (Unixtime, Int) tuples
```

```
API Call:    api/last/:seconds:/seconds
 Example:    api/last/2/seconds
 Returns:    [{"time":1353929983930,"weight":104}]
    Type:    Array of (Unixtime, Int) tuples
```

```
API Call:    api/last/:seconds:/minutes
 Example:    api/last/2/minutes
 Returns:    [{"time":1353929983930,"weight":104}]
    Type:    Array of (Unixtime, Int) tuples
```
```
API Call:    api/last/:seconds:/hours
 Example:    api/last/2/hours
 Returns:    [{"time":1353929983930,"weight":104}]
    Type:    Array of (Unixtime, Int) tuples
```
```
API Call:    api/last/:seconds:/days
 Example:    api/last/2/days
 Returns:    [{"time":1353929983930,"weight":104}]
    Type:    Array of (Unixtime, Int) tuples
```


