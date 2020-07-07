/*
 * Created by JFormDesigner on Sat Jul 04 15:57:53 CST 2020
 */

package com.bookshop.ui.userForm;

import com.bookshop.entity.Order;
import com.bookshop.service.impl.OrderServiceImpl;
import com.bookshop.util.UserData;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author °Ëµã°ë
 */
public class PayForm extends JFrame {
    public PayForm() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        OrderServiceImpl orderService = new OrderServiceImpl();
        Order order = new Order(UserData.lastId,0,UserData.userId,2);

        if (orderService.update(order)>0){
            JOptionPane.showMessageDialog(null, "提示：付款成功！");
            this.setVisible(false);
        }else {
            JOptionPane.showMessageDialog(null, "提示：付款失败！");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        button1 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("\u4ed8\u6b3e");
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1);
        button1.setBounds(145, 285, 110, button1.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(460, 365));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
