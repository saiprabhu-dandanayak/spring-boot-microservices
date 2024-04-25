# Student and Course Microservices

This project consists of two microservices: Student Service and Course Service.

## 🚀 Features

- Student Service:
  - ✅ Create, read, update, and delete student records
  - 🔍 Fetch student details including the course they are enrolled in
- Course Service:
  - ✅ Create, read, update, and delete course records

## 🛠️ Technologies Used

- Spring Boot
- Spring Data JPA
- MySQL
- Eureka Server and Client for Service Discovery
- WebClient for making API calls between microservices

## 🔧 Setup

1. Clone the repository:

    ```bash
    git clone <repository_url>
    ```

2. Import the projects into your IDE (Eclipse/IntelliJ).
3. Configure MySQL database in `application.properties` files.
4. Run the Eureka Server, Course Service, and Student Service.

## 📋 Endpoints

### Student Service

#### Create Student
- Endpoint: `POST /api/students/save`
- Request Body:
  ```json
  {
      "name": "saiprabhu",
      "mobileNo": "1234567890",
      "courseId": 1
  }
