package part02_follow.chapter13_collectionframework.C1304.com.scoremgm.repository;

import java.util.List;

import part02_follow.chapter13_collectionframework.C1304.com.scoremgm.model.Member;

public interface ScoreRepository {
	
	boolean insert(Member member);
	int getCount();
	List<Member> findAll();
	Member find(String no);
	void update(Member member);
	void remove(String no);

}
