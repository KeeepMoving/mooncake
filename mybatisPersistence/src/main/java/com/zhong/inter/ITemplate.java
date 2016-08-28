package com.zhong.inter;

import java.io.Serializable;

public interface ITemplate<T> {

	void add(T t) throws Exception;
	
	void deleteById(Serializable id) throws Exception;
	
	void update(T t) throws Exception;
	
	T queryById(Serializable id) throws Exception;
}
