package c20_JDBC.C2005_member01;

import java.util.List;

public interface C200504_MemberInterface {

	public int insert(C200501_MemberVo C200501_MemberVo);
	public C200501_MemberVo search(int memberId);
	public List<C200501_MemberVo> search(String name);
	public List<C200501_MemberVo> listAll();
	public int update(C200501_MemberVo C200501_MemberVo);
	public int delete(int memberId);
	
}