# SkillShare Platform

## Overview
SkillShare is an online platform that enables users to explore and enroll in various skill-based courses, empowering them to enhance their knowledge and skills. The platform connects instructors, who can create and manage courses, with learners, who can access high-quality learning content tailored to their interests.

---

## Features

### 1. User Roles
- **Admin**:
  - Manage users and courses.
  - Approve or disapprove course content.
- **Instructor**:
  - Create, edit, and delete courses.
  - Upload videos and supplementary content.
  - Interact with students through reviews and feedback.
- **Learner**:
  - Browse and enroll in courses.
  - View course content and leave feedback.
  - Track progress and manage enrolled courses.

### 2. Course Management
- Dynamic course creation with metadata (e.g., title, description, tags).
- Video and document uploads for course content.
- Course reviews and ratings from learners.

### 3. Adaptive Learning
- Personalized course recommendations based on user preferences and activity.
- Progress tracking for enrolled courses.

### 4. Secure Access
- Role-based access control to ensure data security and user privacy.
- Password management and secure authentication.

---

## Technology Stack

### Backend
- **Framework**: Spring Boot
- **Database**: MySQL (via Spring Data JPA)
- **API Design**: RESTful APIs
- **Languages**: Java

### Frontend
- Developed separately using a decoupled architecture.

---

## Project Architecture

### Key Layers
1. **Controller Layer**:
   - Handles API requests and sends responses to the frontend.
2. **Service Layer**:
   - Contains business logic and interacts with repositories.
3. **Repository Layer**:
   - Interfaces with the database using Spring Data JPA.

### Workflow
1. User interacts with the frontend.
2. Frontend sends API requests to the backend.
3. Controllers handle the requests and pass them to services.
4. Services process the logic and interact with repositories.
5. Repositories execute database operations and return results.

---

## Setup and Installation

### Prerequisites
- **Java**: Version 11 or higher.
- **MySQL**: Version 8.0 or higher.
- **Maven**: For dependency management.

### Steps
1. Clone the repository:
   ```bash
  https://github.com/RaviMistry01/SkillShare-online-skill-sharing-platform.git
   ```
2. Navigate to the project directory:
   ```bash
   cd skillshare
   ```
3. Configure the database:
   - Update `application.properties` with your MySQL credentials.
4. Build the project:
   ```bash
   mvn clean install
   ```
5. Run the application:
   ```bash
   mvn spring-boot:run
   ```
6. Access the application:
   - API Documentation: `http://localhost:8080/swagger-ui/`

---

## Database Schema

### Tables
1. **User**:
   - Stores user information such as roles, credentials, and preferences.
2. **Course**:
   - Stores course details including title, description, and instructor ID.
3. **Content**:
   - Stores video and document links associated with courses.
4. **Enrollment**:
   - Tracks which learners are enrolled in which courses.
5. **Review**:
   - Stores learner feedback for courses.

---

## Future Enhancements
- Implement live sessions and webinars.
- Introduce gamification elements (e.g., badges, leaderboards).
- Add support for multiple languages.

---

## Contributors
- **Backend Developer**: Ravi Mistry


---

## License
This project is licensed under the [MIT License](LICENSE).

