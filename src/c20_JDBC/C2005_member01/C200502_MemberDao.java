package c20_JDBC.C2005_member01;

import java.util.ArrayList;
import java.util.List;

import c20_JDBC.C2004_db.DBConn;

public class C200502_MemberDao extends DBConn implements C200504_MemberInterface {
	
	public C200502_MemberDao() { super(); }
	
	// CRUD 기능 구현 - 애플리케이션 기반의 DB연동은 기본적으로 Autocommit = true 상태로 바로 적용됨
	// ** getResultSet은 해당 정의로 사용해도 동작은 가능하나 예약 명령어와 혼동을 줄 수 있으므로 CRUD를 연상할 수 있는 insert나 update, delete을 사용해 명확하게 함.
	
	// 리스트, 추가, 수정, 삭제에 대한 명칭 정의가 어디는 뭐, 어디는 뭐 이런 식으로 작성자에 따라 제각각 달라질 수 있으니 인터페이스로 기준을 잡아줌, 다형성
	
	/**
	 * 전체 리스트
	 */
	@Override
	public List<C200501_MemberVo> listAll() {
		
		List<C200501_MemberVo> list = new ArrayList<C200501_MemberVo>();
		String sql = " select member_id, name, email, left(created_at, 10) from member";
		
		try {
			getPreparedStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				C200501_MemberVo member = new C200501_MemberVo();
				member.setMemberId(rs.getInt(1));
				member.setName(rs.getString(2));
				member.setEmail(rs.getString(3));
				member.setCreatedAt(rs.getString(4));
				
				list.add(member);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	/**
	 * 데이터 추가
	 * @param C200601_MemberVo
	 */
	@Override
	public int insert(C200501_MemberVo memberVo) { // 픽스된 값이 아닌 객체로 담는다.
		
		int rows = 0;
		String sql = """
						insert into member(name, email, created_at)
						            values(?, ?, now())
					""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, memberVo.getName());
			pstmt.setString(2, memberVo.getEmail());
			
			rows= pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rows;
		
	}
	
	/**
	 * 데이터 검색
	 */
	@Override
	public C200501_MemberVo search(int memberId) {
		
		C200501_MemberVo member = new C200501_MemberVo();
		String sql = "select member_id, name, email, created_at"
				+ " from member where member_id = ?";
		
		try {
			getPreparedStatement(sql);
			pstmt.setInt(1, memberId);
			rs= pstmt.executeQuery();
			while(rs.next() ) {
				member.setMemberId(rs.getInt(1));
				member.setName(rs.getString(2));
				member.setEmail(rs.getString(3));
				member.setCreatedAt(rs.getString(4));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return member;
	}
	
	/**
	 * 데이터 검색
	 */
	// 리턴 타입 선언 후 아래 객체 생성 후 리턴을 잡아주고 그 사이에 데이터값을 불러와 객체 생성된 리스트에 넣어주는 패턴
	@Override
	public List<C200501_MemberVo> search(String name) {

		List<C200501_MemberVo> list = new ArrayList<C200501_MemberVo>();
		String sql = """
						select
							member_id,
							name,
						    email,
						    created_at
						from member
						where name = ?
					""";
		
		try {
			getPreparedStatement(sql); // 프리페어 택시가 데이터 값을 담음, 아직 출발은 안함
			pstmt.setString(1, name); // 물음표 순번에 따라 지정해줘야 함
			rs = pstmt.executeQuery(); // sql이 들어가면 에러는 안나나 부모의 sql을 가져오기에 정상 동작 안함
			while(rs.next()) {
				C200501_MemberVo memberVo = new C200501_MemberVo();
				memberVo.setMemberId(rs.getInt(1));
				memberVo.setName(rs.getString(2));
				memberVo.setEmail(rs.getString(3));
				memberVo.setCreatedAt(rs.getString(4));

				list.add(memberVo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	/**
	 * 데이터 수정
	 */
	@Override
	public int update(C200501_MemberVo member) {
		
		int rows = 0;
		String sql = """
						update member
							set name = ?, email = ?
							where member_id = ?
					""";
		
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getEmail());
			pstmt.setInt(3, member.getMemberId());
			rows = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rows;
		
	}
	
	/**
	 * 데이터 삭제
	 */
	@Override
	public int delete(int memberId) {
		
		int rows = 0;
		String sql = "delete from member where member_id = ?";
		
		try {
			getPreparedStatement(sql);
			pstmt.setInt(1, memberId);
			rows = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rows;
		
	}

}
