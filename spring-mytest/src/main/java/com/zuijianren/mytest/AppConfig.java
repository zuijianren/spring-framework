package com.zuijianren.mytest;

import com.zuijianren.mytest.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author 姜辞旧
 * @date 2023/2/13 9:14
 */
@ComponentScan("com.zuijianren.mytest")
@EnableAspectJAutoProxy
public class AppConfig {


	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = (UserService) annotationContext.getBean("userService");
		// 基础测试
//		userService.test();
		// 测试 jdbc
//		userService.queryTest();
		// 测试事务
		userService.transactionalTest();
	}
}
