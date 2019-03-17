package io.graversen.distributed.hashing.worker.app.configuration;

import com.netflix.discovery.EurekaClient;
import io.graversen.trunk.hashing.DigestUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
@RequiredArgsConstructor
@ComponentScan(basePackages = {
        "io.graversen.distributed.hashing.worker.app.api",
        "io.graversen.distributed.hashing.worker.app.service"
})
public class ApplicationConfiguration
{
    private final EurekaClient eurekaClient;

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady()
    {

    }

    @Bean
    public DigestUtils digestUtils()
    {
        return new DigestUtils();
    }

    @Bean
    public String instanceId()
    {
        return eurekaClient.getApplicationInfoManager().getInfo().getInstanceId();
    }
}
