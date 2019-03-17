package io.graversen.distributed.hashing.storage.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "io.graversen.distributed.hashing.storage.app.configuration")
public class StorageApp
{
    public static void main(String[] args)
    {
        SpringApplication.run(StorageApp.class, args);
    }
}
