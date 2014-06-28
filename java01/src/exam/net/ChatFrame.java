package exam.net;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatFrame extends Frame implements ActionListener, KeyListener{
	
	private TextArea tx = new TextArea(25,50);
	private TextField tf = new TextField(40);
	
	public ChatFrame(){
		this.setTitle("채팅방");
		this.setSize(400,500);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
				
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(tx);
		this.add(tf);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	public void keyPressed(KeyEvent e) {

	}

	public void keyTyped(KeyEvent e) {

	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			tf.setText("");
		}
	}
}
