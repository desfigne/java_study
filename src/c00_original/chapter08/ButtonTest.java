package chapter08;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonTest {

	public static void main(String[] args) {
		Frame f = new Frame();
		Panel p = new Panel();
		Button btnStart = new Button("START");
		Button btnExit = new Button("EXIT");
		p.add(btnStart);
		p.add(btnExit);
		f.add(p);
		f.setSize(400, 500);
		f.setVisible(true);
		
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("START 버튼 클릭!!");
			}
		});
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
//		btnExit.addActionListener(
//			e -> {
//				System.exit(0);
//			}
//		);
		
		
	}

}
