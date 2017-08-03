package cn.com.dyj.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

  private Long id;
  private String name;
  private String description;
  private String resourceIds;
  private String available;
}

