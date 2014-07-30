/**
 * 
 */
package org.zhubao.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.zhubao.model.User;
import org.zhubao.vo.FilterVo;

/**
 * @author Jason.Zhu
 * @date   2014-7-24
 * @email jasonzhu@augmentum.com.cn
 */
public interface UserDao extends PagingAndSortingRepository<User,String>,JpaSpecificationExecutor<User>{

	/**
	 * Find by name
	 * @param username
	 * @return
	 */
	User findByUsername(String username);
	
	/**
	 * Find by email
	 * @param email
	 * @return
	 */
	@Query("SELECT u FROM User u WHERE u.emailAddress = ?1")
	User findByEmail(String email);

	/**
	 * Find by filter
	 * @param filterVo
	 * @return
	 */
	List<User> findByCondition(FilterVo filterVo);
	
	
}
