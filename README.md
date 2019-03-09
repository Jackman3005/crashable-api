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


## Postman
I have provided a simple [Postman](https://www.getpostman.com/) collection
with requests for each endpoint locally and on the public test environment.
Available [here](Crashable-API.postman_collection.json). See [importing postman data](https://learning.getpostman.com/docs/postman/collections/data_formats/#importing-postman-data)
for help using this collection.

## Notes

This API is publicly hosted on the [PCF](https://pivotal.io/platform)
platform at [https://crashable-api.cfapps.io](https://crashable-api.cfapps.io)
which can be used for testing. If you send the signal for this application to crash,
PCF will automatically detect the crashed app and restart it. This usually takes
up to 10 seconds.

If this is interesting or valuable to you, feel free to clone/fork
the repo for your own use and/or give feedback in GitHub issues. Pull requests
are welcome.