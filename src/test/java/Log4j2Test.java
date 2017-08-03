import cn.com.dyj.springboot.MainApplication;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class Log4j2Test {
 // protected final Logger logger = LoggerFactory.getLogger(this.getClass());
  protected final ObjectMapper objectMapper = new ObjectMapper();

  @Test
  public void contextLoads() {

    Log4j2.class.getClassLoader().getParent();




//    logger.trace("I am trace log.");
//    logger.debug("I am debug log.");
//    logger.warn("I am warn log.");
//    logger.error("I am error log.");
  }
}
