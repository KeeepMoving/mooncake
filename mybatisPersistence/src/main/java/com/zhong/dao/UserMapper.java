package com.zhong.dao;

import com.zhong.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(int id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}