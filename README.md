To start application please run `mvn spring-boot:run` on a local machine.

Application will be available on http://localhost:8080/


#### List of endpoints:

For all endpoints required request header:
`Content-Type: application/json`

All responses are in json format.

1. **GET** http://localhost:8080/v1/counter/{id}

Response: 
```
{
  "id": 1,
  "amount": 1235.0,
  "villageName": "Abdiel Lowe",
  "villageId": 1
}
```

2. **POST** http://localhost:8080/v1/counter/{id}

Request body:
```
{
    "amount": 1236.7
}
```

Response:
Integer id of counter

3. **GET** http://localhost:8080/v1/consumption-report/{duration}

**duration** can be string with format like: 
_10d_(10 days), _14h_(14 hours), _60m_(60 minutes), _40s_ (40 seconds)

Response:
```
{
  "villages": [
    {
      "village": {
        "id": 1,
        "name": "Abdiel Lowe"
      },
      "consumption": 5910.1
    },
    {
      "village": {
        "id": 3,
        "name": "Israel Blanda"
      },
      "consumption": 909.0
    }
  ]
}
```
