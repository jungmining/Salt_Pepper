package com.min.edu.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryManager {
	//세션 열리는지 확인 
	//뭔가 연결이 이상한건지 안되고있음!..(실패함)

	private static SqlSessionFactory factory;
		
	
	public static SqlSessionFactory getFactory() {
			return factory;
		}


	static {
		String path ="com/min/edu/mybatis/Configure.xml";
		try {
			Reader reader = Resources.getResourceAsReader(path);
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			System.out.println("객체 열리는지 확인해보기");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
