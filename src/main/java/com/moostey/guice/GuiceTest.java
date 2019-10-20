package com.moostey.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiceTest {

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new BillingModule());

        BillingService billingService = injector.getInstance(BillingService.class);

        PizzaOrder pizzaOrder = new PizzaOrder("Very-Veggie", 100d);
        CreditCard creditCard = new CreditCard("12345");

        Receipt receipt = billingService.chargeOrder(pizzaOrder, creditCard);

    }
}
