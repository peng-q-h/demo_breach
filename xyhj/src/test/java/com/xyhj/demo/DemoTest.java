package com.xyhj.demo;

import com.xyhj.demo.annotation.PassAspect;
import com.xyhj.demo.bean.Goods;
import com.xyhj.demo.bean.User;
import com.xyhj.demo.bean.UserVO;
import com.xyhj.demo.demo.AspectDemo;
import com.xyhj.demo.mapper.UserMapper;
import com.xyhj.demo.vo.UserVo;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class DemoTest {
	
	public static void main(String[] args) {
		//get();
		String s = "id,code, \"name\", lastSubstitute, nextSubstitute, shelfLife, englishName, pinyinCode,\n" +
				"referenceCode, referenceName, cadCode, cadName, partType, specification, feature,\n" +
				"\"status\", \"length\", width, height, volume, weight, material, packingAmount, mInPackingAmount,\n" +
				"packingSpecification, partsOutPackingCode, partsInPackingCode, measureUnit, isNotWarrantyTransfer,\n" +
				"creatorId, creatorName, createTime, modifierId, modifierName, modifyTime, abandonerId,\n" +
				"abandonerName, abandonTime, groupABCCategory, imsCompressionNumber, imsManufacturerNumber,\n" +
				"productBrand, rowVersion, substandardName, totalNumber, factury, isOriginal, categoryCode,\n" +
				"overseasPartsFigure, categoryName, expandLanguageNAME1, expandLanguageCode1, expandLanguageCode13,\n" +
				"expandLanguageNAME13, expandLanguageCode12, expandLanguageNAME12, expandLanguageCode11,\n" +
				"expandLanguageNAME11, expandLanguageCode10, expandLanguageNAME10, expandLanguageCode9,\n" +
				"expandLanguageNAME9, expandLanguageCode8, expandLanguageNAME8, expandLanguageCode7,\n" +
				"expandLanguageNAME7, expandLanguageCode6, expandLanguageNAME6, expandLanguageCode5,\n" +
				"expandLanguageNAME5, expandLanguageCode4, expandLanguageNAME4, expandLanguageCode3,\n" +
				"expandLanguageNAME3, expandLanguageCode2, expandLanguageNAME2, exchangeIdentification,\n" +
				"goldenTaxClassifyId, goldenTaxClassifyCode, goldenTaxClassifyName, standardCode,\n" +
				"standardName, oMSparePartMark, repairNumber, isOil, oilRate, isOneThingYard, faultSubCode,\n" +
				"codeLength, isAddMosaic, newLogoStyle, newIdentificationMethod, newImageExplanation,\n" +
				"newLogoPosition, newLogoRemarks, newImageAddress, isRetrospective, codeMarkSource,\n" +
				"partPriceIncreaseRateId, isDriveHouse, vehicleBodyModelDes, isAssembleOrSplitPart,\n" +
				"isEliminate, mngPartsAddTime, varietyCode, varietyName, versionNumber, isSelfMade,\n" +
				"isChangeTechStatus, partsAliasName, partsAliasId";
		
		
		
		// a.id, a.code, a."name", a.lastSubstitute, a.nextSubstitute, a.shelfLife, a.englishName, a.pinyinCode,
		//referenceCode, a.referenceName, a.cadCode, a.cadName, a.partType, a.specification, a.feature,
		//"status", a."length", a.width, a.height, a.volume, a.weight, a.material, a.packingAmount, a.mInPackingAmount,
		//packingSpecification, a.partsOutPackingCode, a.partsInPackingCode, a.measureUnit, a.isNotWarrantyTransfer,
		//creatorId, a.creatorName, a.createTime, a.modifierId, a.modifierName, a.modifyTime, a.abandonerId,
		//abandonerName, a.abandonTime, a.groupABCCategory, a.imsCompressionNumber, a.imsManufacturerNumber,
		//productBrand, a.rowVersion, a.substandardName, a.totalNumber, a.factury, a.isOriginal, a.categoryCode,
		//overseasPartsFigure, a.categoryName, a.expandLanguageNAME1, a.expandLanguageCode1, a.expandLanguageCode13,
		//expandLanguageNAME13, a.expandLanguageCode12, a.expandLanguageNAME12, a.expandLanguageCode11,
		//expandLanguageNAME11, a.expandLanguageCode10, a.expandLanguageNAME10, a.expandLanguageCode9,
		//expandLanguageNAME9, a.expandLanguageCode8, a.expandLanguageNAME8, a.expandLanguageCode7,
		//expandLanguageNAME7, a.expandLanguageCode6, a.expandLanguageNAME6, a.expandLanguageCode5,
		//expandLanguageNAME5, a.expandLanguageCode4, a.expandLanguageNAME4, a.expandLanguageCode3,
		//expandLanguageNAME3, a.expandLanguageCode2, a.expandLanguageNAME2, a.exchangeIdentification,
		//goldenTaxClassifyId, a.goldenTaxClassifyCode, a.goldenTaxClassifyName, a.standardCode,
		//standardName, a.oMSparePartMark, a.repairNumber, a.isOil, a.oilRate, a.isOneThingYard, a.faultSubCode,
		//codeLength, a.isAddMosaic, a.newLogoStyle, a.newIdentificationMethod, a.newImageExplanation,
		//newLogoPosition, a.newLogoRemarks, a.newImageAddress, a.isRetrospective, a.codeMarkSource,
		//partPriceIncreaseRateId, a.isDriveHouse, a.vehicleBodyModelDes, a.isAssembleOrSplitPart,
		//isEliminate, a.mngPartsAddTime, a.varietyCode, a.varietyName, a.versionNumber, a.isSelfMade,
		//isChangeTechStatus, a.partsAliasName, a.partsAliasId
		
		String a = "id,parentId,sparePartId,sparePartCode,sparePartName,salesPrice,retailGuidePrice,\n" +
				"dealerSalesPrice,priceType,validationTime,expireTime,remark,rowVersion,categoryCode,\n" +
				"categoryName,salesPriceFluctuationRatio,retailPriceFluctuationRatio,maxSalesPriceFloating,\n" +
				"minSalesPriceFloating,maxRetailOrderPriceFloating,minRetailOrderPriceFloating,\n" +
				"maxPurchasePricing,isUpsideDown,maxExchangeSalePrice";
		//pspcd.id, pspcd.parentId, pspcd.sparePartId, pspcd.sparePartCode, pspcd.sparePartName, pspcd.salesPrice, pspcd.retailGuidePrice, pspcd.
		//dealerSalesPrice, pspcd.priceType, pspcd.validationTime, pspcd.expireTime, pspcd.remark, pspcd.rowVersion, pspcd.categoryCode, pspcd.
		//categoryName, pspcd.salesPriceFluctuationRatio, pspcd.retailPriceFluctuationRatio, pspcd.maxSalesPriceFloating, pspcd.
		//minSalesPriceFloating, pspcd.maxRetailOrderPriceFloating, pspcd.minRetailOrderPriceFloating, pspcd.
		//maxPurchasePricing, pspcd.isUpsideDown, pspcd.maxExchangeSalePrice
		//getField(a);
//
//		Goods goods1 = new Goods();
//		goods1.setBrandName("aaa");
//		goods1.setCategoryName("bbb");
//		goods1.setPrice(new BigDecimal(12));
//
//		Goods goods2 = new Goods();
//		BeanUtils.copyProperties(goods1,goods2);
//
//
//		Goods goods3 = new Goods();
//		goods3.setId(111D);
//
//		BeanUtils.copyProperties(goods3,goods2,"brandName","price","categoryName");
//
//		System.out.println("goods1 = " + goods1);
//		System.out.println("goods3 = " + goods3);
//		System.out.println("goods2 = " + goods2);
//
//
		//getBean();
		
		bigDecimalTest();
		
	}
	
	public static void bigDecimalTest() {
		BigDecimal a = new BigDecimal(1);
		BigDecimal b = new BigDecimal(2);
		BigDecimal count = new BigDecimal(0);
		for (int i = 0; i < 10; i++) {
			a = a.add(b);
		}
		System.out.println("a = " + a);
	}
	
	
	public static void getBean() {
		UserVO userVo = new UserVO();
		userVo.setId(1);
		userVo.setName("张三");
		userVo.setSex("男");
		User user = new User();
		BeanUtils.copyProperties(userVo,user);
		
		System.out.println("user = " + user);
	}
	
	public static void get() {
		Date d = new Date();
		System.out.println(d);
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd_HHmmss_SSS");
		String dateNowStr = sdf.format(d);
		System.out.println("格式化后的日期：" + dateNowStr);
		
//		String str = "2012113_172633_123";  //要跟上面sdf定义的格式一样
//		Date today = null;
//		try {
//			today = sdf.parse(str);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		System.out.println("字符串转成日期：" + today);
	}
	
	// 获取字符串b在a中首次出现的位置,不存在则返回-1,当b为空字符串时,返回0
	public static int strStr(String a, String b) {
		int aLen = a.length(), bLen = b.length();
		
		for (int i = 0; i + bLen <= aLen; i++) {
			boolean flag = true;
			for (int j = 1; j < bLen; j++) {
				if (a.charAt(i+j) != b.charAt(j)) {
					flag = false;
					break;
				}
			}
			if (flag) {
				return i;
			}
		}
		return -1;
	}
	
	public static void getAnnotation() {
		Class<AspectDemo> demoClass = AspectDemo.class;
		Method execution = null;
		try {
			execution = demoClass.getDeclaredMethod("execution");
			PassAspect aspect = execution.getDeclaredAnnotation(PassAspect.class);
			System.out.println(aspect.value());
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void getField(String s) {
		String s1 = s.replaceAll(",", ", pspcd.");
		System.out.println("s1 = " + s1);
	}
	
	
	
	
	@Resource
	UserMapper userMapper;
	
	@Test
	public void export() {
		User user = new User(1,"zhangsan","12");
		InputStream is = null;
		XSSFWorkbook workbook = null;
		try {
			is = new FileInputStream("src/test/resources/user.xlsx");
			workbook = new XSSFWorkbook(is);
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow row = sheet.createRow(1);
			row.createCell(0).setCellValue(user.getId());
			row.createCell(1).setCellValue(user.getName());
			row.createCell(2).setCellValue(user.getAge());
			Date d = new Date();
			System.out.println(d);
			SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd_HHmmss_SSS");
			String dateNowStr = sdf.format(d);
			System.out.println("格式化后的日期：" + dateNowStr);
			workbook.write(new FileOutputStream("F:\\user__"+ dateNowStr +".xlsx"));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				workbook.close();
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
}
