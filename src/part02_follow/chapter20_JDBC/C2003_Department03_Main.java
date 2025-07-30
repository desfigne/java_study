package part02_follow.chapter20_JDBC;

import java.util.List;

//public class C2007_DepartmentMain {
//
//	public static void main(String[] args) {
//		
//		// DAO 생성 (2단계, 다리까지는 생성됨)
//		C2006_DepartmentDao dao = new C2006_DepartmentDao();
//		dao.getStatement();
//		
//		List<C2005_DepartmentVo> list = dao.getList();
//		list.forEach((department) -> {
//			System.out.print(department.getDeptId() + "\t");
//			System.out.print(department.getDeptName() + "\t");
//			System.out.print(department.getUnitId() + "\t");
//			System.out.print(department.getStartDate() + "\n");
//		});
//		
//		dao.close();
//	}
//
//}

public class C2003_Department03_Main {

	public static void main(String[] args) {
		C2003_Department02_Dao dao = new C2003_Department02_Dao();
		C2003_Department01_Vo insertVo = new C2003_Department01_Vo();
		insertVo.setDeptId("OPQ");     // < 중복되는 내용이 없도록 입력하고 출력해야 정상적으로 등록됨
		insertVo.setDeptName("테스트4");
		insertVo.setUnitId("A");       // >
		
		if(dao.insert(insertVo)) {
			List<C2003_Department01_Vo> list = dao.getList();
			list.forEach((department) -> {
				System.out.print(department.getDeptId() + "\t");
				System.out.print(department.getDeptName() + "\t");
				System.out.print(department.getUnitId() + "\t");
				System.out.print(department.getStartDate() + "\n");
			});
		}
		
		dao.close();
	}

}