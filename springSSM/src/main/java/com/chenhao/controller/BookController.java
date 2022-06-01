package com.chenhao.controller;

import com.chenhao.domain.Book;
import com.chenhao.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    //增加
    @PostMapping
    public Result addBook(Book book) {
        boolean flag = bookService.addBook(book);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    //根据id删除
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id) {
        boolean flag = bookService.deleteById(id);

        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    //根据id修改
    @PutMapping
    public Result updateById(@RequestBody Book book) {
        boolean flag = bookService.updateById(book);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    //根据id进行查询
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id) {
        Book book = bookService.findById(id);
        Integer code = book != null ? Code.GET_OK : Code.GET_ERR;
        return new Result(code, book, "");
    }

    //查询所有
    @GetMapping
    public Result findAll() {
        List<Book> books = bookService.findAll();
        Integer code = books != null ? Code.GET_OK : Code.GET_ERR;
        return new Result(code,books,"");
    }
}
