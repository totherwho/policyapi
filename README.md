# CPR Policy Search Api

## Overview

Policy search API in response to: https://climatepolicyradar.notion.site/Software-Engineer-Technical-Task-25dd74893e49490b975301c5045d736d

Simple REST API on top of Postgresql and utilising Postgresql full text capabilities.

## Usage

### Requirements

* JDK 11 (https://openjdk.java.net/projects/jdk/11/)
* Maven (https://maven.apache.org/users/index.html)
* Postgres 10 (https://www.postgresql.org/docs/10/index.html)

### Installation

Clone repo:
```
 git clone https://github.com/totherwho/policyapi.git
 cd policyapi
```

Add some config

```
vi src/main/resources/application.properties
```

```
spring.datasource.username=<username>
spring.datasource.password=<password>
spring.datasource.url=jdbc:postgresql://localhost:5432/<database>
spring.datasource.jdbc-url=jdbc:postgresql://localhost:5432/<database>
spring.datasource.driver-class-name=org.postgresql.Driver

spring.flyway.enabled=true
spring.flyway.username=${spring.datasource.username}
spring.flyway.password=${spring.datasource.password}
spring.flyway.url=${spring.datasource.jdbc-url}
```

Maven build and run:
```
 mvn clean install
 mvn spring-boot:run
```

### API

Specify `terms` as a comma delimited list without spaces or special characters. 

Request:

```
http://localhost:8080/policyapi/search?terms=uk
http://localhost:8080/policyapi/search?terms=uk,senegal
http://localhost:8080/policyapi/search?terms=wales
```
Response:
```
{
  "sectors": null,
  "totalMatches": 1,
  "matches": [
    {
      "id": "8701",
      "title": "UK Flood and Water Management Act - 2010",
      "sectors": null,
      "description": "This Act makes provision about water, including provision about the management of risks in connection with flooding and coastal erosion. Article 7.2 specifies that the Environment Agency must specify the current and predicted impact of climate change on flood and coastal erosion risk management when coming up with a national flood and coastal erosion risk management strategy for England. The same clause is specified in art. 8.2 for Wales."
    }
  ]
}
```

## Reference

* https://spring.io/projects/spring-boot
* https://start.spring.io/
* https://flywaydb.org/
* https://www.postgresql.org/docs/10
* https://www.postgresql.org/docs/10/textsearch.html

## TODO 

* Add sectors to response to complete remit.
* Add docker-compose support to do away with need for Maven, JDK and Postgres installations.
* Support multi word terms like 'carbon dioxide'.
* Add logging.
* Add Authentication.
* Add unit tests.
* Add some swagger API docs.
* Enhance search capability see: https://www.postgresql.org/docs/10/textsearch.html.
* Add some additional ETL support e.g. POST support for data refresh.


