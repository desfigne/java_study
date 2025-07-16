package chapter07_class.C0714_vendingmachine_v02;

public class RestArea {
    // Field(필드)
    String name;                            // 휴게소 이름
    User user;                              // 사용자 객체
    VendingMachine machine;                 // 자판기 객체

    
    
    // Constructor(생성자)
    public RestArea() {
        this("미입력시");                     // 기본값
    }

    public RestArea(String name) {
        this.name = name;                   // 휴게소 이름 초기화
        user = new User("정국");             // 사용자 생성 (필요시)
        welcome();                          // 환영 메시지 출력
        machine = new VendingMachine(user); // 자판기 생성 (필요시)
    }

    
    
    // Method(메소드)
    public void welcome() {
        System.out.println("==============================================");
        System.out.println("☕🍋🥛" + name + " 휴게소에 오신 것을 환영합니다.");
        System.out.println("==============================================");
    }
}