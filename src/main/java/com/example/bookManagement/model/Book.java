package com.example.bookManagement.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {

    private Long id;
    private String bookName;
    private String authorName;
    private Long price;
    private Long publicationYear;

}
