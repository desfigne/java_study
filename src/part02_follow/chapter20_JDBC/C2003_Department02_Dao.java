package part02_follow.chapter20_JDBC;

import java.util.ArrayList;
import java.util.List;

import part02_follow.chapter20_JDBC.C2004_db.DBConn;

//public class C2006_DepartmentDao {
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
//	public C2006_DepartmentDao() {
//		
//		try {
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
//	public void getStatement() {
//		try {
//			stmt = connection.createStatement();
//			System.out.println("-->> [3단계] Statement 객체 생성 완료 \n");
//		} catch (Exception e) {e.printStackTrace();}
//	}
//
//    // [4단계]  + [5단계] --> CRUD 기능에 따라 메소드 생성으로 대체
//    public List<C2005_DepartmentVo> getList() {
//    	List<C2005_DepartmentVo> list = new ArrayList<C2005_DepartmentVo>();
//		String sql = """
		//				select 
		//					dept_id,
		//				    dept_name,
		//				    unit_id,
		//				    start_date
		//				from department
		//			""";
//        try {
//            rs = stmt.executeQuery(sql);
//            while(rs.next()) {
//            	C2005_DepartmentVo department = new C2005_DepartmentVo();
//            	department.setDeptId(rs.getString(1));
//            	department.setDeptName(rs.getString(2));
//            	department.setUnitId(rs.getString(3));
//            	department.setStartDate(rs.getString(4));
//            	
//            	list.add(department);
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

public class C2003_Department02_Dao extends DBConn {
	
	// Constructor

    // [4단계]  + [5단계] --> CRUD 기능에 따라 메소드 생성으로 대체
	public boolean insert(C2003_Department01_Vo department) {
		boolean result = false;
		try {
			// 1. Statement 방식
//			getStatement();
//			if(stmt != null) {
//				StringBuilder sb = new StringBuilder();
//				sb.append("insert into department(dept_id, dept_name, unit_id, start_date)");
//				sb.append(" values('");
//				sb.append(department.getDeptId() + "', '");
//				sb.append(department.getDeptName() + "', '");
//				sb.append(department.getUnitId() + "',");
//				sb.append(" curdate() )");
//				
//				int resultRow = stmt.executeUpdate(sb.toString());
//				if(resultRow == 1) result = true;
//				System.out.println("rows --> " + resultRow + "가 정상적으로 추가되었습니다.");
//			}

			// 2. PrepareStatement 방식
			String sql ="""
							insert into department(dept_id, dept_name, unit_id, start_date)
							values(?, ?, ?, curdate());
							
						""";
			getPreparedStatement(sql);
			pstmt.setString(1, department.getDeptId());
			pstmt.setString(2, department.getDeptName());
			pstmt.setString(3, department.getUnitId());
			
			int rows = pstmt.executeUpdate();
			if(rows == 1) result = true;
			
        } catch (Exception e) {e.printStackTrace();}
		
		return result;
	}
	
	/**
	 * 전체 리스트
	 */
    public List<C2003_Department01_Vo> getList() {
    	List<C2003_Department01_Vo> list = new ArrayList<C2003_Department01_Vo>();
		String sql = """
						select 
							dept_id,
						    dept_name,
						    unit_id,
						    start_date
						from department
					""";
        try {
            getStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
            	C2003_Department01_Vo department = new C2003_Department01_Vo();
            	department.setDeptId(rs.getString(1));
            	department.setDeptName(rs.getString(2));
            	department.setUnitId(rs.getString(3));
            	department.setStartDate(rs.getString(4));
            	
            	list.add(department);
            }
        } catch (Exception e) {e.printStackTrace();}
        
        close();
        
        return list;
    }

}
