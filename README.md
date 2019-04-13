# myBank 

myBank is a Java banking application designed to help users organize their finances more efficiently.

## How to Run
1. Clone the project
```bash
git clone https://github.com/dlnet/bank.git
```
2. Import as a Maven Project in your IDE
    - For Eclipse:
       - `File > Import > Existing Maven Projects > Select the root directory (the one containing pom.xml)`
    - For IntelliJ IDEA:
       - `New > Project from Existing Sources > Select the pom.xml file`	 
3. Run `BankApplication` in `bank/src/main/java/ca/ucalgary/gui` to start GUI
4. Run `CLI` in `bank/src/main/java/ca/ucalgary/tui` to start text-based UI

Note: You may also compile our code using `mvn clean install` in a terminal. However, doing this may not allow the `Budget` and `Invest` repositories to save. This is because we originally saved our `data-stores` inside of the `src` folder, which is not accessible once the code has been compiled, and we did not have time to refactor everything towards the end.
In this case, it is better to just run the application directly from an IDE, instead of trying to compile.

## Demo Locations
+ Demo 1: `bank/src/main/java/ca/ucalgary/tui`
+ Demo 2: `bank/src/main/java/ca/ucalgary/gui`
+ Demo 3: `bank/src/main/java/ca/ucalgary/gui`

## JUnit Testing
+ The `InvestRepository` class is thoroughly tested.
+ To test, run `InvestRepositoryTest` in `bank/src/test/java/ca/ucalgary/datastore`

## Overview

+ Helps users have a more organized financial future
+ Allows users to check their account balances on a day-to-day basis
+ Checks that users meet their goals and follow their budget

## Design

### Domain
The domain package is to represent all the POJO [(Plain Old Java Object)](https://en.wikipedia.org/wiki/Plain_old_Java_object) entity of a bank business.
For example, `Account.java` is a representation of raw data for an account. This means that the `Account.java` will have properties such as ID, Account Balance, etc.
These POJO should contain no or very little behaviours (setter and getters).

### Services
The services package is to represent actions, operations, behaviours on your POJO. Usually the service package will use the datastore package to save, update, read, delete the POJOs.

### Datastore
This package is to simulate the persistence of the domain objects. Usually you will have one repository type per domain object.

## Development Practices
Note: Never develop against master branch
+ Clone the project
```bash
git clone https://github.com/dlnet/bank.git
```
+ Create a feature branch (branch name cannot have spaces)
```bash
git checkout -b <branch_name>
```
+ Set up your local branch to be remote
```bash
git push --set-upstream origin <branch_name>
```
+ Add your code, commit, and push
```bash
git add .
git commit -m "Your Commit Message"
git push
```
+ Once finished, create a pull request from github

## Features

### Accounts
Allows users to view their current accounts, such as chequing and savings accounts. User will be able to add or delete their accounts from this page.

### Budget
Allows users to track how they spend their money. Will be able to choose categories such as rent, utilities, food, etc. Allocates a portion of their income to each category.

### Invest
Allows user to search different stocks by symbol, and they will be given a brief overview of the stock. Users can purchase stocks and add them their portfolio. Users can manage their portfolio through the app.
