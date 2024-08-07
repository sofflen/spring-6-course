package com.study.spring6_springgurucourse.bootstrap;

import com.study.spring6_springgurucourse.domain.Author;
import com.study.spring6_springgurucourse.domain.Book;
import com.study.spring6_springgurucourse.repositories.AuthorRepository;
import com.study.spring6_springgurucourse.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author ericEvans = new Author("Eric", "Evans");
        Author davidGoggins = new Author("David", "Goggins");
        Book ddd = new Book("Domain Driven Design", "12312321");
        Book cantHurtMe = new Book("Can't Hurt Me", "12131415");

        Author ericSaved = authorRepository.save(ericEvans);
        Author davidSaved = authorRepository.save(davidGoggins);
        Book dddSaved = bookRepository.save(ddd);
        Book cantHurtMeSaved = bookRepository.save(cantHurtMe);

        ericSaved.getBooks().add(dddSaved);
        davidSaved.getBooks().add(cantHurtMeSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(davidSaved);

        System.out.printf("Bootstrap:\nAuthors were saved: %d\nBooks were saved: %d", authorRepository.count(), bookRepository.count());
    }
}
