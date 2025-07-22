# Cloud Microservices Mystery Box Application 

This project demonstrates a microservices architecture deployed on AWS, integrating frontend and backend services with secure authentication and scalable infrastructure.

---

## Architecture Diagram

<img width="1920" height="1034" alt="image" src="https://github.com/user-attachments/assets/e5f9dc8c-4a1f-41be-96ab-0fdd38eea8e2" />


---

## Components

### User
- Initiates requests via frontend interface.

### Frontend
- Built with React and hosted on AWS Amplify.
- Uses Amazon Cognito for user authentication.
- Utilizes JWT tokens for secure API communication.

### API Gateway
- Amazon API Gateway routes frontend requests to backend services.

### Backend Services (EC2 Instances in Public Subnet)
- Two Spring Boot microservices (`user_service` and `mystery_box_service`) running inside Docker containers on T2 EC2 instances.
- These services handle business logic and communicate with their respective databases.

### Databases (Private Subnet)
- Amazon RDS PostgreSQL databases for each microservice (`user_service_db` and `mystery_box_service_db`).
- Databases are in a private subnet for security.

### Networking
- All components are deployed within a Virtual Private Cloud (VPC).
- Public subnet hosts the EC2 instances.
- Private subnet hosts the databases.

---

## Sign Up Flow

<img width="1026" height="596" alt="image" src="https://github.com/user-attachments/assets/599a3429-c96c-40c9-88b4-a3a644b9cd9b" />

### 1. User Authentication
1. User initiates first-time sign-in after registration
2. Frontend sends authentication request to Amazon Cognito
3. Cognito validates credentials and returns JWT token

### 2. User Creation Process
1. Cognito Authorizer on API Gateway authorizes JWT token
2. `@AuthenticationPrincipal` extracts user information from token payload
3. user_service creates new user record in database
4. System triggers welcome email via Amazon SES

### 3. Virtual Currency Initialization
1. After user creation, system requests new virtual currency record
2. mystery_box_service creates initial VC record for new user
3. New virtual currency record saved in mystery_box_service database

### 4. Service Communication
- **Spring Cloud OpenFeign** facilitates service-to-service communication
- Both services run in Docker containers for consistency and scalability

## Key Features

- **Secure Authentication** - JWT-based authentication with Amazon Cognito
- **Microservices Architecture** - Separation of user management and virtual currency services
- **Automated Onboarding** - Welcome emails and virtual currency initialization
- **Containerized Deployment** - Docker containers for all services
- **Database Isolation** - Separate databases for different service domains



---

## Technologies Used

- React  
- AWS Amplify  
- Amazon Cognito  
- JWT  
- Amazon API Gateway  
- Spring Boot  
- Docker  
- Amazon EC2 (T2 instances)  
- Amazon RDS (PostgreSQL)  
- AWS VPC  

---

## Security Considerations

- Authentication handled via Amazon Cognito and JWT.
- Backend databases are isolated in private subnet.
- EC2 instances are in a public subnet, but only expose necessary services.
- Secure communication enforced throughout.

---

## License

This project is licensed under the MIT License.  
See the [LICENSE](LICENSE) file for details.
