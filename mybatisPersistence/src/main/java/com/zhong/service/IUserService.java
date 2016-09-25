package com.zhong.service;

import com.zhong.model.User;

public interface IUserService {

	void addUser(User user) throws Exception;
	
	void deleteById(int id) throws Exception;
	
	void updateUser(User user) throws Exception;
	
	User getUserById(int id) throws Exception;
	
}
