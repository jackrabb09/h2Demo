package com.thereal.Author.dao;

import com.thereal.Author.author.entity.Author;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthorDaoService {
//git
    private static List<Author> authors = new ArrayList<>();

    private static int usersCount = 3;

    static{
        authors.add(new Author(1234,"Arthur Smith", "12058 Tango"));
        authors.add(new Author(3421,"Denzil Wash", "1234 Tango"));
        authors.add(new Author(5555,"Smitty Long", "2345 Tango"));
        authors.add(new Author(3333,"Reed Reed", "5432 Tango"));

    }
    public List<Author> findAll(){
        return authors;
    }

}
