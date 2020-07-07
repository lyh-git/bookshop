/*
 * Created by JFormDesigner on Wed Jul 01 17:44:38 CST 2020
 */

package com.bookshop.ui.publicForm;

import com.bookshop.entity.Admin;
import com.bookshop.entity.User;
import com.bookshop.service.impl.AdminServiceImpl;
import com.bookshop.service.impl.UserServiceImpl;
import com.bookshop.ui.AdminForm.AdminMainForm;
import com.bookshop.ui.userForm.UserMainFrame;
import com.bookshop.ui.userForm.UserRegisterFrame;
import com.bookshop.util.UserData;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author °Ëµã°ë
 */
public class LoginFrame extends JFrame {
    public static void main(String[] args) {
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
    }
    public LoginFrame() {
        initComponents();
    }

    private void loginButtonUserActionPerformed(ActionEvent e) {
        // TODO add your code here
        String name= loginTextField.getText();
        String Password=loginPasswordField.getText();
        UserServiceImpl userService = new UserServiceImpl();
        User user = new User(name,  Password);
        System.out.println(user);
        User u = userService.login(user);
        System.out.println(u);
        System.out.println(u);

        if (u == null) {
            JOptionPane.showMessageDialog(null, "提示：用户名或密码错误！");
        } else if (u.getLevel()==-1){
            JOptionPane.showMessageDialog(null, "提示：用户名或密码错误！");
        }
        else {
            // 登录成功，从登录窗体切换主窗体
            this.setVisible(false);
            UserData.userId=user.getId();
            UserData.Sign="user";
            System.out.println(UserData.userId);
            JOptionPane.showMessageDialog(null, "登录成功");
            UserMainFrame userMainFrame = new UserMainFrame();
            userMainFrame.setVisible(true);
            userMainFrame.showData();

        }
    }

    private void loginButtonAdminActionPerformed(ActionEvent e) {
        String name= loginTextField.getText();
        String Password=loginPasswordField.getText();
        AdminServiceImpl adminService = new AdminServiceImpl();
        Admin admin = new Admin(name, Password);
        System.out.println(admin);
        Admin admin2 = adminService.login(admin);
//        Admin admin3 = adminService.q(admin);

        if (admin2 == null) {
            JOptionPane.showMessageDialog(null, "提示：用户名或密码错误！");
        } else {
            // 登录成功，从登录窗体切换主窗体
            UserData.adminId=admin2.getId();
            UserData.Sign="Admin";
            System.out.println(UserData.userId);
            this.setVisible(false);
            JOptionPane.showMessageDialog(null, "登录成功");
            AdminMainForm adminMainForm = new AdminMainForm();
            adminMainForm.setVisible(true);
        }
    }

    private void loginButtonRegisterActionPerformed(ActionEvent e) {
        // TODO add your code here
        UserRegisterFrame userRegisterFrame = new UserRegisterFrame();
        userRegisterFrame.setVisible(true);
        this.setVisible(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        loginLabelTitle = new JLabel();
        loginLabelName = new JLabel();
        loginTextField = new JTextField();
        loginLabelPassword = new JLabel();
        loginPasswordField = new JPasswordField();
        loginButtonUser = new JButton();
        loginButtonAdmin = new JButton();
        loginButtonRegister = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- loginLabelTitle ----
        loginLabelTitle.setText("\u7528\u6237\u767b\u5f55\u754c\u9762");
        loginLabelTitle.setFont(loginLabelTitle.getFont().deriveFont(loginLabelTitle.getFont().getStyle() | Font.ITALIC, loginLabelTitle.getFont().getSize() + 20f));
        loginLabelTitle.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(loginLabelTitle);
        loginLabelTitle.setBounds(130, 10, 255, loginLabelTitle.getPreferredSize().height);

        //---- loginLabelName ----
        loginLabelName.setText("\u7528\u6237\u540d");
        loginLabelName.setFont(loginLabelName.getFont().deriveFont(loginLabelName.getFont().getSize() + 6f));
        contentPane.add(loginLabelName);
        loginLabelName.setBounds(90, 85, 55, 22);
        contentPane.add(loginTextField);
        loginTextField.setBounds(165, 85, 230, loginTextField.getPreferredSize().height);

        //---- loginLabelPassword ----
        loginLabelPassword.setText("\u5bc6   \u7801");
        loginLabelPassword.setFont(loginLabelPassword.getFont().deriveFont(loginLabelPassword.getFont().getSize() + 6f));
        contentPane.add(loginLabelPassword);
        loginLabelPassword.setBounds(new Rectangle(new Point(90, 160), loginLabelPassword.getPreferredSize()));
        contentPane.add(loginPasswordField);
        loginPasswordField.setBounds(160, 160, 230, loginPasswordField.getPreferredSize().height);

        //---- loginButtonUser ----
        loginButtonUser.setText("\u7528\u6237\u767b\u5f55");
        loginButtonUser.addActionListener(e -> loginButtonUserActionPerformed(e));
        contentPane.add(loginButtonUser);
        loginButtonUser.setBounds(new Rectangle(new Point(85, 225), loginButtonUser.getPreferredSize()));

        //---- loginButtonAdmin ----
        loginButtonAdmin.setText("\u7ba1\u7406\u5458\u767b\u5f55");
        loginButtonAdmin.addActionListener(e -> loginButtonAdminActionPerformed(e));
        contentPane.add(loginButtonAdmin);
        loginButtonAdmin.setBounds(210, 225, 100, 30);

        //---- loginButtonRegister ----
        loginButtonRegister.setText("\u6ce8\u518c");
        loginButtonRegister.addActionListener(e -> loginButtonRegisterActionPerformed(e));
        contentPane.add(loginButtonRegister);
        loginButtonRegister.setBounds(345, 225, 100, 30);

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
    private JLabel loginLabelTitle;
    private JLabel loginLabelName;
    private JTextField loginTextField;
    private JLabel loginLabelPassword;
    private JPasswordField loginPasswordField;
    private JButton loginButtonUser;
    private JButton loginButtonAdmin;
    private JButton loginButtonRegister;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
