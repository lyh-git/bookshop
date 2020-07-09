/*
 * Created by JFormDesigner on Thu Jul 02 12:13:33 CST 2020
 */

package com.bookshop.ui.userForm;

import java.awt.event.*;

import com.bookshop.entity.Book;
import com.bookshop.entity.Cart;
import com.bookshop.entity.Order;
import com.bookshop.service.impl.BookServiceImpl;
import com.bookshop.service.impl.CartServiceImpl;
import com.bookshop.service.impl.OrderServiceImpl;
import com.bookshop.util.UserData;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author °Ëµã°ë
 */
public class ShopingCatForm extends JFrame {
    public static void main(String[] args) {
        ShopingCatForm shopingCatForm = new ShopingCatForm();
        shopingCatForm.setVisible(true);
    }

    int userId = UserData.userId;
    Book book;
    BookServiceImpl bookService = new BookServiceImpl();
    CartServiceImpl cartService = new CartServiceImpl();

    double priceSum;


    public ShopingCatForm() {
        initComponents();
    }

    public void click() {
        table1.setModel(new DefaultTableModel(
                select(),
                new String[]{
                        "ID", "bookID", "\u56fe\u4e66\u540d\u79f0", "\u56fe\u4e66\u4ef7\u683c", "\u56fe\u4e66\u6570\u91cf", "\u56fe\u4e66\u603b\u4ef7\u683c","状态"
                }
        ) {

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        scrollPane1.setViewportView(table1);


    }

    private String[][] select() {

        List<Cart> carts = cartService.queryAllByUserId(userId);

        String[][] datas = new String[carts.size()][7];
        for (int i = 0; i < datas.length; i++) {
            datas[i][0] = carts.get(i).getId().toString();
            datas[i][1] = carts.get(i).getBookId().toString();
            datas[i][2] = carts.get(i).getBookName();
            datas[i][3] = carts.get(i).getBookPrice().toString();
            datas[i][4] = carts.get(i).getBookNum().toString();
            book = bookService.queryById(carts.get(i).getBookId());
            Double discount = book.getDiscount();
            priceSum = carts.get(i).getBookPrice() * carts.get(i).getBookNum() * discount;
            datas[i][5] = (carts.get(i).getBookPrice() * carts.get(i).getBookNum() * discount) + "";
            datas[i][6] = book.getFlag().toString();

        }
        //---- table1 ---
        return datas;
    }

    private void button1ActionPerformed(ActionEvent e) {

        int index = table1.getSelectedRow();
        // 如果下标不为-1，则选中行为数据行
        if (index != -1) {
            // 取得表格对象的数据模型
            TableModel model = table1.getModel();
            // 在表格对象模型中，根据选中的行和列，获取相应的数据值
            Integer id = Integer.parseInt(model.getValueAt(index, 0).toString());
            Integer bookId = Integer.parseInt(model.getValueAt(index, 1).toString());
            Integer bookNum = Integer.parseInt(spinner1.getValue().toString());
            Double bookPrice = Double.parseDouble(model.getValueAt(index, 3).toString());
            String bookName = model.getValueAt(index, 2).toString();


            Cart cart = new Cart(id, userId, bookId, bookNum, bookPrice, bookName);
            if (cartService.update(cart) > 0) {
                JOptionPane.showMessageDialog(null, "提示：" + cart.getBookName() + "修改成功！");
                click();
            } else {
                JOptionPane.showMessageDialog(null, "提示：修改失败！");
            }
        } else {
            JOptionPane.showMessageDialog(null, "提示：请选择需要修改的书籍！");
        }


    }

    private void delButtonActionPerformed(ActionEvent e) {
        int index = table1.getSelectedRow();
        // 如果下标不为-1，则选中行为数据行
        if (index != -1) {
            // 取得表格对象的数据模型
            TableModel model = table1.getModel();
            // 在表格对象模型中，根据选中的行和列，获取相应的数据值
            Integer id = Integer.parseInt(model.getValueAt(index, 0).toString());

            if (cartService.delete(id) > 0) {
                JOptionPane.showMessageDialog(null, "提示：删除成功！");
                click();
            } else {
                JOptionPane.showMessageDialog(null, "提示：删除失败！");
            }
        } else {
            JOptionPane.showMessageDialog(null, "提示：请选择需要删除的书籍！");
        }
    }

    private void clearButton3ActionPerformed(ActionEvent e) {
        // 清空事件
        JOptionPane.showMessageDialog(null, "提示：确定清空购物车?");
        cartService.clearCart(userId);
        click();
        JOptionPane.showMessageDialog(null, "提示：清空成功！");

    }

    //结算
    private void settleAccountsbutton2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        int[] selectedRows = table1.getSelectedRows();
        UserData.arr = new String[selectedRows.length][7];
        double priceSums = 0.0;
        if (selectedRows.length > 0) {
            for (int index = 0; index < selectedRows.length; index++) {

                // 取得表格对象的数据模型
                TableModel model = table1.getModel();
                Integer id = Integer.parseInt(model.getValueAt(index, 0).toString());
                // 在表格对象模型中，根据选中的行和列，获取相应的数据值
                UserData.arr[index][0] = (model.getValueAt(index, 0)).toString();
                System.out.println(UserData.arr[index][0]);
                UserData.arr[index][1] = (model.getValueAt(index, 1)).toString();
                UserData.arr[index][2] = (model.getValueAt(index, 2)).toString();
                UserData.arr[index][3] = (model.getValueAt(index, 3)).toString();
                UserData.arr[index][4] = (model.getValueAt(index, 4)).toString();
                UserData.arr[index][5] = (model.getValueAt(index, 5)).toString();
                UserData.arr[index][6] = (model.getValueAt(index, 6)).toString();
                cartService.delete(id);
            }

            click();
        }
        OrderForm orderForm = new OrderForm();
        orderForm.click();
        this.setVisible(false);
        orderForm.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        settleAccountsbutton2 = new JButton();
        spinner1 = new JSpinner();
        delButton = new JButton();
        clearButton3 = new JButton();

        //======== this ========
        setTitle("\u8d2d\u7269\u8f66");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                },
                new String[] {
                    "ID", "bookID", "\u56fe\u4e66\u540d\u79f0", "\u56fe\u4e66\u4ef7\u683c", "\u56fe\u4e66\u6570\u91cf", "\u56fe\u4e66\u603b\u4ef7\u683c"
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
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(50, 15, 625, 310);

        //---- button1 ----
        button1.setText("\u4fee\u6539");
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(160, 345), button1.getPreferredSize()));

