package com.bookmgm.service;

import java.util.List;
import java.util.Random;

import com.bookmgm.application.BookManagementApplication;
import com.bookmgm.model.Book;
import com.bookmgm.repository.DatabaseBookRepository;
import com.bookmgm.repository.InMemoryBookRepository;
import db.GenericRepositoryInterface;

/**
 * 도서 서비스 구현 클래스
 * 도서 관리 시스템의 비즈니스 로직 구현
 */
public class BookServiceImpl implements BookService {
    private BookManagementApplication bma;
    private GenericRepositoryInterface<Book> repository;
    private Random random = new Random();

    /**
     * 기본 생성자
     */
    public BookServiceImpl() {}

    /**
     * 애플리케이션과 연결된 생성자
     * @param bma 메인 애플리케이션 객체
     */
    public BookServiceImpl(BookManagementApplication bma) {
        this.bma = bma;
        selectRepository();
    }

    /**
     * 새 도서 생성
     * @return 생성된 도서 객체
     */
    public Book createBook() {
        Book book = new Book();
        
        // 랜덤 bid와 isbn 생성
        book.setBid("B" + String.format("%04d", random.nextInt(10000)));
        book.setIsbn(random.nextInt(9000) + 1000);

        System.out.print("도서명을 입력하세요 > ");
        String title = bma.scan.nextLine().trim();
        if(title.isEmpty()) {
            title = bma.scan.nextLine().trim(); // 버퍼 클리어
        }
        book.setTitle(title);

        System.out.print("저자를 입력하세요 > ");
        book.setAuthor(bma.scan.nextLine().trim());

        System.out.print("가격을 입력하세요 > ");
        while(!bma.scan.hasNextInt()) {
            System.out.print("올바른 숫자를 입력하세요 > ");
            bma.scan.next();
        }
        book.setPrice(bma.scan.nextInt());
        bma.scan.nextLine(); // 버퍼 클리어

        return book;
    }

    /**
     * 기존 도서 수정을 위한 새 정보 입력
     * @param existingBook 기존 도서 정보
     * @return 수정된 도서 객체
     */
    public Book createBook(Book existingBook) {
        System.out.print("새 도서명을 입력하세요 (현재: " + existingBook.getTitle() + ") > ");
        String title = bma.scan.nextLine().trim();
        if(!title.isEmpty()) {
            existingBook.setTitle(title);
        }

        System.out.print("새 저자를 입력하세요 (현재: " + existingBook.getAuthor() + ") > ");
        String author = bma.scan.nextLine().trim();
        if(!author.isEmpty()) {
            existingBook.setAuthor(author);
        }

        System.out.print("새 가격을 입력하세요 (현재: " + existingBook.getPrice() + "원) > ");
        if(bma.scan.hasNextInt()) {
            existingBook.setPrice(bma.scan.nextInt());
        }
        bma.scan.nextLine(); // 버퍼 클리어

        return existingBook;
    }

    /**
     * 저장소 선택
     */
    public void selectRepository() {
        System.out.println("================= 시스템에 등록된 도서관 =================");
        System.out.println("1. 더조은교육센터 (메모리)");
        System.out.println("2. 알라딘 (메모리)");
        System.out.println("3. 예스24 (메모리)");
        System.out.println("4. 더조은교육센터 (데이터베이스)");
        System.out.println("5. 알라딘 (데이터베이스)");
        System.out.println("6. 예스24 (데이터베이스)");
        System.out.println("====================================================");
        System.out.print("도서관을 선택해주세요 > ");
        
        int choice = 0;
        if(bma.scan.hasNextInt()) {
            choice = bma.scan.nextInt();
        }
        bma.scan.nextLine(); // 버퍼 클리어
        
        switch(choice) {
            case 1:
                repository = new InMemoryBookRepository("더조은교육센터");
                break;
            case 2:
                repository = new InMemoryBookRepository("알라딘");
                break;
            case 3:
                repository = new InMemoryBookRepository("예스24");
                break;
            case 4:
                repository = new DatabaseBookRepository("더조은교육센터", "book_tj");
                break;
            case 5:
                repository = new DatabaseBookRepository("알라딘", "book_aladin");
                break;
            case 6:
                repository = new DatabaseBookRepository("예스24", "book_yes24");
                break;
            default:
                System.out.println("잘못된 선택입니다. 기본값으로 더조은교육센터(메모리)를 선택합니다.");
                repository = new InMemoryBookRepository("더조은교육센터");
                break;
        }
        
        System.out.println();
    }

