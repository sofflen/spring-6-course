package com.study.spring6_springgurucourse.bootstrap;

import com.study.spring6_springgurucourse.domain.Author;
import com.study.spring6_springgurucourse.domain.Book;
import com.study.spring6_springgurucourse.domain.Publisher;
import com.study.spring6_springgurucourse.repositories.AuthorRepository;
import com.study.spring6_springgurucourse.repositories.BookRepository;
import com.study.spring6_springgurucourse.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author ericEvans = new Author("Eric", "Evans");
        Author davidGoggins = new Author("David", "Goggins");
        Book ddd = new Book("Domain Driven Design", "12312321");
        Book cantHurtMe = new Book("Can't Hurt Me", "12131415");
        Publisher mgpPublisher = new Publisher("Manhattan Book Group Publishers",
                "447 Broadway 2nd Floor, #354", "NYC", "New York", "NY 10013");

        /*
        save() method documentation:
        Use the returned instance for further operations as the save operation might have changed the entity instance completely.
         */
        ericEvans = authorRepository.save(ericEvans);
        davidGoggins = authorRepository.save(davidGoggins);
        mgpPublisher = publisherRepository.save(mgpPublisher);

        ddd.getAuthors().add(ericEvans);
        cantHurtMe.getAuthors().add(davidGoggins);
        ddd.setPublisher(mgpPublisher);
        cantHurtMe.setPublisher(mgpPublisher);

        ddd = bookRepository.save(ddd);
        cantHurtMe = bookRepository.save(cantHurtMe);

        ericEvans.getBooks().add(ddd);
        davidGoggins.getBooks().add(cantHurtMe);
        mgpPublisher.getBooks().add(ddd);
        mgpPublisher.getBooks().add(cantHurtMe);

        authorRepository.save(ericEvans);
        authorRepository.save(davidGoggins);
        publisherRepository.save(mgpPublisher);

        System.out.printf("Bootstrap:\nAuthors: %d\nBooks: %d\nPublishers: %d",
                authorRepository.count(), bookRepository.count(), publisherRepository.count());
    }
}
