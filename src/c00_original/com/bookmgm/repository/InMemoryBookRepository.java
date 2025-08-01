package com.bookmgm.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bookmgm.model.Book;
import db.GenericRepositoryInterface;

/**
 * 메모리 기반 도서 저장소
 */
public class InMemoryBookRepository implements GenericRepositoryInterface<Book> {
    private List<Book> library = new ArrayList<>();
    private String libraryName;

    /**
     * 생성자
     * @param name 도서관 이름
     */
    public InMemoryBookRepository(String name) {
        this.libraryName = name;
        System.out.println("** " + name + " 메모리 도서관 생성 완료 **");
    }

    /**
     * 도서 등록
     * @param book 등록할 도서
     * @return 성공 시 1, 실패 시 0
     */
    @Override
    public int insert(Book book) {
        if(book != null) {
            // 등록일 자동 설정
            if(book.getBdate() == null) {
                book.setBdate(new Date());
            }
            
            if(library.add(book)) {
                System.out.println("메모리에 도서 등록 완료: " + book.getTitle());
                return 1;
            }
        }
        return 0;
    }

    /**
     * 전체 도서 조회
     * @return 전체 도서 리스트
     */
    @Override
    public List<Book> findAll() {
        return new ArrayList<>(library); // 복사본 반환으로 안전성 확보
    }

    /**
     * ID로 도서 검색
     * @param id 검색할 도서 ID
     * @return 찾은 도서, 없으면 null
     */
    @Override
    public Book find(String id) {
        if(id == null) return null;
        
        for(Book book : library) {
            if(book.getBid() != null && book.getBid().equals(id)) {
                return book;
            }
        }
        return null;
    }

    /**
     * 도서 정보 수정
     * @param entity 수정할 도서 정보
     * @return 성공 시 1, 실패 시 0
     */
    @Override
    public int update(Book entity) {
        if(entity == null || entity.getBid() == null) return 0;
        
        for(int i = 0; i < library.size(); i++) {
            if(library.get(i).getBid().equals(entity.getBid())) {
                library.set(i, entity);
                System.out.println("도서 정보 수정 완료: " + entity.getTitle());
                return 1;
            }
        }
        return 0;
    }

    /**
     * 도서 삭제
     * @param id 삭제할 도서 ID
     * @return 성공 시 1, 실패 시 0
     */
    @Override
    public int remove(String id) {
        if(id == null) return 0;
        
        for(int i = 0; i < library.size(); i++) {
            if(library.get(i).getBid().equals(id)) {
                Book removedBook = library.remove(i);
                System.out.println("도서 삭제 완료: " + removedBook.getTitle());
                return 1;
            }
        }
        return 0;
    }

    /**
     * 전체 도서 수 조회
     * @return 전체 도서 수
     */
    @Override
    public int getCount() {
        return library.size();
    }

    /**
     * 도서관 이름 반환
     * @return 도서관 이름
     */
    public String getLibraryName() {
        return libraryName;
    }
}
