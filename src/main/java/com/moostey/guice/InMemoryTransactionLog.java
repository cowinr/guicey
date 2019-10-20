package com.moostey.guice;

import com.google.inject.Inject;

import java.util.logging.Logger;

public class InMemoryTransactionLog implements TransactionLog {

    private final Logger logger;

    @Inject
    public InMemoryTransactionLog(Logger logger) {
        this.logger = logger;
    }

    public void logChargeResult(ChargeResult chargeResult) {
        logger.info(String.format("Charge has been processed for %s", chargeResult.getAmount()));
    }

    public void logException(RuntimeException e) {
        e.printStackTrace();
    }

}
