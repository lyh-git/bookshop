/*
 * Created by JFormDesigner on Fri Jul 03 10:59:02 CST 2020
 */

package com.bookshop.ui.userForm;

import java.awt.event.*;

import com.bookshop.entity.User;
import com.bookshop.service.impl.UserServiceImpl;
import com.bookshop.ui.publicForm.LoginFrame;
import com.bookshop.util.JRichTextField;

import java.awt.*;
import javax.swing.*;

/**
 * @author °Ëµã°ë
 */
public class UserRegisterFrame extends JFrame {
    public static void main(String[] args) {
        UserRegisterFrame userRegisterFrame = new UserRegisterFrame();
        userRegisterFrame.setVisible(true);
    }
    public UserRegisterFrame() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        String loginName = textField1.getText();
        String pws = textField2.getText();
        String name = textField3.getText();
        String email = textField4.getText();
        String tel = textField5.getText();
        String addr = textField6.getText();
        String sex = comboBox1.getSelectedItem().toString();


        User user = new User(loginName,pws,name,sex,email,tel,addr);
        UserServiceImpl userService = new UserServiceImpl();
        int insert = userService.insert(user);
        if (insert>0){
            JOptionPane.showMessageDialog(null, "注册成功");
            this.setVisible(false);
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        comboBox1 = new JComboBox<>();
        textField4 = new JTextField();
        textField5 = new JTextField();
        textField6 = new JTextField();
        checkBox1 = new JCheckBox();
        button1 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u7528\u6237\u540d");
        contentPane.add(label1);
        label1.setBounds(20, 100, 50, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u5bc6\u7801");
        contentPane.add(label2);
        label2.setBounds(20, 145, 55, label2.getPreferredSize().height);

        //---- label3 ----
        label3.setText("\u6635\u79f0");
        contentPane.add(label3);
        label3.setBounds(20, 190, label3.getPreferredSize().width, 20);

        //---- label4 ----
        label4.setText("\u6027\u522b");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(20, 245), label4.getPreferredSize()));

        //---- label5 ----
        label5.setText("\u90ae\u7bb1");
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(20, 290), label5.getPreferredSize()));

        //---- label6 ----
        label6.setText("\u7535\u8bdd");
        contentPane.add(label6);
        label6.setBounds(20, 335, 30, 25);

        //---- label7 ----
        label7.setText("\u5730\u5740");
        contentPane.add(label7);
        label7.setBounds(new Rectangle(new Point(20, 390), label7.getPreferredSize()));

        //---- label8 ----
        label8.setText("\u7528\u6237\u6ce8\u518c");
        label8.setFont(label8.getFont().deriveFont(label8.getFont().getSize() + 15f));
        contentPane.add(label8);
        label8.setBounds(new Rectangle(new Point(155, 30), label8.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(80, 95, 135, textField1.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(80, 140, 135, textField2.getPreferredSize().height);
        contentPane.add(textField3);
        textField3.setBounds(75, 190, 140, textField3.getPreferredSize().height);

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "\u65e0",
            "\u7537",
            "\u5973"
        }));
        contentPane.add(comboBox1);
        comboBox1.setBounds(75, 230, 145, comboBox1.getPreferredSize().height);
        contentPane.add(textField4);
        textField4.setBounds(75, 290, 140, textField4.getPreferredSize().height);
        contentPane.add(textField5);
        textField5.setBounds(75, 340, 145, textField5.getPreferredSize().height);
        contentPane.add(textField6);
        textField6.setBounds(70, 395, 150, textField6.getPreferredSize().height);

        //---- checkBox1 ----
        checkBox1.setText("\u6211\u5df2\u540c\u610f\u76f8\u5173\u534f\u8bae");
        contentPane.add(checkBox1);
        checkBox1.setBounds(new Rectangle(new Point(40, 440), checkBox1.getPreferredSize()));

        //---- button1 ----
        button1.setText("\u7acb\u5373\u6ce8\u518c");
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1);
        button1.setBounds(65, 475, 275, button1.getPreferredSize().height);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JComboBox<String> comboBox1;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JCheckBox checkBox1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
