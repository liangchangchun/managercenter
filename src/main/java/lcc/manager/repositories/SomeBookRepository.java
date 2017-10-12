package lcc.manager.repositories;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import lcc.manager.repositories.book.Book;



public interface SomeBookRepository extends ElasticsearchRepository<Book, String> {

  //  List<Book> findByName(String name);

  //  List<Book> findByPrice(double price);

}
