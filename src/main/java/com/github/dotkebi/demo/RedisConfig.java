package com.github.dotkebi.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
//@EnableCaching
public class RedisConfig {

//  @Bean
//  public RedisConnectionFactory redisConnectionFactory() {
//    return new LettuceConnectionFactory();
//  }
//
//  @Bean
//  public StringRedisTemplate redisTemplate() {
//    var template = new StringRedisTemplate();
//    template.setConnectionFactory(redisConnectionFactory());
//    return template;
//  }

//  @Bean
//  public ObjectMapper objectMapper() {
//    JavaTimeModule module = new JavaTimeModule();
//    LocalDateTimeDeserializer localDateTimeDeserializer = new LocalDateTimeDeserializer(
//        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
//    module.addDeserializer(LocalDateTime.class, localDateTimeDeserializer);
//    return Jackson2ObjectMapperBuilder.json()
//        .modules(module)
//        .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
//        .build();
//  }

//  @Bean
//  public CacheManager redisCacheManager() {
//    RedisSerializationContext.SerializationPair<Object> jsonSerializer =
//        RedisSerializationContext.SerializationPair
//            .fromSerializer(new GenericJackson2JsonRedisSerializer(objectMapper()));
//
//    return RedisCacheManager.RedisCacheManagerBuilder
//        .fromConnectionFactory(redisConnectionFactory())
//        .cacheDefaults(
//            RedisCacheConfiguration.defaultCacheConfig()
//                .disableCachingNullValues()
//                .entryTtl(Duration.ofDays(1))
//                .serializeValuesWith(jsonSerializer)
//        )
//        .build();
//  }

}
