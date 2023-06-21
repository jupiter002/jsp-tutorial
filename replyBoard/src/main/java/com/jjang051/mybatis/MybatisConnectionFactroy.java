package com.jjang051.mybatis;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConnectionFactroy {
	//factory pattern
	private static SqlSessionFactory sqlSessionFactory;
	
	
	static { 
		String resource = "com/jjang051/mybatis/Configure.xml";
		
		try {
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static SqlSession getSqlSession(){
		return sqlSessionFactory.openSession();
	}
}	
