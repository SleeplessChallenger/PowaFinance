## PowaFinance: Flask edition

### quick intro to the project

1. make virtualenv
2. install `requirements.txt`
3. create postgres database, in this case `powa_finance_flask`:
   * `psql postgres`
   * `create database powa_finance_flask;`
3. start `app.py`
4. throw CURL requests:
    * `curl http://localhost:8082/add-user -d '{"username": "SuperName", "email": "duper@mail.com"}' -H "Content-Type: application/json"`
    * successful get: `curl http://localhost:8082/get-user-info/SuperName`
    * erroneous get: ` curl http://localhost:8082/get-user-info/randomName`