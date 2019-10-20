package com.moostey.guice;

public interface CreditCardProcessor {

    ChargeResult charge(CreditCard creditCard, Double amount);
}
