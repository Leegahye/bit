package exam.net.step02.server;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import exam.net.ChatFrame;
import exam.net.step02.Receiver;
import exam.net.step02.Sender;

public class Server {
	public static void main(String[] args) throws Exception {
		ChatFrame cf = new ChatFrame();
		cf.setVisible(true);
		
		Scanner keyScan = new Scanner(System.in);
		
		//1.요청을 받는 역할을 수행할 서버 소켓 생성
		ServerSocket ss = new ServerSocket(9080);
		
		//2.클라이언트의 요청을 기다리고 승인한다. => 클라이언트와 데이터를 주고 받을 소켓 리턴
		Socket socket = ss.accept(); 
		
		//3. 소켓으로 데이터를 보내고, 소켓으로 부터 데이터를 읽는 개체 준비
		InputStream in = socket.getInputStream();
		Scanner in2 = new Scanner(in);
		
		OutputStream out = socket.getOutputStream();
		PrintStream out2 = new PrintStream(out);
		
		Sender senderThread = new Sender(keyScan, out2);
		Receiver receiverThread = new Receiver(in2);
		
		//조수에게 작업을 시작하라고 명령을 내린다.
		senderThread.start();
		receiverThread.start();
		
		/*//4. 클라이언트로 부터 데이터를 읽고 보내기
		String request = null;
		String message = null;
		
		while(true){
			request = in2.nextLine();
			System.out.println("클라이언트 => " + request);
		
			if(request.equals("bye"))
				break;
			
			message = keyScan.nextLine();
			out2.println(message);
		}*/
		
		/*keyScan.close();
		in2.close();
		in.close();
		out2.close();
		out.close();
		socket.close();
		ss.close();*/
	}

}
