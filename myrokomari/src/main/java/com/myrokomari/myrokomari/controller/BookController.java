package com.myrokomari.myrokomari.controller;

import com.myrokomari.myrokomari.dto.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/books")
public class BookController {
    //List<Book> bookList = new ArrayList<>();
    List<Book> b = new LinkedList<>();
    Integer id = 0;
    @PostMapping("/add")
    public Book addBook(@RequestBody Book book){
        book.setId(++id);
        b.add(book);
        //bookList.add(book);
        return book;
    }
    @GetMapping
    public List<Book> getbooks(){
        //return bookList;
        return b;
    }
    @GetMapping("/{id}")
    public Book singleBook(@PathVariable Integer id){
        //return bookList.get(id-1);
        for(Book books : b){
            if(books.getId().equals(id)){
                return books;
            }
        }
        return null;
    }
    @PutMapping("/update/{}")
    public Book addBook(@PathVariable Integer id, @RequestBody Book book){
        for(int i = 0;i < b.size();i++){
            if(b.get(i).getId().equals(id)){
                book.setId(id);
                b.set(i,book);
                break;
            }
        }
        return book;
    }
    @DeleteMapping("/delete")
    public void deleteBook(@RequestParam Integer id){
        for(Book books : b){
            if(Objects.equals(books.getId(), id)){
                b.remove(books);
            }
        }
    }

}
