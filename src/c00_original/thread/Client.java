package thread;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        final String SERVER_IP = "localhost"; // 또는 "127.0.0.1"
        final int SERVER_PORT = 12345;
        Frame f = new Frame("Client");
        Button button1 = new Button("종료버튼");
        
        try {
        	Socket socket = new Socket(SERVER_IP, SERVER_PORT);
        	f.add(button1);
        	f.setSize(300,200);
        	f.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        button1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		System.out.println("클라이언트 종료!!");
        		System.exit(0);
        	}
        });
     
    }//main
}
