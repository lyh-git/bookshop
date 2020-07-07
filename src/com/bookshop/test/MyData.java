package com.bookshop.test;

import com.bookshop.entity.Book;
import com.bookshop.entity.User;
import com.bookshop.service.impl.BookServiceImpl;
import com.bookshop.service.impl.UserServiceImpl;
import org.junit.Test;

import java.util.List;

public class MyData {
    @Test
    public  void test1(){
        UserServiceImpl userService = new UserServiceImpl();
//        Book book = new Book();
//        book.setId(1);
//        book.setName("葵花宝典");
//        book.setAuthor("华仔");
//
//        bookService.insert(book);
        User users = userService.login(new User("admin","admin"));
        System.out.println(users);
        if (users==null){
            System.out.println("kkk");
        }

    }
}
