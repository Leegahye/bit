package exam.net.step02.client;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import exam.net.step02.Receiver;
import exam.net.step02.Sender;

public class Client {

	public static void main(String[] args) throws Exception {
		
		//System.in //키보드
		//Scanner // 텍스트 입력 스트림을 다루는 객체
		Scanner keyScan = new Scanner(System.in);
	
		//1.서버와 통신할 객체 준비
		Socket socket = new Socket("192.168.1.36", 9080);
		//2.소켓으로 데이터를 출력하고, 소켓으로부터 데이터를 읽는 객체준비
		InputStream in = socket.getInputStream(); //데이터 읽기 도구
		Scanner in2 = new Scanner(in);
		
		OutputStream out =  socket.getOutputStream(); //데이터 출력도구
		PrintStream out2 = new PrintStream(out);
		
		Sender senderThread = new Sender(keyScan, out2);
		Receiver receiverThread = new Receiver(in2);
		
		//조수에게 작업을 시작하라고 명령을 내린다.
		senderThread.start();
		receiverThread.start();
		/*String message = null;
		String response = null;
		
		while(true){
			message = keyScan.nextLine();
			out2.println(message);
			
			response = in2.nextLine();
			System.out.println("서버 => " + response);
			
			if(message.equals("quit")){
				out2.println("bye");
				break;
			}
		}*/
		/*keyScan.close();
		out2.close();
		out.close();
		in2.close();
		in.close();
		socket.close();*/
	}
}
