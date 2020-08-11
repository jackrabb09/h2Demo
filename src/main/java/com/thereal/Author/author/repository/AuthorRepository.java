package com.thereal.Author.author.repository;

import com.thereal.Author.author.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

// repository used to persist objects into relational database
    //provide the entity you want to manage, (Author, Integer)
}
