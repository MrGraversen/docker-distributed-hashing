package io.graversen.distributed.hashing.worker.app.configuration;

import com.netflix.discovery.EurekaClient;
import io.graversen.trunk.hashing.DigestUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import java.util.Objects;

@Configuration
@RequiredArgsConstructor
@ComponentScan(basePackages = {
        "io.graversen.distributed.hashing.worker.app.api",
        "io.graversen.distributed.hashing.worker.app.service",
        "io.graversen.distributed.hashing.worker.app.integration"
})
public class ApplicationConfiguration
{
    private final EurekaClient eurekaClient;
    private final CacheManager cacheManager;

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady()
    {
        cacheManager.getCacheNames().stream()
                .map(cacheManager::getCache)
                .filter(Objects::nonNull)
                .forEach(Cache::clear);
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
