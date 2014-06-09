package Study;

public class Subject {
	int kor;
	int eng;
	int mat;
	
	Subject(int kor, int eng, int mat){
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		Print();
	}
	public void Print(){
		System.out.print("국어:"+kor+", 수학:"+mat+", 영어:"+eng);
	}

}
