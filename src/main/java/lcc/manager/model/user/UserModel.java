package lcc.manager.model.user;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName(value = "lcc_user")
public class UserModel  implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 8799212518521515018L;

	@TableId(type = IdType.AUTO)
	@TableField(value = "user_id")
	private Integer userId;
	
	@TableField(value="user_code")
	private Integer userCode;
	
	@TableField(value="user_name")
    private String userName;



	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserCode() {
		return userCode;
	}

	public void setUserCode(Integer userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
    
}
