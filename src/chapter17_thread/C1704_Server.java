package chapter17_thread;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 멀티 채팅 서버 구현
 */
public class C1704_Server {

	public final static int PORT = 9000;

	public static void main(String[] args) {
		
//		ServerSocket server = new ServerSocket(PORT); // try catch 사용해 익셉션 해결, 포트가 다르면 io익셉션 발생
		
		try {
			ServerSocket server = new ServerSocket(PORT);
			System.out.println("서버 실행 중 : " + PORT);
			System.out.println("클라이언트 접속 대기 중입니다.");
			
//			Socket s = server.accept(); // 클라이언트 접속 대기 중
//			System.out.println("✅ 라이언트 접속");
			
			while(true) {
				Socket s = server.accept(); // < 클라이언트가 몇 명이 올지 모르므로 while문으로 계속 돌려야 함
				System.out.println("✅ 클라이언트 접속"); // >
				 // 서버 콘솔창에서 종료를 누르면 클라이언트 소켓도 함께 종료됨, Socket s가 종료되지 않도록 메인 메소드에 종속되지 않도록 처리해야 하므로 서버에 있는 소켓을 쓰레드로 처리
				
				// 클라이언트 별로 접속하고 별도 종료 진행
				new ClientHandler(s).start();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	} // Main

} // Server

class ClientHandler extends Thread {
	Socket s;
	OutputStream output;
	InputStream input;
	
	public ClientHandler(Socket s) {
//		this.s = s;
//		this.output = s.getOutputStream(); // 익셉션 에러 발생, 트라이 캐치 사용
		try {
			this.s = s;
			this.output = s.getOutputStream();
			this.input = s.getInputStream();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void run() {
//		String str = "안녕하세요";
//		output.write(str.getBytes()); // 익셉션 발생, 전달 못갈 가능성이 있어 트라이 캐치 사용
		try {
			String str = "안녕하세요";
			output.write(str.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
