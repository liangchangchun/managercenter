package lcc.manager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import lcc.manager.repositories.SomeBookRepository;
import lcc.manager.repositories.book.Book;

@Service
public class CreateElasticServiceImpl {
   
	//@Autowired
	//MyESManager myESManager;
	
    @Autowired
    private SomeBookRepository bookRepository;
	@Autowired
	ElasticsearchTemplate elasticsearchTemplate;

    public void createIndex(){
    
    List<IndexQuery> indexQueries = new ArrayList<IndexQuery>();
    //first document
    String documentId = "123456";
    Book sampleEntity1 = new Book();
    sampleEntity1.setId(documentId);
    sampleEntity1.setName("some message1");
    sampleEntity1.setPrice((long) 0);

    IndexQuery indexQuery1 = new IndexQueryBuilder().withId(sampleEntity1.getId()).withObject(sampleEntity1).build();
    indexQueries.add(indexQuery1);

    //second document
    String documentId2 = "123457";
    Book sampleEntity2 = new Book();
    sampleEntity2.setId(documentId2);
    sampleEntity2.setName("some message2");
    sampleEntity2.setPrice((long) 10);

    IndexQuery indexQuery2 = new IndexQueryBuilder().withId(sampleEntity2.getId()).withObject(sampleEntity2).build();
    indexQueries.add(indexQuery2);

    elasticsearchTemplate.bulkIndex(indexQueries);
    }
    
    public void saveIndex(String documentId2,String name){
    	    Book sampleEntity2 = new Book();
    	    sampleEntity2.setId(documentId2);
    	    sampleEntity2.setName(name);
    	    sampleEntity2.setPrice((long) 10);
    	    bookRepository.save(sampleEntity2);
    	//elasticsearchTemplate.query(query, resultsExtractor);
    }
    
    public void queryIndex(String documentId){
    	 SearchQuery searchQuery = new NativeSearchQueryBuilder()
         .withQuery(QueryBuilders.termQuery("id", documentId))
         .build();
         Page<Book> sampleEntities = elasticsearchTemplate.queryForPage(searchQuery,Book.class);
         for (Book book : sampleEntities) {
			System.out.println("bookid"+book.getName());
		}
    }
}
