package com.github.dotkebi.demo.query;

import an.awesome.pipelinr.Command;
import com.github.dotkebi.demo.model.HomeModel;
import com.github.dotkebi.demo.model.TestBody;
import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class HomeModelHandler implements Command.Handler<HomeModelQuery, HomeModel> {

  @Override
  public HomeModel handle(HomeModelQuery homeModelQuery) {
    return HomeModel.builder()
        .token(homeModelQuery.getToken())
        .contents(TestBody.builder()
            .createAt(LocalDateTime.now())
            .meaninglessContents(UUID.randomUUID().toString())
            .build())
        .build();
  }

}
