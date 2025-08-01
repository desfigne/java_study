package com.bookmgm.model;

import java.util.Date;

/**
 * 도서 정보를 담는 모델 클래스
 */
public class Book {
    private int rno;        // 행 번호
    private String bid;     // 도서 ID
    private String title;   // 도서 제목
    private String author;  // 저자
    private int price;      // 가격
    private int isbn;       // ISBN 번호
    private Date bdate;     // 등록일

    /**
     * 기본 생성자
     */
    public Book() {}

    /**
     * 전체 필드 생성자
     */
    public Book(String bid, String title, String author, int price, int isbn) {
        this.bid = bid;
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
        this.bdate = new Date();
    }

    // Getter and Setter methods
    public int getRno() {
        return rno;
    }

    public void setRno(int rno) {
        this.rno = rno;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public Date getBdate() {
        return bdate;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }

    /**
     * ID 반환 (메모리 기반 Repository에서 사용)
     * @return bid 값
     */
    public String getId() {
        return bid;
    }

    /**
     * 도서 정보를 문자열로 반환
     */
    @Override
    public String toString() {
        return String.format("Book{bid='%s', title='%s', author='%s', price=%d, isbn=%d}", 
                bid, title, author, price, isbn);
    }

    /**
     * 객체 비교
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return bid != null ? bid.equals(book.bid) : book.bid == null;
    }

    /**
     * 해시코드 생성
     */
    @Override
    public int hashCode() {
        return bid != null ? bid.hashCode() : 0;
    }
}
