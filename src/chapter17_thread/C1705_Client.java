package chapter17_thread;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

public class C1705_Client {

	public static void main(String[] args) {

//		Socket s = new Socket(서버 IP, 9000);
//		Socket s = new Socket(localhost, 9000); // localhost, 127.0.0.1
		// 윈도우 시작 누르고 cmd 실행해서 ipconfig/all 입력하면 IPv4 주소값(내부 주소값) 나옴, 그것을 사용하면 됨
		// 익셉션으로 인해 트라이 캐치 사용
		
		try {
			final String HOST = "localhost";
			final int PORT = 9000;
			Frame f = new Frame();
			Button button1 = new Button("종료");
			
			Socket s = new Socket(HOST, PORT); // localhost, 127.0.0.1
			System.out.println("클라이언트 접속");
			
			// 메세지 수신하는 작업
			
			f.add(button1);
			f.setSize(200, 300);
			f.setVisible(true);
			
			button1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("-- 클라이언트 종료 --");
					System.exit(0);
				}
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 에러가 아닌데 빨간 줄 뜰 때 전체 코드 선택하고 잘라내기 후 붙여넣기 하면 해결됨, 이클립스 에러
	}

}
