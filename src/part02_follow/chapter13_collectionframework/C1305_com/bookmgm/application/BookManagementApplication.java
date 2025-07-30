package part02_follow.chapter13_collectionframework.C1305_com.bookmgm.application;

import java.util.Scanner;

import part02_follow.chapter13_collectionframework.C1305_com.bookmgm.service.BookService;
import part02_follow.chapter13_collectionframework.C1305_com.bookmgm.service.DefaultBookService;

public class BookManagementApplication {
	public static final int REGISTER	= 1;
	public static final int LIST		= 2;
	public static final int SEARCH		= 3;
	public static final int UPDATE		= 4;
	public static final int DELETE		= 5;
	public static final int EXIT		= 6;
	public Scanner scan;
	public BookService service;
	
	//기본 생성자
	public BookManagementApplication() {
		scan = new Scanner(System.in);
		service = new DefaultBookService(this); // 자신의 메소드를 호춣할 수 있도록 this 주소값을 넘김, 생성자할때 배운 내용
		showMenu();
	}
	
	/**
	 * 메뉴 출력
	 */
	public void showMenu() {
		// 배열을 이용하여 메뉴 출력, 배열은 forEach 사용 불가, for문 사용
		// 배열로 구성하는 이유는 개수에 상관없이 자동으로 늘어나고 줄어드는 자동 관리
		String [] labels = {"도서 등록", "도서 목록 조회", "도서 검색", "도서 수정", "도서 삭제", "종료"};
		System.out.println("=================== 도서 관리 시스템 ===================");
		System.out.println("전체 도서 수 : " + service.getCount()); // 겟카운트는 메소드로 실행 후에야 메소드 에어리어에 올라가야 에러가 뜸
		System.out.println("====================================================");
		for(int i=0; i<labels.length; i++) {
			System.out.println((i+1) + "." + labels[i]);
		}
		System.out.println("----------------------------------------------------");
		
		selectMenu();
	}
	
	/**
	 * 메뉴 선택
	 */
	public void selectMenu() {
		System.out.print("메뉴(숫자)를 선택해주세요. > ");
		if(scan.hasNextInt()) {
			switch(scan.nextInt()) { // 컨트롤러 객체
			case REGISTER:	service.register();	break;
			case LIST:		service.list();		break;
			case SEARCH:	service.search();	break;
			case UPDATE:	service.update();	break;
			case DELETE:	service.delete();	break;
			case EXIT:		service.exit();		break; // 역할 구분을 위해 시스템을 직접 종료하지 않고 종료하는 역할에게 넘겨줌
			default :
				System.out.println("메뉴 준비중입니다, 다시 선택해주세요.");
				selectMenu();
			}
		} else {
			System.out.println("=> 올바르지 않은 형식입니다. 다시 선택해주세요.");
			scan.next();
			selectMenu();
		}
	}

	public static void main(String[] args) { // 실행은 메인에서
		new BookManagementApplication() {};
	}

}
