package cn.com.dyj.springboot.service;

import cn.com.dyj.springboot.dao.jpa.master.UserPagSortRepo;
import cn.com.dyj.springboot.dao.jpa.slave.UserCrudRepo;
import cn.com.dyj.springboot.dao.jpa.slave.UserJpaRepos;
import cn.com.dyj.springboot.entity.jpa.UserJpa;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

@Service
public class UserService {

  @Resource
  private UserCrudRepo cru;
  @Resource
  private UserJpaRepos jpa;
  @Resource
  private UserPagSortRepo pageSort;

  public List<UserJpa> list1() {
    Iterable<UserJpa> all = cru.findAll();
    List<UserJpa> list = new ArrayList();
    for (UserJpa user : all) {
      list.add(user);
    }
    return list;
  }

  public List<UserJpa> list2() {
    Iterable<UserJpa> all = jpa.findAll();
    List<UserJpa> list = new ArrayList();
    for (UserJpa user : all) {
      list.add(user);
    }
    return list;
  }

  public List<UserJpa> list3() {
    Iterable<UserJpa> all = pageSort.findAll();
    List<UserJpa> list = new ArrayList();
    for (UserJpa user : all) {
      list.add(user);
    }
    return list;
  }
}
