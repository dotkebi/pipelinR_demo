package com.github.dotkebi.demo.mediator;

import an.awesome.pipelinr.Command;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Order(1)
public class Loggable implements Command.Middleware {

  @Override
  public <R, C extends Command<R>> R invoke(C c, Next<R> next) {
    R response = next.invoke();
    log.info("{} invoke {}", c.getClass().getSimpleName(), response.getClass().getSimpleName());
    return response;
  }

}
