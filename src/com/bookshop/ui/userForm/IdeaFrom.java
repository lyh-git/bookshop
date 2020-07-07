/*
 * Created by JFormDesigner on Thu Jul 02 13:23:02 CST 2020
 */

package com.bookshop.ui.userForm;

import com.bookshop.dao.impl.UserDaoImpl;
import com.bookshop.entity.Ideas;
import com.bookshop.service.impl.IdeaServiceImpl;
import com.bookshop.service.impl.UserServiceImpl;
import com.bookshop.util.UserData;

import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import javax.swing.*;

/**
 * @author °Ëµã°ë
 */
public class IdeaFrom extends JFrame {
    public static void main(String[] args) {
        IdeaFrom ideaFrom = new IdeaFrom();
        ideaFrom.setVisible(true);
    }
    public IdeaFrom() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
//        意见发送
        String title =textField2.getText().trim();
        String text = textField1.getText().trim();
        if ("".equals(title)||"".equals(text)){
            JOptionPane.showMessageDialog(null, "提示：标题和正文都不能为空");
        }else {
            IdeaServiceImpl ideaService = new IdeaServiceImpl();
            String time = new Date(System.currentTimeMillis()).toString();
            String loginName = new UserServiceImpl().queryById(UserData.userId).getLoginName();

            Ideas ideas = new Ideas(title, text, time, loginName);
            if(ideaService.insert(ideas)>0){
                JOptionPane.showMessageDialog(null, "提示：发送成功");
            }else {
                JOptionPane.showMessageDialog(null, "提示：发送失败");
            }
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        label3 = new JLabel();
        textField2 = new JTextField();
        label4 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u610f\u89c1\u7559\u8a00");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(95, 5), label1.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(50, 115, 185, 265);

        //---- button1 ----
        button1.setText("\u53d1\u9001");
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(95, 395), button1.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u6807\u9898");
        contentPane.add(label3);
        label3.setBounds(15, 50, 50, label3.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(45, 45, 180, textField2.getPreferredSize().height);

        //---- label4 ----
        label4.setText("\u6b63\u6587");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(15, 90), label4.getPreferredSize()));

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
    private JTextField textField1;
    private JButton button1;
    private JLabel label3;
    private JTextField textField2;
    private JLabel label4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
