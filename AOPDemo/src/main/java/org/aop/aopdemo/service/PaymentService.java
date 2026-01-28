package org.aop.aopdemo.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public void makePayment() {
        System.out.println("Payment processed successfully");
    }

    public String getStatus() {
        return "PAYMENT_SUCCESS";
    }

    public void failPayment() {
        throw new RuntimeException("Payment failed");
    }
}
