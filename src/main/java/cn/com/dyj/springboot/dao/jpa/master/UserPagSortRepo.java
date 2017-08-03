package cn.com.dyj.springboot.dao.jpa.master;

import cn.com.dyj.springboot.entity.jpa.UserJpa;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserPagSortRepo extends PagingAndSortingRepository<UserJpa, Long> {
}
