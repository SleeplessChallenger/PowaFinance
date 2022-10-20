

### Noun phrases
A user can add an expense.
Our app can show the performance of the user's wallet for a particular date.
A user generates a recommended Investment Portfolio of different Financial Assets.
A user is able to buy a particular Financial Asset from the generated IP provided by our app.

### Use Cases

#### Add new expense
* Actors: User
* Pre: User is registered in the app
* Post: one extra expense in the Wallet
* Primary scenario:
1. User inputs data:
   * amount of expense - required
   * category - optional
   * note - optional
   * date - generates automatically
2. System check correctness of the data:
   * category is within particular ranges (constraint in the app and database)
   * amount > 0 and < n number
3. System saves data in the database:
   * everything gets updated in the database
   * UI receives trigger that new data appeared in database and pulls data (MVC approach)

* Exceptions:
  * point 2 shows possible issues
  * problems with connection:
    * 3 retries
    * 15 seconds timeout from database
    * 30 seconds backoff

#### Filter user's expenses
* Actors: User
* Pre: User has some amount of expenses in database. Else - filter is disabled
* Post: clear view of expenses by category and possible slicers for time
* Primary scenario:
1. User selects period of time which he wants to observe and has a feature to specify amount of expenses
2. System hooks the filter and goes to the database to search for the specified filters
3. System shows:
   * expense - time - category - note
   * if nothing in database: sad picture of "nothing to present"

* Exceptions:
  * user selects too big period of time and there is slow internet connection: "Try later as connection is unstable"

#### Buy financial asset
* Side note: **financial asset** is either stock or bond that has been bought by the user and now in his possession.<br>
  It is in full responsibility of the user and he can buy more of the same ilk or sell it.

* Pre: User is registered and allows our app to leverage pay system on the smartphone (i.e. Google Pay/Android Pay etc)
* Post: User will have asset on the platform account and in our database we will have some mark as well
* Primary scenario:
1. User clicks button in our app to show stocks/bonds for the selected price.
2. Data is fetched via API from the Investment Platform.
3. He adds desired stocks/bonds to the so-called bucket and then clicks on it to go to the checkout.
4. After checkout data is sent to the Investment platform again where user is registered via our app.
5. Changes appear on the both platforms: our and theirs
   * ours: certain category in the app will show pertaining data
   * theirs: depends on the final partner - Investment Platform

* Exceptions:
  * User's card, attached to the paying system, has some issues
  * Investment Platform has some network problems

#### Generate Investment Portfolio
* Actors: User
* Pre: Constraints from business logic: sum of the user's bought assets should be more than 10.000 rubles
* Post: User observes all the data regarding bought assets
* Primary scenario:
1. User clicks special button to see all the bought assets divided into categories:
   * time ranges which they have been bought
   * categories of the assets: stocks/bonds, oil & gas/tech etc
   * most fluctuating ones
2. UI pictures the result nicely on the page and draws additional graphs to supplement the view

* Exceptions:
  * Weak internet connection as, firstly, response with heavy payload will be received, secondly, graphs will be drawn based on it
  * Investment platform has network issues

#### Project User's expenses
* Actors: User
* Pre: at least 10 expenses added to the User's Account and a quarter of time spent
* Post: User observes the projection of his expenses for the next quarter
* Primary scenario:
1. User clicks button to project his expenses for the next quarter
2. System uses ML model to predict his expenses
3. UI shows all the projected expenses:
   * by category
   * by rough sum of money

* Exceptions:
  * ML model hosted on the separate platform gives error due to network issues

#### Get top-notch news from third-party new agency
* Actors: User
* Pre: Just being registered
* Post: A Bunch of events regarding financial sector
* Primary scenario:
1. User, being logged in, clicks to see the newest snippets of news
2. System fetches data from third-party news agency
3. UI draws them nicely
* Exceptions:
  * News Agency has network issues
  * Somehow News Agency sends too big chunk of info, and we don't want to process it


## Story
![Alt text](story.png?raw=true "Story map")