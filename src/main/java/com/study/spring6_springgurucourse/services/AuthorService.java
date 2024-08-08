package com.study.spring6_springgurucourse.services;

import com.study.spring6_springgurucourse.domain.Author;

public interface AuthorService {

    Iterable<Author> findAll();
}
