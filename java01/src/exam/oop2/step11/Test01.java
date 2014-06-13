package exam.oop2.step11;

public class Test01 {
	public static void main(String[] args) {
		LeeInterviewee lee = new LeeInterviewee();
		Interviewer iv = new Interviewer();
		iv.addInterviewee(lee);
		iv.interview();
	}
}
