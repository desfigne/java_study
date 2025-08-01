package com.bookmgm.service;

/**
 * 도서 서비스 인터페이스
 * 도서 관리 시스템의 비즈니스 로직을 정의
 */
public interface BookService {
    /**
     * 도서 등록
     */
    void register();
    
    /**
     * 도서 목록 조회
     */
    void list();
    
    /**
     * 도서 검색
     */
    void search();
    
    /**
     * 도서 수정
     */
    void update();
    
    /**
     * 도서 삭제
     */
    void delete();
    
    /**
     * 시스템 종료
     */
    void exit();
    
    /**
     * 전체 도서 수 조회
     * @return 전체 도서 수
     */
    int getCount();
}
