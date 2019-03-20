package io.graversen.distributed.hashing.worker.app.configuration;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Configuration
@EnableCaching
public class RedisConfiguration
{
    @Bean
    public RedisCacheConfiguration cacheConfiguration()
    {
        return RedisCacheConfiguration.defaultCacheConfig()
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(keySerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(valueSerializer()))
                .entryTtl(Duration.ofDays(1))
                .disableCachingNullValues();
    }

    private RedisSerializer<String> keySerializer()
    {
        return new StringRedisSerializer();
    }

    private RedisSerializer<?> valueSerializer()
    {
        return new GenericJackson2JsonRedisSerializer();
    }

}