    /**
     * 도서 정보 출력
     * @param book 출력할 도서 객체
     */
    public void printBook(Book book) {
        if(book == null) {
            System.out.println("출력할 도서 정보가 없습니다.");
            return;
        }
        
        System.out.println("====================================================");
        System.out.printf("도서번호: %s\n", book.getBid());
        System.out.printf("도서명  : %s\n", book.getTitle());
        System.out.printf("저자    : %s\n", book.getAuthor());
        System.out.printf("가격    : %,d원\n", book.getPrice());
        System.out.printf("ISBN    : %d\n", book.getIsbn());
        if(book.getBdate() != null) {
            System.out.printf("등록일  : %s\n", book.getBdate().toString());
        }
        System.out.println("====================================================");
    }

    /**
     * 도서 목록 출력
     * @param books 출력할 도서 리스트
     */
    public void printBookList(List<Book> books) {
        if(books.isEmpty()) {
            System.out.println("출력할 도서가 없습니다.");
            return;
        }
        
        System.out.println("==================== 도서 목록 ====================");
        System.out.printf("%-8s %-15s %-10s %10s\n", "도서번호", "도서명", "저자", "가격");
        System.out.println("--------------------------------------------------");
        
        for(Book book : books) {
            System.out.printf("%-8s %-15s %-10s %,10d원\n", 
                book.getBid(), 
                book.getTitle().length() > 15 ? book.getTitle().substring(0, 12) + "..." : book.getTitle(),
                book.getAuthor().length() > 10 ? book.getAuthor().substring(0, 7) + "..." : book.getAuthor(),
                book.getPrice());
        }
        System.out.println("==================================================");
    }

    /**
     * 도서 등록
     */
    @Override
    public void register() {
        System.out.println("\n========== 도서 등록 ==========");
        
        try {
            Book book = createBook();
            
            if(repository.insert(book) > 0) {
                System.out.println("✅ 도서가 성공적으로 등록되었습니다.");
                printBook(book);
            } else {
                System.out.println("🚫 도서 등록에 실패했습니다.");
            }
        } catch(Exception e) {
            System.err.println("도서 등록 중 오류가 발생했습니다: " + e.getMessage());
        }
        
        System.out.println("\n계속하려면 Enter를 누르세요...");
        bma.scan.nextLine();
        bma.showMenu();
    }

    /**
     * 도서 목록 조회
     */
    @Override
    public void list() {
        System.out.println("\n========== 도서 목록 ==========");
        
        try {
            List<Book> books = repository.findAll();
            
            if(!books.isEmpty()) {
                printBookList(books);
                System.out.printf("총 %d권의 도서가 등록되어 있습니다.\n", books.size());
            } else {
                System.out.println("등록된 도서가 없습니다.");
            }
        } catch(Exception e) {
            System.err.println("도서 목록 조회 중 오류가 발생했습니다: " + e.getMessage());
        }
        
        System.out.println("\n계속하려면 Enter를 누르세요...");
        bma.scan.nextLine();
        bma.showMenu();
    }

    /**
     * 도서 검색
     */
    @Override
    public void search() {
        System.out.println("\n========== 도서 검색 ==========");
        
        if(getCount() == 0) {
            System.out.println("등록된 도서가 없습니다.");
            System.out.println("\n계속하려면 Enter를 누르세요...");
            bma.scan.nextLine();
            bma.showMenu();
            return;
        }
        
        try {
            System.out.print("검색할 도서번호를 입력하세요 > ");
            String bid = bma.scan.nextLine().trim();
            
            if(bid.isEmpty()) {
                System.out.println("도서번호를 입력해주세요.");
                search();
                return;
            }
            
            Book book = repository.find(bid);
            
            if(book != null) {
                System.out.println("✅ 도서를 찾았습니다.");
                printBook(book);
            } else {
                System.out.println("🚫 해당 도서번호의 도서를 찾을 수 없습니다.");
            }
        } catch(Exception e) {
            System.err.println("도서 검색 중 오류가 발생했습니다: " + e.getMessage());
        }
        
        System.out.println("\n계속하려면 Enter를 누르세요...");
        bma.scan.nextLine();
        bma.showMenu();
    }

