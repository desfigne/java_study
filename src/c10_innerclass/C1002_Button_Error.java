package c10_innerclass;

/**
* 학원 데스크탑 컴퓨터에서 라이브러리 호출을 못하는 에러가 발생하여 전체 주석 처리
*/

//import java.awt.Button;

//import java.awt.BorderLayout;
//import java.awt.Button;
//import java.awt.Frame;
//import java.awt.Panel;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.WindowEvent;
//import java.awt.event.WindowListener;

public class C1002_Button_Error {

//	public static void main(String[] args) {
//		
//		Frame f = new Frame();
//		Panel p = new Panel();
//		Panel p2 = new Panel();
//		Panel p3 = new Panel();
//		f.setLayout(new BorderLayout());
//		Button btnClick = new Button("button1을 클릭해주세요.");
//		Button btnClick2 = new Button("button2을 클릭해주세요.");
//		Button btnClick3 = new Button("button3을 클릭해주세요.");
//		p.add(btnClick); p2.add(btnClick2); p3.add(btnClick3);
//		f.add(p3, BorderLayout.SOUTH);
//		f.add(p2, BorderLayout.CENTER);
//		f.add(p, BorderLayout.NORTH);
//		f.setTitle("버튼 테스트");
//		f.setSize(300, 400);
//		f.setVisible(true);
//		
//		// 버튼의 이벤트 처리1 - 내부 클래스를 생성하여 액션 이벤트 처리
////		JAVA1002Button.ButtonActionListener action = new JAVA1002Button.ButtonActionListener();
//		btnClick.addActionListener(new C1002_Button.ButtonActionListener());
//		
//		// 버튼의 이벤트 처리2 - Anonymous(익명) 클래스를 생성하여 액션 이벤트 처리
//		btnClick2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("Button2 Click");
//			}
//		}); // JVM이 자동으로 임의의 주소값을 생성해 만듬
//		
//		// 버튼의 이벤트 처리3 - 람다식(자바 버전 8 이상부터) 처리방식을 이용한 이벤트 처리
////		btnClick3.addActionListener((ActionEvent e) -> {
////			System.out.println("Button3 Click");
////		});
////
////		btnClick3.addActionListener(e -> {
////			System.out.println("Button3 Click");
////		});
//		
//		btnClick3.addActionListener(e -> System.out.println("Button3 Click"));
//		
//		// Frame의 종료 이벤트
//		f.addWindowListener(new WindowListener() {
//			public void windowActivated(WindowEvent e) {}
//			public void windowClosed(WindowEvent e) {}
//			public void windowClosing(WindowEvent e) {
//				System.out.println(" - 프로그램 종료 - ");
//				System.exit(0);
//			}
//			public void windowDeactivated(WindowEvent e) {}
//			public void windowDeiconified(WindowEvent e) {}
//			public void windowIconified(WindowEvent e) {}
//			public void windowOpened(WindowEvent e) {}
//		});
//		
//	}
//	
//	/**
//	 * 버튼의 이벤트 처리 클래스
//	 */
//	public static class ButtonActionListener implements ActionListener {
//	    public void actionPerformed(ActionEvent e) {
//	        System.out.println("Button1 Click");
//	    }
//	}

}
