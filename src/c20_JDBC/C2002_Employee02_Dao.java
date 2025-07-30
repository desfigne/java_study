package c20_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import c20_JDBC.C2004_db.DBConn;

//public class C2002_EmployeeDao {
//	
//	// Field
//	private String url = "jdbc:mysql://127.0.0.1:3306/hrdb2019";
//	private String user = "root";
//	private String password = "mysql1234";
//	
//	Connection connection;
//	Statement stmt;
//	ResultSet rs;
//	
//	// Constructor
//	
//	// [1단계] 드라이버 로딩 + [2단계] Connection 객체 생성
//	public C2002_EmployeeDao() { // 다리까지 만들어짐 (1단계, 2단계까지 진행)
//		
//		try {
////			String url = "jdbc:mysql://127.0.0.1:3306/hrdb2019"; // < 전역 선언으로 이동
////			String user = "root";
////			String password = "mysql1234";                       // > 전역 선언으로 이동
////			Connection connection = DriverManager. // 전역 선언 후 호출로 변경 (아랫줄)
//			connection = DriverManager.
//					getConnection(url, user, password);
//			
//			System.out.println("-->> [1단계] 드라이버 로딩 완료");
//			System.out.println("-->> [2단계] Connection 객체 생성 완료 \n");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	// [3단계] Statement 객체 생성
//	public void getStatement() { // throws로 C2004_EmployeeTest로 넘김
//		try {
//			stmt = connection.createStatement();
//			System.out.println("-->> [3단계] Statement 객체 생성 완료 \n");
//		} catch (Exception e) {e.printStackTrace();}
//	}
//
////    // [4단계] ResultSet 생성 - 인자로 받은 SQL 쿼리를 실행 + [5단계] rs 객체에서 데이터 추출
////    public ResultSet getResultSet(String sql) {
////        try {
////            rs = stmt.executeQuery(sql);
////            System.out.println("-->> [4단계] ResultSet 생성 완료 - stmt.executeQuery() 완료 \n");
////        } catch (Exception e) {e.printStackTrace();}
//	
////        return rs;
////    }
//
//    // [4단계]  + [5단계] --> CRUD 기능에 따라 메소드 생성으로 대체
//    public List<C2003_EmployeeVo> getList() {
//    	List<C2003_EmployeeVo> list = new ArrayList<C2003_EmployeeVo>();
//		String sql = """
		//				select 
		//					emp_id,
		//				    emp_name,
		//				    hire_date,
		//				    salary
		//				from employee
		//			""";
//        try {
//            rs = stmt.executeQuery(sql);
//            while(rs.next()) {
//            	// rs 객체의 1 row --> EmployeeVo 저장
//            	C2003_EmployeeVo employee = new C2003_EmployeeVo();
//            	employee.setEmpId(rs.getString(1));
//            	employee.setEmpName(rs.getString(2));
//            	employee.setHireDate(rs.getString(3));
//            	employee.setSalary(rs.getInt(4));
//            	
//            	list.add(employee);
//            }
//        } catch (Exception e) {e.printStackTrace();}
//        
//        return list;
//    }
//	
//	// [6단계] connection, stmt, rs 객체 종료
//	public void close() {
//		try {
//			if(rs != null) rs.close();
//			if(stmt != null) stmt.close();
//			if(connection != null) connection.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//}



public class C2002_Employee02_Dao extends DBConn {
	
	// Constructor

    // [4단계]  + [5단계] --> CRUD 기능에 따라 메소드 생성으로 대체
    public List<C2002_Employee01_Vo> getList() {
    	List<C2002_Employee01_Vo> list = new ArrayList<C2002_Employee01_Vo>();
		String sql = """
						select 
							emp_id,
						    emp_name,
						    hire_date,
						    salary
						from employee
					""";
        try {
            getStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
            	// rs 객체의 1 row --> EmployeeVo 저장
            	C2002_Employee01_Vo employee = new C2002_Employee01_Vo();
            	employee.setEmpId(rs.getString(1));
            	employee.setEmpName(rs.getString(2));
            	employee.setHireDate(rs.getString(3));
            	employee.setSalary(rs.getInt(4));
            	
            	list.add(employee);
            }
        } catch (Exception e) {e.printStackTrace();}
        
        close();
        
        return list;
    }
	
//	// [6단계] connection, stmt, rs 객체 종료
//	public void close() {
//		try {
//			if(rs != null) rs.close();
//			if(stmt != null) stmt.close();
//			if(connection != null) connection.close(); // 커넥션은 접근제한자가 있어 에러 발생, 클로즈는 DBConn에 있어 이제는 필요없음
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

}

