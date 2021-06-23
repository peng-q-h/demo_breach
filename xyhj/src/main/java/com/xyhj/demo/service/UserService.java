package com.xyhj.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xyhj.demo.bean.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


public interface UserService extends IService<User> {
	List<User> getPage();
	
	List<User> selectList();
	
	void importDealerPartsTransferOrderDetail(MultipartFile file, HttpServletResponse response);
}
