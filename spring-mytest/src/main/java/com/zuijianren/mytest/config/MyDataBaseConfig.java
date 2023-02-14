package com.zuijianren.mytest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 数据库相关配置
 *
 * @author 姜辞旧
 * @date 2023/2/14 13:41
 */
@EnableTransactionManagement
@Component
// 1. 使用该注解, 可以解决下方被注释代码中通过 dataSource() 方法 获取的 DataSource 不是同一个对象(每次都是一个新对象)的问题
// 2. 当然即使不适用注解, 也可以通过 参数 注入的方法, 保证两者获取的 DataSource 是同一个对象, 如下方未注释的代码 (注意: 依然得保证类有一个@Component注解, 否则Spring不会进行扫描)
// 		此外, 使用 @Configuration 会生成一个代理类 仅只有@Component注解(没有添加什么切面之类的东西)时不会生成代理类
// todo 查看一下当前配置类被代理后的样子
//@Configuration
public class MyDataBaseConfig {

//	@Bean
//	public JdbcTemplate jdbcTemplate() {
//		DataSource dataSource = dataSource();
//		return new JdbcTemplate(dataSource);
//	}
//
//	@Bean
//	public TransactionManager transactionManager() {
//		DataSource dataSource = dataSource();
//		return new DataSourceTransactionManager(dataSource);
//	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean
	public TransactionManager transactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://client1:3306/spring_framework_spring_mytest?characterEncoding=utf-8");
		dataSource.setUsername("spring_framework_spring_mytest");
		dataSource.setPassword("test");
		return dataSource;
	}

}
