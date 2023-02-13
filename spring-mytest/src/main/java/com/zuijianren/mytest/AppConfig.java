package com.zuijianren.mytest;

import com.zuijianren.mytest.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 姜辞旧
 * @date 2023/2/13 9:14
 */
@ComponentScan("com.zuijianren.mytest")
public class AppConfig {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = (UserService) annotationContext.getBean("userService");
		userService.test();
	}
}
