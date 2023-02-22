package common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {
	
	// SqlSessionTemplate 객체를 생성하지 않고도 이용할 수 있도록 static으로 전역선언
	public static SqlSession getSqlSession() {
		// 1. SqlSession 타입의 session 레퍼런스 변수만 먼저 선언
		SqlSession session = null;
		
		try {
			// 2. InputStream을 통해 mybatis-config.xml 파일을 읽음
					// 이때, xml파일을 스트림으로 읽기 위해 Resources.getResourceAsStream() 메소드 사용
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			// 3. SqlSessionFactoryBuilder를 이용해서 세션 팩토리를 생성한 후
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			// 4. 생성된 SqlSessionFactory로 inputstream에 담겨져있는 mybatis-config.xml 파일을 통해 세션을 연결함
			SqlSessionFactory factory = builder.build(is);
			// 5. 연결된 세션을 생성한다.
			session = factory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return session;
	}
}
