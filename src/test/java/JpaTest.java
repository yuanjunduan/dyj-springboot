import cn.com.dyj.springboot.MainApplication;
import cn.com.dyj.springboot.entity.jpa.UserJpa;
import cn.com.dyj.springboot.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class JpaTest {
  //JpaRepository实现了PagingAndSortingRepository接口，
// PagingAndSortingRepository接口实现了CrudRepository接口，
// CrudRepository接口实现了Repository
  @Resource
  UserService user;

  @Test
  public void test1() {
    List<UserJpa> userJpas = user.list2();
    List<UserJpa> userJpas2 = user.list1();
    List<UserJpa> userJpas3 = user.list3();



      System.out.println(userJpas);
      System.out.println(userJpas2);
      System.out.println(userJpas3);

  }
}
