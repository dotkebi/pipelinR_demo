package com.github.dotkebi.demo.services;

import com.github.dotkebi.demo.model.HomeModel;
import com.github.dotkebi.demo.model.TestBody;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HomeModelService {

  @Cacheable("homeModel")
  public Optional<HomeModel> findFirstByToken(String token) {
    try {
      log.info("long process time...");
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      log.error(e.getMessage());
    }

    return Optional.of(HomeModel.builder()
        .token(token)
        .contents(TestBody.builder()
            .createAt(LocalDateTime.now())
            .meaninglessContents(UUID.randomUUID().toString())
            .build())
        .build());
  }

}
