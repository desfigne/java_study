package chapter13.com.scoremgm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import chapter13.com.scoremgm.app.ScoreMgmSystem;
import chapter13.com.scoremgm.model.Member;
import chapter13.com.scoremgm.repository.ScoreRepository;
import chapter13.com.scoremgm.repository.ScoreRepositoryImpl;

public class ScoreServiceImpl implements ScoreService {
	
	Scanner scan;
	ScoreMgmSystem sms;
	ScoreRepository repository = new ScoreRepositoryImpl();
	
	public ScoreServiceImpl() {}
	public ScoreServiceImpl(ScoreMgmSystem sms) {
	    this.sms = sms;
	    this.scan = sms.scan;
	}
	
	/**
	 * 학생 정보 임시 저장
	 * @return List
	 */
	public List createMemberInfo() {
		
		String[] labels = {"학생명", "전공", "국어", "영어", "수학"};
		
		List memberInfo = new ArrayList(); // 제너릭 <> 처리 안한 이유는 스트링과 인트 모두 받기 위해, 이클립스의 노란 표시는 제너릭 표기를 안해서 알려주는 것
		
		Random rd = new Random();
		String no = "2025-" + rd.nextInt(1000, 9999);
		
		memberInfo.add(no);
		
		for(int i=0; i < labels.length; i++) {
			if(i>=2) { // 2글자 아래는 숫자
				System.out.print(labels[i] + "> ");
				memberInfo.add(scan.nextInt());
			} else { // 2글자 이상은 글자
				// i = 0, 1
//				String str = scan.next();
//				memberInfo.add(str);
				System.out.print(labels[i] + "> ");
				memberInfo.add(scan.next());
			}
		}
		
		return memberInfo;
	}
	
	/**
	 * 학생정보 저장소(storage)의 갯수 가져오기
	 */
	public int getCount() {
		return repository.getCount();
	}
	
	/**
	 * 등록
	 */
	@Override
	public void register() {
		
		List memberInfo = createMemberInfo();
		
//		// 학번 생성 : 2025- 고정, 뒷 4자리 랜덤으로 생성 // < createMemberInfo으로 전환해 과목 수에 따라 자동으로 늘어나게 처리
//		String no = createNo();
//		System.out.println("학번 > " + no);
		
//		System.out.println("학생명 > ");
//		String name = scan.next();
//		
//		System.out.println("전공 > ");
//		String department = scan.next();
//		
//		System.out.println("점수 (국어) > ");
//		int kor = scan.nextInt();
//		
//		System.out.println("점수 (영어) > ");
//		int eng = scan.nextInt();
//		
//		System.out.println("점수 (수학) > ");
//		int math = scan.nextInt();               // >
		
		// Member 생성
		Member member = new Member();
		member.setNo((String)memberInfo.get(0));
		member.setName((String)memberInfo.get(1));
		member.setDepartment((String)memberInfo.get(2));
		member.setKor((int)memberInfo.get(3)); // 인티저로 자동으로 랩을 씌워줌
		member.setEng((int)memberInfo.get(4));
		member.setMath((int)memberInfo.get(5));
		
		
//		System.out.println(member.getNo());         // < 디버깅용 체크
//		System.out.println(member.getName());
//		System.out.println(member.getDepartment());
//		System.out.println(member.getKor());
//		System.out.println(member.getEng());
//		System.out.println(member.getMath());       // >
		
		// 저장소 등록을 위한 Repository 호출
		if(repository.insert(member)) {
			// 성공
			System.out.println("=> 등록 완료");
		} else {
			// 실패
			System.out.println("=> 등록 실패");
		}
		
		// 메뉴 호출
		sms.showMenu();
		sms.selectMenu();
	};
	
	/**
	 * 조회
	 */
	@Override
	public void list() {
		if(getCount() != 0) {
			List<Member> list = repository.findAll();

			System.out.println("========================================================");
			System.out.println("학번\t\t이름\t전공\t국어\t영어\t수학");
			System.out.println("--------------------------------------------------------");
			list.forEach((member) -> {
				System.out.print(member.getNo() + "\t");
				System.out.print(member.getName() + "\t");
				System.out.print(member.getDepartment() + "\t");
				System.out.print(member.getKor() + "\t");
				System.out.print(member.getEng() + "\t");
				System.out.print(member.getMath() + "\n");
			});
			System.out.println("--------------------------------------------------------");
			
	//		for(Member member : list) {
	//			System.out.print(member.getNo() + "\t");
	//			System.out.print(member.getName() + "\t");
	//			System.out.print(member.getDepartment() + "\t");
	//			System.out.print(member.getKor() + "\t");
	//			System.out.print(member.getEng() + "\t");
	//			System.out.print(member.getMath() + "\n");
	//		}
		} else {
			System.out.println("=> 등록된 학생이 없습니다.");
		}
		sms.showMenu();
		sms.selectMenu();
	};
	
	public void search() {};
	
	public void update() {};
	
	public void delete() {};
	
	@Override
	public void exit() {
		System.out.println("=> 프로그램 종료");
		System.exit(0);
	};

}
