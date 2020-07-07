package com.bookshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookshop.dao.CartDao;
import com.bookshop.entity.Cart;
import com.bookshop.util.JDBCUtils;

public class CartDaoImpl implements CartDao {

    @Override
    public int insert(Cart cart) {
        String sql = "INSERT INTO `Cart` (`user_id`, `book_id`, `book_num`, `book_price`, `book_name`) VALUES (?, ?, ?, ?, ?)";
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
            preparedStatement.setInt(1, cart.getUserId());
            preparedStatement.setInt(2, cart.getBookId());
            preparedStatement.setInt(3, cart.getBookNum());
            preparedStatement.setDouble(4, cart.getBookPrice());
            preparedStatement.setString(5, cart.getBookName());
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
        String sql = "DELETE FROM `Cart` WHERE `id` = ?";
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
    public int update(Cart cart) {
        String sql = "UPDATE `Cart` SET `user_id` = ?, `book_id` = ?, `book_num` = ?, `book_price` = ?, `book_name` = ?  WHERE `id` = ?";
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        int result = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, cart.getUserId());
            preparedStatement.setInt(2, cart.getBookId());
            preparedStatement.setInt(3, cart.getBookNum());
            preparedStatement.setDouble(4, cart.getBookPrice());
            preparedStatement.setString(5, cart.getBookName());
            preparedStatement.setInt(6, cart.getId());
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
    public List<Cart> queryAll() {
        String sql = "SELECT * FROM `Cart`";
        List<Cart> list = new ArrayList<Cart>();
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Cart cart = new Cart();
                cart.setId(resultSet.getInt(1));
                cart.setUserId(resultSet.getInt(2));
                cart.setBookId(resultSet.getInt(3));
                cart.setBookNum(resultSet.getInt(4));
                cart.setBookPrice(resultSet.getDouble(5));
                cart.setBookName(resultSet.getString(6));
                list.add(cart);
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
    public List<Cart> queryAllByUserId(Integer userId) {
        String sql = "SELECT * FROM `Cart` WHERE `user_id` = ?";
        List<Cart> list = new ArrayList<Cart>();
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Cart cart = new Cart();
                cart.setId(resultSet.getInt(1));
                cart.setUserId(resultSet.getInt(2));
                cart.setBookId(resultSet.getInt(3));
                cart.setBookNum(resultSet.getInt(4));
                cart.setBookPrice(resultSet.getDouble(5));
                cart.setBookName(resultSet.getString(6));

                list.add(cart);
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
    public Cart query(Integer userId, Integer bookId) {

        String sql = "SELECT * FROM `Cart` WHERE `user_id` = ? AND `book_id` = ?";
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Cart cart = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, bookId);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                cart = new Cart();
                cart.setId(resultSet.getInt(1));
                cart.setUserId(resultSet.getInt(2));
                cart.setBookId(resultSet.getInt(3));
                cart.setBookNum(resultSet.getInt(4));
                cart.setBookPrice(resultSet.getDouble(5));
                cart.setBookName(resultSet.getString(6));
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
        return cart;

    }

}
