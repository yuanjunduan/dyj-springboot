package cn.com.dyj.springboot.config.dataSource.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef = "jSlaveEntityManagerFactory",
    transactionManagerRef = "jSlaveTransactionManager",
    basePackages = {"cn.com.dyj.springboot.dao.jpa.slave"})
public class JpaSlaveDataSource {

  @Autowired
  private JpaProperties jProperties;

  @Autowired
  @Qualifier("jSlaveDataSource")
  private DataSource userDataSource;

  /**
   * 我们通过LocalContainerEntityManagerFactoryBean来获取EntityManagerFactory实例
   */
  @Bean(name = "jSlaveEntityManagerFactoryBean")
  //@Primary
  public LocalContainerEntityManagerFactoryBean jSlaveEntityManagerFactoryBean(EntityManagerFactoryBuilder builder) {
    return builder
        .dataSource(userDataSource)
        .properties(getVendorProperties(userDataSource))
        .packages("cn.com.dyj.springboot.entity.jpa") //设置实体类所在位置
        .persistenceUnit("userPersistenceUnit")
        .build();
    //.getObject();//不要在这里直接获取EntityManagerFactory
  }

  private Map<String, String> getVendorProperties(DataSource dataSource) {
    return jProperties.getHibernateProperties(dataSource);
  }

  /**
   * EntityManagerFactory类似于Hibernate的SessionFactory,mybatis的SqlSessionFactory 总之,在执行操作之前,我们总要获取一个EntityManager,这就类似于Hibernate的Session,
   * mybatis的sqlSession.
   */
  @Bean(name = "jSlaveEntityManagerFactory")
  //@Primary
  public EntityManagerFactory jSlaveEntityManagerFactory(EntityManagerFactoryBuilder builder) {
    return this.jSlaveEntityManagerFactoryBean(builder).getObject();
  }

  /**
   * 配置事物管理器
   */
  @Bean(name = "jSlaveTransactionManager")
  //@Primary
  public PlatformTransactionManager writeTransactionManager(EntityManagerFactoryBuilder builder) {
    return new JpaTransactionManager(jSlaveEntityManagerFactory(builder));
  }
}
