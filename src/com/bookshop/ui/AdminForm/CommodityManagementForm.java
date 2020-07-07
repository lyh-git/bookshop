/*
 * Created by JFormDesigner on Sat Jul 04 10:07:55 CST 2020
 */

package com.bookshop.ui.AdminForm;

import java.awt.event.*;

import com.bookshop.entity.Book;
import com.bookshop.service.BookService;
import com.bookshop.service.impl.BookServiceImpl;
import com.bookshop.util.UserData;

import java.awt.*;
import java.sql.Date;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author °Ëµã°ë
 */
public class CommodityManagementForm extends JFrame {

    public static void main(String[] args) {
        CommodityManagementForm commodityManagementForm = new CommodityManagementForm();
        commodityManagementForm.setVisible(true);

    }

    public BookService bookService = new BookServiceImpl();

    public CommodityManagementForm() {
        initComponents();
    }

    public String[][] selectBook() {
        List<Book> books;
        Object selectedItem = selectBomboBox1.getSelectedItem();
        String text = textField1.getText();
        if (selectedItem.equals("书名")) {
            books = bookService.queryByName(text);

        } else {
            books = bookService.queryAll();
        }

        String[][] datas = new String[books.size()][11];
        for (int i = 0; i < books.size(); i++) {
            datas[i][0] = books.get(i).getId().toString();
            datas[i][1] = books.get(i).getName();
            datas[i][2] = books.get(i).getAuthor();
            datas[i][3] = books.get(i).getPublisher();
            datas[i][4] = books.get(i).getPrice().toString();
            datas[i][5] = books.get(i).getType();
            datas[i][6] = books.get(i).getDisc();
            datas[i][7] = books.get(i).getDiscount().toString();
            datas[i][8] = books.get(i).getStore().toString();
            datas[i][9] = books.get(i).getFlag().toString();
            datas[i][10] = books.get(i).getCreateTime();


        }
        return datas;

    }

    public void showData() {


        //---- table1 ----
        table1.setModel(new DefaultTableModel(
                selectBook(),
                new String[]{
                        "ID", "\u4e66\u540d", "\u4f5c\u8005", "\u51fa\u7248\u793e", "\u4ef7\u683c", "\u7c7b\u578b", "\u662f\u5426\u6709\u5149\u789f", "\u6298\u6263", "\u5e93\u5b58", "\u662f\u5426\u4e0b\u67b6", "\u521b\u5efa\u65f6\u95f4"
                }
        ));
        bookScrollPane1.setViewportView(table1);

    }

    private void selectButton1ActionPerformed(ActionEvent e) {
        // TODO add your code here 查询
        showData();
    }

    private void updateButton2ActionPerformed(ActionEvent e) {
        // TODO add your code here
//        修改书籍
        int index = table1.getSelectedRow();
        if (index != -1) {
            // 取得表格对象的数据模型
            TableModel model = table1.getModel();
            String name="未填", author="未填", pulisher="未填", typeId="-1", disc="无", time=new Date(System.currentTimeMillis()).toString();
            int id=0,store=100, flage=1;
            double price=1000000, discount=1;
            try {
                // 在表格对象模型中，根据选中的行和列，获取相应的数据值
                id = Integer.parseInt(model.getValueAt(index, 0).toString());
                name = (model.getValueAt(index, 1)).toString();
                author = (model.getValueAt(index, 2)).toString();
                pulisher = (model.getValueAt(index, 3)).toString() + " ";
                price = Double.parseDouble(model.getValueAt(index, 4).toString());
                typeId = (model.getValueAt(index, 5).toString());
                disc=(model.getValueAt(index, 6).toString());
                discount = Double.parseDouble(model.getValueAt(index, 7).toString());
                store = Integer.parseInt(model.getValueAt(index, 8).toString());
                flage = Integer.parseInt(model.getValueAt(index, 9).toString());
                time=(model.getValueAt(index, 10).toString());
            } catch (Exception es) {
                es.printStackTrace();
                JOptionPane.showMessageDialog(null, "提示：有选项没填,已经选择默认值");
            }

            Book book1 = new Book(id, name, author, pulisher, price, typeId, disc, discount, store, flage, time);
            if (bookService.update(book1) > 0) {
                JOptionPane.showMessageDialog(null, "提示：修改成功！");
            } else {
                JOptionPane.showMessageDialog(null, "提示：修改失败！");
            }
//


        } else {
            JOptionPane.showMessageDialog(null, "提示：请选择ID！");
        }
        showData();
    }

