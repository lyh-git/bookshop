/*
 * Created by JFormDesigner on Sat Jul 04 09:37:53 CST 2020
 */

package com.bookshop.ui.AdminForm;

import com.bookshop.ui.publicForm.LoginFrame;
import com.bookshop.ui.userForm.OrderItemForm;
import com.bookshop.ui.userForm.OrderItemsForm;
import com.bookshop.ui.userForm.UserUpdateForm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author °Ëµã°ë
 */
public class AdminMainForm extends JFrame {
    public static void main(String[] args) {
        AdminMainForm adminMainForm = new AdminMainForm();
        adminMainForm.setVisible(true);

    }
    public AdminMainForm() {
        initComponents();
    }

    private void commodityManagementMenuItemActionPerformed(ActionEvent e) {
        // TODO add your code here
//        商品管理界面
        CommodityManagementForm commodityManagementForm = new CommodityManagementForm();
        commodityManagementForm.setVisible(true);


    }

    private void orderManagementMenuItemActionPerformed(ActionEvent e) {
        // TODO add your code here
        OrderItemForm orderItemForm = new OrderItemForm();
        orderItemForm.setVisible(true);
    }

    private void orderManagementMenuItem2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        OrderItemsForm orderItemsForm = new OrderItemsForm();
        orderItemsForm.setVisible(true);
    }

    private void exitMenuActionPerformed(ActionEvent e) {
        // TODO add your code here
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
    }

    private void exitMenuMouseClicked(MouseEvent e) {
        // TODO add your code here
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
        this.setVisible(false);
    }

    private void userManagementMenuItemActionPerformed(ActionEvent e) {
        // TODO add your code here
//        用户修改界面跳转
        UserUpdateForm userUpdateForm = new UserUpdateForm();
        userUpdateForm.setVisible(true);
    }

    private void ideaManagementMenuItemActionPerformed(ActionEvent e) {
        // TODO add your code here
        AdnimIdeaForm adnimIdeaForm = new AdnimIdeaForm();
        adnimIdeaForm.setVisible(true);
    }

    private void updateInfomenuItemActionPerformed(ActionEvent e) {
        // TODO add your code here
//        管理员信息修改
        UpdateAdminForm updateAdminForm = new UpdateAdminForm();
        updateAdminForm.setVisible(true);
    }

    private void menuItem1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        BookTypeForm bookTypeForm = new BookTypeForm();
        bookTypeForm.setVisible(true);

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        CommodityManagementMenu = new JMenu();
        commodityManagementMenuItem = new JMenuItem();
        menuItem1 = new JMenuItem();
        orderManagementMenu = new JMenu();
        orderManagementMenuItem = new JMenuItem();
        orderManagementMenuItem2 = new JMenuItem();
        userManagementMenu = new JMenu();
        userManagementMenuItem = new JMenuItem();
        ideaManagementMenu = new JMenu();
        ideaManagementMenuItem = new JMenuItem();
        adminSetting = new JMenu();
        updateInfomenuItem = new JMenuItem();
        registerMenuItem6 = new JMenuItem();
        exitMenu = new JMenu();
        label1 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {

            //======== CommodityManagementMenu ========
            {
                CommodityManagementMenu.setText("\u5546\u54c1\u7ba1\u7406");

                //---- commodityManagementMenuItem ----
                commodityManagementMenuItem.setText("\u5546\u54c1\u5c5e\u6027\u7ba1\u7406");
                commodityManagementMenuItem.addActionListener(e -> commodityManagementMenuItemActionPerformed(e));
                CommodityManagementMenu.add(commodityManagementMenuItem);

                //---- menuItem1 ----
                menuItem1.setText("\u5546\u54c1\u7c7b\u522b\u7ba1\u7406");
                menuItem1.addActionListener(e -> menuItem1ActionPerformed(e));
                CommodityManagementMenu.add(menuItem1);
            }
            menuBar1.add(CommodityManagementMenu);

            //======== orderManagementMenu ========
            {
                orderManagementMenu.setText("\u8ba2\u5355\u7ba1\u7406");

                //---- orderManagementMenuItem ----
                orderManagementMenuItem.setText("\u7528\u6237\u8ba2\u5355\u7ba1\u7406");
                orderManagementMenuItem.addActionListener(e -> orderManagementMenuItemActionPerformed(e));
                orderManagementMenu.add(orderManagementMenuItem);

                //---- orderManagementMenuItem2 ----
                orderManagementMenuItem2.setText("\u7528\u6237\u8ba2\u5355\u9879\u7ba1\u7406");
                orderManagementMenuItem2.addActionListener(e -> orderManagementMenuItem2ActionPerformed(e));
                orderManagementMenu.add(orderManagementMenuItem2);
            }
            menuBar1.add(orderManagementMenu);

            //======== userManagementMenu ========
            {
                userManagementMenu.setText("\u7528\u6237\u7ba1\u7406");

                //---- userManagementMenuItem ----
                userManagementMenuItem.setText("\u7528\u6237\u4fe1\u606f\u4fee\u6539");
                userManagementMenuItem.addActionListener(e -> userManagementMenuItemActionPerformed(e));
                userManagementMenu.add(userManagementMenuItem);
            }
            menuBar1.add(userManagementMenu);

            //======== ideaManagementMenu ========
            {
                ideaManagementMenu.setText("\u610f\u89c1\u7ba1\u7406");

                //---- ideaManagementMenuItem ----
                ideaManagementMenuItem.setText("\u610f\u89c1\u4fe1\u606f\u7ba1\u7406");
                ideaManagementMenuItem.addActionListener(e -> ideaManagementMenuItemActionPerformed(e));
                ideaManagementMenu.add(ideaManagementMenuItem);
            }
            menuBar1.add(ideaManagementMenu);

            //======== adminSetting ========
            {
                adminSetting.setText("\u7ba1\u7406\u5458\u8bbe\u7f6e");

                //---- updateInfomenuItem ----
                updateInfomenuItem.setText("\u4fee\u6539\u4fe1\u606f");
                updateInfomenuItem.addActionListener(e -> updateInfomenuItemActionPerformed(e));
                adminSetting.add(updateInfomenuItem);

                //---- registerMenuItem6 ----
                registerMenuItem6.setText("\u6ce8\u518c\u7ba1\u7406\u5458");
                adminSetting.add(registerMenuItem6);
            }
            menuBar1.add(adminSetting);

            //======== exitMenu ========
            {
                exitMenu.setText("\u9000\u51fa");
                exitMenu.addActionListener(e -> exitMenuActionPerformed(e));
                exitMenu.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        exitMenuMouseClicked(e);
                    }
                });
            }
            menuBar1.add(exitMenu);
        }
        setJMenuBar(menuBar1);

        //---- label1 ----
        label1.setText("\u7ba1\u7406\u5458\u754c\u9762");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 20f));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(195, 100, 305, 145);

        contentPane.setPreferredSize(new Dimension(700, 530));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;
    private JMenu CommodityManagementMenu;
    private JMenuItem commodityManagementMenuItem;
    private JMenuItem menuItem1;
    private JMenu orderManagementMenu;
    private JMenuItem orderManagementMenuItem;
    private JMenuItem orderManagementMenuItem2;
    private JMenu userManagementMenu;
    private JMenuItem userManagementMenuItem;
    private JMenu ideaManagementMenu;
    private JMenuItem ideaManagementMenuItem;
    private JMenu adminSetting;
    private JMenuItem updateInfomenuItem;
    private JMenuItem registerMenuItem6;
    private JMenu exitMenu;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
