package com.bookshop.dao.impl;

import com.bookshop.dao.BookListDao;
import com.bookshop.entity.Book;
import com.bookshop.entity.BookList;
import com.bookshop.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookListImpl implements BookListDao {
    @Override
    public List<BookList> queryAll() {
        // DQL:Connection PreparedStatement ResultSet
        String sql = "SELECT * FROM `booklist`";
        List<BookList> list = new ArrayList<>();
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                BookList bookList = new BookList();
                bookList.setName(resultSet.getString(1));
                bookList.setLink(resultSet.getString(2));
                bookList.setPublicer(resultSet.getString(3));
                bookList.setGrade(resultSet.getString(4));
                bookList.setNum(resultSet.getString(5));
                bookList.setContent(resultSet.getString(6));
                list.add(bookList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public List<BookList> queryByName(String name) {
        String sql = "SELECT * FROM `Booklist` WHERE `name` LIKE ? ";
        List<BookList> list = new ArrayList<>();
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%"+name+"%");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                BookList bookList = new BookList();
                bookList.setName(resultSet.getString(1));
                bookList.setLink(resultSet.getString(2));
                bookList.setPublicer(resultSet.getString(3));
                bookList.setGrade(resultSet.getString(4));
                bookList.setNum(resultSet.getString(5));
                bookList.setContent(resultSet.getString(6));
                list.add(bookList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
