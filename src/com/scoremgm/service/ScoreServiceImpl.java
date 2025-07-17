package com.scoremgm.service;

import java.util.Random;
import java.util.Scanner;

public class ScoreServiceImpl implements ScoreService {
	
	Scanner scan;
	
	public ScoreServiceImpl() {}
	public ScoreServiceImpl(Scanner scan) {
	    this.scan = scan;
	}
	
	public void register() {
		System.out.println("학생명 > ");
		String name = scan.next();
		
		System.out.println("전공 > ");
		String department = scan.next();
		
		System.out.println("점수 (국어) > ");
		int kor = scan.nextInt();
		
		System.out.println("점수 (영어) > ");
		int eng = scan.nextInt();
		
		System.out.println("점수 (수학) > ");
		int math = scan.nextInt();
		
		// 학번 생성 : 2025- 고정, 뒷 4자리 랜덤으로 생성
		String no = createNo();
		System.out.println("학번 > " + no);
		
		// Member 생성
		
	};
	
	public String createNo() {
		String no = "2025-";
		Random rd = new Random();
		return no += rd.nextInt(1000, 9999);
	}
	
	public void list() {};
	
	public void search() {};
	
	public void update() {};
	
	public void delete() {};
	
	public void exit() {};

}
