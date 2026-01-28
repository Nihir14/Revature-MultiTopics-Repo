package org.aop.aopdemo.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.aop.aopdemo.config.AppConfig;
import org.aop.aopdemo.service.PaymentService;

public class MainApp {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        PaymentService paymentService =
                context.getBean(PaymentService.class);

        paymentService.makePayment();
        paymentService.getStatus();

        try {
            paymentService.failPayment();
        } catch (Exception ignored) {}
    }
}
