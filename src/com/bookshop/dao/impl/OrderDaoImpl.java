package com.bookshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookshop.dao.OrderDao;
import com.bookshop.entity.Order;
import com.bookshop.util.JDBCUtils;
import com.bookshop.util.UserData;

import javax.xml.transform.Result;

public class OrderDaoImpl implements OrderDao {



    public  int selectLastInsert() {
        String sql="SELECT LAST_INSERT_ID()";
        // 获取连接
        Connection connection = JDBCUtils.getConnection();
        // 语句执行平台
        PreparedStatement preparedStatement = null;
        // 记录受影响的行数
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                UserData.lastId=resultSet.getInt("id");
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
        System.out.println(UserData.lastId);
        return UserData.lastId;
    }

    @Override
    public int insert(Order order) {
        String sql = "INSERT INTO `Order` ( `user_id`, `status`,`pricesum`) VALUES (?, ?, ?)";
        String sql2="SELECT LAST_INSERT_ID()";
        // 获取连接
        Connection connection = JDBCUtils.getConnection();
        // 语句执行平台
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1 = null;
        // 记录受影响的行数
        int result = 0;
        ResultSet resultSet;
        try {
            // 获得预编译对象后
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement1 = connection.prepareStatement(sql2);
            // 给?赋值
            preparedStatement.setInt(1, order.getUserId());
            preparedStatement.setInt(2, order.getStatus());
            preparedStatement.setDouble(3, order.getPriceSum());
            result = preparedStatement.executeUpdate();
//查询lastid
            resultSet = preparedStatement1.executeQuery();

            if (resultSet.next()) {
                UserData.lastId=resultSet.getInt(1);
            }
            System.out.println(UserData.lastId);
            if(UserData.lastId>0&&result>0) {
                return (UserData.lastId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 资源的关闭
            try {
                assert preparedStatement != null;
                preparedStatement.close();
                assert preparedStatement1 != null;
                preparedStatement1.close();
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
        String sql = "DELETE FROM `Order` WHERE `id` = ?";
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
    public int update(Order order) {
        String sql = "UPDATE `Order` SET `order_item_id` = ?, `user_id` = ?, `status` = ? WHERE `id` = ?";
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        int result = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 0);
            preparedStatement.setInt(2, order.getUserId());
            preparedStatement.setInt(3, order.getStatus());
            preparedStatement.setInt(4, order.getId());
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
    public List<Order> queryAll() {
        String sql = "SELECT * FROM `Order`";
        List<Order> list = new ArrayList<Order>();
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt(1));
                order.setUserId(resultSet.getInt(3));
                order.setPriceSum(resultSet.getDouble(4));
                order.setStatus(resultSet.getInt(5));
                list.add(order);
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
    public List<Order> queryByUserId(Integer userId) {
        String sql = "SELECT * FROM `Order` WHERE `user_id` = ?";
        List<Order> list = new ArrayList<Order>();
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt(1));
                order.setOrderItemId(resultSet.getInt(2));
                order.setUserId(resultSet.getInt(3));
                order.setPriceSum(resultSet.getDouble(4));
                order.setStatus(resultSet.getInt(5));
                list.add(order);
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
