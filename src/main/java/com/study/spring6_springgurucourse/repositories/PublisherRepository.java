package com.study.spring6_springgurucourse.repositories;

import com.study.spring6_springgurucourse.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
