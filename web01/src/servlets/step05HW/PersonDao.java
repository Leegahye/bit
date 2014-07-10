/* PreparedStatement 적용 
 * - SQL 템플릿을 정의한 후, IN-PARAMETER에 값을 넣는 방법
 * - 장점
 *   1) SQL문이 간결해진다.
 *   2) IN-PARAMETER를 통해 값을 입력하기 때문에 SQL문을 조작할 수 없다.
 *   3) 바이너리 데이터를 입력할 수 있다.
 *   4) 반복하여 작업을 수행할 때 속도가 빠르다.
 *      => 이유: SQL문을 미리 만들어 놓고 값만 입력하여 실행하기 때문이다.
 */
package servlets.step05HW;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonDao {
  DbConnectionPool dbConnectionPool;
  
  public void setDbConnectionPool(DbConnectionPool dbConnectionPool) {
    this.dbConnectionPool = dbConnectionPool;
  }
  
  public ArrayList<Person> list() throws Exception {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      con = dbConnectionPool.getConnection();
      stmt = con.createStatement();
      
      rs = stmt.executeQuery(
          "select mno, name, email, tel, pwd "
          + " from members order by mno desc");
      
      ArrayList<Person> persons = new ArrayList<Person>();
      Person person = null;
      
      while (rs.next()) {
    	person = new Person();
    	
    	person.setNo( rs.getInt("mno"));
    	person.setName( rs.getString("name"));
    	person.setEmail(rs.getString("email"));
    	person.setTel( rs.getString("tel"));
    	person.setPw( rs.getString("pwd")); 
    	persons.add(person);
      }
      return persons;
      
    } catch (Exception e) {
      throw e;
      
    } finally { 
      try { rs.close();} catch (SQLException e) {}
      try { stmt.close();} catch (SQLException e) {}
      dbConnectionPool.returnConnection(con);
    }
  }

  public Person selectOne(int no) throws Exception {
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    try {
      con = dbConnectionPool.getConnection();
      stmt = con.prepareStatement(
          "select mno, name, email, tel, pwd from members where mno=?");
      stmt.setInt(1, no);
      rs = stmt.executeQuery();
      
      if (rs.next()) {
		  Person person = new Person();
		  person.setNo( rs.getInt("mno"));
		  person.setName( rs.getString("name"));
		  person.setEmail( rs.getString("email"));
		  person.setTel( rs.getString("tel"));
		  person.setPw( rs.getString("pwd"));
		  return person;
      } else {
        return null;
      }
      
    } catch (Exception e) {
      throw e;
      
    } finally { 
      try { rs.close();} catch (SQLException e) {}
      try { stmt.close();} catch (SQLException e) {}
      dbConnectionPool.returnConnection(con);
    }
  }

  public void insert(Person person) throws Exception {
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null; // 자동 생성된 PK 값을 가져오는 역할자
    
    try {
      con = dbConnectionPool.getConnection();

      stmt = con.prepareStatement(
          "insert into members (name, email, tel, pwd)" +
          " values(?, ?, ?, ?)", 
          Statement.RETURN_GENERATED_KEYS);

      // IN-PARAMETER의 타입에 따라 setXxxx(인덱스, 값) 호출한다.
      stmt.setString(1, person.getName()); 
      stmt.setString(2, person.getEmail());
      stmt.setString(3, person.getTel());
      stmt.setString(4, person.getPw());
      
      int count = stmt.executeUpdate();
      
      if (count == 1) {
        // 입력 성공 후에 자동 생성된 PK 값 가져오기
        rs = stmt.getGeneratedKeys(); //1) 자동 생성 PK값 가져오는 역할자 얻기 
        rs.next(); // 2) PK 값 가져오기 
        person.setNo( rs.getInt(1)); // 3) DBMS에서 자동 생성된 PK 값을 Score에 저장. 
      }
      
    } catch (Exception e) {
      throw e;
      
    } finally { 
      try { rs.close();} catch (SQLException e) {}
      try { stmt.close();} catch (SQLException e) {}
      dbConnectionPool.returnConnection(con);
    }
  }

  public int delete(int no) throws Exception {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
      con = dbConnectionPool.getConnection();
      stmt = con.prepareStatement( 
          "delete from members where mno = ?");
      
      stmt.setInt(1, no);
      
      return stmt.executeUpdate();
      
      
    } catch (Exception e) {
      throw e;
      
    } finally { 
      try { stmt.close();} catch (SQLException e) {}
      dbConnectionPool.returnConnection(con);
    }
  }

  public void update(Person person) throws Exception {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
      con = dbConnectionPool.getConnection();
      stmt = con.prepareStatement(
          "update members set name=?, email=?, tel=?, pwd=? where mno=?");
      
      stmt.setString(1, person.getName());
      stmt.setString(2, person.getEmail());
      stmt.setString(3, person.getTel());
      stmt.setString(4, person.getPw());
      stmt.setInt(5, person.getNo());
      
      stmt.executeUpdate();
      
    } catch (Exception e) {
      throw e;
      
    } finally { 
      try { stmt.close();} catch (SQLException e) {}
      //try { con.close();} catch (SQLException e) {}
      dbConnectionPool.returnConnection(con);
    }
  }  
  
}
