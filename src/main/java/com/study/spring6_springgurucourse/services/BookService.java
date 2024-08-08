package com.study.spring6_springgurucourse.services;

import com.study.spring6_springgurucourse.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}
