package com.github.dotkebi.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("local")
class RedisTemplateTests {

  @Autowired
  private StringRedisTemplate template;

  @Test
  void contextLoads() {
    template.opsForValue().set("testKey", "template");
    var value = template.opsForValue().get("testKey");
    assertEquals("template", value);
    System.out.println(value);
  }

}
