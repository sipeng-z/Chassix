package com.core.service;

import com.system.domain.entity.SystemUsers;
import com.system.service.SystemUsersService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class AuthorizeService {

	@Autowired
	private SystemUsersService systemUsersService;

//	@Autowired
//	private MenuService menuService;

//	@Autowired
//	private ActionsService actionService;



	public boolean hasAccessModuleAction(String userId, String module, String... actions) {
		boolean result = false;
		try{
			SystemUsers usersInfo = systemUsersService.get(userId);
			if (usersInfo != null) {
				result = isSuperAdministrator(usersInfo.getLevel());
				if (result == false) {
					if("ignore".equals(module)){
						return true;
					}
//					result = menuService.hasAccessModule(userId, module);
					if (result == false) {
						return false;
					}
					if (actions == null || actions.length == 0)
						return true;
//					Set<String> list = actionService.getAuthorizeActionSet(userId, module);
					for (String action : actions) {
//						if (list.contains(action)) {
//							return true;
//						}
					}
				}
			}
		}catch (Exception e){
			return result;
		}

		return result;
	}

	private boolean isSuperAdministrator(Integer administratorLevel) {
		return (administratorLevel != null && administratorLevel.equals(9));
	}

}
