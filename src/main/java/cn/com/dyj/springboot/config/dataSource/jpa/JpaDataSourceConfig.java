package cn.com.dyj.springboot.config.dataSource.jpa;

import com.alibaba.druid.pool.DruidDataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class JpaDataSourceConfig {

  @Bean(name = "jMasterDataSource")
  @Primary
  @ConfigurationProperties(prefix = "spring.jpa.master.datasource")
  public DataSource jpaMasterDataSource() {
    return new DruidDataSource();
  }

  @Bean(name = "jSlaveDataSource")
  @Qualifier("jSlaveDataSource")
  @ConfigurationProperties(prefix = "spring.jpa.slave.datasource")
  public DataSource jSlaveDataSource() {
    return new DruidDataSource();
  }


  /*@Primary
  @Bean(name = "jpaMasterDataSource")
  @Qualifier("jpaMasterDataSource")
  @ConfigurationProperties(prefix = "jpa.master.datasource")
  public DataSource jpaMasterDataSource() {
    //return DataSourceBuilder.create().build();
    return new DruidDataSource();
  }

  @Bean(name = "jpaSlaveDataSource")
  @ConfigurationProperties(prefix = "jpa.slave.datasource")
  public DataSource jpaSlaveDataSource() {
    return new DruidDataSource();
  }

  @Bean(name = "masterJdbcTemplate")
  public JdbcTemplate masterJdbcTemplate(
      @Qualifier("jpaMasterDataSource") DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }

  @Bean(name = "slaveJdbcTemplate")
  public JdbcTemplate slaveJdbcTemplate(
      @Qualifier("jpaSlaveDataSource") DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }*/
}
