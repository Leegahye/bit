package exam.net;

import java.util.Scanner;

public class ServerReceiver extends Thread{
	Scanner in;
 
	public ServerReceiver(Scanner in){
		this.in = in;
	}
	public void run(){
		String message = null;
		while(true){
			message = in.nextLine();
			Server.ta.append("server : " + message +"\n");
			if(message.equals("bye")){
				break;
			}
		} 
	}
}