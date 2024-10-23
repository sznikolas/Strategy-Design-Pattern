package com.example.designpattern.gateways;

import com.example.designpattern.processor.PaymentProcessor;
import org.springframework.stereotype.Component;


@Component("PayPal")
public class PayPal implements PaymentProcessor {
    @Override
    public void makePayment(double amount, String currency) {
        // PayPal-specific logic to process payment
        //actual api
        System.out.println("Payment processed via PayPal: " + amount + " " + currency);
    }
}
