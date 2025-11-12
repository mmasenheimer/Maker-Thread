# MakerThread Dev Log

## 2025-07-01
- Initialized Spring Boot project with Maven  
- Set up project structure and dependencies: Spring JPA, Spring Security, Lombok, PostgreSQL  
- Configured Docker for consistent local development environment  
- Created initial README with project overview  

## 2025-07-05
- Designed PostgreSQL schema with 5 tables: Users, Projects, Tags, Comments, Likes  
- Implemented JPA entity classes for each table  
- Created repository interfaces for CRUD operations  
- Began implementing user registration endpoint  

## 2025-07-07
- Completed user registration and login with JWT authentication  
- Added validation for email, password, and username uniqueness  
- Started CRUD endpoints for Projects: create and read operations  
- Wrote initial unit tests for authentication and project services  

## 2025-07-09
- Completed update and delete operations for Projects  
- Set up one-to-many relationships between Users and Projects   
- Improved error handling and response messages for invalid requests  

## 2025-07-13
- Implemented commenting system for projects (add, edit, delete)  
- Wrote unit tests for Comment and Like services  
- Updated README with API endpoints and setup instructions  

## 2025-07-17
- Deployed backend using Docker for local testing  
- Tested full workflow
- Fixed minor bugs in authentication flow and entity relationships  

## 2025-07-20
- Optimized Maven build process and integrated Lombok
- Ensured all 12 RESTful API endpoints function as intended  
- Prepared backend for frontend integration and cloud deployment  
