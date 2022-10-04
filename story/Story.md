

### Noun phrases
A user can add an expense.
Our app can show the performance of the user's wallet for a particular date.
A user generates a recommended Investment Portfolio of different Financial Assets.
A user is able to buy a particular Financial Asset from the generated IP provided by our app.

### Use Cases
#### Add new expense
* Actors: User
* Pre: null
* Post: one extra expense in the Wallet
* Primary scenario:
* 1. User sends date and value of expense to the System
* 2. System shows an updated list of recent expenses to the User
* Exceptions: No date provided
#### Filter user's expenses
* Actors: User
* Pre: null
* Post: clear view of expenses by category
* Primary scenario:
* 1. User sends selected period of time to the System
* 2. System shows the list of expenses to the User
* Exceptions: null
#### Generate Investment Portfolio
* Actors: User
* Pre: Constraints from business logic: budget of the user's wallet should be more than 10.000
* Post: null
* Primary scenario:
* 1. User sends Investment Horizon (date) of Portfolio to the System
* 2. System shows a list of Financial Assets to the User
* Alternative Scenarios:
* Exceptions: No date or incorrect date provided
#### Analyse User's Performance
* Actors: User
* Pre: at least one expense added to the User's Account
* Post: null
* Primary scenario:
* 1. User sends request to see a graph to the System
* 2. System shows a graph of Wallet Performance to the User
* Exceptions:

