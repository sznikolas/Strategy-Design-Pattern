package com.example.designpattern.Service;

import com.example.designpattern.processor.PaymentProcessor;
import com.example.designpattern.request.PaymentRequest;
import com.example.designpattern.response.PaymentResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Random;

@Service
public class PaymentService {

    @Autowired
    private Map<String, PaymentProcessor> paymentProcessorMap;
    //PayPal, PayPal.class

    @PostConstruct
    public void init() {
        System.out.println("Available processors: " + paymentProcessorMap.keySet());
    }

    public PaymentResponse processPayment(String gateway, PaymentRequest paymentRequest) {
        PaymentProcessor paymentProcessor = paymentProcessorMap.get(gateway);

        if (paymentProcessor == null) {
            throw new IllegalArgumentException("Payment gateway not found: " + gateway);
        }
        paymentProcessor.makePayment(paymentRequest.amount(), paymentRequest.currency());
        return new PaymentResponse(true, new Random().nextLong(1000000000L));

    }

    //    private PaymentProcessor getPaymentGatewayInstance(String gateway) {
//        PaymentProcessor processor = null;
//        switch (gateway.toLowerCase()) {
//            case "paypal":
//                processor = new PayPalAdapter();
//                break;
//            case "stripe":
//                processor = new StripeAdapter();
//                break;
//            case "gpay":
//                processor = new GPayAdapter();
//                break;
//        }
//        return processor;
//    }
}
