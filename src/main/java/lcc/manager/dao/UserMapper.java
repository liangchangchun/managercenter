package lcc.manager.dao;

import lcc.manager.model.user.UserModel;

import com.baomidou.mybatisplus.mapper.AutoMapper;

public interface UserMapper extends AutoMapper<UserModel> {
	void addUser(UserModel userModel);
}
