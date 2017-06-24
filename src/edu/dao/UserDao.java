package edu.dao;

import java.util.List;
import edu.po.Users;

public interface UserDao {
	
   public List<Users>  findAll();
  
   public Users findById(Integer id);
   
   public void save(Users user);
   
   public void update(Users user);
   
   public void delete(Users user);
   
   public Users findByUserName(String userName);
   
}
