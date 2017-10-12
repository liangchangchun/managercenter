package lcc.manager.model;

import io.searchbox.annotations.JestId;

/**
 * 虚拟news 搜索文章
 * 
 * @author hk
 * 
 *         2013-1-12 下午11:38:29
 */
public class News {

	@JestId
	private int id;
	private String title;
	private String content;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
