package com.xyhj.demo.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyhj.demo.bean.User;
import com.xyhj.demo.bean.queryvo.UserExcelVO;
import com.xyhj.demo.bean.resultvo.UserExcelResultVO;
import com.xyhj.demo.mapper.UserMapper;
import com.xyhj.demo.service.UserService;
import com.xyhj.demo.utils.ExportUtil;
import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 12623
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
	
	@Resource
	private UserMapper userMapper;
	
	
	@Override
	public List<User> getPage() {
		IPage<User> iPage = new Page<>(1,5);
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		userMapper.selectPage(iPage,wrapper);
		
		return null;
	}
	
	@Override
	public List<User> selectList() {
		
		System.out.println(userMapper.selectById(1));
		
		LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
		
		for (int i = 0; i < 10; i++) {
			wrapper.eq(User::getId, i);
		}
		List<User> userList = userMapper.selectList(wrapper);
		System.out.println("userList = " + userList.toString());
		return userList;
	}
	
	@Override
	@SneakyThrows
	public void importDealerPartsTransferOrderDetail(MultipartFile multipartFile, HttpServletResponse response) {
		System.out.println("multipartFile =========== " + multipartFile.isEmpty());
		System.out.println("multipartFile =========== " + multipartFile.getName());
		System.out.println("multipartFile =========== " + multipartFile.getOriginalFilename());
		
		
		ImportParams params = new ImportParams();
		params.setTitleRows(0);
		params.setHeadRows(1);
		params.setNeedVerify(true);
		params.setSaveUrl("/excel/");
		params.setNeedSave(true);
		
		List<UserExcelVO> userExcelVoS = ExcelImportUtil.importExcel(multipartFile.getInputStream(), UserExcelVO.class, params);
		List<UserExcelResultVO> userExcelResultVOs = new ArrayList<>();
		userExcelVoS.forEach(item -> {
			UserExcelResultVO userExcelResultVO = new UserExcelResultVO();
			BeanUtils.copyProperties(item, userExcelResultVO);
			userExcelResultVOs.add(userExcelResultVO);
		});
		
		ExportUtil.fileStreamOutputBuilder(response, "aa", UserExcelResultVO.class, userExcelResultVOs);
		
		
//		InputStream inputStream = multipartFile.getInputStream();
//		File outFile = new File(System.getProperty("user.dir"),"aaa.xlsx");
//		System.out.println(outFile.getAbsolutePath());
//		//输出流
//		FileOutputStream fos = new FileOutputStream(outFile);
//		int len = 0;
//		byte[] bytes = new byte[1024];
//		while ((len = inputStream.read(bytes)) != -1) {
//			fos.write(bytes,0, len);
//			fos.flush();
//		}
//		inputStream.close();
//		fos.close();
		
		
		/*ExcelImportResult<UserExcelVO> result = ExcelImportUtil.importExcelMore(multipartFile.getInputStream(), UserExcelVO.class, params);
		System.out.println("userExcelVOS = " + result.toString());
	
		System.out.println("是否校验失败: " + result.isVerifyFail());
		System.out.println("校验失败的集合:" + JSONObject.toJSONString(result.getFailList()));
		System.out.println("校验通过的集合:" + JSONObject.toJSONString(result.getList()));
		for (UserExcelVO entity : result.getFailList()) {
			String msg = "第" + entity.getRowNum() + "行的错误是：" + entity.getErrorMsg();
			System.out.println(msg);
		}
		
		String multipartFileName = multipartFile.getOriginalFilename().substring(0, multipartFile.getOriginalFilename().lastIndexOf("."));
		ExportUtil.multipartFileStreamOutputBuilder(response,multipartFileName, UserExcelVO.class, result.getFailList());*/
	}
}
