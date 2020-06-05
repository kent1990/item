package com.zhengke.common.util.tools;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

public class FileExport {
	/**
	 * 导出Excel文件
	 * 
	 * @param excelHeader
	 *            导出文件中表格头
	 * @param list
	 *            导出的内容
	 * @param response
	 *            HttpServletResponse对象，用来获得输出流向客户端写导出的文件
	 * @param sheetName
	 *            Excel的sheet名称，加上时间戳作为导出文件的名称
	 */
    public static void exportExcel(String [] excelHeader,List<Object[]> list,String sheetName,HttpServletResponse response) {    
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(sheetName);
		HSSFRow row = sheet.createRow((int) 0);
        //设置单元格是否显示网格线
		sheet.setDisplayGridlines(false);
		
		// 设置头单元格样式
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		Font fontHeader = wb.createFont();
		fontHeader.setBold(true);//Font.BOLDWEIGHT_BOLD
		fontHeader.setFontHeight((short) 240);
		style.setFont(fontHeader);
		style.setBorderBottom(BorderStyle.THIN);
		style.setBorderLeft(BorderStyle.THIN);
		style.setBorderRight(BorderStyle.THIN);
		style.setBorderTop(BorderStyle.THIN);
		
		// 设置头内容
		for (int i = 0; i < excelHeader.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellValue("  " +excelHeader[i] + "  ");
			cell.setCellStyle(style);			
		}   
        
		// 设置内容单元格样式
		HSSFCellStyle styleCell = wb.createCellStyle();
		Font fontCell = wb.createFont();
		fontCell.setColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
		styleCell.setAlignment(HorizontalAlignment.CENTER);
		styleCell.setFont(fontCell);
		styleCell.setBorderBottom(BorderStyle.THIN);
		styleCell.setBorderLeft(BorderStyle.THIN);
		styleCell.setBorderRight(BorderStyle.THIN);
		styleCell.setBorderTop(BorderStyle.THIN);
        //设置单元格内容
		for (int i = 0; i < list.size(); i++) {
			row = sheet.createRow(i + 1);
			//设置行高
			row.setHeightInPoints(20);
			Object[] obj = (Object[]) list.get(i);			
			for (int j = 0; j < excelHeader.length; j++) {
				styleCell.setWrapText(false);
            	HSSFCell cell = row.createCell(j);
				if (obj[j] != null){
					 cell.setCellValue("  " + obj[j].toString() + "  ");
				}else{
					cell.setCellValue(""); 
				}			
				//if(obj[j].toString().length()>20)
				//	styleCell.setWrapText(true);
				cell.setCellStyle(styleCell);
				sheet.autoSizeColumn(j);
            }   
        } 
		
		OutputStream ouputStream = null;
		try {
	        response.setCharacterEncoding("UTF-8");	
	        response.setContentType("application/vnd.ms-excel"); 
	        String fileName = sheetName;
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHMMSS");
	        fileName+=(dateFormat.format(new Date())).toString()+".xls";				
	        response.setHeader("Content-disposition", "attachment;filename="+URLEncoder.encode(fileName, "UTF-8"));   
	        ouputStream = response.getOutputStream();   
	        wb.write(ouputStream);     
	        ouputStream.flush();  
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
        	try {
        		if(ouputStream!=null)
        			wb.close();
        			ouputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
    }
    
   
}
