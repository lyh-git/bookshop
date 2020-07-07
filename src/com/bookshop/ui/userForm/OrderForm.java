/*
 * Created by JFormDesigner on Fri Jul 03 12:25:52 CST 2020
 */

package com.bookshop.ui.userForm;

import java.awt.event.*;

import com.bookshop.entity.Book;
import com.bookshop.entity.Cart;
import com.bookshop.entity.Order;
import com.bookshop.entity.OrderItem;
import com.bookshop.service.impl.BookServiceImpl;
import com.bookshop.service.impl.CartServiceImpl;
import com.bookshop.service.impl.OrderItemServiceImpl;
import com.bookshop.service.impl.OrderServiceImpl;
import com.bookshop.util.UserData;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author °Ëµã°ë
 */
public class OrderForm extends JFrame {
    public static void main(String[] args) {
        OrderForm orderForm = new OrderForm();
        orderForm.setVisible(true);

    }

    int last_id;


    OrderServiceImpl orderService = new OrderServiceImpl();
    Order order = new Order();
    int userId = UserData.userId;
    CartServiceImpl cartService = new CartServiceImpl();

    public void click() {
        orderTable.setModel(new DefaultTableModel(
                UserData.arr,
                new String[]{
                        "ID", "bookID", "\u56fe\u4e66\u540d\u79f0", "\u56fe\u4e66\u4ef7\u683c", "\u56fe\u4e66\u6570\u91cf", "\u56fe\u4e66\u603b\u4ef7\u683c","状态"
                }
        ) {

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        scrollPane1.setViewportView(orderTable);


    }

    private String[][] select() {

        List<Order> orders = orderService.queryAll();

        String[][] datas = UserData.arr;
        //---- table1 ---
        return datas;
    }

    public OrderForm() {
        initComponents();
        click();
    }

    //提交订单
    private void button1ActionPerformed(ActionEvent e) {


        //        int index = table1.getSelectedRow();
        // 如果下标不为-1，则选中行为数据行
        int[] selectedRows = orderTable.getSelectedRows();
        double priceSums = 0.0;
        int remainder=0;
        Book book1=null;
        BookServiceImpl bookService=null;
        OrderItemServiceImpl orderItemService = new OrderItemServiceImpl();
        if (selectedRows.length > 0) {
            for (int index = 0; index < selectedRows.length; index++) {
                // 取得表格对象的数据模型
                TableModel model = orderTable.getModel();
                // 在表格对象模型中，根据选中的行和列，获取相应的数据值
                int booknum=Integer.parseInt(model.getValueAt(index, 4).toString());
                Integer bookId = Integer.parseInt(model.getValueAt(index, 1).toString());

                priceSums = priceSums + Double.parseDouble(model.getValueAt(index, 5).toString());
                Integer statu = Integer.parseInt(model.getValueAt(index, 6).toString());
                bookService= new BookServiceImpl();
                book1 = bookService.queryById(bookId);
                remainder = book1.getStore() - booknum;
                book1.setStore( book1.getStore()-booknum);
                if(remainder<0||statu!=1){
                    JOptionPane.showMessageDialog(null, "提示：订单项创建失败,可能库存不足够或者商品下架");
                    return;
                }
            }
            OrderServiceImpl orderService = new OrderServiceImpl();
            UserData.lastpricesum=priceSums;
            Order order = new Order(userId, priceSums, 1);
            last_id = orderService.insert(order);


        }
        if (last_id > 0) {
//                插入订单现
            if (selectedRows.length > 0) {
                for (int index = 0; index < selectedRows.length; index++) {
                    // 取得表格对象的数据模型
                    TableModel model = orderTable.getModel();
                    // 在表格对象模型中，根据选中的行和列，获取相应的数据值
                    int booknum=Integer.parseInt(model.getValueAt(index, 4).toString());
                    double priceSum = Double.parseDouble(model.getValueAt(index, 5).toString());
                    Integer bookId = Integer.parseInt(model.getValueAt(index, 1).toString());
//                    Integer userId, Integer bookId, Integer orderId, Double priceSum
                    OrderItem orderItem = new OrderItem(userId,bookId,last_id,priceSum);
                    if (orderItemService.insert(orderItem)>0&&remainder>=0){
                        bookService.update(book1);
                        JOptionPane.showMessageDialog(null, "提示：订单项创建成功");
                    }else {
                        JOptionPane.showMessageDialog(null, "提示：订单项创建失败,可能库存不足够");
                    }


                }

                JOptionPane.showMessageDialog(null, "提示：订单创建成功");
                this.setVisible(false);
                UserData.arr = new String[][]{
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                };
                click();
                PayForm payForm = new PayForm();
                payForm.setVisible(true);

            }
        } else {
            JOptionPane.showMessageDialog(null, "提示：订单创建失败");
        }

    }

//    private void orderTableMouseClicked(MouseEvent e) {
//            if (e.getClickCount() == 2){
//            int row = ((JTable)e.getSource()).rowAtPoint(e.getPoint());
////            int col = ((JTable)e.getSource()).columnAtPoint(e.getPoint());
//                if (row == orderTable.getSelectedRow()){
//
//                    JOptionPane.showMessageDialog(null,"用户名不能更改");
//                }
//            }
//
//    }

    private void getRowData() {
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        orderTable = new JTable();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- orderTable ----
            orderTable.setModel(new DefaultTableModel(
                new Object[][] {
                    {"", null, "", null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                },
                new String[] {
                    "ID", "userId", "\u603b\u4ef7\u683c", "\u72b6\u6001"
                }
            ) {
                boolean[] columnEditable = new boolean[] {
                    false, false, false, false
                };
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            orderTable.setFont(orderTable.getFont().deriveFont(orderTable.getFont().getSize() + 2f));
            scrollPane1.setViewportView(orderTable);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(70, 65, 490, 250);

        //---- button1 ----
        button1.setText("\u7ed3\u7b97");
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(490, 335), button1.getPreferredSize()));
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(85, 335), button2.getPreferredSize()));

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
    private JScrollPane scrollPane1;
    private JTable orderTable;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
