package com.xyhj.demo;

import com.xyhj.demo.bean.User;
import com.xyhj.demo.service.UserService;
import com.xyhj.demo.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * @Author: pengquanhong
 * @Date: 2021/6/7 16:57
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@WebAppConfiguration
public class UserTest {
	
	@Autowired
	UserService service;
	
	@Test
	public void getUserList() {
		List<User> userList = service.selectList();
		System.out.println("userList = " + userList.toString());
	}
}
