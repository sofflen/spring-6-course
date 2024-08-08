package com.study.spring6_springgurucourse.services;

import com.study.spring6_springgurucourse.domain.Book;
import org.springframework.stereotype.Service;

@Service
public interface BookService {

    Iterable<Book> findAll();
}
