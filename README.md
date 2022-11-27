# Our project

* Google drive link with all the stuff: https://drive.google.com/drive/folders/1MkSPGF1lrQHcoD-xnvADpegFCmCPfwUf?usp=sharing
* second branch for `flask`: [press me](https://github.com/SleeplessChallenger/PowaFinance/tree/master-flask)

## Brief outline

1. Product name - Powa Finance
2. Team members:
   1. Slobodeniuk Daniil - Backend developer https://github.com/SleeplessChallenger
   2. Dmitry Egorov - Android developer https://github.com/DmitrijEgorow 
   3. Roman Dubinskiy - Frontend developer https://github.com/rvdubinskiy

## Project start-up
1. create database:
   * `psql postgres`
   * `create database powa_finance;`
2. CURL commands to throw:
   - `curl -X POST http://localhost:8080/add-user -d '{"userName": "OLOLO", "email": "ssss", "passHash": "randomPass"}' -H "Content-Typ
      {"responseCode":200,"message":"Successfully added the user"}`
   - `curl http://localhost:8080/get-user-info/OLOLO`
   - `curl http://localhost:8080/get-expense/OLOLO`

## Product Description

Our system is a multi-purposed Android app which presents a lot of features for users. We've decided
to create a new app, despite barrage of competitors, as 2/3 of the apps are not userDto-friendly at all
or devoid of features which we think are helpful for the current world.

Finances and their track has always been a pet peeve for people and trying to alleviate such a burden
is an excellent choice.

Though finances may sound vague, we've decided to focus our attention at core features which, from our angle
of view, bring the most benefit and don't clutter the app making it too arduous to use.

- track finances for either individual or group of people
- observe selected stocks/bonds
- manage investments with up-to-date data on trade stocks, ETFs, mutual funds
- integration with FNS system (LKDR)

Unique factor (aka purple cow) is fully free tier with minor adds related budgeting/finances 
    or paid tier with zero adds 

**Features:**

* finance calculation: simple and crisp way to track your daily expenses:
  * userDto is able to enter daily expenses in pre-created categories or make custom ones for usability
  * for simplicity the input of data is presented in a multiple ways:
    * plain manual
    * scan
    * automatic (FNS)
* projection of expenditures for month/year with AI: 
  * userDto will see graphs/charts of the expenses for the future (resembles Sber online)
  * app provides an outline for how much you'll spend in the future based on your previous spending
    * here traditional ML is used
* adjustment of expenses to current inflation:
  * unfortunately, inflation is real and old-fashioned expenses tracker/projection is not enough
  * your expenses will change according to the inflation ratio. Re-calculation will happen once a quarter
* provides option to create shared account where multiple users can enter their spending:
  * single account is great and neat, but sometimes family wants to keep finances up to sleeve
  * each userDto will have a registration and hence each group will have admin who accepts/adds people to
    the group
    * participants will have various rights in the group
* integration with trading platforms where you can evaluate investment opportunities:
  * all of us want to multiply our earnings, so why not provide this feature?
  * app shows current most interesting stocks/bonds based on Bank of Russia API
  * our app will have access to wallet with cards on the smartphone
  * access to trading platforms where you can use card from the app
    * much more secure as we'll be an intermediary
    
## Similar Systems

1. WeBull https://www.webull.com/
2. Robinhood: https://robinhood.com/us/en/
3. Sberbank online

### Design

Link to the Figma file with Android+IOS templates: [link](https://www.figma.com/file/JRZ7YYoRnIvGuQlYjl9mhQ/PowaFinance-App?node-id=1412%3A4461)

## Database design

![Alt text](./images/database_design.png?raw=true "Database design")
