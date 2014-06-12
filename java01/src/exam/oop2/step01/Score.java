/*
 * 다형성(polymorphism) : Overloading
 *  - 같은 기능을 수행하는 메서드에 대해 같은 이름을 부여함으로써 프로그래밍의 일관성 확보.
 *  - 문법
 *   	메서드 이름은 같아야 한다.
 *   	파라미터는 달라야 한다.
 *   	리턴 타입은 상관없다.(파라미터 타입과 개수가 달라야 한다. 이름은 상관없다.)
 *   	파라미터가 같고 리턴타입이 다른경우는 만들 수 없다.
 *  - ex)
 *  	class Calculator{
			int plus(int a,int b){
				return a+b;
			}
			float plus(float a, int b){ //ok
				return a+b;
			}
			float plus(int a, float b){ //ok
			return a+b;
			}
	
			//오류
			int plus(int x, int y){
				return x+y;
			}
		}
		
	- 어떻게 호출될 메서드를 구분하는가?
	메서드를 호출할 때 파라미터 값으로 구분한다.
	ex1)plus(10,20);
	ex2)plus(10.0f,20);
	ex3)plus(10,20.0f);
*/

package exam.oop2.step01;



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
	public Score(String name, int kor, int eng, int mat){
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = kor+eng+mat;
		this.avg = this.tot/3.0f;
	}	
}