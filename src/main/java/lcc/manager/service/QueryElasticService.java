package lcc.manager.service;

import java.util.List;

import org.elasticsearch.search.sort.SortOrder;


public interface QueryElasticService {
	 /** 查询 id */  
    public List<String> queryId(String type, String[] fields, String content,  
            String sortField, SortOrder order, int from, int size);
  
    
}
