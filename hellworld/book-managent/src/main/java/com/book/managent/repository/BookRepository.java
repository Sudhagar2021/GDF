package com.book.managent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.managent.domain.Author;
import com.book.managent.domain.Book;
@Repository
public interface BookRepository extends  JpaRepository<Book, Long>{

}
