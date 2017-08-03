package cn.com.dyj.springboot.entity.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.joda.time.DateTime;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
//无参构造 这个是数据库数据转对象时用 不加会报错
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
@Builder
public class UserJpa implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(name = "user_name")
  private String userName;
  @Column
  private String password;
  @Column
  private String phone;
  @Column
  private int status;
/*  @Column(name = "create_time")
  private DateTime createTime;*/
}
