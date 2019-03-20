# Cake REST microservice

Run info:
=========
Running a server locally:
mvn spring-boot:run

Cake REST microservice API:
============================
1. Getting all cakes
Exampl
GET  http://localhost:8000/v1/cakes

2. Getting particualr cake
Pattern
GET  http://localhost:8000/v1/cakes/{id}
Example
GET  http://localhost:8000/v1/cakes/1

3. Adding new cake into the system(The impl should be extended to accepting JSON obj also)
Pattern
POST http://localhost:8000/v1/cakes?title={titleValue}&desc={descriptionValue}&imageUrl={imaveUrl}
Example
POST http://localhost:8000/v1/cakes?title=Lemon%20cheesecake&desc=A%20cheesecake%20made%20of%20lemon&imageUrl=https%3A%2F%2Fs3-eu-west-1.amazonaws.com%2Fs3.mediafileserver.co.uk%2Fcarnation%2FWebFiles%2FRecipeImages%2Flemoncheesecake_lg.jpg


Technical endpoints:
====================
http://localhost:8000/h2-console