package repository;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public abstract class AbstractRepository {
	// 객체 생성 될 때 생성자 없이 자동으로 초기화 시키기 위해서 static으로 만들어 줌
	private static SqlSessionFactory sqlSessionFactory;
	static {
		setSqlSessionFactory();
	}
	private static void setSqlSessionFactory() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		}catch(IOException e) {
			throw new IllegalArgumentException(e);
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
