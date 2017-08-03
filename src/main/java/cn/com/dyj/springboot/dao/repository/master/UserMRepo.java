/*
package cn.com.dyj.springboot.dao.repository.master;

import cn.com.dyj.springboot.config.handler.DateTimeTypeHandler;
import cn.com.dyj.springboot.entity.User;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMRepo {

  @Select("select * from user")
  @Results({
      @Result(column = "user_name", property = "userName"),
      @Result(column = "create_time", property = "createTime", typeHandler = DateTimeTypeHandler.class)
  })
  List<User> findUserList();
}*/
