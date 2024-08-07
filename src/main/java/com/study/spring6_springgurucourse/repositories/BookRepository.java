package com.study.spring6_springgurucourse.repositories;

import com.study.spring6_springgurucourse.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
