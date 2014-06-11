/*
 * Entity역할
 *  - 성적정보를 표현하는 역할 => Value Object(VO)
 */
package exam.oop.score;

public class Score {
	String name;
	int kor;
	int mat;
	int eng;
    int tot;
	float avg;
	
	public Score(){
		
	}
	//이미 생성자가 있기 때문에 기본생성자가 자동으로 추가되지 않는다.
	/*public Score(String name, int kor, int eng, int mat){
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = kor+eng+mat;
		this.avg = this.tot/3.0f;
	}*/
	
}