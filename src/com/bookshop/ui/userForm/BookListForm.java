/*
 * Created by JFormDesigner on Wed Jul 08 21:48:28 CST 2020
 */

package com.bookshop.ui.userForm;

import java.awt.event.*;
import com.bookshop.entity.Book;
import com.bookshop.entity.BookList;
import com.bookshop.service.impl.BookListServiceImpl;

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

        contentPane.setPreferredSize(new Dimension(720, 470));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    private String[][] select() {
        List<BookList> bookLists;
        bookLists = bookListService.queryAll();
        
        String[][] datas = new String[bookLists.size()][7];
        for (int i = 0; i < datas.length; i++) {
            datas[i][0] = bookLists.get(i).getId().toString();
            datas[i][1] = bookLists.get(i).getName();
            datas[i][2] = bookLists.get(i).getLink();
            datas[i][3] = bookLists.get(i).getPublicer().toString();
            datas[i][4] = bookLists.get(i).getGrade();
            datas[i][5] = bookLists.get(i).getNum();
            datas[i][6] = bookLists.get(i).getContent().toString();
            

        }
        return datas;
    }
    public void showData(){
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                   select(),
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
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
