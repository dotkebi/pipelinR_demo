package com.github.dotkebi.demo.mediator.query;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;
import com.github.dotkebi.demo.model.HomeModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ExpireHomeModelEventHandler implements
    Command.Handler<ExpireHomeModelEvent, Voidy> {

  @Autowired
  private StringRedisTemplate redisTemplate;

  @Override
  public Voidy handle(ExpireHomeModelEvent command) {
    var key = HomeModel.getRedisKey(command.getToken());
    redisTemplate.delete(key);
    return new Voidy();
  }

}
