package com.kh.mvc.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.kh.mvc.controller.UserController;
import com.kh.mvc.model.dto.UserDTO;

/* MemberView 클래스는 JDBC실습을 위해 생성하였으며,
 * 사용자에게 입력 및 출력을 수행하는 메소드를 제공합니다.
 * 
 * @author : 종로 C강의장
 * @version : 0.1
 * @date : 2025-03-04
 */

public class UserView {
	
	private Scanner sc = new Scanner(System.in);
	private UserController userController = new UserController();
	
	/*
	 * 프로그램 시작 시 사용자에게 보여줄 메인화면을 출력해주는 메소드
	 */
	public void mainMenu() {
		
		while(true) {
			System.out.println("--- USER테이블 관리 프로그램 ---");
			System.out.println("1. 회원 전체 조회");
			System.out.println("2. 회원 추가");
			System.out.println("3. 비밀번호 수정");
			System.out.println("4. 회원 탙퇴");
			System.out.println("5. 단일 회원 조회");
			System.out.println("6. 회원 아이디로 조회");
			System.out.println("9. 프로그램 종료");
			System.out.print("이용할 메뉴를 선택해주세요 > ");
			int menuNo = 0;
			
			try {
				menuNo  = sc.nextInt();
			} catch(InputMismatchException e) {
				sc.nextLine();
				continue;
			}
			sc.nextLine();
		
			switch(menuNo) {
			case 1 : findAll(); break;
			case 2 : insertUser(); break;
			case 3 : updatePw(); break;
			case 4 : deleteUser(); break;
			case 5 : findUser(); break;
			case 9 : System.out.println("프로그램 종료"); return;
			default : System.out.println("잘못된 메뉴 선택입니다");
			}
		}
	}
	// 회원 전체 정보를 조회해주는 기능
	private void findAll() {
		System.out.println("\n --- 회원 전체 목록 ---");
		// Controller야 저기 DB가서 회원 전체 목록 좀 가져와줘
		List<UserDTO> list = userController.findAll();
		
		System.out.println("\n조회된 총 인원 수는 " + list.size() + "명 입니다.");
		
		if(!list.isEmpty()) {
			System.out.println("===========================================");
			for(UserDTO user : list) {
				System.out.println(user.getUserName() + "님의 정보");
				System.out.println("아이디 : " + user.getUserId());
				System.out.println("가입일 : " + user.getEnrollDate());
				System.out.println();
			}
			
			System.out.println("===========================================");
			
		} else {
			System.out.println("회원이 존재하지 않습니다");
		}
	}
	
	/*
	 * TB_USER에 INSERT할 값을 사용자에게 입력받도록 유도하는 화면
	 */
	private void insertUser() {
		System.out.println("--- 회원 추가 ---");
		
		System.out.print("아이디를 입력하세요 > ");
		//while(true) {
			String userId = sc.nextLine();
			// UNIQUE했다고 치고 입력받은 아이디 가지고 DB가서 WHERE조건절에다가 사용자가 입력한 아이디 넣어서
			// 조회 결과 있으면 혼내기
			// if(조회결과중복없음) {
			// SELECT USER_ID FROM TB_USER WHERE USER_ID =사용자가 입력한 아이디값
			// break;
			// }
			// System.out.println("중복된 아이디가 존");			
		  // }
	
		System.out.print("비밀번호를 입력하세요 > ");
		String userPw = sc.nextLine();
		System.out.print("이름을 입력하세요 > ");
		String userName = sc.nextLine();
		
		int result = userController.insertUser(userId, userPw, userName);
		
		if(result > 0) {
			System.out.println(userName + "님 가입에 성공하셨습니다");
		} else {
			System.out.println("회원 추가에 실패했습니다. 다시 시도해주세요");
		}
	}
	
	public void updatePw() {
		System.out.println("--- 비밀번호 수정 ---");
		
		System.out.print("아이디 입력 > ");
		String userId = sc.nextLine();
		
		System.out.print("현재 비밀번호 입력 > ");
		String userPw = sc.nextLine();
		
		System.out.print("변경할 비밀번호 입력 > ");
		String newUserPw = sc.nextLine();
		
		int result = userController.updatePw(userId, userPw, newUserPw);
		
		if(result > 0) {
			System.out.println("비밀번호가 변경되었습니다");
		} else {
			System.out.println("비밀번호 변경이 실패하였습니다. 다시 시도해주세요");
		}
	}
	
	public void deleteUser() {
		System.out.println("--- 회원 탈퇴 ---");
		
		System.out.print("아이디 입력 > ");
		String userId = sc.nextLine();
		
		System.out.print("비밀번호 입력 > ");
		String userPw = sc.nextLine();
		
		int result = userController.deleteUser(userId, userPw);
		
		if(result > 0) {
			System.out.println("회원 탈퇴되었습니다");
		} else {
			System.out.println("회원탈퇴 실패하였습니다. 아이디, 비밀번호 확인하세요");
		}
	}
	
	public int findUser() {
		System.out.println("--- 단일 회원 조회 ---");
		
		System.out.print("회원 번호 입력 > ");
		int userNo = sc.nextInt();
		
		int result = userController.findUser(userNo);
		
		if(result > 0) {
			System.out.println(userNo + "회원이 조회되었습니다");
		} else {
			System.out.println(userNo + "회원이 없습니다. 다시 입력하세요");
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
