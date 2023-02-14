package com.zuijianren.mytest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author 姜辞旧
 * @date 2023/2/14 9:15
 */
@Aspect
@Component
public class TestAop {

	@Pointcut("execution(* com.zuijianren.mytest.service.UserService.test())")
	public void pointcut() {
	}

	@Before("pointcut()")
	public void before(JoinPoint joinPoint) {
		Object target = joinPoint.getTarget();
		System.out.println("aop before");
	}
}
