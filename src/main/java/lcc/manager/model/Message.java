package lcc.manager.model;

import java.io.Serializable;

/**
 * 
 * 请求返回的信<br/>
 * 
 * @author dh <br/>
 * @version [1.0, 2015-9-23] <br/>
 */
public class Message  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7374785786064683283L;
	/**
	 * 消息
	 */
	private int code;//1:成功 9:失败   10:字段错误
	/**
	 * 消息文本
	 */
	private String text;
	/**
	 * 字段标志
	 */
	private String field;

	/**
	 * 版本
	 */
	private String version;

	/**
	 * 数据
	 */
	private Object data;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}


	public Message() {
		super();
	}

	public Message(int code, String text) {
		this.code = code;
		this.text = text;
	}

	public Message(int code, String text, String field) {
		this.code = code;
		this.text = text;
		this.field = field;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
