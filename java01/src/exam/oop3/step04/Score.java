/*
 * Entity역할
 *  - 성적정보를 표현하는 역할 => Value Object(VO)
 */
package exam.oop3.step04;

public class Score {
	private String name;
	private int kor;
	private int mat;
	private int eng;
    private int tot;
	private float avg;
	
	public Score(){}
		
	public Score(String name, int kor, int eng, int mat){
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = kor+eng+mat;
		this.avg = this.tot/3.0f;
	}
	
	private void compute(){
		this.tot = this.kor+this.eng+this.mat;
		this.avg = this.tot/3.0f; //암시적 형변환
	}
	public int getTotal(){
		return this.tot;
	}
	public float getAverage(){
		return this.avg;
	}
	
	public void setKor(int kor){
		this.kor = kor;
		this.compute();
	}
	public void setEng(int eng){
		this.eng = eng;
		this.compute();
	}
	public void setMat(int mat){
		this.mat = mat;
		this.compute();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public int getMat() {
		return mat;
	}

	public int getEng() {
		return eng;
	}
	
}