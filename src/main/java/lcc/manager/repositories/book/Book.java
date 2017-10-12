package lcc.manager.repositories.book;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Created by yemengying on 16/1/10.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(indexName= "index-book", type= "book", shards = 1, replicas = 0, refreshInterval = "-1")
public class Book implements Serializable {
	private static final long serialVersionUID = 5087399043114656670L;
	
	@Id
    private String id;
    @Field(type = FieldType.text)
    private String name;
    @Field
    private Long price;
    @Version
    private Long version;

   
}
