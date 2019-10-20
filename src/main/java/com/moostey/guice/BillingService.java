package com.moostey.guice;

/**
 * Billing Service.
 */
//@ImplementedBy(com.moostey.guice.RealBillingService.class)
public interface BillingService {

    /**
     * @param order      order
     * @param creditCard cc
     * @return com.moostey.guice.Receipt
     */
    Receipt chargeOrder(PizzaOrder order, CreditCard creditCard);

}
