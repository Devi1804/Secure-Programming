# Phonebook Management System

## Decription
The project involves a rest API application with the following APIs implemented to manage a phonebook. The program shall be capable of receiving and storing a list of people with their full name and telephone. The application shall include the following API endpoints:

**GET /PhoneBook/list** – Produce a list of the members of the database.

**POST /PhoneBook/add** – Add a new person to the database.
Argument is an object with name and phone number string elements (represented in JSON).

**PUT /PhoneBook/deleteByName** – Remove someone from the database by name.
Argument is the name as a string.

**PUT /PhoneBook/deleteByNumber** – Remove someone by telephone #.
Argument is the phone number as a string

## Tech Stack
- Java 1.8
- Spring boot 2.7.0
- Maven framework
- Swagger UI for API documentation and interacting with the APIs.
- Junit Test suite
- SQL Lite database

## Bonus
In addition, following functionalities were also added:
- Using database to store the input data.
- Using an API that supports parameterized queries.
