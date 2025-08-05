# Console-Based Bank ATM Simulation
This project is a command-line application developed in Java that simulates basic banking operations. It is designed based on Object-Oriented Programming (OOP) principles.

## Features
This project simulates the core functionalities of a real-world Automated Teller Machine (ATM) with a focus on stability and a clear user experience.

#### Core Banking Operations:
* **Balance Inquiry:** Users can securely check their current account balance.

* **Cash Deposit:** Allows users to deposit positive amounts into their account.

* **Cash Withdrawal:** Allows users to withdraw cash, with built-in protection against overdrawing.

#### Security & Robust Validation:
* **Secure Login:** The application authenticates users based on a unique account number and a secret PIN.

* **Insufficient Funds Protection:** Prevents a user from withdrawing more money than available in their balance.

* **Invalid Input Handling:** The application handles invalid transaction amounts (e.g., negative values) gracefully.

* **Operation Cancellation:** Users have the option to cancel a deposit or withdrawal operation and return to the main menu.

#### Object-Oriented Design (OOP):
* **Separation of Concerns:** The application logic is cleanly separated into multiple classes, each with a single responsibility:

  * `ATM.java:` Handles all user interface logic (prompts, inputs, and outputs) and manages the application flow.

  * `Bank.java:` Acts as a repository, managing the collection of all user accounts.

  * `Account.java:` Represents the application's core model, holding the data and business logic for a single bank account.

  * `App.java:` Serves as the main entry point for the application.

#### User Experience: 
* **Continuous Operation:** The ATM runs in a continuous loop, allowing for multiple user sessions until the program is manually stopped.

* **Interactive Menu:** A clear, numbered menu guides the user through the available actions.

* **Clear Feedback:** The application provides informative success and error messages for all operations

## Technologies Used
* **Java:** The core programming language used for the application.

* **Maven:** Used for project build automation and dependency management.

##  Getting Started
Follow these instructions to get a copy of the project up and running on your local machine.

**Prerequisites:**
* Java Development Kit (JDK) (e.g., version 17 or higher)

* Apache Maven

**Installation & Running**
1. Clone the repository to your local machine:
```bash
  git clone https://github.com/emrecakall/atm-simulation.git
```
2. Navigate to the project directory:
```bash
  atm-simulation
```
3. Compile the project using Maven:
```bash
  mvn compile
```
4. Run the application from the command line:
```bash
  mvn exec:java -Dexec.mainClass="com.bankatm.App"
```









