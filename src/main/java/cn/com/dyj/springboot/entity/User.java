package cn.com.dyj.springboot.entity;

import io.swagger.annotations.ApiModelProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.joda.time.DateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Builder 链式编程 不推荐
public class User {

  // 用户Id
  @ApiModelProperty(value = "用户id")
  private Long id;

  //用户名
  @ApiModelProperty(name = "userName", value = "用户名", dataType = "String")
  private String userName;

  private String password;
  private String phone;
  private int status;
  

  //用户创建时间
  @ApiModelProperty(name = "createTime", value = "用户创建时间", dataType = "DateTime")
  private DateTime createTime;
}