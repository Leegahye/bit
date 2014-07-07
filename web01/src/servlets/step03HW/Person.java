/* Entity 역할
 * - 성적 정보를 표현하는 역할 => Value Object(VO)
 */
package servlets.step03HW;

import java.io.Serializable;

public class Person implements Serializable  {
  private static final long serialVersionUID = 1L;

  private int no;
  private String name;
  private String email;
  private String tel;
  private String pw;

  public Person() {}

  public Person(String name, String email, String tel, String pw) {
    this.name = name;
    this.email = email;
    this.tel = tel;
    this.pw = pw;
  }
	
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getPw() {
		return pw;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}	
	
	@Override
	public String toString() {
		return "Person [no=" + no + ", name=" + name + ", email=" + email
				+ ", tel=" + tel + ", pw=" + pw + "]";
	}

	public void add(Person person) {
		// TODO Auto-generated method stub
		
	}

}


















