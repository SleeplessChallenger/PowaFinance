## Textual scenarios for use cases

1. User enters app 

   * Successful case:
     - User: opens PowaFinance app
     - App: authentication window appeared
     - Step 1 for User: make input for password and password
     - App: profile page appears
     - End
   * Alternative flow:
     - At Step 1: User puts incorrect password or login entered
     - App: error pops up
     - Returns to Step 1

2. Add new expense

   * Successful case:
      - User clicks "Add new expense button"
      - App: opens window with data input for the expense
      - Step 1: User inputs _amount_, _reason_. Then clicks "Add expense"
      - App: validates data (amount > 0 and < some upper bound)
      - Step 2: User observes pop-up: "Data has been saved!" and closes the pop-up
   * Alternative flow:
     - At Step 1 User's data doesn't comply with the constraints
     - App: produces according error message
     - User stays at the same step

3. Fetch news from news API

   * Successful case:
     - Step 1: User clicks "Get top-notch financial new"
     - App retrieves data and produces feed in the designated section
     - Step 2: User enters feed and see topics. Clicks on topics
     - App: Opens full news
   * Alternative flow:
     - At Step 1 there is issue with network and unsuccessful network hop
     - App: make `@Retryable` for 3 times with `@backOff` 30 seconds and `timeout`: 15 seconds
     - App: if still no result, error window "Try again later"

4. Project expenses for the next quarter

    * Successful case:
      - Step 1: User clicks "Project my expenses for the next quarter"
      - App: aggregates user's data regarding expenses and then makes request to AWS where ML model is hosted
      - Step 2: User observes pop-up: "expenses are being calculated, plz wait"
      - App: gets response from AWS and presents data to the User
      - Step 3: User analyzes data
   * Alternative flow 1:
     - After Step 1 App sees that there is not enough data (at least 1 quarter) for projecting expenses
     - App: gives error window "You need at least one quarter of data for expenses to be projected"
   * Alternative flow 2:
     - After Step 2 User waits for data to be calculated at AWS
     - App doesn't get response with `timeout` and required `@Retryable` for 3 times with `@backOff` 30 seconds
     - App produces pop-up: "Try again later"

5. Buy financial asset in the partner investing platform
    * Successful case:
      - Step 1: User clicks "Buy financial asset"
      - App: connects to the partner trading platform
      - Step 2: User selects desired financial assets and clicks "buy"
      - App: uses User's card on the android app and fetches data to the partner platform
      - App: persists changes in the database and produces success pop-up to the User
   * Alternative flow 1:
     - After Step 2 App fails to connect to trading platform with `timeout` and required `@Retryable` for 3 times with `@backOff` 30 seconds
     - App produces error pop-up: "Try again later"
   * Alternative flow 2:
     - After Step 2 App tries to retrieve money from User's card on android app, but there is not enough money
     - App produces error message: "Not enough money on the card. Plz try later"

6. Filter User's expenses
    * Successful case:
      - Step 1: User clicks _filter expenses_
      - App: opens filters to the User
      - Step 2: User fine-tunes filters
      - App: gives results
   * Alternative flow:
     - After Step 2 App understands that there is no data that fits the filters
     - App produces empty result with message: "No data according to the filters"