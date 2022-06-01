package com.chenhao.service.impl;

import com.chenhao.dao.BookDao;
import com.chenhao.domain.Book;
import com.chenhao.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    public boolean addBook(Book book) {
        bookDao.addBook(book);
        return true;
    }

    public boolean deleteById(Integer id) {
        bookDao.deleteById(id);
        return true;
    }

    public boolean updateById(Book book) {
        bookDao.updateById(book);
        return true;
    }

    public Book findById(Integer id) {
        Book book = bookDao.findById(id);
        return book;
    }

    public List<Book> findAll() {
        List<Book> books = bookDao.findAll();
        return books;
    }
}
