package exam.oop3.stpo06;


/*
 * Score 클래스도 String 클래스처럼
 * equals()메서드가 인스턴스 값을 비교하게 하자!
 */
public class Object04 {
	
	static class Score{
		String name;
		int kor;
		int eng;
		int math;
		int sum;
		float average;
		
		@Override
		public String toString() {
			return "[" + name + "," + kor + "," + eng +","+ math + "]"; 
		}
	}
	
	
	public static void main(String[] args) {
		String s1 = new String("Hello");
		String s2 = new String("Hello");
		
		if(s1 != s2){
			System.out.println("s1 <> s2 : 주소다르다");
		}
	
		if(s1.equals(s2)){
			System.out.println("s1.equals(s2) : 값은 같다");
		}
		
		System.out.println("해시값도 같다.");
		System.out.println(Integer.toHexString(s1.hashCode()));
		System.out.println(Integer.toHexString(s2.hashCode()));
	}
}
