/*
 * Created by JFormDesigner on Thu Jul 02 13:02:55 CST 2020
 */

package com.bookshop.ui.userForm;

import java.awt.event.*;
import com.bookshop.entity.Cart;
import com.bookshop.entity.Order;
import com.bookshop.entity.OrderItem;
import com.bookshop.entity.User;
import com.bookshop.service.impl.OrderItemServiceImpl;
import com.bookshop.service.impl.OrderServiceImpl;
import com.bookshop.util.UserData;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author °Ëµã°ë
 */
public class OrderItemForm extends JFrame {
    private OrderServiceImpl orderService = new OrderServiceImpl();
    List<Order> orderItems;
    public HashMap<Integer,String> orderStatu=new HashMap<>();
    public HashMap<String,Integer> orderStatu2=new HashMap<>();
//把数据展示到表格
    public void click() {

        table1.setModel(new DefaultTableModel(
                select(),
                new String[]{
                        "ID", "总价", "\u7528\u6237ID", "\u8ba2\u5355\u72b6\u6001"
                }
        ) {

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }

        }

        );
        scrollPane1.setViewportView(table1);



    }
//获取用户订单项数据
    private  String[][] select() {
//        根据不同用户选择展示数据
        if("user".equals(UserData.Sign)) {
           orderItems = orderService.queryByUserId(UserData.userId);
        }else {
           orderItems = orderService.queryAll();
        }
        String[][] datas = new String[ orderItems.size()][4];
        for (int i = 0; i < datas.length; i++) {
            if (orderItems.get(i).getStatus()==-1){
                UserData.arrayList.add(orderItems.get(i).getId());
                continue;
            }
            datas[i][0] = orderItems.get(i).getId().toString();
            datas[i][1] = orderItems.get(i).getPriceSum().toString();
            datas[i][2] = orderItems.get(i).getUserId().toString();
            datas[i][3] = orderStatu.get(orderItems.get(i).getStatus());


        }
        //---- table1 ---
        return datas;
    }
    public OrderItemForm() {
//        初始化订单状态
        orderStatu.put(-1,"删除");
        orderStatu.put(1,"未付款");
        orderStatu.put(2,"已付款");
        orderStatu2.put("删除",-1);
        orderStatu2.put("未付款",1);
        orderStatu2.put("已付款",2);
        initComponents();
        click();
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        OrderItemsForm orderItemsForm = new OrderItemsForm();
        orderItemsForm.setVisible(true);

    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        click();
    }

    private void button3ActionPerformed(ActionEvent e) {
        // TODO add your code here
//        删除
        //        注销用户,体现在statu的修改
        int  id,userId,status;
        double priceSum;
        int index = table1.getSelectedRow();
        TableModel model = table1.getModel();
        // 如果下标不为-1，则选中行为数据行
        if (index != -1) {
            id = Integer.parseInt(model.getValueAt(index, 0).toString());
            userId = Integer.parseInt(model.getValueAt(index, 2).toString());
            priceSum = Double.parseDouble(model.getValueAt(index, 1).toString());
            status=-1;
//            JOptionPane.showMessageDialog(null, "提示：有选项没填,已经设置为默认值");

//            "ID", "登录名", "密码", "昵称", "性别", "邮箱", "电话", "地址"
            Order order = new Order(id,userId,priceSum,status);
            if (orderService.update(order) > 0) {
                JOptionPane.showMessageDialog(null, "提示：注销成功！");
                click();
            } else {
                JOptionPane.showMessageDialog(null, "提示：注销失败！");
            }
        } else {
            JOptionPane.showMessageDialog(null, "提示：请选择需要注销的订单！");
        }
    }

    private void table1MouseClicked(MouseEvent e) {
        // TODO add your code here
//        点击表格判定订单是否付款
//        未付款跳转到付款界面
        if(e.getClickCount()==2){
            int row = ((JTable)e.getSource()).rowAtPoint(e.getPoint());
            int index=table1.getSelectedRow();
            if (row == index){
                TableModel model = table1.getModel();
                // 如果下标不为-1，则选中行为数据行
                if (index != -1) {
                    int id = Integer.parseInt(model.getValueAt(index, 0).toString());
                    int statu = orderStatu2.get((model.getValueAt(index, 3).toString()));
                    UserData.lastId=id;
                    if(statu==2){
                        JOptionPane.showMessageDialog(null, "提示：订单已付款");
                    }else {
                        PayForm payForm = new PayForm();
                        payForm.setVisible(true);
                    }


                }
            }
        }
    }



    private void initComponents() {


        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u8ba2\u5355\u9875\u9762");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 16f));
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(245, 25), label1.getPreferredSize()));

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                },
                new String[] {
                    "ID", "\u8ba2\u5355ID", "\u7528\u6237ID", "\u8ba2\u5355\u72b6\u6001"
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
            table1.setCellSelectionEnabled(true);
            table1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    table1MouseClicked(e);
                }
            });
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(60, 95, 550, 275);

        //---- button1 ----
        button1.setText("\u8be6\u7ec6\u8ba2\u5355\u4fe1\u606f");
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(465, 50), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u5237\u65b0");
        button2.addActionListener(e -> button2ActionPerformed(e));
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(60, 50), button2.getPreferredSize()));

        //---- button3 ----
        button3.setText("\u5220\u9664");
        button3.addActionListener(e -> button3ActionPerformed(e));
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(75, 390), button3.getPreferredSize()));

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
        click();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
