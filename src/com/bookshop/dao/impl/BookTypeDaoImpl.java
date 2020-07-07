package com.bookshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookshop.dao.BookTypeDao;
import com.bookshop.entity.BookType;
import com.bookshop.util.JDBCUtils;

public class BookTypeDaoImpl implements BookTypeDao {

    @Override
    public int insert(BookType bookType) {
        String sql = "INSERT INTO `Book_type` (`type`, `create_time`) VALUES (?, ?)";
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
            preparedStatement.setString(1, bookType.getType());
            preparedStatement.setString(2, bookType.getCreateTime());
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
        String sql = "DELETE FROM `Book_type` WHERE `id` = ?";
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
    public int update(BookType bookType) {
        String sql = "UPDATE `Book_type` SET `type` = ? WHERE `id` = ?";
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        int result = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bookType.getType());
            preparedStatement.setInt(2, bookType.getId());

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
    public List<BookType> queryAll() {
        // DQL:Connection PreparedStatement ResultSet
        String sql = "SELECT * FROM `Book_type`";
        List<BookType> list = new ArrayList<BookType>();
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                BookType bookType = new BookType();
                bookType.setId(resultSet.getInt(1));
                bookType.setType(resultSet.getString(2));
                bookType.setCreateTime(resultSet.getString(3));
                list.add(bookType);
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
