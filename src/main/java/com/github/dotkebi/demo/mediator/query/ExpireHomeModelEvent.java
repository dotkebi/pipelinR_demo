package com.github.dotkebi.demo.mediator.query;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ExpireHomeModelEvent implements Command<Voidy> {

  private String token;

}
