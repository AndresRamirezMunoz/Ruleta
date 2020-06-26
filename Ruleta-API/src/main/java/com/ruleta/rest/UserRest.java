package com.ruleta.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruleta.dao.UserDao;
import com.ruleta.entity.User;

@RestController
@RequestMapping("users")
public class UserRest {

	@Autowired
	private UserDao userDao;
	
	@GetMapping
	public ResponseEntity<List<User>> getRoulettes() {
		List<User> users = userDao.findAll();
		return ResponseEntity.ok(users);
	}
}
