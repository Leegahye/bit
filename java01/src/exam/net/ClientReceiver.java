package exam.net;

import java.util.Scanner;

public class ClientReceiver extends Thread{
	Scanner in;
	public ClientReceiver(Scanner in){
		this.in = in;
	}
	public void run(){
		String message = null;
		while(true){
			message = in.nextLine();
			Client.ta.append("client : " + message+"\n");
 
			if(message.equals("bye")){
				break;
			}
		} 
	}
}