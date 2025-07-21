package part02_follow.chapter17_thread;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class C1705_Client {

	public static void main(String[] args) {

//		Socket s = new Socket(서버 IP, 9000);
//		Socket s = new Socket(localhost, 9000); // localhost, 127.0.0.1
		// 윈도우 시작 누르고 cmd 실행해서 ipconfig/all 입력하면 IPv4 주소값(내부 주소값) 나옴, 그것을 사용하면 됨
		// 익셉션으로 인해 트라이 캐치 사용
		
		try {
			String id = "2";
			final String HOST = "localhost";
			final int PORT = 9000;
			Frame f = new Frame("채팅 클라이언트");
			Panel p = new Panel();
			f.setLayout(new BorderLayout());
			TextArea ta = new TextArea();
			TextField tf = new TextField(40);
			Button send = new Button("전송");
			Button button1 = new Button("종료");
			ta.setEditable(false);
			tf.setText("[" + id + "] : ");
			p.add(tf);	p.add(send);
			
			Socket s = new Socket(HOST, PORT); // localhost, 127.0.0.1
			System.out.println("클라이언트 접속");
			
			// < 1번째 방법
//			InputStream input = s.getInputStream();
//			OutputStream output = s.getOutputStream();
//			
//			byte[] buffer = new byte[1024]; // 1KB 크기
//			int bytesRead = input.read(buffer); // 읽은 바이트 수 반환
//			
//			if (bytesRead != -1) {
//				String receivedMessage = new String(buffer, 0, bytesRead, "UTF-8");
////				System.out.println("서버로부터 받은 메시지 : " + receivedMessage);
////				ta.append("서버로부터 받은 메시지 : " + receivedMessage);
//				ta.append(receivedMessage);
//			}
			// >
			
			// < 업그레이드된 2번째 방법
			DataInputStream input = new DataInputStream(s.getInputStream());
			DataOutputStream output = new DataOutputStream(s.getOutputStream());
			
			new ServiceThread(input, ta).start();
//			ta.append(input.readUTF() + "\n");
			// >
			
			f.add(p, BorderLayout.NORTH);
			f.add(ta, BorderLayout.CENTER);
			f.add(button1, BorderLayout.SOUTH);
			f.setSize(400, 500);
			f.setVisible(true);
			
			// 전송 버튼 이벤트
			send.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 전송 버튼 클릭 ----> 서버로 tf 데이터 전송
//					System.out.println(tf.getText());
					try {
						// 전송 버튼 클릭 ----> 서버로 tf 데이터 전송
						output.writeUTF(tf.getText());
						tf.setText("[" + id + "] : ");
//						ta.append(input.readUTF() + "\n");
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			});
			
			// 종료 이벤트
			button1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						System.out.println("-- 클라이언트 종료 --");
						output.writeUTF("exit");
						System.exit(0);
					} catch (Exception e2) {}
				}
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 에러가 아닌데 빨간 줄 뜨는 상황이 발생 시 전체 코드 선택하고 잘라내기 후 붙여넣기 하면 해결됨, 이클립스 에러
	}

}

class ServiceThread extends Thread {
	
	DataInputStream input;
	TextArea ta;
	
	public ServiceThread(DataInputStream input, TextArea ta) {
		this.input = input;
		this.ta = ta;
	}
	
	public void run() {
		try {
			while(true) {
				ta.append(input.readUTF() + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
