package chapter13_collectionframework.C1304.com.scoremgm.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import chapter13_collectionframework.C1304.com.scoremgm.model.Member;

public class ScoreRepositoryImpl implements ScoreRepository { // 추상 메소드 오버라이드
	
	List<Member> storage = new ArrayList<Member>();
	
	@Override
	public boolean insert(Member member) {
		if(member == null) return false;
		return storage.add(member);
//		System.out.println("storage.size() --> " + storage.size());
	};
	
	@Override
	public int getCount() {
		return storage.size();
	}
	
	@Override
	public List<Member> findAll() {
		return storage;
	}
	
	@Override
	public Member find(String no) {
		no = "2025-" + no;
		Member member = null;
		
		if(no != null) {
			for(Member m : storage) {
//				if(m.getNo().equals("2025-" + no)) { // 조정하는 과정은 상위에서 진행하길 권장
				if(m.getNo().equals(no)) {
					member = m;
				}
			}
		}
			
//		if(no != null) {
		// 강사님과 학생들 오류나는 코드 > 외부에서 생성된 member 변수의 scope Iterable 관리
		// forEach는 메소드 호출이므로 스택에 새로운 블록으로 생성되어 실행됨
		// 실행 중이던 find는 중지하고 나서 forEach로 주도권이 넘어오므로 find의 member는 삭제됨
		// 자바스크립트에서도 동일하게 실행안되는 예제
		
		// 람다식 메소드여서 스택에서 새롭게 넘어가서 실행되기 때문에 상위의 맴버가 초기화되서 사라져 맴버를 불러오지 못함
		// 새로운 블럭으로 불러와짐

//			storage.forEach(m -> {
//				if(m.getNo().equals(no)) {
//					member = m;
//				}
//			});
//		}
		
//		if(no != null) { // 강사님과 학생들은 에러가 뜨는데 나는 아래 코드가 에러가 안뜸, 비교 분석하기
//			storage.forEach(m -> {
//				if(m.getNo().equals(no)) {
//					member = m;
//				}
//			}
//		);
		
		return member;
	}
	
	@Override
	public void update(Member member) {
		int idx = -1;
		
		for(int i = 0; i < storage.size(); i++) {
			Member m = storage.get(i);
			if(m.getNo().equals(member.getNo())) {
				idx = i;
				break; // search 인덱스 구성 짜는거랑 비슷함
			}
		}
		storage.set(idx, member);
	}
	
	@Override
	public void remove(String no) {
		// 별도의 개체가 아닌 스토리지에 붙어있는 주머니 개념으로 인덱스를 내부적으로 처리해 오류를 방지할 수 있음 / 컨트롤+쉬프트 O로 연동 필요
		no = "2025-" + no;
		Iterator<Member> ie = storage.iterator();
		while(ie.hasNext()) {
			Member member = ie.next();
			if(member.getNo().equals(no)) {
				ie.remove();
				break; // 재정비 작업은 알아서 작업 진행, remove로 직접 삭제보다는 이터레이터로 삭제 진행
			}
		}
	}

}
