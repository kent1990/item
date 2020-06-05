package com.zhengke.common.action.view;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zhengke.common.action.CommonAction;
  

@Controller("ViewPicAction") @Scope("prototype")
public class ViewPicAction extends CommonAction {
	private static final long serialVersionUID = 1L;

	public void view() throws IOException {
		
		String path = ServletActionContext.getRequest().getParameter("path");
		if(path==null||"".equals(path)){
			return;
		}
		
		FileInputStream is = new FileInputStream(path);
		int i = is.available(); // 得到文件大小
		byte data[] = new byte[i];
		is.read(data); // 读数据
		is.close();
		ServletActionContext.getResponse().setContentType("image/*"); // 设置返回的文件类型		OutputStream toClient = ServletActionContext.getResponse().getOutputStream(); // 得到向客户端输出二进制数据的对象
		toClient.write(data); // 输出数据
		toClient.flush();
		toClient.close();

	}
	
	/**
	 * 查看相对路径图片
	 * @throws IOException
	 */
	public void viewRelative() throws IOException {
		String path = ServletActionContext.getRequest().getParameter("path");
		if(path==null||"".equals(path)){
			return;
		}
		String name = path.substring(path.lastIndexOf("/"));
		String realpath = ServletActionContext.getServletContext().getRealPath(path.substring(0,path.lastIndexOf("/")));
		path= realpath+name;
		//path=new String(path.getBytes("iso-8859-1"),"UTF-8"); 
		
		FileInputStream is = new FileInputStream(path);
		int i = is.available(); // 得到文件大小
		byte data[] = new byte[i];
		is.read(data); // 读数据

		is.close();
		ServletActionContext.getResponse().setContentType("image/*"); // 设置返回的文件类型

		OutputStream toClient = ServletActionContext.getResponse()
				.getOutputStream(); // 得到向客户端输出二进制数据的对象
		toClient.write(data); // 输出数据
		toClient.flush();
		toClient.close();
	}
	
	
}
