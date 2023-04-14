package com.example.demo.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration  //@Configuration �� �ִ� ���ϵ��� ���α׷��� ���۵Ǹ� �˾Ƽ� ��ü���� ȣ��ȴ�
public class MyBatisConfig {

	//hikari �����ϱ�   
	@Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig() {
		
		System.out.println("********");
        return new HikariConfig();
    }

    @Bean
    public DataSource dataSource() {
        return new HikariDataSource(hikariConfig());
    }
	    
	@Bean   //��ü�� �����
	public SqlSessionFactory makeSqlSessionFactory(
			DataSource  dataSource) throws Exception 
	{
		
		System.out.println("********");
		final SqlSessionFactoryBean factory  
		   = new SqlSessionFactoryBean();
		
		//����ü�� application.properties ���Ͽ� �ִ�  datasource
		//�� ���� 
		factory.setDataSource(dataSource);
		//�������ϰ� �����ϱ�(mybatis-config.xml)���ϰ� ����
		PathMatchingResourcePatternResolver resolver 
		  = new PathMatchingResourcePatternResolver();
		//classpath - src/main/resource  : ��������Ʈ�� �����Ҷ� �ۼ��Ҷ� xml������ ���� ����. ���  xml ������ resouce������ ���� 
		Resource configLocation = resolver.getResource("classpath:mybatis-config.xml");
		
		factory.setConfigLocation(configLocation);
		return factory.getObject();
		
	}
	
	@Bean 
	public SqlSessionTemplate makeSqlSession(
			SqlSessionFactory factory)
	{
		return new SqlSessionTemplate(factory);
	}
	
	
}