package edu.action.user;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import com.opensymphony.xwork2.ActionSupport;
import edu.service.UserService;

public class GenerateExcelAction extends ActionSupport{

	private static final long serialVersionUID = -3061171643125977707L;
	private UserService userservice;
    private String fileName;
	
	public UserService getUserservice() {
		return userservice;
	}


	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}
	

	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public InputStream getDownloadFile(){
        this.fileName = "EXCEL下载例子.xls";
        try {
			this.fileName = new String(fileName.getBytes(),"ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
		} 
		return this.userservice.getInputStream();
	}
	
	
	@Override
    public String execute() throws Exception {
    	// TODO Auto-generated method stub
    	return "success";
    }
}
