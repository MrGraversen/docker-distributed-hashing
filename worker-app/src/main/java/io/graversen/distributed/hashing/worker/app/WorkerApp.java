package io.graversen.distributed.hashing.worker.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "io.graversen.distributed.hashing.worker.app.configuration")
public class WorkerApp
{
    public static void main(String[] args)
    {
        SpringApplication.run(WorkerApp.class, args);
    }
}
