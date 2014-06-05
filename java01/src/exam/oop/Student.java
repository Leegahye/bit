package exam.oop;

import java.util.Scanner;

class Stu_info{
	Scanner sc  = new Scanner(System.in);
	private String name;
	private int kor;
	private int mat;
	private int eng;
	private int tot;
	private float avg;
	
	public Stu_info(){
		name = "null";
		kor=mat=eng=tot = 0;
		avg = 0.0f;
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
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	
	public void input(){
		
		System.out.print("이름 : ");
		name = sc.nextLine();
		System.out.print("국어 : ");
		kor = Integer.parseInt(sc.nextLine());
		System.out.print("영어 : ");
		eng = Integer.parseInt(sc.nextLine());
		System.out.print("수학 : ");
		mat = Integer.parseInt(sc.nextLine());
		cal();
		
	}
	public void cal(){
		
		tot = kor+mat+eng;
		avg = tot/3.0f;
		System.out.println(name+" 님의 총점 : "+tot+", 평균 : "+avg);
	}
	
}

public class Student{
	
	private Stu_info s[] = new Stu_info[3];
	
	public Student(){
		for(int i = 0; i<s.length; i++){
			s[i] = new Stu_info();
		}
	}
	
	public void setStudent(String name, int kor, int eng, int mat){
		for(int i = 0; i<3; i++){
			s[i].cal();
		}
		
	}
	public void input(){
		
	}
	
	public static void main(String[] args){
		Student stu = new Student();
		

		
	}
}