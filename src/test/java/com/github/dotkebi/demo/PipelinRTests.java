package com.github.dotkebi.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import an.awesome.pipelinr.Pipeline;
import com.github.dotkebi.demo.mediator.query.ExpireHomeModelEvent;
import com.github.dotkebi.demo.model.HomeModel;
import com.github.dotkebi.demo.mediator.query.HomeModelQuery;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.StopWatch;

@SpringBootTest
@ActiveProfiles("local")
class PipelinRTests {

  private static StopWatch stopWatch;

  @BeforeAll
  public static void setUp() {
    stopWatch = new StopWatch("pipelinR with redis");
  }

  @Autowired
  private Pipeline pipeline;

  @Autowired
  private StringRedisTemplate redisTemplate;

  @Test
  void queryTest() {
    var testToken = "testToken";

    stopWatch.start("remove previous cache");
    new ExpireHomeModelEvent(testToken).execute(pipeline);
    stopWatch.stop();

    stopWatch.start("non-cache");
    HomeModel result = new HomeModelQuery(testToken).execute(pipeline);
    stopWatch.stop();
    System.out.println(result);
    assertEquals(testToken, result.token);

    stopWatch.start("cache");
    result = new HomeModelQuery(testToken).execute(pipeline);
    stopWatch.stop();
    assertEquals(testToken, result.token);
    System.out.println(result);

    stopWatch.start("cache delete");
    new ExpireHomeModelEvent(testToken).execute(pipeline);
    stopWatch.stop();

    stopWatch.start("non-cache again");
     result = new HomeModelQuery(testToken).execute(pipeline);
    stopWatch.stop();
    System.out.println(result);
    assertEquals(testToken, result.token);

    stopWatch.start("cache again");
    result = new HomeModelQuery(testToken).execute(pipeline);
    stopWatch.stop();
    assertEquals(testToken, result.token);
    System.out.println(result);

    System.out.println(stopWatch.shortSummary());
    System.out.println(stopWatch.getTotalTimeMillis());
    System.out.println(stopWatch.prettyPrint());
  }

}
