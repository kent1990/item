package com.zhengke.controller.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("view")
public class ViewPicController {
	@RequestMapping("viewPic.do")
	public void view(String path,HttpServletResponse response){
		OutputStream toClient = null;
		FileInputStream is = null;
		if(path==null||"".equals(path)){
			return;
		}
		try {
			is = new FileInputStream(path);
			int i = is.available(); // �õ��ļ���С
			byte data[] = new byte[i];
			is.read(data); // ������
	
			response.setContentType("image/*"); // ���÷��ص��ļ�����
	
			toClient = response.getOutputStream(); // �õ���ͻ���������������ݵĶ���
			toClient.write(data); // �������
			toClient.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			 try {
				if(is!=null)
					is.close();
				} catch (IOException e1) {
					 	e1.printStackTrace();
			 }
			 if(toClient!=null)
				try {
					toClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}	
}
