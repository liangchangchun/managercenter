package lcc.manager.service;

import com.baomidou.framework.service.ISuperService;

import lcc.manager.model.user.UserModel;

public interface UserService extends ISuperService<UserModel> {

	void addUser(UserModel user);
}
