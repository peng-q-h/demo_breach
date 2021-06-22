package com.xyhj.demo.vo;

import com.xyhj.demo.bean.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserVo {
	
	private String groupName;
	private Long id;
	private String name;
	private String age;
	private List<UserVo> userVos;
	
	
	
	
	public static void main(String[] args) {
		
		UserVo u0 = new UserVo();
		u0.setId(1L);
		u0.setAge("12");
		u0.setName("张三");
		
		UserVo u1 = new UserVo();
		u1.setGroupName(u0.getId().toString());
		UserVo u2 = new UserVo();
		UserVo u3 = new UserVo();
		UserVo u4 = new UserVo();
		List<UserVo> list = new ArrayList<>();
		list.add(u1);
		list.add(u2);
		list.add(u3);
		list.add(u4);
		u0.setUserVos(list);
		
		System.out.println("u0 = " + u0);
	}
}
