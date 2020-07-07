package com.bookshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookshop.dao.OrderItemDao;
import com.bookshop.entity.OrderItem;
import com.bookshop.util.JDBCUtils;

public class OrderItemDaoImpl implements OrderItemDao {

    @Override
    public int insert(OrderItem orderItem) {
        String sql = "INSERT INTO `Orderitem` (`user_id`, `book_id`, `order_id`, `price_sum`) VALUES (?, ?, ?, ?)";
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
            preparedStatement.setInt(1, orderItem.getUserId());
            preparedStatement.setInt(2, orderItem.getBookId());
            preparedStatement.setInt(3, orderItem.getOrderId());
            preparedStatement.setDouble(4, orderItem.getPriceSum());
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
        String sql = "DELETE FROM `Orderitem` WHERE `id` = ?";
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        int result = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
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
    public int update(OrderItem orderItem) {
        // "INSERT INTO `Order_item` (`user_id`, `book_id`, `order_id`,
        // `price_sum`) VALUES (?, ?, ?, ?)";
        String sql = "UPDATE `Orderitem` SET `user_id` = ?, `book_id` = ?, `order_id` = ?, `price_sum` = ? WHERE `id` = ?";
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        int result = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, orderItem.getUserId());
            preparedStatement.setInt(2, orderItem.getBookId());
            preparedStatement.setInt(3, orderItem.getOrderId());
            preparedStatement.setDouble(4, orderItem.getPriceSum());
            preparedStatement.setInt(5, orderItem.getId());
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
    public List<OrderItem> queryAll() {
        String sql = "SELECT * FROM bookshop.`Orderitem`";
        List<OrderItem> list = new ArrayList<OrderItem>();
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                OrderItem orderItem = new OrderItem();
                orderItem.setId(resultSet.getInt(1));
                orderItem.setUserId(resultSet.getInt(2));
                orderItem.setBookId(resultSet.getInt(3));
                orderItem.setOrderId(resultSet.getInt(4));
                orderItem.setPriceSum(resultSet.getDouble(5));
                list.add(orderItem);
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
    public List<OrderItem> queryByUserId(Integer userId) {
        String sql = "SELECT * FROM `Orderitem` WHERE `user_id` = ?";
        List<OrderItem> list = new ArrayList<OrderItem>();
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                OrderItem orderItem = new OrderItem();
                orderItem.setId(resultSet.getInt(1));
                orderItem.setUserId(resultSet.getInt(2));
                orderItem.setBookId(resultSet.getInt(3));
                orderItem.setOrderId(resultSet.getInt(4));
                orderItem.setPriceSum(resultSet.getDouble(5));
                list.add(orderItem);
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
