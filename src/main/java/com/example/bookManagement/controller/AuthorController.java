package com.example.bookManagement.controller;


import com.example.bookManagement.model.Author;
import com.example.bookManagement.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping("/authorList")
    public String veiwAuthorList(Model model){
        List<Author> authors = authorService.getAllAuthor();
        model.addAttribute("authors", authors);
        return "AuthorList";
    }

    @GetMapping("/addAuthor")
    public String addAuthor(Model model) {

        Author author = new Author();
        model.addAttribute("author", author);
        return "EditUpdateAuthor";

    }

    @PostMapping("/saveAuthor")
    public String saveAuthor(@ModelAttribute("author")Author author,Model model, RedirectAttributes redirectAttributes) {


        if(author.getId()==null){
            long x = authorService.getSize();
            x = x+1;

            author.setId(x);
            authorService.addAuthor(author);

            String message = "Added Successfully !";


            redirectAttributes.addFlashAttribute("author", author);
            redirectAttributes.addFlashAttribute("message",message);
            return "redirect:/confirmationMessage";


        }
        else{
            authorService.updateAuthor(author);
            String message = "Updated Successfully !";
            redirectAttributes.addFlashAttribute("author", author);
            redirectAttributes.addFlashAttribute("message",message);
            return "redirect:/confirmationMessage";
        }

    }

    @GetMapping("/updateAuthor/{id}")
    public String updateAuthor(@PathVariable ("id")Long id, Model model){

        Author author = authorService.getAuthorById(id);
        model.addAttribute("author", author);
        return "EditUpdateAuthor";
    }

}
