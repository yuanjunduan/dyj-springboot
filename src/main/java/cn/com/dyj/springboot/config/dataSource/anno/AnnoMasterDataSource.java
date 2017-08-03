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

@Configuration
@MapperScan(basePackages = "cn.com.dyj.springboot.dao.repository.master", sqlSessionTemplateRef = "amasterSqlSessionTemplate")
public class AnnoMasterDataSource {

  @Bean(name = "amasterDataSource")
  @ConfigurationProperties(prefix = "master.datasource")
  //@Primary
  public DataSource amasterDataSource() {
    return DataSourceBuilder.create().build();
  }


  @Bean(name = "amasterTransactionManager")
  //@Primary
  public DataSourceTransactionManager amasterTransactionManager(@Qualifier("amasterDataSource") DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }

  @Bean(name = "amasterSqlSessionFactory")
  //@Primary
  public SqlSessionFactory amasterSqlSessionFactory(@Qualifier("amasterDataSource") DataSource dataSource) throws Exception {
    SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
    bean.setDataSource(dataSource);
    return bean.getObject();
  }

  @Bean(name = "amasterSqlSessionTemplate")
  //@Primary
  public SqlSessionTemplate amasterSqlSessionTemplate(@Qualifier("amasterSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
    return new SqlSessionTemplate(sqlSessionFactory);
  }

}
*/
