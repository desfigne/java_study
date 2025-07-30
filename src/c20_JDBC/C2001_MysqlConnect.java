package c20_JDBC;

//깃헙에서 클론하고 나면 모듈-인포에 등록안했다고 에러가 뜨는데, 그냥 모듈 인포 파일을 삭제해주면 됨
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class C2001_MysqlConnect {

	public static void main(String[] args) {

//		// 0단계 - 드라이버 다운로드 및 패스 추가
//		// 1단계 - 드라이버 로딩 - DriverManager
//		
//		// URL 형식 - "jdbc:mysql://서버주소:포트번호/DB명?옵션들추가.."
//		// ㄴ 자바 jdbc api에서 찾아야 함
//		// ㄴ 드라이버 파일이나 타입에 따라 형식이 각자 다름
//		
//		String url = "jdbc:mysql://127.0.0.1:3306/hrdb2019";
//		String user = "root";
//		String password = "mysql1234";
//		Connection connection = DriverManager.
//				getConnection(url, user, password)
				
		try {
			// [1단계] 드라이버 로딩 + [2단계] Connection 객체 생성
			String url = "jdbc:mysql://127.0.0.1:3306/hrdb2019";
			String user = "root";
			String password = "mysql1234";
			Connection connection = DriverManager.
					getConnection(url, user, password);
			
			System.out.println("-->> [1단계] 드라이버 로딩 완료");
			System.out.println("-->> [2단계] Connection 객체 생성 완료 \n");
			
			// [3단계] Statement 객체 생성
			Statement stmt = connection.createStatement();
			
			System.out.println("-->> [3단계] Statement 객체 생성 완료 \n");
			
			// [4단계] ResultSet 생성 - stmt 객체를 이용한 ResultSet 객체 생성
//			String sql ="select emp_id, emp_name, dept_id, salary from employee";
//			String sql ="select emp_id, emp_name, dept_id, salary from employee"
//					+ " where dept_id = 'SYS'";
//					// 앞에 띄어쓰기가 없으면 워크벤치 상에서 from과 where가 붙어있게 되어 에러 발생
//					// from employeewhere dept_id = 'SYS'
			
//			// 요즘 사용하는 방법들 2가지는 아래 방법들
//			StringBuilder sb = new StringBuilder(100);
//			sb.append("select emp_id, emp_name, dept_id, salary from employee");
//			sb.append(" where dept_id = 'SYS'");
//
//			// sql 쿼리는 jvm이 아닌 워크벤치에서 실행해 확인하는 것을 더 권장
//			ResultSet rs = stmt.executeQuery(sb.toString());
			
			// JDK 15 버전 이상에서만 사용 가능 --> 자바스크립트 ``(백틱연산자~) : 템플릿 리터럴
//			String sql = """
//							select emp_id, emp_name, dept_id, salary from employee
//							where dept_id = 'SYS'
//						""";
			String sql = """
							select 
								row_number() over() as rno,
							    emp_id,
							    emp_name,
							    dept_id,
							    salary,
							    hire_date
							from employee where dept_id ='SYS';
						""";

			// sql 쿼리는 jvm이 아닌 워크벤치에서 실행해 확인하는 것을 더 권장
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs != null) {
				System.out.println("-->> [4단계] ResultSet 생성 완료 - stmt 객체를 이용한 ResultSet 객체 생성 완료 \n");
				
				// [5단계] rs 객체에서 데이터 추출
				while(rs.next()) { // 끝까지 읽고 불린 타입으로 종료 처리
					// 인덱스가 많을 수도 있고 적을 수도 있기에 while문으로 실행
					// 메모리가 아닌 객체 안에 들어가있기에 0번지가 아닌 1번지부터 시작
					
//					rs.getInt(1); // 인덱스로 할 경우, 언더바가 들어가는 경우가 많다보니 인덱스를 주로 사용함
//					rs.getInt("rno");
					
					System.out.print(rs.getInt(1) + "\t");
					System.out.print(rs.getString(2) + "\t");
					System.out.print(rs.getString(3) + "\t");
					System.out.print(rs.getString(4) + "\t");
					System.out.print(rs.getInt(5) + "\t");
//					System.out.print(rs.getString(6) + "\n");
//					System.out.print(rs.getDate(6) + "\n");
					System.out.print(rs.getDate(6).toLocalDate() + "\n");
					
					// rs는 데이터 연동을 위해 사용하는 정해진 명령어로 다른 클래스에서 참조해 사용하려면 사용 불가,
					// 컬렉션에 rs 값을 담아서 다른 클래스에서 사용해야 함 (어레이 리스트에 담음)
					// List<row가 담기는 객체 : EmployeeVo>
				}
				System.out.println("\n-->> [5단계] rs 객체에서 데이터 추출 \n");
			}
			
			// [6단계] connection, stmt, rs 객체 종료
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(connection != null) connection.close();
			
			System.out.println("-->> [6단계] rs 객체 종료 완료");
			System.out.println("-->> [6단계] stmt 객체 종료 완료");
			System.out.println("-->> [6단계] connection 객체 종료 완료 \n");
			
			// 각 단계가 체어링되어 진행되기 때문에 선 작업단계가 진행이 안되면 이후 단계 진행 안됨
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
