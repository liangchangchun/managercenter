package lcc.manager.service.impl;

import lcc.manager.dao.UserMapper;
import lcc.manager.model.user.UserModel;
import lcc.manager.service.UserService;
import lcc.manager.service.support.BaseServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, UserModel> implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	public void addUser(UserModel user) {
		userMapper.addUser(user);	
	}


}
