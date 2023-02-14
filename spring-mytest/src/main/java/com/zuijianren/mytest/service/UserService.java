package com.zuijianren.mytest.service;

import com.zuijianren.mytest.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 姜辞旧
 * @date 2023/2/13 10:47
 */
@Component
public class UserService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void test() {
		System.out.println("test");
	}

	public void queryTest() {
		User user = jdbcTemplate.queryForObject("select * from t_user where userId =1", new BeanPropertyRowMapper<User>(User.class));
		System.out.println(user);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void transactionalTest() {
		jdbcTemplate.update("insert into t_user (userId, username) values (2, '小明') ");
		int i = 5 / 0;
	}

}
