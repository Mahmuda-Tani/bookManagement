package com.example.bookManagement.service;


import com.example.bookManagement.model.Author;
import com.example.bookManagement.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    public List<Author> authors = new ArrayList<>();

    public void addAuthor(Author author){
        authors.add(author);
    }

    public List<Author> getAllAuthor(){
        return authors;
    }

    public Long getSize(){
        Long x =(long)(authors.size());
        return x;
    }


    public Author getAuthorById(Long id){
        Author author1 =new Author();
        for (Author author : authors) {
            if (author.getId().equals(id)) {
                author1=author;
                break;
            }
        }
        return author1;
    }


    public void updateAuthor(Author author){



        for (Author author1:authors) {
            if (author1.getId().equals(author.getId())){

                author1.setName(author.getName());
                break;
            }
        }
    }



}
