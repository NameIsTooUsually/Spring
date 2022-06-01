package com.chenhao.service;

import com.chenhao.domain.Book;

import java.util.List;

public interface BookService {
    //增加
    public boolean addBook(Book book);

    //根据id删除
    public boolean deleteById(Integer id);

    //根据id修改
    public boolean updateById(Book book);

    //根据id进行查询
    Book findById(Integer id);

    //查询所有
    List<Book> findAll();

}
