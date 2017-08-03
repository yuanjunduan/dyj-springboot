/*
package cn.com.dyj.springboot.config.dataSource.anno;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


*/
/**
 * Created by summer on 2016/11/25.
 *//*

@Configuration
@MapperScan(basePackages = "cn.com.dyj.springboot.dao.repository.slave", sqlSessionTemplateRef = "aslaveSqlSessionTemplate")
public class AnnoSlaveDataSource {

  @Bean(name = "aslaveDataSource")
  @ConfigurationProperties(prefix = "slave.datasource")
  public DataSource aslaveDataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean(name = "aslaveSqlSessionFactory")
  public SqlSessionFactory aslaveSqlSessionFactory(@Qualifier("aslaveDataSource") DataSource dataSource) throws Exception {
    SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
    bean.setDataSource(dataSource);
    return bean.getObject();
  }

  @Bean(name = "aslaveTransactionManager")
  public DataSourceTransactionManager aslaveTransactionManager(@Qualifier("aslaveDataSource") DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }

  @Bean(name = "aslaveSqlSessionTemplate")
  public SqlSessionTemplate aslaveSqlSessionTemplate(@Qualifier("aslaveSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
    return new SqlSessionTemplate(sqlSessionFactory);
  }

}
*/
