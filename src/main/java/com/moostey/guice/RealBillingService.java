package com.moostey.guice;

import java.util.logging.Logger;

/**
 * Real billing service implementation
 */

public class RealBillingService implements BillingService {

    private CreditCardProcessor processor;
    private TransactionLog transactionLog;
    private Logger logger;

    /**
     * @param processor      processor
     * @param transactionLog transactionLog
     */
    public RealBillingService(CreditCardProcessor processor, TransactionLog transactionLog, Logger logger) {
        this.processor = processor;
        this.transactionLog = transactionLog;
        this.logger = logger;
    }

    public CreditCardProcessor getProcessor() {
        return processor;
    }

    public TransactionLog getTransactionLog() {
        return transactionLog;
    }

    public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {
        try {
            ChargeResult result = processor.charge(creditCard, order.getAmount());
            transactionLog.logChargeResult(result);

            logger.info(String.format("Charge was %s", result.wasSuccessful() ? "applied" : "not applied"));

            return result.wasSuccessful()
                    ? Receipt.forSuccessfulCharge(order.getAmount())
                    : Receipt.forDeclinedCharge(result.getDeclineMessage());

        } catch (RuntimeException e) {
            transactionLog.logException(e);
            return Receipt.forSystemFailure(e.getMessage());
        }
    }

}
