/*
 * Created by JFormDesigner on Wed Jul 08 21:48:28 CST 2020
 */

package com.bookshop.ui.userForm;

import java.awt.event.*;
import com.bookshop.entity.Book;
import com.bookshop.entity.BookList;
import com.bookshop.service.impl.BookListServiceImpl;
import com.bookshop.util.UserData;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author °Ëµã°ë
 */
public class BookListForm extends JFrame {
    public static void main(String[] args) {
        BookListForm bookListForm = new BookListForm();
        bookListForm.setVisible(true);
    }
    BookListServiceImpl bookListService=new BookListServiceImpl();
    public BookListForm() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
//        刷新
        showData();
    }

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        showData();
//        String name = textField1.getText().trim();
//        JythonTest.main1(name);
//        JOptionPane.showMessageDialog(null, "提示：数据获取成功,请刷新");
    }

    private void button3ActionPerformed(ActionEvent e) {
        // TODO add your code here
//        插入
        String name = textField1.getText().trim();
        JythonTest.main1(name);
        JOptionPane.showMessageDialog(null, "提示：数据获取成功,请刷新");
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        textField1 = new JTextField();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                },
                new String[] {
                    "ID", "\u4e66\u540d", "\u94fe\u63a5", "\u51fa\u7248\u793e", "\u8bc4\u5206", "\u8bc4\u8bba\u6570\u91cf", "\u7b80\u4ecb"
                }
            ) {
                boolean[] columnEditable = new boolean[] {
                    false, false, false, false, false, false, false
                };
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(15, 30, 690, 355);

        //---- button1 ----
        button1.setText("\u5237\u65b0");
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(70, 395), button1.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(265, 400, 95, textField1.getPreferredSize().height);

        //---- button2 ----
        button2.setText("\u67e5\u8be2");
        button2.addActionListener(e -> button2ActionPerformed(e));
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(400, 400), button2.getPreferredSize()));

        //---- button3 ----
        button3.setText("\u63d2\u5165");
        button3.addActionListener(e -> button3ActionPerformed(e));
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(180, 400), button3.getPreferredSize()));
        if ("user".equals(UserData.Sign)) {
            button3.setVisible(false);
        }
        contentPane.setPreferredSize(new Dimension(720, 470));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    private String[][] select() {
        List<BookList> bookLists;
        bookLists = bookListService.queryByName(textField1.getText().trim());
        
        String[][] datas = new String[bookLists.size()][6];
        for (int i = 0; i < datas.length; i++) {
            datas[i][0] = bookLists.get(i).getName();
            datas[i][1] = bookLists.get(i).getLink();
            datas[i][2] = bookLists.get(i).getPublicer().toString();
            datas[i][3] = bookLists.get(i).getGrade();
            datas[i][4] = bookLists.get(i).getNum();
            datas[i][5] = bookLists.get(i).getContent().toString();
            

        }
        return datas;
    }
    public void showData(){
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                   select(),
                    new String[] {
                             "\u4e66\u540d", "\u94fe\u63a5", "\u51fa\u7248\u793e", "\u8bc4\u5206", "\u8bc4\u8bba\u6570\u91cf", "\u7b80\u4ecb"
                    }
            ) {
                boolean[] columnEditable = new boolean[] {
                         false, false, false, false, false, false
                };
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });

            scrollPane1.setViewportView(table1);

        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JTextField textField1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