        //---- settleAccountsbutton2 ----
        settleAccountsbutton2.setText("\u7ed3\u7b97");
        settleAccountsbutton2.addActionListener(e -> settleAccountsbutton2ActionPerformed(e));
        contentPane.add(settleAccountsbutton2);
        settleAccountsbutton2.setBounds(new Rectangle(new Point(585, 345), settleAccountsbutton2.getPreferredSize()));

        //---- spinner1 ----
        spinner1.setModel(new SpinnerNumberModel(1, 1, 50, 1));
        contentPane.add(spinner1);
        spinner1.setBounds(30, 345, 128, spinner1.getPreferredSize().height);

        //---- delButton ----
        delButton.setText("\u5220\u9664");
        delButton.addActionListener(e -> delButtonActionPerformed(e));
        contentPane.add(delButton);
        delButton.setBounds(new Rectangle(new Point(295, 345), delButton.getPreferredSize()));

        //---- clearButton3 ----
        clearButton3.setText("\u6e05\u7a7a");
        clearButton3.addActionListener(e -> clearButton3ActionPerformed(e));
        contentPane.add(clearButton3);
        clearButton3.setBounds(new Rectangle(new Point(435, 345), clearButton3.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(725, 435));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton settleAccountsbutton2;
    private JSpinner spinner1;
    private JButton delButton;
    private JButton clearButton3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
