/*
 * Created by JFormDesigner on Mon Jul 06 10:49:28 CST 2020
 */

package com.bookshop.ui.AdminForm;

import com.bookshop.dao.impl.BookTypeDaoImpl;
import com.bookshop.entity.Book;
import com.bookshop.entity.BookType;
import com.bookshop.service.impl.BookServiceImpl;
import com.bookshop.service.impl.BookTypeServiceImpl;

import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author °Ëµã°ë
 */
public class BookTypeForm extends JFrame {
    public static void main(String[] args) {
        BookTypeForm bookTypeForm = new BookTypeForm();
        bookTypeForm.setVisible(true);
    }

    BookType bookType = new BookType();
    BookTypeServiceImpl bookTypeService = new BookTypeServiceImpl();

    public BookTypeForm() {
        initComponents();
    }

    public String[][] selectBook() {
        List<BookType> bookTypes;
        bookTypes = bookTypeService.queryAll();
        String[][] datas = new String[bookTypes.size()][11];
        for (int i = 0; i < bookTypes.size(); i++) {
            datas[i][0] = bookTypes.get(i).getId().toString();
            datas[i][1] = bookTypes.get(i).getType();
            datas[i][2] = bookTypes.get(i).getCreateTime();


        }
        return datas;

    }

    public void showData() {


        //---- table1 ----
        table1.setModel(new DefaultTableModel(
                selectBook(),
                new String[]{
                        "ID", "\u7c7b\u578b", "\u521b\u5efa\u65f6\u95f4"
                }
        ));
        scrollPane1.setViewportView(table1);

    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
//        图书类别查询
        showData();

    }

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        //        修改书籍
        int index = table1.getSelectedRow();
        if (index != -1) {
            // 取得表格对象的数据模型
            TableModel model = table1.getModel();
            int id = Integer.parseInt(model.getValueAt(index, 0).toString());
            String type = (model.getValueAt(index, 1)).toString();
            String time = new Date(System.currentTimeMillis()).toString();
            bookType.setId(id);
            bookType.setCreateTime(time);
            bookType.setType(type);
            if (bookTypeService.update(bookType) > 0) {
                JOptionPane.showMessageDialog(null, "提示：修改成功！");
                showData();
            } else {
                JOptionPane.showMessageDialog(null, "提示：修改失败！");
            }
        }
    }

    private void button3ActionPerformed(ActionEvent e) {
        // TODO add your code here
//        增加
        int index = table1.getSelectedRow();
        if (index != -1) {
            // 取得表格对象的数据模型
            TableModel model = table1.getModel();
//            int id = Integer.parseInt(model.getValueAt(index, 0).toString());
            if ((model.getValueAt(index, 1)) == null) {
                JOptionPane.showMessageDialog(null, "提示：类型不能为空！");
            } else {
                String type = (model.getValueAt(index, 1)).toString();
                String time = new Date(System.currentTimeMillis()).toString();
//            bookType.setId(id);
                bookType.setCreateTime(time);
                bookType.setType(type);
                if (bookTypeService.insert(bookType) > 0) {
                    JOptionPane.showMessageDialog(null, "提示：修改成功！");
                    showData();
                } else {
                    JOptionPane.showMessageDialog(null, "提示：修改失败！");
                }
            }

        }
    }

    private void button5ActionPerformed(ActionEvent e) {
        // TODO add your code here
//        添加一行
        List<BookType> bookTypes;
        bookTypes = bookTypeService.queryAll();
        String[][] datas = new String[bookTypes.size() + 1][4];
        for (int i = 0; i < bookTypes.size(); i++) {
            datas[i][0] = bookTypes.get(i).getId().toString();
            datas[i][1] = bookTypes.get(i).getType();
            datas[i][2] = bookTypes.get(i).getCreateTime();
        }
        table1.setModel(new DefaultTableModel(
                datas,
                new String[]{
                        "ID", "\u7c7b\u578b", "\u521b\u5efa\u65f6\u95f4"
                }
        ));
        scrollPane1.setViewportView(table1);
    }

    private void button4ActionPerformed(ActionEvent e) {
        // TODO add your code here
//        删除
        int index = table1.getSelectedRow();
        if (index != -1) {
            // 取得表格对象的数据模型
            TableModel model = table1.getModel();
            int id = Integer.parseInt(model.getValueAt(index, 0).toString());
            bookType.setId(id);
            if (bookTypeService.delete(id) > 0) {
                JOptionPane.showMessageDialog(null, "提示：删除成功！");
                showData();
            } else {
                JOptionPane.showMessageDialog(null, "提示：删除失败！");
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {"", null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                },
                new String[] {
                    "ID", "\u7c7b\u578b", "\u521b\u5efa\u65f6\u95f4"
                }
            ));
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(15, 45, 730, 380);

        //---- button1 ----
        button1.setText("\u67e5\u8be2");
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(85, 445), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u4fee\u6539");
        button2.addActionListener(e -> button2ActionPerformed(e));
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(230, 450), button2.getPreferredSize()));

        //---- button3 ----
        button3.setText("\u589e\u52a0");
        button3.addActionListener(e -> button3ActionPerformed(e));
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(370, 450), button3.getPreferredSize()));

        //---- button4 ----
        button4.setText("\u5220\u9664");
        button4.addActionListener(e -> button4ActionPerformed(e));
        contentPane.add(button4);
        button4.setBounds(new Rectangle(new Point(525, 450), button4.getPreferredSize()));

        //---- button5 ----
        button5.setText("  +  ");
        button5.setFont(button5.getFont().deriveFont(button5.getFont().getSize() + 6f));
        button5.addActionListener(e -> button5ActionPerformed(e));
        contentPane.add(button5);
        button5.setBounds(new Rectangle(new Point(15, 15), button5.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(765, 530));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
