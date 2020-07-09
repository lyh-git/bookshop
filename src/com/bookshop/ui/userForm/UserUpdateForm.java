/*
 * Created by JFormDesigner on Sun Jul 05 13:48:53 CST 2020
 */

package com.bookshop.ui.userForm;

import java.awt.event.*;

import com.bookshop.entity.Cart;
import com.bookshop.entity.User;
import com.bookshop.service.impl.UserServiceImpl;
import com.bookshop.util.UserData;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author °???°?
 */
public class UserUpdateForm extends JFrame {
    private UserServiceImpl userService = new UserServiceImpl();

    public UserUpdateForm() {
        initComponents();
        click();
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
//       修改用户
        int lev = 0, id;
        String loginName, password, name = "未设置", sex = "未设置", email = "未设置", tel = "未设置", address = "未设置";
        int index = table1.getSelectedRow();
        TableModel model = table1.getModel();
        // 如果下标不为-1，则选中行为数据行
        if (index != -1) {
            id = Integer.parseInt(model.getValueAt(index, 0).toString());
            loginName = model.getValueAt(index, 1).toString();
            password = model.getValueAt(index, 2).toString();
            try {
                // 取得表格对象的数据模型
                // 在表格对象模型中，根据选中的行和列，获取相应的数据值
                name = model.getValueAt(index, 3).toString();
                sex = model.getValueAt(index, 4).toString();
                email = model.getValueAt(index, 5).toString();
                tel = model.getValueAt(index, 6).toString();
                address = model.getValueAt(index, 7).toString();
                if ("user".equals(UserData.Sign)) {
                    lev = userService.queryById(id).getLevel();
                } else {
                    lev = Integer.parseInt(model.getValueAt(index, 8).toString());
                }
            } catch (Exception es) {
                JOptionPane.showMessageDialog(null, "提示：有选项没填,已经设置为默认值");
            }
//            "ID", "登录名", "密码", "昵称", "性别", "邮箱", "电话", "地址"
            User user = new User(id, loginName, password, name, sex, email, tel, address, lev);
            if (userService.update(user) > 0) {
                JOptionPane.showMessageDialog(null, "提示：" + user.getLoginName() + "修改成功！");
                click();
            } else {
                JOptionPane.showMessageDialog(null, "提示：修改失败！");
            }
        } else {
            JOptionPane.showMessageDialog(null, "提示：请选择需要修改的用户！");
        }

    }

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
//        注销用户,体现在lev的修改
        int lev = 0, id;
        String loginName, password, name = "未设置", sex = "未设置", email = "未设置", tel = "未设置", address = "未设置";
        int index = table1.getSelectedRow();
        TableModel model = table1.getModel();
        // 如果下标不为-1，则选中行为数据行
        if (index != -1) {
            id = Integer.parseInt(model.getValueAt(index, 0).toString());
            loginName = model.getValueAt(index, 1).toString();
            password = model.getValueAt(index, 2).toString();
            try {
                // 取得表格对象的数据模型
                // 在表格对象模型中，根据选中的行和列，获取相应的数据值
                name = model.getValueAt(index, 3).toString();
                sex = model.getValueAt(index, 4).toString();
                email = model.getValueAt(index, 5).toString();
                tel = model.getValueAt(index, 6).toString();
                address = model.getValueAt(index, 7).toString();
                lev = -1;

            } catch (Exception es) {
                JOptionPane.showMessageDialog(null, "提示：有选项没填,已经设置为默认值");
            }
//            "ID", "登录名", "密码", "昵称", "性别", "邮箱", "电话", "地址"
            User user = new User(id, loginName, password, name, sex, email, tel, address, lev);
            if (userService.update(user) > 0) {
                JOptionPane.showMessageDialog(null, "提示：" + user.getLoginName() + "注销成功！");
//                click();
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(null, "提示：注销失败！");
            }
        } else {
            JOptionPane.showMessageDialog(null, "提示：请选择需要注销的用户！");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                    new Object[][]{
                            {null, null, null, null, null, null, null, null},
                            {null, null, null, null, null, null, null, null},
                    },
                    new String[]{
                            "ID", "\u767b\u5f55\u540d", "\u5bc6\u7801", "\u6635\u79f0", "\u6027\u522b", "\u90ae\u7bb1", "\u7535\u8bdd", "\u5730\u5740"
                    }
            ) {
                boolean[] columnEditable = new boolean[]{
                        false, false, true, true, true, true, true, true
                };

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(20, 40, 710, 465);

        //---- button1 ----
        button1.setText("\u4fee\u6539");
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(105, 520), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u6ce8\u9500");
        button2.addActionListener(e -> button2ActionPerformed(e));
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(575, 525), button2.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(770, 595));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public void click() {
        //---- table1 ----
        if ("user".equals(UserData.Sign)) {
            table1.setModel(new DefaultTableModel(
                    select(),
                    new String[]{
                            "ID", "登录名", "密码", "昵称", "性别", "邮箱", "电话", "地址"
                    }
            )
                            {
                                boolean[] columnEditable = new boolean[]{
                                        false, false, true, true, true, true, true, true
                                };

                                @Override
                                public boolean isCellEditable(int rowIndex, int columnIndex) {
                                    return columnEditable[columnIndex];
                                }
                            }
            );
            scrollPane1.setViewportView(table1);
        } else {
            table1.setModel(new DefaultTableModel(
                                    select(),
                                    new String[]{
                                            "ID", "\u767b\u5f55\u540d", "\u5bc6\u7801", "\u6635\u79f0", "\u6027\u522b", "\u90ae\u7bb1", "\u7535\u8bdd", "\u5730\u5740", "等级"
                                    }
                            ) {
                                boolean[] columnEditable = new boolean[]{
                                        false, false, true, true, true, true, true, true
                                };

                                @Override
                                public boolean isCellEditable(int rowIndex, int columnIndex) {
                                    return columnEditable[columnIndex];
                                }
                            }
            );
            scrollPane1.setViewportView(table1);
            button2.setVisible(false);
        }


    }

    private String[][] select() {
        String[][] datas;
        if ("user".equals(UserData.Sign)) {
            User user = userService.queryById(UserData.userId);
            datas = new String[1][8];
            if (user.getLevel() == -1) {
                return new String[][]{
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                };
            }
            datas[0][0] = user.getId().toString();
            datas[0][1] = user.getLoginName();
            datas[0][2] = user.getPassword();
            datas[0][3] = user.getName();
            datas[0][4] = user.getSex();
            datas[0][5] = user.getEmail();
            datas[0][6] = user.getTel();
            datas[0][7] = user.getAddress();

        } else {
            List<User> users = userService.queryAll();
            datas = new String[users.size()][9];
            for (int i = 0; i < datas.length; i++) {
                datas[i][0] = users.get(i).getId().toString();
                datas[i][1] = users.get(i).getLoginName();
                datas[i][2] = users.get(i).getPassword();
                datas[i][3] = users.get(i).getName();
                datas[i][4] = users.get(i).getSex();
                datas[i][5] = users.get(i).getEmail();
                datas[i][6] = users.get(i).getTel();
                datas[i][7] = users.get(i).getAddress();
                datas[i][8] = users.get(i).getLevel().toString();
            }
        }
        //---- table1 ---
        return datas;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
