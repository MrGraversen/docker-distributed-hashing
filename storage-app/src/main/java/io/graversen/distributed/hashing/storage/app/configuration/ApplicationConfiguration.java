package io.graversen.distributed.hashing.storage.app.configuration;

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
        "io.graversen.distributed.hashing.storage.app.api"
})
public class ApplicationConfiguration
{
    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady()
    {

    }

    @Bean
    public DigestUtils digestUtils()
    {
        return new DigestUtils();
    }
}
