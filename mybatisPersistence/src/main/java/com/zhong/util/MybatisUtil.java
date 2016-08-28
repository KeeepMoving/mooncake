package com.zhong.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {

	private static final String MYBATIS_CONFIG_LACATION = "/config/mybatis.xml";
	private static final ThreadLocal<SqlSession> THREAD_LOCAL =  new ThreadLocal<>();
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			loadConfig();
		} catch (Exception e) {
			System.err.println("%%%% Error Creating SqlSessionFactory %%%%");
			e.printStackTrace();
		}
	}

	public MybatisUtil() {

	}
	
	public static SqlSession getSqlSession() throws Exception {
		SqlSession sqlSession = THREAD_LOCAL.get();
		if (sqlSession == null) {
			if(sqlSessionFactory == null) {
				loadConfig();
			}
			sqlSession = (sqlSessionFactory != null) ? sqlSessionFactory.openSession() : null;
			THREAD_LOCAL.set(sqlSession);
		}
		return sqlSession;
	}
	
	public static void closeSqlSession() {
		SqlSession sqlSession = THREAD_LOCAL.get();
		if(sqlSession != null) {
			sqlSession.close();
			THREAD_LOCAL.set(null);
		}
	}
	
	private static void loadConfig() throws Exception {
		InputStream resourceAsStream = MybatisUtil.class.getResourceAsStream(MYBATIS_CONFIG_LACATION);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream );
	}
}
