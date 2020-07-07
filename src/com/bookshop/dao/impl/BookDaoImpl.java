package com.bookshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookshop.dao.BookDao;
import com.bookshop.entity.Book;
import com.bookshop.util.JDBCUtils;

public class BookDaoImpl implements BookDao {

    @Override
    public int insert(Book book) {
        String sql = "INSERT INTO `Book` (`name`, `author`, `publisher`, `price`, `type_id`, `disc`, `discount`, `store`, `flag`, `create_time`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        // 获取连接
        Connection connection = JDBCUtils.getConnection();
        // 语句执行平台
        PreparedStatement preparedStatement = null;
        // 记录受影响的行数
        int result = 0;
        try {
            // 获得预编译对象后
            preparedStatement = connection.prepareStatement(sql);
            // 给?赋值
            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getPublisher());
            preparedStatement.setDouble(4, book.getPrice());
            preparedStatement.setString(5, book.getType());
            preparedStatement.setString(6, book.getDisc());
            preparedStatement.setDouble(7, book.getDiscount());
            preparedStatement.setInt(8, book.getStore());
            preparedStatement.setInt(9, book.getFlag());
            preparedStatement.setString(10, book.getCreateTime());
            // 执行sql语句 DML
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 资源的关闭
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // 对结果的处理
        return result;
    }

    @Override
    public int delete(Integer id) {
        // ?代表占位符
        // DML 数据操纵语言
        // DQL 数据查询语言 SELECT
        // DDL 数据定义语言 表结构
        // DCL 数据控制语言 权限
        String sql = "DELETE FROM `Book` WHERE `id` = ?";
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        int result = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }



    @Override
    public int update(Book book) {


        String sql = "UPDATE `book` SET `name` = ?, `author` = ?, `publisher` = ?, `price` = ?, `type_id` = ?, `disc` = ?, `discount` = ?, `store` = ?, `flag` = ?, `create_time` = ? WHERE `id` = ?";
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        int result = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getPublisher());
            preparedStatement.setDouble(4, book.getPrice());
            preparedStatement.setString(5, book.getType());
            preparedStatement.setString(6, book.getDisc());
            preparedStatement.setDouble(7, book.getDiscount());
            preparedStatement.setInt(8, book.getStore());
            preparedStatement.setInt(9, book.getFlag());
            preparedStatement.setString(10, book.getCreateTime());
            preparedStatement.setInt(11, book.getId());

            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    @Override
    public List<Book> queryAll() {
        // DQL:Connection PreparedStatement ResultSet
        String sql = "SELECT * FROM `book`";
        List<Book> list = new ArrayList<Book>();
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt(1));
                book.setName(resultSet.getString(2));
                book.setAuthor(resultSet.getString(3));
                book.setPublisher(resultSet.getString(4));
                book.setPrice(resultSet.getDouble(5));
                book.setType(resultSet.getString(6));
                book.setDisc(resultSet.getString(7));
                book.setDiscount(resultSet.getDouble(8));
                book.setStore(resultSet.getInt(9));
                book.setFlag(resultSet.getInt(10));
                book.setCreateTime(resultSet.getString(11));
                list.add(book);
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
    public Book queryById(Integer id) {
        String sql = "SELECT * FROM `book` WHERE `id` = ?";
        Book book = new Book();
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                book.setId(resultSet.getInt(1));
                book.setName(resultSet.getString(2));
                book.setAuthor(resultSet.getString(3));
                book.setPublisher(resultSet.getString(4));
                book.setPrice(resultSet.getDouble(5));
                book.setType(resultSet.getString(6));
                book.setDisc(resultSet.getString(7));
                book.setDiscount(resultSet.getDouble(8));
                book.setStore(resultSet.getInt(9));
                book.setFlag(resultSet.getInt(10));
                book.setCreateTime(resultSet.getString(11));
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
        return book;
    }

    @Override
    public List<Book> queryByName(String name) {
        String sql = "SELECT * FROM `Book` WHERE `name` LIKE ? ";
        List<Book> list = new ArrayList<Book>();
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%"+name+"%");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt(1));
                book.setName(resultSet.getString(2));
                book.setAuthor(resultSet.getString(3));
                book.setPublisher(resultSet.getString(4));
                book.setPrice(resultSet.getDouble(5));
                book.setType(resultSet.getString(6));
                book.setDisc(resultSet.getString(7));
                book.setDiscount(resultSet.getDouble(8));
                book.setStore(resultSet.getInt(9));
                book.setFlag(resultSet.getInt(10));
                book.setCreateTime(resultSet.getString(11));
                list.add(book);
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
