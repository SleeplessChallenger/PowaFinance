Here we would like to present various cases in our system:

1. Get expenses of the user:
   * User uses API `/get-my-expenses.md/{UUID:user_id}` which is GET request
   * `Expenses microservice` will accept the request. It is REST over HTTP, synchronous-blocking.
   * Next, microservice will take `id` of the user and go to the `Expenses database microservice`
        - It is some kind of wrapper around database. It will give response to the `Expense microservice`
   * `Expense microservice` will give response to the user

2. Project expenses for the next quarter:
   * User makes request on the API: `/project-my-expenses/{UUID:user_id}`
   * The request will lay in the Queue. So, it is asynchronous-nonblocking with queue-based brokers
   * `Projection microservice` will read data from the queue and make request to `Expenses microservice`
     - This request is REST over HTTPS (TLS 1.2). It is synchronous-blocking as we need data to proceed.
   * After request has returned, we proceed to the next request: send data via `event` to AWS
    - We will use Kafka for guaranteed delivery.
   * AWS responds to us via broker as well (as we use `event` type communication)
   * From `Projection microservice` response goes to the user
