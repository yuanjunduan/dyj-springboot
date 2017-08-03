package cn.com.dyj.springboot.api;

import cn.com.dyj.springboot.entity.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import lombok.extern.slf4j.Slf4j;

import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import springfox.documentation.annotations.ApiIgnore;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@RequestMapping("/hello")
@Api("userController相关api")
public class HelloWorldApi {

  // @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
  @ApiOperation(value = "功能操作", notes = "具体说明")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
      @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
  })
  @RequestMapping(value = "/world", method = RequestMethod.PUT)
  public String helloWorld() {
    return "你好";
  }


  @ApiOperation(value = "测试freemark", notes = "跳转到一个页面")
  @RequestMapping(value = "/free", method = RequestMethod.GET)
  public String freemark(Model model, User user) {
    model.addAttribute("name", "小段");
    model.addAttribute("age", "26");
    model.addAttribute("address", "哪里都是家");

    model.addAttribute("date", new DateTime());

    return "freemark";
  }

  @ApiIgnore
  @ApiOperation(value = "忽略一个方法", notes = "忽略一个方法")
  @RequestMapping(value = "/ignore", method = RequestMethod.GET)
  public String ignore(Model model, User user) {

    return "freemark";
  }

  @PostMapping(value = "/upload")
  public void upload(HttpServletRequest request) throws IOException {

    List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
    MultipartFile file = null;
    BufferedOutputStream stream = null;

    File tempFile = new File("D:\\ETest\\upload");
    if (!tempFile.exists()) {
      tempFile.mkdir();
    }

    for (int i = 0; i < files.size(); ++i) {
      file = files.get(i);
      if (!file.isEmpty()) {
        try {

          //重命名上传后的文件名
          String localFilePath = tempFile + File.separator + new DateTime() + file.getOriginalFilename();
          //定义上传路径
          File localFile = new File(localFilePath);
          file.transferTo(localFile);


          byte[] bytes = file.getBytes();
          stream = new BufferedOutputStream(new FileOutputStream(new File(tempFile + File.separator + file.getOriginalFilename())));
          stream.write(bytes);
          stream.close();
        } catch (Exception e) {
          //TODO 异常处理
        }
      } else {
        //FIXME 文件为空怎么处理
      }
    }
  }
}