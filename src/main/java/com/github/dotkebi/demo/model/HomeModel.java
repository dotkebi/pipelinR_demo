package com.github.dotkebi.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class HomeModel {

  private static final long serialVersionUID = 1L;

  public String token;

  public TestBody contents;

}
