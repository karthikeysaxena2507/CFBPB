# CF-Brokerage-Backend
The backend of the consumer finance brokerage prototype

## Requirements to run the app locally 

1. Java JDK 11 must be installed in the system
* You can download and install Java 11 from [here](https://www.oracle.com/in/java/technologies/javase/jdk11-archive-downloads.html).
* Refer to following tutorials for Java 11 installation:

  * [MacOS](https://www.youtube.com/watch?v=pxi3iIy4F5A)
  * [Windows](https://www.youtube.com/watch?v=1ZbHHLobt8A)
  * [Linux (Ubuntu)](https://www.youtube.com/watch?v=ogWKP9Lm-Qo)
  
2. Latest version of **Maven** build tool
* You can download and install Maven from [here](https://maven.apache.org/download.cgi).
* Refer to following tutorials for Maven installation:

  * [MacOS](https://www.youtube.com/watch?v=j0OnSAP-KtU)
  * [Windows](https://www.youtube.com/watch?v=6AVC3X88z6E)
  * [Linux (Ubuntu)](https://www.youtube.com/watch?v=TYfO26yc1EM)

3. Following Properties must be defined (if not present already) in the *src/main/resources/application.yml* file
  * spring: <br />
      &nbsp;&nbsp;data: <br />
        &nbsp;&nbsp;&nbsp;&nbsp;mongodb: <br />
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;uri: ${MONGO_DATABASE_URI} <br />
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;database: ${MONGO_DATABASE_NAME} <br />
      &nbsp;&nbsp;redis: <br />
        &nbsp;&nbsp;&nbsp;&nbsp;password: ${REDIS_DB_PASSWORD} <br />
        &nbsp;&nbsp;&nbsp;&nbsp;host: ${REDIS_DB_HOST} <br />
        &nbsp;&nbsp;&nbsp;&nbsp;port: ${REDIS_DB_PORT} <br />
  * equifax: <br />
      &nbsp;&nbsp;username: ${EQUIFAX_USERNAME} <br />
      &nbsp;&nbsp;password: ${EQUIFAX_PASSWORD} <br />
  * illion: <br />
      &nbsp;&nbsp;apiKey: ${ILLION_API_KEY} <br />

## How to run locally?

Clone the repository on your local machine in the folder of your choice

    git clone https://github.com/karthikeysaxena2507/CF-Brokerage-Backend.git
    
Move into the project folder and install all the dependencies

    mvn clean install
    
Start the spring boot application, it will by default run at http://localhost:9000

    mvn spring-boot:run
    
## Technologies Used

* The Backend is built as a **Spring Boot** application, running on the embedded **Tomcat** server.
* The Rest APIs are built using the **Spring Data Rest** framework.
* For database, **MongoDB** atlas was used and, querying is done using **MongoTemplate** and **MongoRepositories**.
* Configured **Redis** for caching using **redisTemplate**.
* Used Spring Boot **Rest Template** to access external Rest Services like **Illion**.
* Used Spring Boot **Web Service Template** to access external Soap Services like **Equifax**.
* The app is deployed on **Heroku** platform.

## Important Note
* Following Data was inserted into MongoDB Collections using **Apache poi** dependency in spring boot. <br />
  [Consumer Finance Data](https://docs.google.com/spreadsheets/d/1ciHzZ33Is7ThEcqUU3yxMrATyPRIQrv3LcQRy9e79X0/edit#gid=2043658304)
* The postman collection is available [here](https://www.getpostman.com/collections/2507a818a6f15d342a9d)
