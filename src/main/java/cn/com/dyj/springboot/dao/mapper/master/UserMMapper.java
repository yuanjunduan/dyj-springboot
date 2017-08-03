package cn.com.dyj.springboot.dao.mapper.master;

import cn.com.dyj.springboot.entity.User;

import java.util.List;

public interface UserMMapper {
  
  List<User> findUserList();
}
