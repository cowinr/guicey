package com.moostey.guice;

public class Receipt {

    private String receiptMessage;

    public Receipt(String receiptMessage) {
        this.receiptMessage = receiptMessage;
    }

    public static Receipt forSuccessfulCharge(Double amount) {
        return new Receipt("com.moostey.guice.Receipt: Received " + amount);
    }

    public static Receipt forDeclinedCharge(String declineMessage) {
        return new Receipt(declineMessage);
    }

    public static Receipt forSystemFailure(String message) {
        return new Receipt(message);
    }

    public String getReceiptMessage() {
        return receiptMessage;
    }
}
