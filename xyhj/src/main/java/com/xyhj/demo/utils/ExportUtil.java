package com.xyhj.demo.utils;

import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.alibaba.fastjson.JSON;
import com.xyhj.demo.base.Result;
import com.xyhj.demo.base.ResultGenerator;
import com.xyhj.demo.base.RetEnum;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;

/**
 * @Author: WindyHu
 * @Date: 2021/5/18 14:05
 * @Description:
 */
public class ExportUtil {


    /**
     * 构造文件流输出
     * @param response
     * @param fileName
     * @param tClass
     * @param exportVOList
     * @throws Exception
     */
    public static void fileStreamOutputBuilder (HttpServletResponse response, String fileName, Class<?> tClass, List<?> exportVOList) throws Exception {
        Workbook workbook = cn.afterturn.easypoi.excel.ExcelExportUtil.exportExcel(new ExportParams(fileName, fileName, ExcelType.XSSF), tClass, exportVOList);
        response.reset();
        response.setContentType("application/msexcel;charset=UTF-8");
        // 下载文件能正常显示中文
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName + ".xlsx", "UTF-8"));
        //设置不要缓存
        response.setHeader("Pragma", "No-cache");
        //设置http状态码，如果为200时，则前端解析该文件数据。
        response.setStatus(200);
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }

    /**
     * 下载超出最大限制数量时，构造json格式返回业务提示
     * @param response
     * @throws Exception
     */
    public static void exportFailOutputJson (HttpServletResponse response) throws Exception {
        Result result = ResultGenerator.genFailResult(RetEnum.EXPORT_SIZE_OUTNUMBER);
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        //设置http状态码，如果为600时，则前端解析该json数据
        response.setStatus(600);
        PrintWriter pw = response.getWriter();
        pw.write(JSON.toJSONString(result));
        pw.flush();
        pw.close();
    }


}
