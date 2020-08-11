package com.thereal.Author;

import com.thereal.Author.author.entity.Author;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    public void run(String... arg0) throws Exception{
        Author author = new Author();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter User id:");
        int id = Integer.parseInt(sc.next());
        System.out.println("Enter name");
        String name = sc.next();
        System.out.println("Enter new Address");
        String address = sc.next();

        author.setId(id);
        author.setName(name);
        author.setAddress(address);

    }

}
