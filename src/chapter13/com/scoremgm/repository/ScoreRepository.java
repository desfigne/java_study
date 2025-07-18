package chapter13.com.scoremgm.repository;

import java.util.List;

import chapter13.com.scoremgm.model.Member;

public interface ScoreRepository {
	
	boolean insert(Member member);
	int getCount();
	List<Member> findAll();

}
