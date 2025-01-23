package com.currency.billpayapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.currency.*")
public class CurrencyBillPayAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyBillPayAppApplication.class, args);
    }

}
