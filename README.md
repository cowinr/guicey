# FreshGuice
A hands on practice package for Google Guice. 

This maven project implements a com.moostey.guice.BillingService which charges a com.moostey.guice.PizzaOrder using a com.moostey.guice.CreditCard and generated a com.moostey.guice.Receipt.
See classes in package for more details.

### Interfaces
* com.moostey.guice.BillingService - charges an order using a credit card
* com.moostey.guice.CreditCardProcessor - debits some amount from credit card
* com.moostey.guice.TransactionLog - logs results
### Classes
**src**
* com.moostey.guice.CreditCard - entity representing a Credit Card
* com.moostey.guice.PizzaOrder - entity representing a Pizza order
* com.moostey.guice.Receipt - entity representing a receipt
* com.moostey.guice.RealBillingService implements com.moostey.guice.BillingService
* com.moostey.guice.PaypalCreditCardProcessor implements com.moostey.guice.CreditCardProcessor
* com.moostey.guice.BankCreditCardProcessor implements com.moostey.guice.CreditCardProcessor
* com.moostey.guice.InMemoryTransactionLog implements com.moostey.guice.TransactionLog
* com.moostey.guice.GuiceTest - Main class which uses com.moostey.guice.BillingService
* com.moostey.guice.BillingModule - All Guice bindings go here

**tst** 
* GuiceInjectionTest : Unit tests to check binding constraints

### Task
The task here is to create Guice Bindings in the com.moostey.guice.BillingModule such that the following constraints are satisfied: 

1. All implementations of com.moostey.guice.BillingService should be bound to com.moostey.guice.RealBillingService.
2. com.moostey.guice.CreditCardProcessor interface annotated with @Paypal should be bound to com.moostey.guice.PaypalCreditCardProcessor class.
3. com.moostey.guice.CreditCardProcessor interface named with string “Bank” should be bound to com.moostey.guice.BankCreditCardProcessor class.
4. com.moostey.guice.BillingService instances returned by injector should have instance of com.moostey.guice.BankCreditCardProcessor as their dependency.
5. All implementations of com.moostey.guice.TransactionLog should be bound to com.moostey.guice.InMemoryTransactionLog.

All 5 unit tests in GuiceInjectionTests should pass if the above conditions are satisfied.
You should also be able to run the main method in com.moostey.guice.GuiceTest. 
 
For now, [this](https://github.com/google/guice/wiki/GettingStarted) is the user guide to follow. 

 




