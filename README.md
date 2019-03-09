# Crashable API

This API was developed to test an application runtime platform's 
ability to restart crashed applications.


## Endpoints

### `GET /hello`
Returns a message confirming the API is running.

### `GET /crash`
This will request the API to immediately shutdown without waiting for other
processes to complete. It returns "OK" to the caller first.

### `GET /doSomething/{seconds}`
Simulates a long running process that will run for the given number of seconds.

e.g. `/doSomething/15` will take 15 seconds to return to the caller.


## Notes

This API is publicly hosted at [https://crashable-api.cfapps.io](https://crashable-api.cfapps.io)
which can be used for testing.

If this is interesting or valuable to you, feel free to clone/fork
the repo for your own use and/or give feedback in GitHub issues. Pull requests
are welcome.