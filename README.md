# SpringBoot-AngularJs-Seed -- the seed for SpringBoot & AngularJS apps
This project is an application skeleton for a SpringBoot & AngularJS web app. You can use it to quickly bootstrap your web app projects or a java microservice.

## Dependencies
### Back-end Microservice
* `spring-boot-starter-web` to create a stand-alone Spring applications
* `spring-boot-starter-data-jpa` to access database with JPA
* `MySQL` the Java SQL database
* `spring-boot-starter-test` to create a Spring Unit test

### Front-end
* `angularjs` the popular JavaScript-based front-end web application framework
* `ng-table` simple table with sorting and filtering on AngularJS
* `restangular` AngularJS service that simplifies common GET, POST, DELETE, and UPDATE requests
* `bootstrap` the popular HTML, CSS, and JS framework for developing responsive, mobile first projects

## Getting started
To get you started you can simply clone this repository and install the dependencies.
### Prerequisites
* JDK 1.8
* Maven 3.0+
* Eclipse or other IDE

### Build the package
```
mvn clean package
```
### Run the application
```
java -jar webapp-springboot-angularjs-seed.jar
```
then browse to the app at http://localhost:8080/index.html

```

## RESTful APIs
* get info of all users
`GET /users`
* create a new user
`POST /users`
* get a user
`GET /users/{id}`
* update a user
`PUT /users/{id}`
* delete a user
`DELETE /users/{id}`
* Request Parameters
    * JSON format: `{"name":"string","age":int}`
* Response Messages
    * Success
        * 200 OK
    * Failure
        * 400 Bad Request
        * 404 User Not Found or Not Found
        * 500 Internal Server Error
