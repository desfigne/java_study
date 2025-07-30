package c17_thread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * 멀티 채팅 서버 구현
 */
public class C1704_Server {

	public final static int PORT = 9000;
	public static ArrayList<ClientHandler> list = new ArrayList<ClientHandler>();

	public static void main(String[] args) {
		
//		ServerSocket server = new ServerSocket(PORT); // try catch 사용해 익셉션 해결, 포트가 다르면 io익셉션 발생
		
		try {
			ServerSocket server = new ServerSocket(PORT);
			System.out.println("서버 실행 중 : " + PORT);
			System.out.println("클라이언트 접속 대기 중입니다.");
			
//			Socket s = server.accept(); // 클라이언트 접속 대기 중
//			System.out.println("✅ 클라이언트 접속");
			
			while(true) {
				Socket s = server.accept(); // < 클라이언트가 몇 명이 올지 모르므로 while문으로 계속 돌려야 함
				System.out.println("✅ 클라이언트 접속"); // >
				 // 서버 콘솔창에서 종료를 누르면 클라이언트 소켓도 함께 종료됨, Socket s가 종료되지 않도록 메인 메소드에 종속되지 않도록 처리해야 하므로 서버에 있는 소켓을 쓰레드로 처리
				
				// 클라이언트 별로 접속하고 별도 종료 진행
//				new ClientHandler(s).start();
				ClientHandler ch = new ClientHandler(s);
				ch.start();
				list.add(ch);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	} // Main

} // Server

class ClientHandler extends Thread {
	Socket s;
//	OutputStream output;
//	InputStream input;
	DataOutputStream output;	// < 데이터 타입 변경
	DataInputStream input;		// >
	
	public ClientHandler(Socket s) {
//		this.s = s;
//		this.output = s.getOutputStream(); // 익셉션 에러 발생, 트라이 캐치 사용
		try {
			this.s = s;
//			this.output = s.getOutputStream();	// 서버가 전송
//			this.input = s.getInputStream();	// 서버가 수신, 스트림은 바이너리 코드가 통과할 수 있는 통로
			this.output = new DataOutputStream(s.getOutputStream());	// < 데이터 타입이 맞지 않아 송수신 불가, 타입 변경
			this.input = new DataInputStream(s.getInputStream());		// >
			String str = "[서버] : 안녕하세요, 서버입니다. 환영합니다.";
			output.writeUTF(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void run() { // 주고 받는 작업
//		String str = "안녕하세요";
//		output.write(str.getBytes()); // 익셉션 발생, 전달 못갈 가능성이 있어 트라이 캐치 사용
		try {
//			String str = "[서버] : 안녕하세요, 서버입니다. 환영합니다.";	// < 1번만 출력하도록 위로 이동 처리
////			output.write(str.getBytes());
//			output.writeUTF(str);								// >
			
			boolean flag = true;
			while(flag) {
				String recievedMsg = input.readUTF();	// < 한번만 받고 주는 상태, while문으로 감싸줘야 계속 반복됨
				if(recievedMsg.equals("exit")) {
					System.out.println("클라이언트 종료!!");
					C1704_Server.list.remove(this);
					flag = false;
				} else {
//					System.out.println(receivedMsg);
//					output.writeUTF("[서버]" + recievedMsg);	// > 현재 접속한 클라이언트에게 전송
					C1704_Server.list.forEach(ch -> {
						try {
							ch.output.writeUTF(recievedMsg);
						} catch (Exception e) {
							e.printStackTrace();
						}
					});
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
