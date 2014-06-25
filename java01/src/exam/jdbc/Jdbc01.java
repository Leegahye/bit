package exam.jdbc;
/*
 * 역할자
 *  - 어떤 기능들을 수행하는 클래스를 지칭
 *  - 역할자를 "객체"라 부름
 *  
 */
public class Jdbc01 {

	public static void main(String[] args) throws Exception{
		//1. Driver 역할자(객체)를 로딩
		//Driver 역할자란?
		// - JDBC드라이버의 정보를 알려주는 객체
		// - DBMS와의 연결을 수행하는 객체
		// - java.sql.Dirver 인터페이스를 구현한 객체
		//Driver 역할자를 로딩?
		// - java.sql.Driver 구현체(구현한 클래스)를 로딩
		// - ex)MySQL JDBC Driver => com.mysql.jdbc.Driver
		//임의로 클래스 로딩 방법?
		// - java.lang.Class.forName("클래스이름");
		// - 클래스 이름은 반드시 패키지 이름을 포함해야 한다.
		Class.forName("com.mysql.jdbc.Driver");
		
		
		//2. DriverManager를 통해 connection 역할자를 얻기
		//3. Connection 역할자를 통해 Statement 역할자를 얻기
		//4. Statement  역할자를 통해 SQL 서버에 보냄
		//5. ResultSet 역할자를 통해 서버에서 레코드를 하나씩 가져옴
		//6. ResultSet 역할자 닫기
		//7. Statement 역할자 닫기
		//8. Connection 역할자 끊기
	}

}
