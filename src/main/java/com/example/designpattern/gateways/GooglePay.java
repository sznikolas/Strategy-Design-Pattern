package com.example.designpattern.gateways;

import com.example.designpattern.processor.PaymentProcessor;
import org.springframework.stereotype.Component;

@Component("GooglePay")
public class GooglePay implements PaymentProcessor {

    @Override
    public void makePayment(double amount, String currency) {
        // GooglePay-specific logic to process payment
        System.out.println("Payment processed via GooglePay: " + amount + " " + currency);
    }
}
