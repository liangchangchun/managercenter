package lcc.manager.controller;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lcc.manager.common.BaseUtil;
import lcc.manager.model.Message;
import lcc.manager.model.user.UserModel;
import lcc.manager.service.UserService;
import lcc.manager.service.impl.CreateElasticServiceImpl;


@Controller
public class UserController extends BaseUtil {
	
	@Autowired
	private UserService userService;
	
	@Autowired
    private CreateElasticServiceImpl createElasticServiceImpl;
	
	@RequestMapping(value="/login") 
	public String login(HttpSession session, Model model) throws Exception {
		
		model.addAttribute("message", "123456");

		return "login";
	}
	
	@RequestMapping(value="/init") 
	public void init(Integer id,String userName, HttpServletResponse reponse) throws Exception {
		
		Message message = new Message(1, "操作成功!");
		try {
			if (id != null) {
				UserModel user=new UserModel();
				user.setUserCode(id);
				user.setUserName(userName);
				//userServiceImpl.addUser(user);
				userService.insert(user);
				String docid=id+"";
				createElasticServiceImpl.saveIndex(docid,userName);
				createElasticServiceImpl.queryIndex(docid);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// 回写
			message = new Message(9, "操作失败!");
		}
		this.htmlWrite(reponse, message);
	}
	
}
