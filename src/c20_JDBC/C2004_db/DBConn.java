package c20_JDBC.C2004_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConn {
	
	// Field
	private String url = "jdbc:mysql://127.0.0.1:3306/hrdb2019";
	private String user = "root";
	private String password = "mysql1234";
	
	Connection connection;
//	Statement stmt; - 같은 패키지 안에서만 공유 가능, Dao에서는 사용 불가
//	ResultSet rs;
	protected Statement stmt; // 상속된 자식 클래스에서 사용 가능
	protected PreparedStatement pstmt; // 둘 중에 하나로만 사용 가능
	protected ResultSet rs;
	
	// Constructor
	
	// [1단계] 드라이버 로딩 + [2단계] Connection 객체 생성
	protected DBConn() { // 상속되어 있는 자식 클래스만 호출할 수 있도록 프로텍티드
		try {
			connection = DriverManager.
					getConnection(url, user, password);
			
			System.out.println("-->> [1단계] 드라이버 로딩 완료");
			System.out.println("-->> [2단계] Connection 객체 생성 완료 \n");
		} catch (Exception e) {e.printStackTrace();}
	}
	
	// [3단계] Statement 객체 생성
	public void getStatement() {
		try {
			stmt = connection.createStatement();
			System.out.println("-->> [3단계] Statement 객체 생성 완료 \n");
		} catch (Exception e) {e.printStackTrace();}
		
//		return stmt; // 1번째 방법
	}
	
	// [3단계] PreparedStatement 객체 생성
	public void getPreparedStatement(String sql) {
		try {
			pstmt = connection.prepareStatement(sql);
			System.out.println("-->> [3단계] PreparedStatement 객체 생성 완료 \n");
		} catch (Exception e) {e.printStackTrace();}
	}
	
	// [4단계 ~ 5단계] 작업은 각각의 데이터가 다르므로 각각의 테이블 Dao에서 작업 진행하도록 해야 함
	
	// [6단계] connection, stmt, rs 객체 종료
	public void close() {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(connection != null) connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
