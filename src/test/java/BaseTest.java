import cn.com.dyj.springboot.MainApplication;

import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@WebAppConfiguration
//@ActiveProfiles("development.env")
public class BaseTest extends Assert {

  protected MockMvc mockMvc;

  @Resource
  protected WebApplicationContext wac;


  @Before()
  public void initMock() {
    mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    //mockMvc = MockMvcBuilders.webAppContextSetup(wac).addFilters(filterChainProxy).build();
  }

//  public String getToken(final String email, final String password) throws UnsupportedEncodingException, Exception {
//
//    final HashMap<String, String> param = new HashMap<String, String>();
//    param.put("email", email);
//    param.put("password", password);
//    final ObjectMapper mapper = new ObjectMapper();
//    final String requestJson = mapper.writeValueAsString(param);
//
//    final String value = mockMvc.perform(
//        MockMvcRequestBuilders.post("/api/v1/login")
//            .contentType(MediaType.APPLICATION_JSON)
//            .content(requestJson)
//    )
//        .andReturn().getResponse().getContentAsString();
//
//    final Map<?, ?> map = mapper.readValue(value, Map.class);
//    return (String) map.get("token");
//  }

}