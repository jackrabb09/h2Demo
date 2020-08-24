package com.thereal.Author.author.api;

import com.thereal.Author.author.entity.Author;
import com.thereal.Author.author.repository.AuthorRepository;
import com.thereal.Author.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import javax.validation.Valid;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RequestMapping("/author")
@RestController(value = "author")
public class AuthorAPI {

    //nipsey
    @Autowired
    AuthorRepository authorRepository;

    //Create
    @PostMapping(value ="/addAuthor")
    ResponseEntity<Object> addAuthor(@Valid @RequestBody Author newAuthor) throws Exception{
//no changes
        Author aut = authorRepository.save(newAuthor);
        //return "Author " + newAuthor.getName() + " created";

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aut.getId()).toUri();
       return ResponseEntity.created(location).build();
    }

    @GetMapping(value = "/getAuthor")
    //List<> List that hold Objects of type author.
    public List<Author> getAuthors(){

        if(authorRepository.findAll().isEmpty())
            System.out.println("List is empty");

        return authorRepository.findAll();

    }
    //Read
    @GetMapping(value = "/getAuthor/{id}")
    public Author retrieveAuthor(@PathVariable int id){
        Author aut = authorRepository.findById(id).get();

        if (aut == null){
            throw new UserNotFoundException("id- " + id);
        }
        return aut;
        //return get() author
    }
    //updating
    @PutMapping(value = "/updateAuthor/{id}")
    public ResponseEntity<Object> updateAuthor(@RequestBody Author newAuthor,@PathVariable int id){
        //Find the author
        Optional<Author> author = authorRepository.findById(Integer.valueOf(id));
        //if author not present. return ResponseEntity.noContent
        if(!author.isPresent())
            return ResponseEntity.noContent().build();

        //Otherwise set id/name
        newAuthor.setId(id);
        newAuthor.setName(newAuthor.getName());
        //save newAuthor in repository
        authorRepository.save(newAuthor);
        return ResponseEntity.noContent().build();
    }
    //Delete
    @DeleteMapping(value = "/deleteAuthor/{id}")
    void deleteAuthor(@PathVariable int id, Author author){


//        Iterator<Author> iterator = author.
        //Delete author by ID(Primary Key)
        authorRepository.deleteById(id);
        System.out.println(id+ " has been deleted");
       // System.out.println(authorRepository.findAll());
    }
}
