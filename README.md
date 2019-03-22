# Cake REST microservice - code sample

## Running info:

```
mvn spring-boot:run
```

## Authentication info:

```
admin/admin
guest/guest
```

## OAuth2 authorization info:

```
read-client/read123
read-write-client/write123
```

### Getting OAuth2 authorization token:

```
curl -i -X POST http://localhost:8000/oauth/token \
   -H 'authorization: Basic cmVhZC13cml0ZS1jbGllbnQ6d3JpdGUxMjM=' \
   -F grant_type=password \
   -F username=admin \
   -F password=admin \
   -F client_id=read-write-client
```

### Accessing endpoint with authorization token

```
curl -i -X GET http://localhost:8000/api/services/1/cakes \
    -H 'Content-Type: application/json' \
    -H 'authorization: Bearer 93f74651-dbbc-4ec9-8239-dcdb28554931'
```

## Cake REST microservice API:

### Getting all cakes

```
curl -i -X GET http://localhost:8000/api/services/1/cakes \
    -H 'Content-Type: application/json' \
    -H 'authorization: Bearer 93f74651-dbbc-4ec9-8239-dcdb28554931'
```

### Getting particular cake

```
curl -i -X GET http://localhost:8000/api/services/1/cakes/1 \
    -H 'Content-Type: application/json' \
    -H 'authorization: Bearer 93f74651-dbbc-4ec9-8239-dcdb28554931'
```

### Adding new cake into the system

```
curl -i -X POST http://localhost:8000/api/services/1/cakes \
    -H 'Content-Type: application/json' \
    -H 'authorization: Bearer 93f74651-dbbc-4ec9-8239-dcdb28554931' \
    -d '{"title": "Lemon cheesecake", \
         "desc": "A cheesecake made of lemon", \
         "image": "https://s3-eu-west-1.amazonaws.com/s3.mediafileserver.co.uk/carnation/WebFiles/RecipeImages/lemoncheesecake_lg.jpg" \
        }'
```
