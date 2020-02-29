package com.github.dotkebi.demo.mediator.query;

import an.awesome.pipelinr.Command;
import com.github.dotkebi.demo.model.HomeModel;
import com.github.dotkebi.demo.services.HomeModelService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Slf4j
@Component
public class HomeModelQueryHandler implements Command.Handler<HomeModelQuery, HomeModel> {

  @Autowired
  private HomeModelService service;

  @Autowired
  private StringRedisTemplate redisTemplate;

  @Autowired
  private Gson gson;

  @Override
  public HomeModel handle(HomeModelQuery request) {

    var key = HomeModel.getRedisKey(request.getToken());

    var exist = redisTemplate.hasKey(key);

    if (exist != null && exist) {
      var contents = redisTemplate.opsForValue().get(key);
      if (StringUtils.isEmpty(contents)) {
        return null;
      }
      return gson.fromJson(contents.trim(), new TypeToken<HomeModel>(){}.getType());
    }

    var optional = service.findFirstByToken(request.getToken());
    if (optional.isEmpty()) {
      return null;
    }

    var result = optional.get();
    redisTemplate.opsForValue().set(key, gson.toJson(result).trim(), HomeModel.getRedisTTLInSeconds(), TimeUnit.SECONDS);

    return result;
  }

}
