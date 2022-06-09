package dao;

import entities.User;

public interface UserDao {
	
	User findById(Integer id);

}
