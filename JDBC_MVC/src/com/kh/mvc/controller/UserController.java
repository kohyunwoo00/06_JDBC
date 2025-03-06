package com.kh.mvc.controller;

import java.util.List;

import com.kh.mvc.model.dao.UserDAO;
import com.kh.mvc.model.dto.UserDTO;
import com.kh.mvc.model.service.UserService;


/*
 * VIEW에서 온 요청을 처리해주는 클래스
 * 메소드로 전달된 데이터값을 가공처리한 후 DAO로 전달
 * DAO로부터 반환받음 결과를 사용자가 보게될 View(응답화면)에 반환
 */
public class UserController {
	private UserDAO userDao = new UserDAO();
	private UserService userService = new UserService();
	
	public List<UserDTO> findAll() {
		return userService.findAll();
	}
	
	public int insertUser(String userId, String userPw, String userName) {
		UserDTO user = new UserDTO();
		user.setUserId(userId);
		user.setUserPw(userPw);
		user.setUserName(userName);
		int result =  userDao.insertUser(user);
		user = null;
		return result;
	}
	
	public int updatePw(String userId, String userPw, String newUserPw) {
		UserDTO user = new UserDTO();
		user.setUserId(userId);
		user.setUserPw(userPw);
		user.setNewUserPw(newUserPw);
		
		int result = userDao.updatePw(user);
		
		return result;
	}
	
	
	public int deleteUser(String userId, String userPw) {
		UserDTO user = new UserDTO();
		user.setUserId(userId);
		user.setUserPw(userPw);
		
		int result = userDao.deleteUser(user);
		
		return result;
	}
	
	public int findUser(String userNo) {
		UserDTO user = new userDTO();
		user.setUserNo(userNo);
		
		int result = userDao.findUser(user);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
