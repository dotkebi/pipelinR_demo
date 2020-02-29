package com.github.dotkebi.demo.mediator.query;

import an.awesome.pipelinr.Command;
import com.github.dotkebi.demo.model.HomeModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class HomeModelQuery implements Command<HomeModel> {

  private String token;

}
