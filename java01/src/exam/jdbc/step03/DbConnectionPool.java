package exam.jdbc.step03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/* DB connection 객체를 빌려주고 반납받는 역할 수행
 *  - 적은 개수의 Connection으로 SQL처리
 *  - 객체를 빌려주고 반납받는 방식의 프로그래밍을 "Pooling 기법"이라 한다.
 *  - 디자인 패턴에서는 => Flyweight 패턴이라고 함 
 */
public class DbConnectionPool {
	ArrayList<Connection> connections = new ArrayList<Connection>(); //connection을 저장할 list
	String driver;
	String url;
	String username;
	String password;
	
	public DbConnectionPool(String driver, String url, 
			String username, String password) throws ClassNotFoundException{
		this.driver = driver;
		this.url = url;
		this.username = username;
		this.password = password;
		
		Class.forName(driver);
	}
	public Connection getConnection() throws SQLException{
		if(connections.size() == 0){
			return DriverManager.getConnection(this.url,this.username, this.password);
		}else{
			return connections.remove(0); //0번 값을 꺼내 준다. ArrayList에서는 제거한다.
		}
	}
	public void returnConnection(Connection con){
		try {
			if(!con.isClosed() && con.isValid(1)){ //닫겨있지않고, 유효하면(1초동안 유효한지 검사)
				connections.add(con);//유효한 connection을 list에 담겠다.
			}
		} catch (SQLException e) {/*무시*/}
	}

}
