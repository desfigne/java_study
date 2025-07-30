package c20_JDBC;

import java.sql.ResultSet;
import java.util.List;

public class C2002_Employee03_Main {

//	public static void main(String[] args) {
//		
//		// DAO 생성 (2단계, 다리까지는 생성됨)
//		C2002_EmployeeDao dao = new C2002_EmployeeDao();
//		dao.getStatement();
////		ResultSet rs = dao.getResultSet("select emp_id, emp_name from employee");
////		try {
////			while(rs.next()) {
////				System.out.print(rs.getString(1) + "\t");
////				System.out.print(rs.getString(2) + "\n");
////			}
////		} catch (Exception e) {e.printStackTrace();}
//		
//		List<C2003_EmployeeVo> list = dao.getList();
//		list.forEach((employee) -> {
//			System.out.print(employee.getEmpId() + "\t");
//			System.out.print(employee.getEmpName() + "\t");
//			System.out.print(employee.getHireDate() + "\t");
//			System.out.print(employee.getSalary() + "\n");
//		});
//		
//		dao.close();
//	}

	public static void main(String[] args) {
		C2002_Employee02_Dao dao = new C2002_Employee02_Dao();
		List<C2002_Employee01_Vo> list = dao.getList();

		list.forEach((employee) -> {
			System.out.print(employee.getEmpId() + "\t");
			System.out.print(employee.getEmpName() + "\t");
			System.out.print(employee.getHireDate() + "\t");
			System.out.print(employee.getSalary() + "\n");
		});
		
		dao.close();
	}

}
