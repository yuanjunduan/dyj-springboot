/*
import cn.com.dyj.springboot.MainApplication;
import cn.com.dyj.springboot.dao.mapper.master.UserMMapper;
import cn.com.dyj.springboot.entity.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class MapperTest {

  @Resource
  private UserMMapper userRepo;


  @Test
  public void findUserList() throws Exception {

    // final List<User> list = uc.findAll();
    //final List<User> listm = um.findAllUserList1();
    //List<User> userList = userRepo.findUserList();

    List<User> userList = userRepo.findUserList();
    System.out.println(userList);


  }
}
*/
