package com.bookmgm.application;

import java.util.Scanner;

import com.bookmgm.service.BookService;
import com.bookmgm.service.BookServiceImpl;

/**
 * 도서 관리 시스템 메인 애플리케이션
 */
public class BookManagementApplication {
    // 메뉴 상수 정의
    public static final int REGISTER = 1;
    public static final int LIST = 2;
    public static final int SEARCH = 3;
    public static final int UPDATE = 4;
    public static final int DELETE = 5;
    public static final int EXIT = 6;

    // 필드
    public Scanner scan;
    public BookService service;

    /**
     * 애플리케이션 생성자 및 초기화
     */
    public BookManagementApplication() {
        System.out.println("==========================================");
        System.out.println("     📚 도서 관리 시스템을 시작합니다 📚     ");
        System.out.println("==========================================\n");
        
        scan = new Scanner(System.in);
        service = new BookServiceImpl(this);
        
        // 환영 메시지 후 메뉴 시작
        System.out.println("시스템 초기화가 완료되었습니다.\n");
        showMenu();
    }

    /**
     * 메뉴 출력
     */
    public void showMenu() {
        try {
            // 메뉴 라벨 배열
            String[] labels = {
                "도서 등록", 
                "도서 목록 조회", 
                "도서 검색", 
                "도서 수정", 
                "도서 삭제", 
                "시스템 종료"
            };
            
            // 시스템 상태 표시
            System.out.println("=================== 도서 관리 시스템 ===================");
            System.out.printf("현재 등록된 도서 수: %d권\n", service.getCount());
            System.out.println("====================================================");
            
            // 메뉴 항목 출력
            for(int i = 0; i < labels.length; i++) {
                System.out.printf("%d. %s\n", (i + 1), labels[i]);
            }
            
            System.out.println("----------------------------------------------------");
            selectMenu();
            
        } catch(Exception e) {
            System.err.println("메뉴 출력 중 오류가 발생했습니다: " + e.getMessage());
            System.exit(1);
        }
    }

    /**
     * 메뉴 선택 처리
     */
    public void selectMenu() {
        System.out.print("메뉴를 선택해주세요 (1-6) > ");
        
        try {
            if(scan.hasNextInt()) {
                int choice = scan.nextInt();
                scan.nextLine(); // 버퍼 클리어
                
                // 메뉴 선택에 따른 처리
                switch(choice) {
                    case REGISTER: 
                        service.register(); 
                        break;
                    case LIST: 
                        service.list(); 
                        break;
                    case SEARCH: 
                        service.search(); 
                        break;
                    case UPDATE: 
                        service.update(); 
                        break;
                    case DELETE: 
                        service.delete(); 
                        break;
                    case EXIT: 
                        service.exit(); 
                        break;
                    default:
                        System.out.println("❌ 올바른 메뉴 번호(1-6)를 선택해주세요.\n");
                        showMenu();
                        break;
                }
            } else {
                System.out.println("❌ 숫자를 입력해주세요.\n");
                scan.nextLine(); // 잘못된 입력 제거
                showMenu();
            }
        } catch(Exception e) {
            System.err.println("메뉴 선택 중 오류가 발생했습니다: " + e.getMessage());
            scan.nextLine(); // 버퍼 클리어
            showMenu();
        }
    }

    /**
     * 애플리케이션 시작점
     * @param args 명령행 파라미터
     */
    public static void main(String[] args) {
        try {
            new BookManagementApplication();
        } catch(Exception e) {
            System.err.println("시스템 시작 중 치명적인 오류가 발생했습니다: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}
