package cn.com.dyj.springboot.dao.jpa.slave;

import cn.com.dyj.springboot.entity.jpa.UserJpa;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserCrudRepo extends CrudRepository<UserJpa, Long> {

  List<UserJpa> findByUserName(String userName);
}
