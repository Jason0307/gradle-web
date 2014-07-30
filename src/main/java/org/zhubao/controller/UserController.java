/**
 * 
 */
package org.zhubao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zhubao.dao.UserDao;
import org.zhubao.model.User;

/**
 * @author Jason.Zhu
 * @date   2014-7-29
 * @email jasonzhu@augmentum.com.cn
 */
@Controller
public class UserController {

	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public @ResponseBody Page<User> getUserList(Pageable pageable){
		Page<User> users = userDao.findAll(pageable);
		PageRequest pageRequest = (PageRequest)pageable;
		System.out.println(pageRequest);
		System.out.println(users);
		return users;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/users/v2", method = RequestMethod.GET)
	public HttpEntity<PagedResources<User>> getUsers(Pageable pageable,PagedResourcesAssembler assembler){
		Page<User> users = userDao.findAll(pageable);
		PageRequest pageRequest = (PageRequest)pageable;
		System.out.println(pageRequest);
		System.out.println(users);
		return new ResponseEntity(assembler.toResource(users), HttpStatus.OK);
	}
}
