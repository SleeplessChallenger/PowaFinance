Here we would like to present various cases in our system:

1. Get expenses of the userDto:
   * table.UserEntity uses API `/my-expenses/{userId}` which is GET request
   * `Expenses microservice` will accept the request. It is REST over HTTP, synchronous-blocking.
   * Next, microservice will take `id` of the userDto and go to the `Expenses database microservice`
        - It is some kind of wrapper around database. It will give response to the `Expense microservice`
   * `Expense microservice` will give response to the userDto

2. Add expense for the userDto:
   * table.UserEntity uses API `/my-expenses/{userId}` which is POST request
   * `Expenses microservice` will accept the request. It is REST over HTTP, synchronous-blocking.
   * Next, microservice will take `id` of the userDto and go to the `Expenses database microservice`
      - It is some kind of wrapper around database. It will add data to the `Expense microservice`
   * `Expense microservice` will give 200 if OK and 400/404 if anything else 

3. Project expenses for the next quarter:
   * table.UserEntity makes request on the API: `/project-expenses/{user_id}`
   * The request will lay in the Queue. So, it is asynchronous-nonblocking with queue-based brokers
   * `Projection microservice` will read data from the queue and make request to `Expenses microservice`
   * After request has returned, we proceed to the next request: send data via `event` to AWS
    - We will use Kafka for guaranteed delivery.
   * AWS responds to us via broker as well (as we use `event` type communication)
   * From `Projection microservice` response goes to the userDto
