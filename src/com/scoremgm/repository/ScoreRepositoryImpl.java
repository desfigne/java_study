package com.scoremgm.repository;

import java.util.ArrayList;
import java.util.List;

import com.scoremgm.model.Member;

public class ScoreRepositoryImpl implements ScoreRepository { // 추상 메소드 오버라이드
	
	List<Member> storage = new ArrayList<Member>();
	
	@Override
	public List<Member> findAll() {
		return storage;
	}
	
	@Override
	public int getCount() {
		return storage.size();
	}
	
	@Override
	public boolean insert(Member member) {
		if(member == null) return false;
		return storage.add(member);
//		System.out.println("storage.size() --> " + storage.size());
	};

}
