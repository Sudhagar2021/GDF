package com.book.managent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.managent.domain.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{

}
