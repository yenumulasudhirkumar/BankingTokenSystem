# BankingTokenSystem

Problem: A bank, ABC Bank, has many branches and customers. Each branch has a limited number of teller counters.

ABC Bank provides a better customer experience to their premium customers by providing priority over non premium customers (less waiting time at branches).

In order to achieve this, ABC Bank has decided to introduce new machines to manage queues at each of their branches.

Tech Stack:

1.Java - 1.8

2.Spring Boot - 2.0.0

3.PostgreSql - 9.5.10

Setup Instructions
Prerequisite:

1.Java 1.8 or higher installed

2.PostgreSql 9.5 or higher installed (https://www.postgresql.org/download/linux/ubuntu/)

3.active-spring.Maven installed (https://maven.apache.org/install.html)

Run Application:

mvn install && java -jar target/token-generation-management-0.0.1-SNAPSHOT.jar

View Rest Api Documentation:
Swagger is integrated to the application. To view documentation, follow the below url after running the application http://localhost:9090/swagger-ui.html

Design Diagrams
Please refer to ER.png and entity.uml diagrams
