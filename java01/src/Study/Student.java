package Study;

public class Student extends Subject{
	int sci;

	Student(int kor, int eng, int mat,int sci) {
	  super(kor, eng, mat);
	  this.sci = sci;
	  getSci();
  }
	public void getSci(){
		System.out.println(", 과학:"+this.sci);
	}
	
	public static void main(String[] args) {
		Student stu = new Student(100,90,50,80);
	}

}
