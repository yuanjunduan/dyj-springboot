package cn.com.dyj.springboot.dao.jpa.slave;

import cn.com.dyj.springboot.entity.jpa.UserJpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepos extends JpaRepository<UserJpa, Long> {
}
