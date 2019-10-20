package com.moostey.guice;

import com.moostey.guice.annotations.Paypal;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Names;

import java.util.logging.Logger;

public class BillingModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(CreditCardProcessor.class).annotatedWith(Paypal.class).to(PaypalCreditCardProcessor.class);
        bind(CreditCardProcessor.class).annotatedWith(Names.named("Bank")).to(BankCreditCardProcessor.class);
        bind(CreditCardProcessor.class).to(BankCreditCardProcessor.class);
        bind(TransactionLog.class).to(InMemoryTransactionLog.class);
    }

    @Provides
    @Singleton
    public BillingService getBillingService(CreditCardProcessor ccp, TransactionLog transactionLog, Logger logger) {
        return new RealBillingService(ccp, transactionLog, logger);
    }
}
