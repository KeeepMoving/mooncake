package com.zhong.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhong.dao.UserMapper;
import com.zhong.model.User;
import com.zhong.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService{

	@Resource
	private UserMapper userMapper;
	
	@Override
	public void addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id) throws Exception {
		
	}

	@Override
	public void updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUserById(int id) throws Exception {
		User user = this.userMapper.selectByPrimaryKey(id);
		return user;
	}

}
