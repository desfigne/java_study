package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 데이터베이스 연결 공통 클래스
 */
public class DBConn {
    // 데이터베이스 연결 정보
    private String url = "jdbc:mysql://127.0.0.1:3306/hrdb2019";
    private String user = "root";
    private String password = "mysql1234";
    
    // 데이터베이스 연결 및 SQL 실행 객체들
    Connection connection;
    protected Statement stmt;
    protected PreparedStatement pstmt;
    protected ResultSet rs;

    /**
     * 데이터베이스 연결 생성자
     */
    protected DBConn() {
        try {
            // 데이터베이스 연결
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("데이터베이스 연결 성공");
        } catch(Exception e) {
            System.err.println("데이터베이스 연결 실패: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * PreparedStatement 객체 생성
     * @param sql 실행할 SQL 쿼리
     */
    public void getPreparedStatement(String sql) {
        try {
            pstmt = connection.prepareStatement(sql);
        } catch (Exception e) { 
            System.err.println("PreparedStatement 생성 실패: " + e.getMessage());
            e.printStackTrace(); 
        }
    }

    /**
     * Statement 객체 생성
     */
    public void getStatement() {
        try {
            stmt = connection.createStatement();
        } catch (Exception e) { 
            System.err.println("Statement 생성 실패: " + e.getMessage());
            e.printStackTrace(); 
        }
    }

    /**
     * 데이터베이스 연결 종료
     */
    public void close() {
        try {
            if(rs != null) rs.close();
            if(pstmt != null) pstmt.close();
            if(stmt != null) stmt.close();
            if(connection != null) connection.close();
            System.out.println("데이터베이스 연결 종료");
        } catch (Exception e) {
            System.err.println("연결 종료 중 오류: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
