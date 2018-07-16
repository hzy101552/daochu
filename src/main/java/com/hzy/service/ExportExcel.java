package com.hzy.service;

import java.io.BufferedOutputStream;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
 
import javax.servlet.http.HttpServletResponse;
 
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportExcel<T> {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void exportExcel(String[] headers,Collection<T> dataset, String fileName,HttpServletResponse response) {
		// 声明一个工作薄
		XSSFWorkbook workbook = new XSSFWorkbook();
		// 生成一个表格
		XSSFSheet sheet = workbook.createSheet(fileName);
		// 设置表格默认列宽度为20个字节
		sheet.setDefaultColumnWidth((short) 20);
		// 产生表格标题行
		XSSFRow row = sheet.createRow(0);
		//创建表头
		for (short i = 0; i < headers.length; i++) {
			//总共需要多少单元格(列)
			XSSFCell cell = row.createCell(i);
			//单元格的名字
			XSSFRichTextString text = new XSSFRichTextString(headers[i]);
			//赋值
			cell.setCellValue(text);
		}
		try {
			// 遍历集合数据，产生数据行
			Iterator<T> it = dataset.iterator();
			int index = 0;
			while (it.hasNext()) {
				index++;
				row = sheet.createRow(index);
				T t = (T) it.next();
				// 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
				Field[] fields = t.getClass().getDeclaredFields();
				for (short i = 0; i < headers.length; i++) {
					//总共需要多少单元格(列)
					XSSFCell cell = row.createCell(i);
					//field=private java.lang.Integer com.hzy.pojo.User.属性
					Field field = fields[i];
					//fieldName=id\name\age之类的
					String fieldName = field.getName();
					//getMethodName=getId\getname\getage之类的
					String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
					Class tCls = t.getClass();
					Method getMethod = tCls.getMethod(getMethodName, new Class[] {});
					Object value = getMethod.invoke(t, new Object[] {});
					// 判断值的类型后进行强制类型转换
					String textValue = null;
					// 其它数据类型都当作字符串简单处理
					if(value != null && value != ""){
						textValue = value.toString();
					}
					Date date = new Date();
					if(getMethod.getReturnType().equals(date.getClass())) {
						//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						textValue = sdf.format(date);
					}
					if (textValue != null) {
						XSSFRichTextString richString = new XSSFRichTextString(textValue);
						cell.setCellValue(richString);
					}
				}
			}
			getExportedFile(workbook, fileName,response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * 
	 * 方法说明: 指定路径下生成EXCEL文件
	 * @return
	 */
	public void getExportedFile(XSSFWorkbook workbook, String name,HttpServletResponse response) throws Exception {
		BufferedOutputStream fos = null;
		try {
			String fileName = name + ".xlsx";
			response.setContentType("application/x-msdownload");
			response.setHeader("Content-Disposition", "attachment;filename=" + new String( fileName.getBytes("gb2312"), "ISO8859-1" ));
			fos = new BufferedOutputStream(response.getOutputStream());
			workbook.write(fos);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				fos.close();
			}
		}
	}
 
}

