package com.example.bookManagement.controller;


import com.example.bookManagement.model.Author;
import com.example.bookManagement.model.Book;
import com.example.bookManagement.service.AuthorService;
import com.example.bookManagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.MalformedURLException;
import java.util.List;

@Controller
public class BookController {


    @Autowired
    private  BookService bookService;

    @Autowired
    private AuthorService authorService;

    @GetMapping("/booklist")
    public String viewHomePage(Model model) {


            List<Book> books = bookService.getAllBook();
            List<Author> authors = authorService.getAllAuthor();


            model.addAttribute("books", books);
            model.addAttribute("authors",authors);
            return "index";

    }

    @GetMapping("/books/{author}")
    public ResponseEntity<List<Book>> getAllBookByAuthorName(@PathVariable String author) throws MalformedURLException {
        List<Book> books = bookService.getAllBookByAuthor(author);
        return ResponseEntity.ok(books);
    }


    @GetMapping("search/books/{searchWith}")
    public ResponseEntity<List<Book>> getAllBookBySearch(@PathVariable String searchWith) throws MalformedURLException {
        List<Book> books = bookService.getAllBookBysearchWith(searchWith);
        return ResponseEntity.ok(books);
    }


    @GetMapping("/addBook")
    public String addBook(Model model) {

        Book book = new Book();
        model.addAttribute("book", book);
        return "Book_Form";

    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book,Model model, RedirectAttributes redirectAttributes) {

        if(book.getId()==null){
        long x = bookService.getSize();
        x = x+1;

        book.setId(x);
        bookService.addBook(book);

        String message = "Added Successfully !";


        redirectAttributes.addFlashAttribute("book", book);
        redirectAttributes.addFlashAttribute("message",message);
        return "redirect:/confirmationMessage";


        }
        else{
            bookService.updateBook(book);
            String message = "Updated Successfully !";
            redirectAttributes.addFlashAttribute("book", book);
            redirectAttributes.addFlashAttribute("message",message);
            return "redirect:/confirmationMessage";
        }

    }



    @GetMapping("/updateBook/{id}")
    public String updateBook(@PathVariable ("id")Long id, Model model){
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "Book_Form";
    }

    @GetMapping("/confirmationMessage")
    public String confirmation (){

        return "ConfirmationMessage";

    }
















}
