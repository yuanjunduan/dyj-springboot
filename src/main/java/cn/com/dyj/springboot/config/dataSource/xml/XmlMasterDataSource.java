/*
package cn.com.dyj.springboot.config.dataSource.xml;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


@Configuration
@MapperScan(basePackages = XmlMasterDataSource.PACKAGE, sqlSessionTemplateRef = "XmasterSqlSessionTemplate")
public class XmlMasterDataSource {

  // 精确到 master 目录，以便跟其他数据源隔离
  static final String PACKAGE = "cn.com.dyj.springboot.dao.mapper.master";
  static final String MAPPER_LOCATION = "classpath:mapper/master/*.xml";

  //=================数据源 DruidDataSource
//  @Value("${cluster.datasource.url}")
//  private String url;
//
//  @Value("${cluster.datasource.username}")
//  private String user;
//
//  @Value("${cluster.datasource.password}")
//  private String password;
//
//  @Value("${cluster.datasource.driverClassName}")
//  private String driverClass;
//
//  @Bean(name = "XclusterDataSource")
//  public DataSource clusterDataSource() {
//    DruidDataSource dataSource = new DruidDataSource();
//    dataSource.setDriverClassName(driverClass);
//    dataSource.setUrl(url);
//    dataSource.setUsername(user);
//    dataSource.setPassword(password);
//    return dataSource;
//  }

  //================= 自带数据源
  @Bean(name = "XmasterDataSource")
  @ConfigurationProperties(prefix = "master.datasource")
  //@Primary // 同时启动anno xml 只允许一个primary
  public DataSource masterDataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean(name = "XmasterSqlSessionFactory")
  //@Primary
  public SqlSessionFactory masterSqlSessionFactory(@Qualifier("XmasterDataSource") DataSource dataSource) throws
      Exception {
    SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
    bean.setDataSource(dataSource);

    //VFS.addImplClass(SpringBootVFS.class);
    //bean.setTypeHandlersPackage("cn.com.dyj.springboot.config.handler");//转换dateTime
    //bean.setTypeAliasesPackage("cn.com.dyj.springboot.entity");

    bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
    return bean.getObject();
  }

  @Bean(name = "XmasterTransactionManager")
  //@Primary
  public DataSourceTransactionManager masterTransactionManager(@Qualifier("XmasterDataSource") DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }

  @Bean(name = "XmasterSqlSessionTemplate")
  //@Primary
  public SqlSessionTemplate masterSqlSessionTemplate(@Qualifier("XmasterSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
    return new SqlSessionTemplate(sqlSessionFactory);
  }
}
*/
