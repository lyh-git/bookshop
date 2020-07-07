package com.bookshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookshop.dao.UserDao;
import com.bookshop.entity.User;
import com.bookshop.util.JDBCUtils;

public class UserDaoImpl implements UserDao {

    public static void main(String[] args) {
    }

    @Override
    public int insert(User user) {
        String sql = "INSERT INTO `User` (`login_name`, `password`, `name`, `sex`, `email`, `tel`,`address`) VALUES (?, ?, ?, ?, ?, ?, ?)";
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
            preparedStatement.setString(1, user.getLoginName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getName());
            preparedStatement.setString(4, user.getSex());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getTel());
//            preparedStatement.setInt(7, user.getLevel());
            preparedStatement.setString(7, user.getAddress());

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
        String sql = "DELETE FROM `User` WHERE `id` = ?";
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
    public int update(User user) {
        String sql = "UPDATE `User` SET `login_name` = ?, `password` = ?, `name` = ?, `sex` = ?, `email` = ?, `tel` = ?, `level` =?,`address`= ? WHERE `id` = ?";
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        int result = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getLoginName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getName());
            preparedStatement.setString(4, user.getSex());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getTel());
            preparedStatement.setInt(7, user.getLevel());
            preparedStatement.setString(8, user.getAddress());
            preparedStatement.setInt(9, user.getId());
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
    public List<User> queryAll() {
        // DQL:Connection PreparedStatement ResultSet
        String sql = "SELECT * FROM `User`";
        List<User> list = new ArrayList<User>();
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setLoginName(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setName(resultSet.getString(4));
                user.setSex(resultSet.getString(5));
                user.setEmail(resultSet.getString(6));
                user.setTel(resultSet.getString(7));
                user.setLevel(resultSet.getInt(8));
                user.setAddress(resultSet.getString(9));
                list.add(user);
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
    public User queryById(Integer id) {
        String sql = "SELECT * FROM `User` WHERE `id` = ?";
        User user = new User();
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
                user.setLoginName(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setName(resultSet.getString(4));
                user.setSex(resultSet.getString(5));
                user.setEmail(resultSet.getString(6));
                user.setTel(resultSet.getString(7));
                user.setLevel(resultSet.getInt(8));
                user.setAddress(resultSet.getString(9));
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
        return user;
    }

    @Override
    public User login(User user) {
        String sql = "SELECT * FROM `user` WHERE `login_name` = ? AND `password` = ?";
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getLoginName());
            preparedStatement.setString(2, user.getPassword());

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
                user.setLoginName(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setName(resultSet.getString(4));
                user.setSex(resultSet.getString(5));
                user.setEmail(resultSet.getString(6));
                user.setTel(resultSet.getString(7));
                user.setLevel(resultSet.getInt(8));
                user.setAddress(resultSet.getString(9));
            } else {
                user = null;
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
        return user;
    }

}
