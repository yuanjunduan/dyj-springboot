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
@MapperScan(basePackages = XmlSlaveDataSource.PACKAGE, sqlSessionTemplateRef = "XslaveSqlSessionTemplate")
public class XmlSlaveDataSource {

  // 精确到 master 目录，以便跟其他数据源隔离
  static final String PACKAGE = "cn.com.dyj.springboot.dao.mapper.cluster";
  static final String MAPPER_LOCATION = "classpath:mapper/master/*.xml";


  @Bean(name = "XslaveDataSource")
  @ConfigurationProperties(prefix = "slave.datasource")
  public DataSource slaveDataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean(name = "XslaveSqlSessionFactory")
  public SqlSessionFactory slaveSqlSessionFactory(@Qualifier("XslaveDataSource") DataSource dataSource) throws Exception {
    SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
    bean.setDataSource(dataSource);
    bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
    return bean.getObject();
  }

  @Bean(name = "XslaveTransactionManager")
  public DataSourceTransactionManager slaveTransactionManager(@Qualifier("XslaveDataSource") DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }

  @Bean(name = "XslaveSqlSessionTemplate")
  public SqlSessionTemplate slaveSqlSessionTemplate(@Qualifier("XslaveSqlSessionFactory") SqlSessionFactory
      sqlSessionFactory) throws Exception {
    return new SqlSessionTemplate(sqlSessionFactory);
  }

}
*/
