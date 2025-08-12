## Flight Booking System API Testing

This project provides a comprehensive suite for testing the APIs of a Flight Booking System. Its purpose is to validate the reliability, security, and correctness of all backend endpoints involved in the flight booking process.

### Project Overview

The Flight Booking System API Testing repository is designed to ensure that the core functionalities of the flight booking platform work as intended. It covers all major modules such as searching for flights, booking tickets, user management, payment processing, and cancellations. The repository contains automated test cases that simulate real-world user scenarios as well as edge cases to guarantee robust API behavior.

### Key Features

- **Comprehensive API Coverage:** Test cases are written for all essential endpoints, including flight search, booking, ticket cancellation, user registration, authentication, and payment.
- **Automated Testing:** The project leverages modern testing frameworks to automate API tests, making it easy to run regression, smoke, and integration tests.
- **Validation of Business Logic:** Tests not only check API responses and status codes but also validate the underlying business logic like seat availability, fare calculation, user eligibility, and refund processing.
- **Error Handling and Edge Cases:** Dedicated scenarios are included to ensure proper error messages and handling for invalid requests, unauthorized access, and system failures.
- **Reporting and Logs:** The framework generates detailed test execution reports and logs to help developers and QA engineers quickly identify issues.
- **Continuous Integration Ready:** The suite is designed for seamless integration with CI/CD pipelines, enabling automated checks during code merges and deployments.

### Structure

- **Test Suites:** Organized by API modules (e.g., Search, Booking, Cancellation, Payments, User Management).
- **Configuration Files:** Easy setup for environment variables, authentication tokens, and API endpoints.
- **Utilities:** Helpers for request generation, response validation, and test data setup.
- **Documentation:** Clear instructions on how to run tests, interpret reports, and extend the suite for new functionality.

### Use Cases

- **Developers:** Validate new features or changes to the API before deployment.
- **QA Engineers:** Perform regression, integration, and smoke testing efficiently.
- **DevOps:** Integrate automated tests into deployment pipelines for continuous quality assurance.
- **Stakeholders:** Gain confidence in the stability and reliability of the Flight Booking System APIs.

### Getting Started

1. Clone the repository.
2. Install dependencies as per the provided documentation.
3. Configure environment variables and authentication details.
4. Run the desired test suites using the prescribed commands.

### Team & Individual Contributions

- **Shubhangee Agrawal (Product Owner)**
  - Created base test configuration and utilities (Framework)
  - Added status code validation (200, 400, 401, 404) (Testing)
  - Finalized Test Summary Report for Sprint 4 (Documentation)
  - Contributed to framework documentation and knowledge transfer (Team/Documentation)

- **Ananya Sadhukhan**
  - Set up Rest Assured framework and Maven dependencies (Framework)
  - Implemented API response validation and assertions (Testing)
  - Generated Rest Assured test reports and documentation (Reporting)
  - Created comprehensive test suite execution pipeline (Integration)
  - Contributed to framework documentation and knowledge transfer (Team/Documentation)

- **Rishikesh LNU**
  - Implemented authentication token generation automation (Automation)
  - Automated View Passenger List API (GET /viewPassengerList) (Automation)
  - Implemented data-driven testing with external test data (Testing)

- **Prabal Gupta**
  - Automated View Passenger by ID API (GET /viewPassengerById) (Automation)
  - Automated Delete Passenger API (DELETE /deletePassengerById) (Automation)
  - Implemented negative test scenarios and error handling (Testing)

- **Vedant Nikalje**
  - Automated Add Passenger API (POST /addPassenger) (Automation)
  - Automated View Passenger by Name/Mobile API (GET) (Automation)

- **Team**
  - Configured TestNG integration and test execution (Integration)
  - Participated in Sprint 4 retrospective meeting (Meeting)
  - Contributed to framework documentation and knowledge transfer (Documentation)

---

This project is crucial for maintaining a high-quality, reliable, and secure flight booking API. It aims to deliver a seamless experience for both users and developers, minimizing issues in production and ensuring business continuity.
