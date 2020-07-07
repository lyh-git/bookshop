/*
 * Created by JFormDesigner on Mon Jul 06 20:10:08 CST 2020
 */

package com.bookshop.ui.AdminForm;

import java.awt.event.*;
import com.bookshop.entity.Admin;
import com.bookshop.entity.User;
import com.bookshop.service.impl.AdminServiceImpl;
import com.bookshop.util.UserData;

import java.awt.*;
import java.sql.Date;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author °Ëµã°ë
 */
public class UpdateAdminForm extends JFrame {
    public UpdateAdminForm() {
        initComponents();
        showDate();
    }
    public String[][] getDate(){
        String[][] datas;
        Admin admin = new AdminServiceImpl().queryById(UserData.adminId);
        datas = new String[1][8];
        datas[0][0] = admin.getId().toString();
        datas[0][3] = admin.getCreateTime();
        datas[0][2] = admin.getPassword();
        datas[0][1] = admin.getName();
        return datas;

    }
    public void showDate(){
        table1.setModel(new DefaultTableModel(
               getDate(),
                new String[] {
                        "ID", "\u767b\u5f55\u540d", "\u5bc6\u7801", "\u521b\u5efa\u65f6\u95f4"
                }
        ));
        scrollPane1.setViewportView(table1);
    }

    private void button1ActionPerformed(ActionEvent e) {
//        修改管理员
        int index = table1.getSelectedRow();
        TableModel model = table1.getModel();
        // 如果下标不为-1，则选中行为数据行
        if (index != -1) {
            int id = Integer.parseInt(model.getValueAt(index, 0).toString());
            String loginName = model.getValueAt(index, 1).toString();
            String password = model.getValueAt(index, 2).toString();
            String time =new Date(System.currentTimeMillis()).toString();
//
            Admin admin = new Admin(id, loginName, password,time);
            if (new AdminServiceImpl().update(admin) > 0) {
                JOptionPane.showMessageDialog(null, "提示：" + admin.getName() + "修改成功！");
                showDate();
            } else {
                JOptionPane.showMessageDialog(null, "提示：修改失败！");
            }
        } else {
            JOptionPane.showMessageDialog(null, "提示：请选择需要修改的用户！");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null},
                },
                new String[] {
                    "ID", "\u767b\u5f55\u540d", "\u5bc6\u7801", "\u521b\u5efa\u65f6\u95f4"
                }
            ));
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(20, 30, 725, 350);

        //---- button1 ----
        button1.setText("\u4fee\u6539");
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(310, 395), button1.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(755, 490));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
