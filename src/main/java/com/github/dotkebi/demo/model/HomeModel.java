package com.github.dotkebi.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class HomeModel {

  public String token;
  public TestBody contents;

  public static String getRedisKey(String token) {
    return String.format("homeModel_%s", token);
  }

  public static long getRedisTTLInSeconds() {
    return 600L;
  }

}
