package exam.oop3.step01;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

public class ScoreApp02 {
	
	public static void main(String[] args) {
		Frame f = new Frame();
		f.setTitle("비트 성적관리 시스템");
		f.setSize(400, 300);
		f.addWindowListener(new MyWindowListener());
		//f.add(new Label("이름"));
		//f.add(new TextField(20));
		//f.add(new Button("추가"));
		f.setVisible(true);
		
	}

}
