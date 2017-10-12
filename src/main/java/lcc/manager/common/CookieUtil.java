package lcc.manager.common;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @ClassName: CookieUtil 
 * @Description:cookie工具类
 * @author duhai 
 * @date 2016年3月16日 下午2:51:11
 */
public class CookieUtil {
	
	/**
	 * 从cookie中通过可以获取值
	 * @param req
	 * @param key
	 * @return
	 */
	public synchronized static String get(HttpServletRequest req, String key) {
		String value = null;
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(key)) {
					value = cookie.getValue();
					break;
				}
			}
		}

		return value;
	}
	
	/**
	 * 将值放入到cookie中
	 * @param resp
	 * @param key
	 * @param value
	 * @param expire
	 */
	public synchronized static void set(HttpServletResponse resp, String key, String value,
			int expire) {
		Cookie cookie = new Cookie(key, value);
		cookie.setMaxAge(expire);
		// 设置到根,如果不设置根,会根据response的目录结构来设置cookie目录,这样一来就没有全局cookie取了
		cookie.setPath("/");
		// cookie.setDomain(Constant.DOMAIN);
		resp.addCookie(cookie);
	}

}
