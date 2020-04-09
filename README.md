# Event Tracker

## Assumptions
- When event is created a user is logged in and username is provided through the header. 
- In order for an event to be created a user must be logged in and have their username info in header.
- One REST call creates exactly one event.
- Random timestamp generator: Some records will randomly go into yesterday (see additional notes at the bottom of README).

## How to Use
### Recommended Build Process (Eclipse IDE)
Due to the requirements of Java applications, the recommended build process is to use Eclipse with Spring Tools 4 and Java 1.8 JDK.

1. Download and install Java JDK 1.8 from Oracle [Download here](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
2. Download Spring Tools 4 for Eclipse (Alternative would be Spring Tools 4 for Visual Code Studio, but I have not verified the build process) [Download here](https://spring.io/tools)

### Manual Build Process 
To build the project without Eclipse, use the following steps:

1. Download and install Java JDK 1.8 from Oracle [Download here](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
2. Once installed, confirm that your `JAVA_HOME` is pointing to the correct directory. On Mac, this is most likely `/Library/Java/Home`. If your path is incorrect, set the path to the directory where the JDK was installed using `$ export JAVA_HOME=/path/to/JDK`
3. Clone this repository and navigate to it.
4. Install the application: `./mvnw clean install`
5. Run the applcation: `./mvnw spring-boot:run`
6. Access Swagger at `localhost:8080/swagger-ui.html`

### Swagger
Swagger can be accessed at `localhost:8080/swagger-ui.html`

- Go to user controller and create a new user.
- Go to event controller and create events with user email in the header. User must exist or error will be thrown.

## Important Notes
- As you create events, it will randomly date the events with todays time stamp and others with yesterdays timestamp.  This is to simulate the function for getting last days events and to ensure that there are events stored for the last day
- Go to get events in the events controller and you can filter by last day, email, none(returns all events), or filter by both useremail and last day events.