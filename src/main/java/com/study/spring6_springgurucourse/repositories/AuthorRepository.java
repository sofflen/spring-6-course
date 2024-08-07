package com.study.spring6_springgurucourse.repositories;

import com.study.spring6_springgurucourse.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
