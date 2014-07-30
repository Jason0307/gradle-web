/**
 * 
 */
package org.zhubao.service.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.zhubao.dao.UserDao;
import org.zhubao.model.User;
import org.zhubao.service.UserService;
import org.zhubao.util.MD5Util;
import org.zhubao.vo.FilterVo;

/**
 * @author Jason.Zhu
 * @date 2014-7-24
 * @email jasonzhu@augmentum.com.cn
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	/* (non-Javadoc)
	 * @see org.zhubao.service.UserService#findBySearch(org.zhubao.model.User)
	 */
	@Override
	public Page<User> findBySearch(final User user,Pageable pageable) {
		Specification<User> spec = new Specification<User>() {  
		    public Predicate toPredicate(Root<User> root,  
		            CriteriaQuery<?> query, CriteriaBuilder cb) {  
		        Predicate p1 = cb.like(root.get("username").as(String.class), "%"+user.getUsername()+"%");  
		        Predicate p2 = cb.like(root.get("emailAddress").as(String.class), "%"+user.getEmailAddress()+"%");  
		        query.where(cb.and(p1,p2));  
		        query.orderBy(cb.desc(root.get("userId").as(Long.class)));  
		        return query.getRestriction();  
		    }  
		};
		return userDao.findAll(spec,pageable);
	}

	public User login(String username, String password) {
		User user = userDao.findByUsername(username);
		if (null != user) {
			if (MD5Util.validatePassword(user.getPassword(),password)) {
				return user;
			}
		}
		System.out.println("No such user{" + username + "}");
		return null;
	}

	public void saveUser(User user) {
		userDao.save(user);
	}

	public User findByUserId(String userId) {
		User user = userDao.findOne(userId);
		return user;
	}

	public void deleteUser(User user) {
		userDao.delete(user);
	}

	public void deleteUser(String userId) {
		userDao.delete(userId);
	}

	public User findByUsername(String username) {
		User user = userDao.findByUsername(username);
		return user;
	}

	public User findByEmail(String email) {
		User user = userDao.findByEmail(email);
		return user;
	}

	@Override
	public List<User> findByCondition(FilterVo filterVo) {
		return userDao.findByCondition(filterVo);
	}

}
