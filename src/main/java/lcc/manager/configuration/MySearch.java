package lcc.manager.configuration;

import java.util.List;

import io.searchbox.core.Search;
import io.searchbox.core.Sort;
/**
 * 
 * @ClassName: MySearch 
 * @Description: 自写查询,继承Search
 * @author duhai 
 * @date 2016年5月12日 下午4:53:53
 */
public class MySearch extends Search{
	
	/**
	 * 不带参数的初始化查询
	 */
	public MySearch() {
		super();
	}
	
	/**
	 * 带查询条件和排序
	 * @param query
	 * @param sortList
	 */
	public MySearch(String query, List<Sort> sortList) {
		super(query, sortList);
	}
	
	/**
	 * 带查询条件
	 */
	public MySearch(String query) {
		super(query);
	}
	
	/**
	 * 加上分页
	 * @param query
	 * @param sortList
	 * @param from
	 * @param size
	 */
	public MySearch(String query, List<Sort> sortList,Integer from,Integer size) {
		 String sorting = "";
	        for (Sort s : sortList) {
	            if (s != sortList.get(0))
	                sorting += ",\n";
	            sorting += s.toString();
	        }
	        if (sorting.length() > 0)
	            sorting = "\"sort\": [" + sorting + "], \n";
	        String fromString = "\"from\": "+from+", \n";
	        String sizeString = "\"size\": "+size+", \n";
	        setData("{\n" + fromString + sizeString + sorting + query +  "\n}");
	}
	
	
	/**
	 * 
	 * @param queryBuilderValue
	 * @return
	 */
	public static String createQueryWithBuilder2(String queryBuilderValue) {
        return "\"query\":" + queryBuilderValue + "";
    }
	
	

}
