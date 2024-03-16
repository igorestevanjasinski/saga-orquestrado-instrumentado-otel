***Saga Orchestrated + Spring Boot + Opentelemetry***

- Libs:
  - https://github.com/open-telemetry/opentelemetry-java-instrumentation/tree/main/instrumentation/kafka/kafka-clients/kafka-clients-2.6
  - https://github.com/open-telemetry/opentelemetry-java-instrumentation/tree/main/instrumentation/spring/spring-kafka-2.7
  - https://github.com/open-telemetry/opentelemetry-java-instrumentation/tree/main/instrumentation/spring/spring-boot-autoconfigure
  - https://github.com/open-telemetry/opentelemetry-java-instrumentation/tree/main/instrumentation/jdbc
  - https://github.com/open-telemetry/opentelemetry-java-instrumentation/tree/main/instrumentation/mongo/mongo-3.1

***Running application***
```
git clone https://github.com/igorestevanjasinski/saga-orquestrado-instrumentado-otel.git
pytho3 build.py
```
**Testing application**
```
http://localhost:3000/swagger-ui/index.html
```

**POST** http://localhost:3000/api/order

Payload:

```json
{
  "products": [
    {
      "product": {
        "code": "COMIC_BOOKS",
        "unitValue": 15.50
      },
      "quantity": 3
    },
    {
      "product": {
        "code": "BOOKS",
        "unitValue": 9.90
      },
      "quantity": 1
    }
  ]
}
```
**Accessing Grafana**
```
http://localhost:3001/explore
```
- Search for order-service
  ![image](https://github.com/igorestevanjasinski/saga-orquestrado-instrumentado-otel/assets/108187126/01f745b4-c713-4cfc-a6c7-6fc736ddbba0)


***Grafana Tempo***
![image](https://github.com/igorestevanjasinski/saga-orquestrado-instrumentado-otel/assets/108187126/98a69717-1498-4d28-89fc-72ea65c5d211)
