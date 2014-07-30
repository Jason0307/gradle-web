/**
 * 
 */
package org.zhubao.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.zhubao.model.User;
import org.zhubao.vo.FilterVo;

/**
 * @author Jason.Zhu
 * @date   2014-7-24
 * @email jasonzhu@augmentum.com.cn
 */
public interface UserService {

	void saveUser(User user);

	User findByUserId(String userId);
	
	User findByEmail(String email);
	
	void deleteUser(User user);
	
	void deleteUser(String userId);
	
	User findByUsername(String username);
	
	User login(String username,String password);
	
	Page<User> findBySearch(User user,Pageable pageable);
	
	List<User> findByCondition(FilterVo filterVo);
}
