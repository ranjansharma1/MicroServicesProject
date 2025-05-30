# Microservices Overview

A comprehensive microservices-based application built using Spring Boot and Spring Cloud, demonstrating key concepts such as service discovery, Load Balancer, API gateway, centralized configuration, inter-service communication, and more.

---

## 📦 Project Structure

The repository comprises the following services:

- **ServiceRegistry**: Eureka Server for service discovery.
- **ConfigServer**: Centralized configuration management.
- **ApiGateway**: Routing and load balancing via Spring Cloud Gateway.
- **UserService**: Manages user-related operations.
- **HotelService**: Handles hotel information.
- **RatingService**: Manages user ratings for hotels.

---

## 🧩 Microservices Architecture Overview

The application follows a typical microservices architecture with the following components:

- **Service Registry (Eureka Server)**: Facilitates service discovery.
- **Config Server**: Provides centralized configuration to all services.
- **API Gateway**: Acts as a single entry point, routing requests to appropriate services.
- **Microservices**: Independent services for users, hotels, and ratings.

---

## 🔄 Service Interactions

- **UserService** communicates with **RatingService** to fetch user ratings.
- **RatingService** interacts with **HotelService** to retrieve hotel details for each rating.
- **ApiGateway** routes external requests to the appropriate microservice.

---

## 🔧 Technologies Used

- **Spring Boot**: For building microservices.
- **Spring Cloud**: For service discovery, configuration, and gateway.
- **Eureka Server**: Service registry.
- **Spring Cloud Config**: Centralized configuration management.
- **Spring Cloud Gateway**: API gateway for routing and load balancing.
- **Feign Client**: Declarative REST client for inter-service communication.
- **Apache JMeter**: For performance testing.

---

## 🚀 Running the Application

### Start the Eureka Server:
- Navigate to `ServiceRegistry` directory.
- Run the application.

### Start the Config Server:
- Navigate to `ConfigServer` directory.
- Run the application.

### Start the Microservices:
- Navigate to each service directory (`UserService`, `HotelService`, `RatingService`).
- Run each application.

### Start the API Gateway:
- Navigate to `ApiGateway` directory.
- Run the application.

> Ensure that the configuration files are correctly set up and that each service registers with the Eureka Server.

---

## 📁 Configuration Management

- All services fetch their configurations from the **ConfigServer**.
- The configurations are stored in a centralized **Git repository** ([config helper](https://github.com/ranjansharma1/micro-config-helper))  , which the ConfigServer accesses.

---

## 📞 Inter-Service Communication

- **Feign Clients** are used for declarative REST calls between services.
- **RestTemplate** can also be used for programmatic REST calls.

---

## 🛡️ Security and Resilience

- Implementations can include **circuit breakers** and **fallback methods** using **Resilience4j** or **Hystrix**.
- **Rate limiting** and **security** can be managed at the API Gateway level.

---

## 📈 Performance Testing

- **Apache JMeter** scripts are included for load testing the services.
- Use the provided JMeter files to simulate concurrent users and measure performance.

---

## 🤝 Contributing

Contributions are welcome! Please fork the repository and submit a pull request for any enhancements or bug fixes.


