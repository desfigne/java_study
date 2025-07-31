package c20_JDBC.C2005_member01;

import java.util.List;

public class C200503_MemberMain {

	public static void main(String[] args) {
		
		C200502_MemberDao memberDao = new C200502_MemberDao();
		
//		// 검색 - 스트링 호출
//		List<C200501_MemberVo> list = memberDao.search("홍길동");
//		
////		if(list != null) {
//		if(list.size() != 0) {
//			list.forEach((member) -> {
//				System.out.print(member.getMemberId() + "\t");
//				System.out.print(member.getName() + "\t");
//				System.out.print(member.getEmail() + "\t");
//				System.out.print(member.getCreatedAt() + "\n");
//			});
//			System.out.println("--> 데이터 출력");
//		}
		
//		// 검색 - 아이디 호출
//		C200501_MemberVo member = memberDao.search(3);
//		if(member.getMemberId() != 0) {
//			System.out.print(member.getMemberId() + "\t");
//			System.out.print(member.getName() + "\t");
//			System.out.print(member.getEmail() + "\t");
//			System.out.print(member.getCreatedAt() + "\n");
//		}
		
	}

}
