package com.example.bookManagement.service;

import com.example.bookManagement.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BookService {

    public List<Book> books = new ArrayList<>();


    public void addBook(Book book) {

       books.add(book);
       System.out.println(books);

    }

    public void updateBook(Book book){

        Long id = book.getId();

        for (Book book1:books) {
            if (book1.getId().equals(book.getId())){

                book1.setBookName(book.getBookName());
                book1.setAuthorName(book.getAuthorName());
                book1.setPrice(book.getPrice());
                book1.setPublicationYear(book.getPublicationYear());
                break;
            }
        }
    }

    public Long getSize(){
        Long x =(long)(books.size());
        return x;
    }

    public List<Book> getAllBook() {
        return books;
    }

    public List<Book> getAllBookByAuthor(String name) {
        List<Book> bookList = new ArrayList<>();

        for (Book book : books) {
            if (book.getAuthorName().equals(name)) {
                bookList.add(book);
            }
        }

        return bookList;
    }

    public List<Book> getAllBookBysearchWith(String searchWith) {
        List<Book> bookList = new ArrayList<>();


            for (Book book : books) {
                if (book.getAuthorName().equals(searchWith) || book.getBookName().equals(searchWith)) {
                    bookList.add(book);
                }
            }
            System.out.println(bookList.size());

        return bookList;
    }


    public  Book getBookById(Long id){
        Book book1 =new Book();
        for (Book book : books) {
            if (book.getId().equals(id)) {
               book1=book;
               break;
            }
        }
        return book1;
    }


}
