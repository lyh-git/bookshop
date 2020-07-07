/*
 * Created by JFormDesigner on Sat Jul 04 22:44:52 CST 2020
 */

package com.bookshop.ui.userForm;

import java.awt.event.*;
import com.bookshop.entity.Order;
import com.bookshop.entity.OrderItem;
import com.bookshop.service.impl.OrderItemServiceImpl;
import com.bookshop.service.impl.OrderServiceImpl;
import com.bookshop.util.UserData;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author °Ëµã°ë
 */
public class OrderItemsForm extends JFrame {
    OrderServiceImpl orderService1=  new OrderServiceImpl();
    List<OrderItem> orderItems;
    public OrderItemsForm() {
        initComponents();
        click();
    }


        private OrderItemServiceImpl orderService = new OrderItemServiceImpl();
        public void click() {

            table1.setModel(new DefaultTableModel(
                    select(),
                    new String[]{
                            "ID", "userID", "bookID", "orderID", "价格"
                    }
            ) {

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return false;
                }
            });
            scrollPane1.setViewportView(table1);


        }

        private  String[][] select() {
//            "ID", "userID", "bookID", "orderID", "价格"

            if("user".equals(UserData.Sign)) {
                orderItems = orderService.queryByUserId(UserData.userId);
            }else {
                orderItems = orderService.queryAll();
            }
            List<Order> orders = orderService1.queryByUserId(UserData.userId);
            String[][] datas = new String[ orderItems.size()][5];
            for (int i = 0; i < datas.length; i++) {


                    if (UserData.arrayList.contains(orderItems.get(i).getOrderId()))
                    {
                        continue;
                    }
                    datas[i][0] = orderItems.get(i).getId().toString();
                    datas[i][1] = orderItems.get(i).getUserId().toString();
                    datas[i][2] = orderItems.get(i).getBookId().toString();
                    datas[i][3] = orderItems.get(i).getOrderId().toString();
                    datas[i][4] = orderItems.get(i).getPriceSum().toString();
//                }

            }
            System.out.println(UserData.arrayList);
            //---- table1 ---
            return datas;
        }

        private void button1ActionPerformed(ActionEvent e) {
            // TODO add your code here
//            刷新
            click();
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
                    {null, null, null, "", null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                },
                new String[] {
                    "ID", "userID", "bookID", "orderID", "\u4ef7\u683c"
                }
            ));
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(15, 15, 575, 310);

        //---- button1 ----
        button1.setText("\u5237\u65b0");
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(40, 340), button1.getPreferredSize()));

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
    private JTable table1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
