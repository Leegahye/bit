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
 
public class Server extends Frame{
	ServerSocket ss = new ServerSocket(9080);
	
 
	InputStream in;
	Scanner in2;
 
	OutputStream out;
	PrintStream out2;
 
	static TextArea ta ;
	TextField tf;
	
	public Server() throws Exception{
	
		this.setSize(400,500);
		this.setTitle("서버 채팅방");
		ta = new TextArea(25,50);
		tf = new TextField(40);
		 
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(ta);
		this.add(tf);
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
 
		ta.append("연결 기다리는중\n");
		Socket socket = ss.accept(); 
		ta.append("연결됨\n");
		
		in = socket.getInputStream();
		in2 = new Scanner(in);
		
		out = socket.getOutputStream();
		out2 = new PrintStream(out);
		
		ServerReceiver serverThread = new ServerReceiver(in2);
		
		serverThread.start();
	}
	
	public static void main(String[] args) throws Exception {
		
		new Server();
	}
}
