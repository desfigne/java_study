package com.bookmgm.repository;

import java.util.ArrayList;
import java.util.List;

import com.bookmgm.model.Book;
import db.DBConn;
import db.GenericRepositoryInterface;

/**
 * 데이터베이스 기반 도서 저장소
 */
public class DatabaseBookRepository extends DBConn implements GenericRepositoryInterface<Book> {
    private String tableName;
    private String libraryName;

    /**
     * 생성자
     * @param libraryName 도서관 이름
     * @param tableName 테이블 이름
     */
    public DatabaseBookRepository(String libraryName, String tableName) {
        super();
        this.libraryName = libraryName;
        this.tableName = tableName;
        System.out.println("** " + libraryName + " 데이터베이스 도서관 생성 완료 **");
        System.out.println("연결된 테이블: " + tableName);
    }

    /**
     * 도서 등록
     * @param book 등록할 도서
     * @return 성공 시 1, 실패 시 0
     */
    @Override
    public int insert(Book book) {
        if(book == null) return 0;
        
        int rows = 0;
        String sql = String.format(
            "INSERT INTO %s(title, author, price, isbn, bdate) VALUES(?, ?, ?, ?, NOW())", 
            tableName
        );
        
        try {
            getPreparedStatement(sql);
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setInt(3, book.getPrice());
            pstmt.setInt(4, book.getIsbn());
            
            rows = pstmt.executeUpdate();
            
            if(rows > 0) {
                System.out.println("데이터베이스에 도서 등록 완료: " + book.getTitle());
            }
        } catch (Exception e) {
            System.err.println("도서 등록 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
        
        return rows;
    }

    /**
     * 전체 도서 조회
     * @return 전체 도서 리스트
     */
    @Override
    public List<Book> findAll() {
        List<Book> list = new ArrayList<>();
        String sql = String.format(
            "SELECT bid, title, author, price, isbn, bdate FROM %s ORDER BY bid", 
            tableName
        );
        
        try {
            getPreparedStatement(sql);
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
                Book book = new Book();
                book.setBid(rs.getString("bid"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getInt("price"));
                book.setIsbn(rs.getInt("isbn"));
                book.setBdate(rs.getTimestamp("bdate"));
                list.add(book);
            }
            
            System.out.println("데이터베이스에서 " + list.size() + "개의 도서를 조회했습니다.");
        } catch(Exception e) {
            System.err.println("도서 목록 조회 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
        
        return list;
    }

    /**
     * ID로 도서 검색
     * @param id 검색할 도서 ID
     * @return 찾은 도서, 없으면 null
     */
    @Override
    public Book find(String id) {
        if(id == null) return null;
        
        Book book = null;
        String sql = String.format(
            "SELECT bid, title, author, price, isbn, bdate FROM %s WHERE bid = ?", 
            tableName
        );
        
        try {
            getPreparedStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            
            if(rs.next()) {
                book = new Book();
                book.setBid(rs.getString("bid"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getInt("price"));
                book.setIsbn(rs.getInt("isbn"));
                book.setBdate(rs.getTimestamp("bdate"));
                
                System.out.println("도서 검색 완료: " + book.getTitle());
            }
        } catch(Exception e) {
            System.err.println("도서 검색 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
        
        return book;
    }

    /**
     * 도서 정보 수정
     * @param entity 수정할 도서 정보
     * @return 성공 시 1, 실패 시 0
     */
    @Override
    public int update(Book entity) {
        if(entity == null || entity.getBid() == null) return 0;
        
        int rows = 0;
        String sql = String.format(
            "UPDATE %s SET title=?, author=?, price=? WHERE bid=?", 
            tableName
        );
        
        try {
            getPreparedStatement(sql);
            pstmt.setString(1, entity.getTitle());
            pstmt.setString(2, entity.getAuthor());
            pstmt.setInt(3, entity.getPrice());
            pstmt.setString(4, entity.getBid());
            
            rows = pstmt.executeUpdate();
            
            if(rows > 0) {
                System.out.println("도서 정보 수정 완료: " + entity.getTitle());
            }
        } catch(Exception e) {
            System.err.println("도서 수정 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
        
        return rows;
    }

    /**
     * 도서 삭제
     * @param id 삭제할 도서 ID
     * @return 성공 시 1, 실패 시 0
     */
    @Override
    public int remove(String id) {
        if(id == null) return 0;
        
        int rows = 0;
        String sql = String.format("DELETE FROM %s WHERE bid = ?", tableName);
        
        try {
            getPreparedStatement(sql);
            pstmt.setString(1, id);
            
            rows = pstmt.executeUpdate();
            
            if(rows > 0) {
                System.out.println("도서 삭제 완료: " + id);
            }
        } catch(Exception e) {
            System.err.println("도서 삭제 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
        
        return rows;
    }

    /**
     * 전체 도서 수 조회
     * @return 전체 도서 수
     */
    @Override
    public int getCount() {
        int rows = 0;
        String sql = String.format("SELECT COUNT(*) FROM %s", tableName);
        
        try {
            getPreparedStatement(sql);
            rs = pstmt.executeQuery();
            
            if(rs.next()) {
                rows = rs.getInt(1);
            }
        } catch(Exception e) {
            System.err.println("도서 수 조회 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
        
        return rows;
    }

    /**
     * 도서관 이름 반환
     * @return 도서관 이름
     */
    public String getLibraryName() {
        return libraryName;
    }

    /**
     * 테이블 이름 반환
     * @return 테이블 이름
     */
    public String getTableName() {
        return tableName;
    }
}
