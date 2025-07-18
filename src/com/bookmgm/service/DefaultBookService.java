package com.bookmgm.service;

import java.util.List;
import java.util.Random;

import com.bookmgm.application.BookManagementApplication;
import com.bookmgm.model.Book;
import com.bookmgm.repository.AladinBookRepository;
import com.bookmgm.repository.BookRepository;
import com.bookmgm.repository.InMemoryBookRepository;
import com.bookmgm.repository.Yes24BookRepository;

public class DefaultBookService implements BookService{
	BookManagementApplication bma;
	BookRepository repository; // 인터페이스 타입 선언
	
	public DefaultBookService() {}
	public DefaultBookService(BookManagementApplication bma) {
		this.bma = bma; // 스코프(범위)를 넓혀줌
		selectRepository();
//		repository = new InMemoryBookRepository(); // 자식 클래스 지정
	}

	/**
	 * 도서 생성
	 */
	public Book createBook() {
		Random rd = new Random();
		Book book = new Book();
//		int id = rd.nextInt(1000, 9999);
		book.setId(String.valueOf(rd.nextInt(1000, 9999)));

		System.out.print("도서명 > ");
		book.setName(bma.scan.next());
		
		System.out.print("저자 > ");
		book.setAuthor(bma.scan.next());
		
		System.out.print("가격 > ");
		book.setPrice(bma.scan.nextInt());
		
		return book;
	}
	
	/**
	 * 도서 생성
	 * @param book - old book 정보
	 * 도서 수정시 도서 정보를 일부 수정하여 반환
	 */
	public Book createBook(Book book) {
		System.out.print("도서명 > ");
		book.setName(bma.scan.next());
		
		System.out.print("저자 > ");
		book.setAuthor(bma.scan.next());
		
		System.out.print("가격 > ");
		book.setPrice(bma.scan.nextInt());
		
		return book;
	}
	
	/**
	 * 도서 등록
	 */
	@Override
	public void register() {
//		selectRepository();
		
		Book book = createBook();

//		System.out.println(book); // 객체 주소값으로 출력됨

//		System.out.println(book.getName()); // < DB로 전달하기 전 체크
//		System.out.println(book.getAuthor());
//		System.out.println(book.getPrice()); // > 값이 안뜨거나 널값이 뜨면 크레에이트북이 잘못돼었으므로 체크 필요
		
		if(repository.insert(book)) {
			System.out.println("✅ 도서가 등록되었습니다.");
		} else {
			System.out.println("🚫 도서가 등록되지 않았습니다.");
		}
		
		bma.showMenu();
	};
	
	/**
	 * 도서관 선택 (레파지토리)
	 */
	public void selectRepository() { // 인터페이스와 레포지토리로 분리해서 구성하면 중복성이 매우 현저히 낮아짐, 유지보수성이 용이
		System.out.println("================= 시스템에 등록된 도서관 =================");
		System.out.println("1. 교육센터\t2. 알라딘\t3. 예스24");
		System.out.println("====================================================");
		System.out.print("도서관을 선택해주세요. > ");
		int rno = bma.scan.nextInt();
		if(rno == 1) {
			repository = new InMemoryBookRepository();
		} else if(rno == 2) {
			repository = new AladinBookRepository();
		} else if(rno == 3) {
			repository = new Yes24BookRepository();
		}
	}
	
	/**
	 * 도서 출력 - 검색, 수정 시 결과 출력
	 * @param book
	 */
	public void printBook(Book book) {
		System.out.println("----------------------------------------------------");
		System.out.print("[" + book.getId() + "]\t");
		System.out.print(book.getName() + " - ");
		System.out.print(book.getAuthor() + "\t");
		System.out.print(book.getPrice() + "\n");
		System.out.println("----------------------------------------------------");
	}
	
	/**
	 * 도서 조회
	 */
	@Override
	public void list() {
		if(getCount() != 0) {
			List<Book> library = repository.selectAll();
			library.forEach(book -> {
				System.out.print("[" + book.getId() + "]\t");
				System.out.print(book.getName() + " - ");
				System.out.print(book.getAuthor() + ",\t");
				System.out.print(book.getPrice() + "\n");
			});
		} else {
			System.out.println("🚫 등록된 도서가 존재하지 않습니다.");
		}
		bma.showMenu();
	}; // 이거 코드 맞나? 라이브러리 포이치 안에 왜 코드가 없지?

	/**
	 * 도서 검색
	 */
	@Override
	public void search() {
		if(getCount() != 0) {
			System.out.print("도서번호를 입력해주세요. > ");
			Book book = repository.select(bma.scan.next());
			if(book != null) {
				printBook(book);
			} else {
				System.out.println("🚫 검색하신 도서가 없습니다.");
			}
		} else {
			System.out.println("🚫 등록된 도서가 존재하지 않습니다.");
		}
		bma.showMenu();
	};
	
	/**
	 * 도서 수정
	 */
	@Override
	public void update() {
		if(getCount() != 0) {
			System.out.print("도서번호를 입력해주세요. > ");
			Book book = repository.select(bma.scan.next());
			if(book != null) {
				repository.update(createBook(book));
				System.out.println("✅ 도서가 수정되었습니다.");
				printBook(book);
			} else {
				System.out.println("🚫 검색하신 도서가 없습니다.");
			}
		} else {
			System.out.println("🚫 등록된 도서가 존재하지 않습니다.");
		}
		bma.showMenu();
		
	};
	
	/**
	 * 도서 삭제
	 */
	@Override
	public void delete() {
		if(getCount() != 0) {
			System.out.print("도서번호를 입력해주세요. > ");
			Book book = repository.select(bma.scan.next());
			if(book != null) {
//				repository.remove(book.getId());
				repository.remove(book);
				System.out.println("✅ 도서가 삭제되었습니다.");
				printBook(book);
			} else {
				System.out.println("🚫 검색하신 도서가 없습니다.");
			}
		} else {
			System.out.println("🚫 등록된 도서가 존재하지 않습니다.");
		}
		bma.showMenu();
	};
	
	@Override
	public void exit() {
		System.out.println("✅ 시스템이 종료됩니다.");
		System.exit(0);
	};
	
	@Override
	public int getCount() { // 리턴 타입으로 디폴트 구조 먼저 생성
		return repository.getCount();
	};
}
