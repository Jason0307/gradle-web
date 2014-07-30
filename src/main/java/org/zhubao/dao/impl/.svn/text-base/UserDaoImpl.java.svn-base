/**
 * 
 */
package org.zhubao.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.zhubao.model.User;
import org.zhubao.vo.FilterVo;

/**
 * @author Jason.Zhu
 * @date 2014-7-24
 * @email jasonzhu@augmentum.com.cn
 */
public class UserDaoImpl {

	@Autowired
	private EntityManager entityManager; 
	
	public List<User> findByCondition(FilterVo filterVo) {
		List<User> users = new ArrayList<User>();
		Map<String, String> filters = filterVo.getFilters();
		Set<Entry<String, String>> entrySet = filters.entrySet();
		StringBuilder sb = new StringBuilder("SELECT u FROM User u WHERE ");
		for (Iterator<Entry<String, String>> iter = entrySet.iterator(); iter
				.hasNext();) {
			Entry<String, String> entry = iter.next();
			String filterName = entry.getKey();
			String filterValue = entry.getValue();
			sb.append("u." + filterName).append(" like '%")
					.append(filterValue ).append("%'");
			if (iter.hasNext()) {
				sb.append(" AND ");
			}
		}
		TypedQuery<User> typeQuery = entityManager.createQuery(sb.toString(), User.class);
		users = typeQuery.getResultList();
		return users;
	}

	
	
	
}
