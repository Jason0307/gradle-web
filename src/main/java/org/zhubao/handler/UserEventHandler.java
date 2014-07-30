/**
 * 
 */
package org.zhubao.handler;

import org.springframework.data.rest.repository.annotation.HandleBeforeDelete;
import org.springframework.data.rest.repository.annotation.HandleBeforeSave;
import org.springframework.data.rest.repository.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;
import org.zhubao.model.User;

/**
 * @author Jason.Zhu
 * @date   2014-7-30
 * @email jasonzhu@augmentum.com.cn
 */
@Component
@RepositoryEventHandler
public class UserEventHandler {

	@HandleBeforeSave(User.class)
	public void handleSaveUser(User user){
		System.out.println("User save ...");
	}
	
	@HandleBeforeDelete(User.class)
	public void handleDeleteUser(User user){
		System.out.println("User delete ...");
	}
}
