/*
 * 생성자 오버로딩과 this()
 *  - 생성자에서 다른 생성자를 호출할 때 사용 => this()
 *  - 기존 생성자 재활용
 *  - 단, 일반 메서드에서는 this()를 사용할 수 없다.
 *  
 */

package exam.oop2.step01;

public class Score2 {
	String name;
	int kor;
	int mat;
	int eng;
    int tot;
	float avg;
	
	public Score2(){
		
	}
	
	public Score2(int score){
		this(score,score,score);
	}
	
	public Score2(int kor, int eng, int mat){
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = kor+eng+mat;
		this.avg = this.tot/3.0f;
	}
	//이미 생성자가 있기 때문에 기본생성자가 자동으로 추가되지 않는다.
	public Score2(String name, int kor, int eng, int mat){
		//기존의 생성자 기능을 활용한다. -> 코드절약
		this(kor,eng,mat); // 다른 생성자를 호출 할 때는 무조건 첫 문장!
		this.name = name;
	}
	
	/*public void test(){
		//일반 메서드에서는 생성자를 호출 할 수 없다.
		this();//용서받지 못할코드
	}*/
}