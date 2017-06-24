package edu.servlet;


import java.io.File;
import java.io.FileFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class DeleteFileServlet extends HttpServlet {
	
	private static final long serialVersionUID = -2815463818847538023L;

	public void destroy() {
		super.destroy(); 
	}

	public void init() throws ServletException {

		File file = new File("."); //当前目录 即  tomcat安装目录/bin 

		//查找当前目录下文件后缀为xls的文件并将它们放到一个集合中
		File[] subFiles = file.listFiles(new FileFilter(){

			@Override
			public boolean accept(File pathname) {
				// TODO Auto-generated method stub
				if(pathname.getName().endsWith("xls")){
					return true;
				}
				return false;
			}
			
		});
		for(File f : subFiles){
			f.delete();  //删除文件
		}
	}

}
