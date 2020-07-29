Exercise 1 :
Part 1:
In this exercise, you will build an API using the Spring Boot Framework. The primary goal of this exercise is to learn the structure of the Spring Boot API, and to set up functionality that allows users to register and persist in an H2 "in-memory" database.

For the registered users, you will implement "CRUD" functionality:

Create users
Read registered users
Update user information
Delete users
Users must provide the following information to successfully register:

First Name
Last Name
Email Address
Password
Go to start.spring.io to begin your project and add the required dependencies.
Go to mvnrepository.com to add dependencies you may have missed

Setup a logical "control flow" within your Spring Boot API using the following components:

Controllers
Services
Interfaces
Entities
Repositories
Set up data persistance for the registered users using the H2 database

Set up endpoints for the following operations:

Storing a user in the database
Retrieving a specific user by their ID and returning the user as a response
Retrieving a specific user by their email address and returning the user as a response
Retrieving a list of all the users and returning it as a response
Updating a user in the database (Hint: find the user, set the fields from the request body, and save it again) (Make sure you test that the user has been correctly modified)
Deleting a user from your database (Make sure that you test that the user has been correctly removed)
It is strongly recommended to test your API using a REST API client, such as Postman or Insomnia. You can use the client to do the following:

Check the general functionality of your API by pinging it using the various API calls.
After doing a "PUT" on a user, "GET" the user to see if the information has been successfully updated.
After doing a "DELETE" on a user, "GET" the list of users to see if that particular user has been removed.
As is the case with any Java Application, be sure to follow good Object Oriented Design (OOD) Principles and Patterns

Part 2
Edit or add to your code from Part 1 to implement the following:

Add Pagination to your functionality to retrieve all records. (Hint: you can set the page limit low so you don't have to input too many records).
Add/Edit your entities to include a POJO for Requests, and a POJO for Responses, including only relevant and safe fields. Responses should include an HTTP Response field.
Add a POJO for a Data Transfer Object and use it in the appropriate classes and methods to transfer data between other classes (Hint: use BeanUtils.copyProperties()).
Add Exception handling, including custom Exceptions when necessary. Make sure to return them to the user if they are thrown.