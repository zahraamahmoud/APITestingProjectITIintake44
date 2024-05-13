# APITestingProjectITIintake44

API Testing for Go REST Web Service

This project focuses on API testing for a Go REST web service that provides endpoints for managing users, posts, comments, and todos. CRUD operations have been implemented for each endpoint, and Postman collections have been utilized for manual testing. Additionally, RestAssured has been employed for automating the web service tests, including POJO serialization and deserialization.

## Features

- CRUD operations for managing (User Endpoint - Post Endpoint - Comment Endpoint -Todo Endpoint )
- Postman Collections: Includes Postman collections for manual testing.
- RestAssured Automation: Automated tests using RestAssured framework.
- POJO Serialization/Deserialization: Serialization and deserialization of objects using Plain Old Java Objects (POJOs).
  
##  Getting Started
- Clone the Repository:
        https://github.com/zahraamahmoud/APITestingProjectITIintake44.git
- Import the Project:
        Import the project into your preferred IDE as a Maven project.
- Run Tests:
        Execute the test classes under the tests package to run automated tests.
- Explore Postman Collections:
        Import the Postman collection (collection.json) located in the postman directory to explore and execute manual tests.

##Dependencies

RestAssured: Java library for RESTful API testing.
TestNG: Framework for writing and running tests.
Json: Library for JSON serialization and deserialization.
Maven: Dependency management tool for Java projects.

## Project Structure

```plaintext
project-root/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── models/
│   │   │       ├── comment/
│   │   │       │   ├── CreateCommentRequestBodyModel.java
│   │   │       │   └── CreateCommentResponseBodyModel.java
│   │   │       ├── post/
│   │   │       │   ├── CreatePostRequestBodyModel.java
│   │   │       │   ├── CreatePostResponseBodyModel.java
│   │   │       │   └── UpdatePostBodyUsingPATCHRequestBodyModel.java
│   │   │       ├── todo/
│   │   │       │   ├── CreateTodoRequestBodyModel.java
│   │   │       │   └── CreateTodoResponseBodyModel.java
│   │   │       └── user/
│   │   │           ├── CreateUserRequestBodyModel.java
│   │   │           ├── CreateUserResponseBodyModel.java
│   │   │           ├── CreateUserWithInvalidFieldsResponseBodyModel.java
│   │   │           ├── GetSingleUserResponseBodyModel.java
│   │   │           └── GetUserWithInvalidIDResponseBodyModel.java
│   │   │
│   └── test/
│       ├── java/
│       │   ├── requests/
│       │   │   ├── CommentRequests.java
│       │   │   ├── PostRequests.java
│       │   │   ├── TodoRequests.java
│       │   │   └── UserRequests.java
│       │   │
│       ├── testcases/
│       │   ├── comment/
│       │   │   ├── invalidCommentTests/
│       │   │   │   ├── CreateInvalidCommentsTests.java
│       │   │   │   ├── DeleteInvalidCommentTests.java
│       │   │   │   ├── GetInvalidCommentTests.java
│       │   │   │   └── PutInvalidCommentTests.java
│       │   │   │
│       │   │   └── validCommentTests/
│       │   │       ├── CreateValidCommentTests.java
│       │   │       ├── DeleteValidCommentTests.java
│       │   │       ├── GetValidCommentTests.java
│       │   │       └── PutValidCommentTests.java
│       │   │
│       │   ├── post/
│       │   │   ├── invalidPostTests/
│       │   │   │   ├── CreatePostWithInvalidFieldsTests.java
│       │   │   │   ├── DeletePostWithInvalidID.java
│       │   │   │   └── GetPostWithInvalidIDTests.java
│       │   │   │
│       │   │   └── validPostTests/
│       │   │       ├── CreatePostWithValidFieldsTests.java
│       │   │       ├── DeletePostWithValidID.java
│       │   │       ├── UpdatePostWithValidFieldsUsingPATCHTests.java
│       │   │       └── UpdatePostWithValidFieldsUsingPutTests.java
│       │   │
│       │   ├── todo/
│       │   │   ├── invalidTodoTests/
│       │   │   │   ├── CreateInvalidTodoTests.java
│       │   │   │   ├── DeleteInvalidTodoTests.java
│       │   │   │   ├── GetInvalidTodoTests.java
│       │   │   │   └── PutInvalidTodoTests.java
│       │   │   │
│       │   │   └── validTodoTests/
│       │   │       ├── CreateValidTodoTests.java
│       │   │       ├── DeleteValidTodoTests.java
│       │   │       ├── GetValidTodoTests.java
│       │   │       └── PutValidTodoTests.java
│       │   │
│       │   └── user/
│       │       ├── invalidUserTests/
│       │       │   ├── CreateUserWithInvalidFieldsTests.java
│       │       │   ├── DeleteUserWithInvalidIDTests.java
│       │       │   └── GetUserWithInvalidIDTests.java
│       │       │
│       │       └── validUserTests/
│       │           ├── CreateUserWithValidFieldsTests.java
│       │           ├── DeleteUserWithValidIDTests.java
│       │           ├── GetUserWithValidIDTests.java
│       │           └── UpdateUserWithValidFieldsUsingPutTests.java
│       │
│       └── utils/
│           └── Constants.java


##License
This project is licensed under the MIT License.
