# Cake REST microservice - sample code

## Running info:

```
mvn spring-boot:run
```

## OAuth2 info:

### Getting OAuth2 authorization token:

```
curl -X POST \
  http://localhost:8080/oauth/token \
  -H 'authorization: Basic cmVhZC1jbGllbnQ6cmVhZDEyMw==' \
  -F grant_type=password \
  -F username=guest \
  -F password=guest \
  -F client_id=read-client
```

### Accessing endpoint with authorization token

```
curl -X GET \
  http://localhost:8000/v2/cakes \
  -H 'authorization: Bearer 76da9193-1324-408a-a1bd-4ab5484c45df'
```



## Cake REST microservice API:

/v1/** - for this pattern of resource path yo udon't need authotization
/v2/** - for this pattern of resource path yo need OAuth2 authotization

### Getting all cakes

```
curl -X GET \
  http://localhost:8000/v1/cakes \


curl -X GET \
  http://localhost:8000/v2/cakes \
  -H 'authorization: Bearer 76da9193-1324-408a-a1bd-4ab5484c45df'
```

### Getting particualr cake

```
curl -X GET \
  http://localhost:8000/v1/cakes/1 \


curl -X GET \
  http://localhost:8000/v2/cakes/1 \
  -H 'authorization: Bearer 76da9193-1324-408a-a1bd-4ab5484c45df'
```

### Adding new cake into the system(The impl should be extended to accepting JSON obj also)

```
curl -X POST \
  http://localhost:8000/v1/cakes \
  -F title=Lemon%20cheesecake \
  -F desc=A%20cheesecake%20made%20of%20lemon \
  -F imageUrl=https%3A%2F%2Fs3-eu-west-1.amazonaws.com%2Fs3.mediafileserver.co.uk%2Fcarnation%2FWebFiles%2FRecipeImages%2Flemoncheesecake_lg.jpg

curl -X POST \
  http://localhost:8000/v2/cakes \
  -H 'authorization: Bearer 76da9193-1324-408a-a1bd-4ab5484c45df' \
  -F title=Lemon%20cheesecake \
  -F desc=A%20cheesecake%20made%20of%20lemon \
  -F imageUrl=https%3A%2F%2Fs3-eu-west-1.amazonaws.com%2Fs3.mediafileserver.co.uk%2Fcarnation%2FWebFiles%2FRecipeImages%2Flemoncheesecake_lg.jpg
```
