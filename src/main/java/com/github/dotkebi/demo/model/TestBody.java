package com.github.dotkebi.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

@ToString
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestBody {

  public String meaninglessContents;

  @DateTimeFormat
  @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
  public LocalDateTime createAt;

}
