package edu.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import utils.StringUtils;
import edu.dao.UserDao;
import edu.po.Users;
import edu.service.UserService;
import edu.vo.UserVO;

public class UserServiceImpl implements UserService {
	
	private Logger logger = Logger.getLogger(UserServiceImpl.class);

	public UserDao userdao;

	public UserDao getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}

	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return userdao.findAll();
	}

	@Override
	public void save(UserVO uservo) {
		// TODO Auto-generated method stub
        Users user = new Users();
        user.setPassword(uservo.getPassword());
        user.setUsername(uservo.getUsername());
        userdao.save(user);
	}
	
	
	/**
	 * 判断用户名、密码是否和数据库匹配，返回空字符串或null则表明匹配，否则不匹配
	 * @param uservo
	 * @return 错误提示信息
	 */	
	@Override
	public String checkLogin(UserVO uservo) {
		Users user = findByUserName(uservo.getUsername());
		if(user  == null ){
			return "该用户不存在！";
		}else{
			if(user.getPassword().equals(uservo.getPassword())){
				return "";
			}else{
				return "密码错误！";
			}
		}
	}
	

	@Override
	public Users findByUserName(String userName) {
		return userdao.findByUserName(userName);
	}

	public InputStream getInputStream(){
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet =  wb.createSheet("sheet1");
		HSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellValue("序号");
		row.createCell(1).setCellValue("用户名");
		row.createCell(2).setCellValue("密码");
		
		int index = 1;
		List<Users> userlist = findAll();
		Iterator<Users> iterator = userlist.iterator();
	    while(iterator.hasNext()){
	    	Users user = iterator.next();
	    	row = sheet.createRow(index);
	    	row.createCell(0).setCellValue(user.getId());
			row.createCell(1).setCellValue(user.getUsername());
			row.createCell(2).setCellValue(user.getPassword());
	    	index++;
	    }
	    
/* 方法一: */
	   ByteArrayOutputStream bos = new ByteArrayOutputStream();
	   try {
		   wb.write(bos);
	   } catch (IOException e) {
		   // TODO Auto-generated catch block
		   //e.printStackTrace();
		   logger.error(StringUtils.getExceptionMessage(e));
	   } 
	   byte content[] = bos.toByteArray();
	   
	   InputStream inputstream = new ByteArrayInputStream(content);
	   try {
		   bos.close();
	   } catch (IOException e) {
		   // TODO Auto-generated catch block
		   //e.printStackTrace();
		   logger.error(StringUtils.getExceptionMessage(e));
	   } 
	    
/* 方法二: */    
/*	    String filename = RandomStringUtils.randomAlphanumeric(10);
	    final File file = new File(filename+".xls");
	       
	    try {
			FileOutputStream fos = new FileOutputStream(file);
			wb.write(fos);
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.error(StringUtils.getExceptionMessage(e));
		}
		
		InputStream inputstream = null;
	    
		try {
			inputstream = new FileInputStream(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.error(StringUtils.getExceptionMessage(e));
		}
		
		new Thread(
		   new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(15000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					logger.error(StringUtils.getExceptionMessage(e));
				}
				file.delete(); //删除临时文件
			}
			   
		   }
	    ).start();
*/		
		return inputstream;
	}

}
