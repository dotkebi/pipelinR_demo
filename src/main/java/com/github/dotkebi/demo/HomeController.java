package com.github.dotkebi.demo;

import an.awesome.pipelinr.Pipeline;
import com.github.dotkebi.demo.model.HomeModel;
import com.github.dotkebi.demo.query.HomeModelQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

  @Autowired
  private Pipeline pipeline;

  @GetMapping({"", "/", "/home"})
  public ResponseEntity<HomeModel> home() {
    HomeModel result = new HomeModelQuery("testToken").execute(pipeline);
    return ResponseEntity.ok(result);
  }

}
