package com.bookshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookshop.dao.AdminDao;
import com.bookshop.entity.Admin;
import com.bookshop.util.JDBCUtils;

public class AdminDaoImpl implements AdminDao {

    @Override
    public int insert(Admin admin) {
        String sql = "INSERT INTO `Admin` (`name`, `password`, `create_time`) VALUES (?, ?, ?)";
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
            preparedStatement.setString(1, admin.getName());
            preparedStatement.setString(2, admin.getPassword());
            preparedStatement.setString(3, admin.getCreateTime());
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
    public int delete(Integer adminId) {
        String sql = "DELETE FROM `Admin` WHERE `id` = ?";
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        int result = 0;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, adminId);
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
    public int update(Admin admin) {
        String sql = "UPDATE `Admin` SET `name` = ?, `password` = ? WHERE `id` = ?";
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        int result = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, admin.getName());
            preparedStatement.setString(2, admin.getPassword());
            preparedStatement.setInt(3, admin.getId());

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
    public List<Admin> queryAll() {
        // DQL:Connection PreparedStatement ResultSet
        String sql = "SELECT * FROM `Admin`";
        List<Admin> list = new ArrayList<Admin>();
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Admin admin = new Admin();
                admin.setId(resultSet.getInt(1));
                admin.setName(resultSet.getString(2));
                admin.setPassword(resultSet.getString(3));
                admin.setCreateTime(resultSet.getString(4));
                list.add(admin);
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
    public Admin queryById(Integer adminId) {
        String sql = "SELECT * FROM `admin` WHERE `id` = ?";
        Admin admin = new Admin();
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, adminId);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                admin.setId(resultSet.getInt(1));
                admin.setName(resultSet.getString(2));
                admin.setPassword(resultSet.getString(3));
                admin.setCreateTime(resultSet.getString(4));
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
        return admin;
    }

    @Override
    public Admin login(Admin admin) {
        String sql = "SELECT * FROM `Admin` WHERE `name` = ? AND `password` = ?";
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, admin.getName());
            preparedStatement.setString(2, admin.getPassword());

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                admin.setId(resultSet.getInt(1));
                admin.setName(resultSet.getString(2));
                admin.setPassword(resultSet.getString(3));
                admin.setCreateTime(resultSet.getString(4));
            } else {
                admin = null;
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
        return admin;
    }

}
