package com.chenhao.dao;


import com.chenhao.domain.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BookDao {
    //增加
    @Insert("insert into tbl_book (type,name,description) values(#{type},#{name},#{description})")
    public void addBook(Book book);

    //根据id删除
    @Delete("delete tbl_book where id = #{id}")
    public void deleteById(Integer id);

    //根据id修改
    @Update("update tbl_book set type=#{type},name=#{name},description=#{description} where id#=#{id}")
    public void updateById(Book book);

    //根据id进行查询
    @Select("select * from tbl_book where id=#{id}")
    Book findById(Integer id);

    //查询所有
    @Select("select * from tbl_book")
    List<Book> findAll();

}
