package com.mateusflores.sdjpaintro.repositories;

import com.mateusflores.sdjpaintro.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
