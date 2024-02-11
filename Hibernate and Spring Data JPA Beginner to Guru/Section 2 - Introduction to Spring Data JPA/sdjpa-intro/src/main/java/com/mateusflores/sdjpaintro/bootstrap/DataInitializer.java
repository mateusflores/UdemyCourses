package com.mateusflores.sdjpaintro.bootstrap;

import com.mateusflores.sdjpaintro.domain.Book;
import com.mateusflores.sdjpaintro.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Book bookDDD = new Book("Domain Driven Design", "123", "RandomHouse");

        Book savedDDD = bookRepository.save(bookDDD);
        System.out.println("Id: " + savedDDD.getId());

        Book bookSIA = new Book("Spring in Action", "1234435", "Oriely");
        Book savedSIA = bookRepository.save(bookSIA);
        System.out.println("Id: " + savedSIA.getId());

        bookRepository.findAll().forEach(book -> {
            System.out.println("Book Id: " + book.getId());
            System.out.println("Book Title: " + book.getTitle());
        });
    }
}
