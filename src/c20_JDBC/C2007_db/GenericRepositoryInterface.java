package c20_JDBC.C2007_db;

import java.util.List;

import c20_JDBC.C2007_com.scoremgm.model.MemberVo;

public interface GenericRepositoryInterface<T> {
	
	int insert(T entity);
	int getCount();
	List<T> findAll();
	T find(String no);
	int update(T entity);
	int remove(String no);
	
	// 여러 곳에서 공통적으로 사용하는 것만 넣어야 함

}
