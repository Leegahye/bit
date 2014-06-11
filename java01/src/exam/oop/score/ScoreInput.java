/*
 * Boundary 역할
 *  - 사용자로부터 성적 정보를 입력받는 역할.
 */
package exam.oop.score;
import java.util.Scanner;

public class ScoreInput {

	ScoreDao scoreDao;
	
	public ScoreInput(ScoreDao scoreDao){

		this.scoreDao = scoreDao;
	}
	public void service(Scanner scanner){
		//1.사용자로부터 성적 정보를 입력받는다
		Score score = new Score();
		System.out.print("이름?");
		score.name = scanner.nextLine();
		System.out.print("국어?");
		score.kor = Integer.parseInt(scanner.nextLine());
		System.out.print("영어?");
		score.eng = Integer.parseInt(scanner.nextLine());
		System.out.print("수학?");
		score.mat = Integer.parseInt(scanner.nextLine());
		
		score.tot = score.kor+score.eng+score.mat;
		score.avg = score.tot/3.0f;
		
		//2. 성적정보를 ScoreDao에게 전달한다.
		scoreDao.insert(score);
	
	}

}
