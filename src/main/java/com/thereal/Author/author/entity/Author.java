package com.thereal.Author.author.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "author_details")//Author object should be stored in a "authors" table
@GenericGenerator(name = "gen", strategy = "increment")
public class Author {

    @Id
    @Column(name = "athr_id")// id attribute should be stored in a column called athr_id
    @GeneratedValue(generator = "gen")
    private int id;

    @Size(min = 2)
    @Column(name = "athr_nm")
    private String name;

    @Column(name ="athr_addr")
    private String address;

    public Author(){

    }
    public Author(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    @Override
//    public String toString() {
//        return "Author{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", address='" + address + '\'' +
//                '}';
}

