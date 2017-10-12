package lcc.manager.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
/**
 * 
 * @ClassName: BaseUtil 
 * @Description: 基础工具类，编写的control继承这个类，然后字节使用这个类中的方法
 * @author duhai 
 * @date 2016年3月15日 下午2:59:47
 */
public class BaseUtil {

	protected final Log log = LogFactory.getLog(getClass());

	/**
	 * 返回ajax
	 * @param T
	 * @param total
	 * @param response
	 */
	public <T> void writeList(List<T> T, Integer total,
			HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("rows", T);
		model.put("total", total);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		gson.toJson(model);
		Utils.IO.writeText(gson.toJson(model), response);
	}

	/**
	 * 
	 * 将json对象输出到前台页面 <br/>
	 * 
	 * @param response
	 * @param json
	 * <br/>
	 */
	protected void htmlWrite(HttpServletResponse response, Object json) {
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().print(Utils.Json.toJson(json, "yyyy-MM-dd HH:mm:ss"));
		} catch (IOException e) {
			log.info(e);
		} catch (Exception e) {// 保留原始异常
			log.info(e);
		} finally {
		}
	}
	protected void renderString(HttpServletResponse response, Object json) {
		response.setContentType("application/json;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().print(Utils.Json.toJson(json, "yyyy-MM-dd HH:mm:ss"));
		} catch (IOException e) {
			log.info(e);
		} catch (Exception e) {// 保留原始异常
			log.info(e);
		} finally {
		}
	}

}
