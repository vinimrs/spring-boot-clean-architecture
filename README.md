# Clean Architecture with Spring Boot

<img src="https://img.shields.io/github/license/vinimrs/VinChat?color=black" align="center" />

An analysis of a clean architecture implementation in a spring boot application. Checking the results of the merge of this two architectures. Comparing the code metrics of Spring Boot classical architecture and the result of the clean architecture applied to it.


## The target application

Project to implement a web application of a system for online bike rentals using the technologies **Java [Spring Boot] for the development of a [API REST]**, in order to contemplate the main responsibilities of a bicycle rental exploring and knowing better how the development of web systems works.
<p align="center">

   <img src="https://github.com/vinimrs/AA3/assets/92659173/a049e76c-6a65-4879-9793-effb81320359"  width="800"/>
   <p align="center">
      <i>Collection of requests for the API - Postman
</i>
    </p>
</p>

### Features

This system was based on the [requirements document](https://github.com/vinimrs/A3/blob/main/requisitos.pdf) proposed by the professor during the course.

- `Feature 1` `Users management`:  The system allows a super user (administrator) to manage (CRUD) all users of the system, such as rental companies and customers.
- `Feature 2` `Bikes rental`: The system allows customers to rent bicycles at a certain date from rentesCompanies available in the system.
- `Feature 3` `Browsing without login`: The system provides interfaces for non-logged in users to be able to use the system without a registration.
- `And more...`.

### Technologies

- [Spring Boot]
- [REST API]

## Common Spring Boot Architecture

The common architecture is an simple one, based on layers that communicate with a certain hierarchy between them, as can be seen below.

<p align="center">
  <img src="https://github.com/vinimrs/spring-boot-clean-architecture/assets/92659173/72604042-c0d1-41ae-b74b-9109f95f6839" />
     <p align="center">
      <i>Common spring boot architecture</i>
   </p>
</p>

The central idea is that it will have well-defined layers with vertical boundaries. But this idea is not being followed properly. In reality, some cyclic dependencies occur between layers, because many responsibilities are not well separated, making the code more coupled. 

Layers depend on others in a partial hierarchy and all layers depend on the structure code. And this can be negative for a few reasons:

1. The main rules of the domain are mixed with the details of the framework;
2. The code complexity of domain rules increases;
3. Changes to the structure directly affect the application code.

The application implemented is the [common project].

## Simplified Spring Boot Architecture with Clean Architecture

Trying to improve code organization, the clean architecture is a good start with that rules. We can arrive in an well-defined vertial boundaries, with a rigid hierarchy between the layers, the rules of the domain code is encapsulated of the framework code, and basically the code of the inner layers. 

<p align="center">
  <img src="https://github.com/vinimrs/spring-boot-clean-architecture/assets/92659173/b2093822-8aa2-4606-af36-1d2410a9b27f" />
  <p align="center">
      <i>Spring boot architecture with clean arhcitecture</i>
   </p>
</p>

The resulting architecture proposed for the application of Clean Architecture will contain 3 layers, they are: Infraestructure, Use case and Entity. In which follows a rigid hierarchy between the layers - the codes of the innermost layers do not know those of the outermost.

This architecture implemented is in the [simplified project].

[Spring Boot]: https://spring.io/projects/spring-boot
[API REST]: https://www.redhat.com/pt-br/topics/api/what-is-a-rest-api