    private void button5ActionPerformed(ActionEvent e) {
        // TODO add your code here
        List<Book> books1;
        books1 = bookService.queryAll();

        String[][] datas = new String[books1.size()+1][11];
        for (int i = 0; i < books1.size(); i++) {
            datas[i][0] = books1.get(i).getId().toString();
            datas[i][1] = books1.get(i).getName();
            datas[i][2] = books1.get(i).getAuthor();
            datas[i][3] = books1.get(i).getPublisher();
            datas[i][4] = books1.get(i).getPrice().toString();
            datas[i][5] = books1.get(i).getType();
            datas[i][6] = books1.get(i).getDisc();
            datas[i][7] = books1.get(i).getDiscount().toString();
            datas[i][8] = books1.get(i).getStore().toString();
            datas[i][9] = books1.get(i).getFlag().toString();
            datas[i][10] = books1.get(i).getCreateTime();


        }
        //---- table1 ----
        table1.setModel(new DefaultTableModel(
                datas,
                new String[]{
                        "ID", "\u4e66\u540d", "\u4f5c\u8005", "\u51fa\u7248\u793e", "\u4ef7\u683c", "\u7c7b\u578b", "\u662f\u5426\u6709\u5149\u789f", "\u6298\u6263", "\u5e93\u5b58", "\u662f\u5426\u4e0b\u67b6", "\u521b\u5efa\u65f6\u95f4"
                }
        ));
        bookScrollPane1.setViewportView(table1);
    }