    /**
     * 도서 수정
     */
    @Override
    public void update() {
        System.out.println("\n========== 도서 수정 ==========");
        
        if(getCount() == 0) {
            System.out.println("등록된 도서가 없습니다.");
            System.out.println("\n계속하려면 Enter를 누르세요...");
            bma.scan.nextLine();
            bma.showMenu();
            return;
        }
        
        try {
            System.out.print("수정할 도서번호를 입력하세요 > ");
            String bid = bma.scan.nextLine().trim();
            
            Book book = repository.find(bid);
            
            if(book != null) {
                System.out.println("현재 도서 정보:");
                printBook(book);
                
                System.out.println("새로운 정보를 입력해주세요 (변경하지 않으려면 Enter):");
                Book updatedBook = createBook(book);
                
                if(repository.update(updatedBook) > 0) {
                    System.out.println("✅ 도서 정보가 성공적으로 수정되었습니다.");
                    printBook(updatedBook);
                } else {
                    System.out.println("🚫 도서 수정에 실패했습니다.");
                }
            } else {
                System.out.println("🚫 해당 도서번호의 도서를 찾을 수 없습니다.");
            }
        } catch(Exception e) {
            System.err.println("도서 수정 중 오류가 발생했습니다: " + e.getMessage());
        }
        
        System.out.println("\n계속하려면 Enter를 누르세요...");
        bma.scan.nextLine();
        bma.showMenu();
    }

    /**
     * 도서 삭제
     */
    @Override
    public void delete() {
        System.out.println("\n========== 도서 삭제 ==========");
        
        if(getCount() == 0) {
            System.out.println("등록된 도서가 없습니다.");
            System.out.println("\n계속하려면 Enter를 누르세요...");
            bma.scan.nextLine();
            bma.showMenu();
            return;
        }
        
        try {
            System.out.print("삭제할 도서번호를 입력하세요 > ");
            String bid = bma.scan.nextLine().trim();
            
            Book book = repository.find(bid);
            
            if(book != null) {
                System.out.println("삭제할 도서 정보:");
                printBook(book);
                
                System.out.print("정말 삭제하시겠습니까? (y/N) > ");
                String confirm = bma.scan.nextLine().trim();
                
                if(confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes")) {
                    if(repository.remove(bid) > 0) {
                        System.out.println("✅ 도서가 성공적으로 삭제되었습니다.");
                    } else {
                        System.out.println("🚫 도서 삭제에 실패했습니다.");
                    }
                } else {
                    System.out.println("삭제가 취소되었습니다.");
                }
            } else {
                System.out.println("🚫 해당 도서번호의 도서를 찾을 수 없습니다.");
            }
        } catch(Exception e) {
            System.err.println("도서 삭제 중 오류가 발생했습니다: " + e.getMessage());
        }
        
        System.out.println("\n계속하려면 Enter를 누르세요...");
        bma.scan.nextLine();
        bma.showMenu();
    }

    /**
     * 시스템 종료
     */
    @Override
    public void exit() {
        System.out.println("\n========== 시스템 종료 ==========");
        System.out.println("도서 관리 시스템을 종료합니다.");
        System.out.println("이용해 주셔서 감사합니다.");
        
        // 데이터베이스 연결 종료 (DatabaseBookRepository인 경우)
        if(repository instanceof DatabaseBookRepository) {
            ((DatabaseBookRepository) repository).close();
        }
        
        System.exit(0);
    }

    /**
     * 전체 도서 수 조회
     * @return 전체 도서 수
     */
    @Override
    public int getCount() {
        try {
            return repository.getCount();
        } catch(Exception e) {
            System.err.println("도서 수 조회 중 오류가 발생했습니다: " + e.getMessage());
            return 0;
        }
    }
}
