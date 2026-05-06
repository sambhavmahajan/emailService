## API for sending email

Prerequisite:
Java 21

Run: ```mvnw spring-boot:run```

.env file:
```
HOST=smtp.gmail.com
USERNAME=email@gmail.com
PORT=587
EMAILPASSWORD=googleAppsPassword
PASSWORD=apiPasswordYouWant
```
### API
/send-email POST
Payload:
```
{
    "password":"apiPasswordYouWant",
    "to":"email@gmail.com",
    "subject":"testing123",
    "body":"this is body"
}
```
This app uses SMTP under the hood, configure other providers as per documentation.