    private void button3ActionPerformed(ActionEvent e) {
        // TODO add your code here
//        增加书籍

        int index = table1.getSelectedRow();

        System.out.println(table1.getRowCount());

        // 取得表格对象的数据模型
        TableModel model = table1.getModel();
        String name = "无", author = "", pulisher = "无", typeId = "-1", disc = "无", time = new Date(System.currentTimeMillis()).toString();
        ;
        int store = 100, flage = 1;
        double price = 100000, discount = 1;
        if (index!=-1) {
            try {
                // 在表格对象模型中，根据选中的行和列，获取相应的数据值

                name = (model.getValueAt(index, 1)).toString();
                author = (model.getValueAt(index, 2)).toString();
                pulisher = (model.getValueAt(index, 3)).toString() + " ";
                price = Double.parseDouble(model.getValueAt(index, 4).toString());
                typeId = (model.getValueAt(index, 5).toString());
                disc = (model.getValueAt(index, 6).toString());
                discount = Double.parseDouble(model.getValueAt(index, 7).toString());
                store = Integer.parseInt(model.getValueAt(index, 8).toString());
                flage = Integer.parseInt(model.getValueAt(index, 9).toString());
                time = (model.getValueAt(index, 10).toString());
            } catch (Exception es) {
                JOptionPane.showMessageDialog(null, "提示：有选项没填,已经选择默认值");
            }
            Book book1 = new Book(name, author, pulisher, price, typeId, disc, discount, store, flage, time);
            if (bookService.insert(book1) > 0) {
                JOptionPane.showMessageDialog(null, "提示：添加成功！");
            } else {
                JOptionPane.showMessageDialog(null, "提示：添加失败！");
            }
        }else {
            JOptionPane.showMessageDialog(null, "提示：请选择添加行！");
        }
        showData();


    }
    private void button4ActionPerformed(ActionEvent e) {
        // TODO add your code here
//        删除

        int[] selectedRows = table1.getSelectedRows();
        if (selectedRows.length > 0) {
            for (int index = 0; index < selectedRows.length; index++) {
                // 取得表格对象的数据模型
                TableModel model = table1.getModel();
                // 在表格对象模型中，根据选中的行和列，获取相应的数据值
                int id = Integer.parseInt(model.getValueAt(selectedRows[index], 0).toString());
                bookService.delete(id);

            }
            JOptionPane.showMessageDialog(null, "提示：删除成功！");
        }else {
            JOptionPane.showMessageDialog(null, "提示：删除失败！");
            JOptionPane.showMessageDialog(null, "提示：请选择ID！");
        }

        showData();


    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        bookScrollPane1 = new JScrollPane();
        table1 = new JTable();
        selectButton1 = new JButton();
        updateButton2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        selectBomboBox1 = new JComboBox<>();
        textField1 = new JTextField();
        button5 = new JButton();

        //======== this ========
        setTitle("\u4e66\u672c\u7ba1\u7406");
        setBackground(SystemColor.inactiveCaptionBorder);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== bookScrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, "", null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null, null},
                },
                new String[] {
                    "ID", "\u4e66\u540d", "\u4f5c\u8005", "\u51fa\u7248\u793e", "\u4ef7\u683c", "\u7c7b\u578b", "\u662f\u5426\u6709\u5149\u789f", "\u6298\u6263", "\u5e93\u5b58", "\u662f\u5426\u4e0b\u67b6", "\u521b\u5efa\u65f6\u95f4"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    Integer.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
                };
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
            });
            bookScrollPane1.setViewportView(table1);
        }
        contentPane.add(bookScrollPane1);
        bookScrollPane1.setBounds(10, 40, 760, 370);

        //---- selectButton1 ----
        selectButton1.setText("\u67e5\u8be2");
        selectButton1.addActionListener(e -> selectButton1ActionPerformed(e));
        contentPane.add(selectButton1);
        selectButton1.setBounds(new Rectangle(new Point(310, 430), selectButton1.getPreferredSize()));

        //---- updateButton2 ----
        updateButton2.setText("\u4fee\u6539");
        updateButton2.addActionListener(e -> updateButton2ActionPerformed(e));
        contentPane.add(updateButton2);
        updateButton2.setBounds(new Rectangle(new Point(430, 430), updateButton2.getPreferredSize()));

        //---- button3 ----
        button3.setText("\u589e\u52a0\u56fe\u4e66");
        button3.addActionListener(e -> button3ActionPerformed(e));
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(545, 430), button3.getPreferredSize()));

        //---- button4 ----
        button4.setText("\u5220\u9664");
        button4.addActionListener(e -> button4ActionPerformed(e));
        contentPane.add(button4);
        button4.setBounds(new Rectangle(new Point(660, 430), button4.getPreferredSize()));

        //---- selectBomboBox1 ----
        selectBomboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "\u4e66\u540d",
            "\u4f5c\u8005",
            "\u4ef7\u683c"
        }));
        contentPane.add(selectBomboBox1);
        selectBomboBox1.setBounds(new Rectangle(new Point(65, 425), selectBomboBox1.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(170, 435, 115, textField1.getPreferredSize().height);

        //---- button5 ----
        button5.setText("+");
        button5.setFont(button5.getFont().deriveFont(button5.getFont().getSize() + 8f));
        button5.setForeground(Color.black);
        button5.setBackground(Color.white);
        button5.addActionListener(e -> button5ActionPerformed(e));
        contentPane.add(button5);
        button5.setBounds(new Rectangle(new Point(10, 10), button5.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(790, 520));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane bookScrollPane1;
    private JTable table1;
    private JButton selectButton1;
    private JButton updateButton2;
    private JButton button3;
    private JButton button4;
    private JComboBox<String> selectBomboBox1;
    private JTextField textField1;
    private JButton button5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
