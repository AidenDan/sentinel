package com.alibabanacossentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaNacosSentinel8401Application {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaNacosSentinel8401Application.class, args);
    }

}
