package exam.net;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
 
public class Client extends Frame{
	Socket socket = new Socket("127.0.0.1",9080);
	
	InputStream in = socket.getInputStream();
	Scanner in2 = new Scanner(in);
 
	OutputStream out =  socket.getOutputStream();
	PrintStream out2 = new PrintStream(out);
	
	static TextArea ta;
	TextField tf;
 
	public Client() throws Exception{
	
		ClientReceiver clientThread = new ClientReceiver(in2);
		clientThread.start();
		
		ta = new TextArea(25,50);
		tf = new TextField(40);
			
		this.setSize(400,500);
		this.setTitle("클라이언트 채팅방");
		this.setVisible(true);
		tf.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if(key == KeyEvent.VK_ENTER){
					ta.append("나 : "+tf.getText()+"\n");
					out2.println(tf.getText());
					tf.setText("");
				}
			}
		});
		
		this.addWindowListener(new WindowAdapter() {
		      public void windowClosing(WindowEvent e) {
		        System.exit(0);
		      }
		 });
		
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(ta);
		this.add(tf);
		this.setVisible(true);
	}
	
	public static void main(String[] args) throws Exception {
		new Client();
	}
}