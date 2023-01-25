# Assessment
### Introduction
* Used Spring boot to implement Rest API.
* Get /customer/reward to get all rewards for each customer
* Get /customer/reward/{customerId} to get an individual's reward by customer id
### Main application
* Technologies used - Spring Boot, Spring Data JPA
* Embedded database - H2 for quick development and test
* Start the application by running [UserRestStarter class](src/main/java/com/ryan/reward/RewardApplication.java)
* Configuration file - [application.properties](src/main/resources/application.properties)
* data.sql and schema.sql will be automatically populated during startup.

### Test
* Technologies used - JUnit
