# myBank 

myBank is a Java banking application designed to help users better organize their finances. It will have three key features, each encompassing a major aspect of the user's finances. The features will be; Accounts, Budget and Invest. 

## How to Run (Demo 3)

+ Clone the project
```bash
git clone https://github.com/dlnet/bank.git
``` 
+ Run `BankApplication` in `bank/src/main/java/ca/ucalgary/gui`

## Demo 2 Location
Demo 2 is located here: `bank/src/main/java/ca/ucalgary/gui`

## Demo 1 Location
Demo 1 is located here: `bank/src/main/java/ca/ucalgary/tui`

## JUnit Testing
The InvestRepository.java class is thoroughly tested. To test, run InvestRepositoryTest.java in `bank/src/test/java/ca/ucalgary/datastore`

## Overview

+ Helps users have a more organized financial future
+ Allows users to check their account balances on a day-to-day basis
+ Checks that users meet their goals and follow their budget

## Design

### Domain
The domain package is to represent all the POJO [(Plain Old Java Object)](https://en.wikipedia.org/wiki/Plain_old_Java_object) entity of a bank business.
For example, Account.java is a representation of raw data for an account. This means that the Account.java will have properties such as ID, Account Balance, etc.
These POJO should contain no or very little behaviours (setter and getters).

### Services
The service package is to represent actions, operations, behaviours on your POJO. Usually the service package will use the datastore package to save, update, read, delete the POJOs.

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
Allows users to view their current accounts, such as chequing and savings accounts. User will be able to add or delete their accounts from the settings page.

### Budget
Allows users to track how they spend their money. Will be able to choose categories such as rent, utilities, food, etc. Allocates a portion of their income to each category.

### Invest
Allows user to search different stocks by symbol, and they will be given a brief overview of the stock. Users can purchase stocks and add them their portfolio. Users can manage their portfolio through the app.
