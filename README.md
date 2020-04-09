# Event Tracker

## Assumptions
- When event is created a user is logged in and username is provided through the header. 
- In order for an event to be created a user must be logged in and have their username info in header.
- One REST call creates exactly one event.
- Random timestamp generator: Some records will randomly go into yesterday (see additional notes at the bottom of README).

## How to Use
### Build Requirements
Recommended build process uses Eclipse with Java 8 and Maven.

### Swagger
Swagger can be accessed at `localhost:8080/swagger-ui.html`

- Go to user controller and create a new user.
- Go to event controller and create events with user email in the header. User must exist or error will be thrown.

## Important Notes
- As you create events, it will randomly date the events with todays time stamp and others with yesterdays timestamp.  This is to simulate the function for getting last days events and to ensure that there are events stored for the last day
- Go to get events in the events controller and you can filter by last day, email, none(returns all events), or filter by both useremail and last day events.