/*
 * Created by JFormDesigner on Thu Jul 02 10:53:18 CST 2020
 */

package com.bookshop.ui.userForm;

import com.bookshop.entity.Book;
import com.bookshop.entity.Cart;
import com.bookshop.service.BookService;
import com.bookshop.service.CartService;
import com.bookshop.service.impl.BookServiceImpl;
import com.bookshop.service.impl.CartServiceImpl;
import com.bookshop.ui.publicForm.LoginFrame;
import com.bookshop.util.UserData;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author °Ëµã°ë
 */
public class UserMainFrame extends JFrame {
    public BookService bookService = new BookServiceImpl();
    public CartService cartService = new CartServiceImpl();
    public HashMap<Integer, String> bookstatu = new HashMap<>();
    public HashMap<String, Integer> bookstatu2 = new HashMap<>();


    public static void main(String[] args) {
        UserMainFrame userMainFrame = new UserMainFrame();
        userMainFrame.setVisible(true);
    }

    private static IdeaFrom ideaFrom = null;
    private static OrderItemForm orderForm = null;
    private static ShopingCatForm shopingCatForm = null;

    public UserMainFrame() {
        bookstatu.put(-1, "删除");
        bookstatu.put(0, "下架");
        bookstatu.put(1, "上架");
        bookstatu2.put("删除", -1);
        bookstatu2.put("下架", 0);
        bookstatu2.put("上架", 1);
        initComponents();
    }

    private void shoppingCartMenuActionPerformed(ActionEvent e) {
//        购物车界面
        ShopingCatForm shopingCatForm = new ShopingCatForm();
        shopingCatForm.setVisible(true);


    }


    private void ideaMenu3MouseClicked(MouseEvent e) {
        //        意见界面跳转
        if (ideaFrom == null) {
            ideaFrom = new IdeaFrom();
        }
        ideaFrom.setVisible(true);
    }

    private void orderMenuMouseClicked(MouseEvent e) {
        //        订单界面跳转
        if (orderForm == null) {
            orderForm = new OrderItemForm();
        }
        orderForm.setVisible(true);
    }

    private void shoppingCartMenuMouseClicked(MouseEvent e) {
        if (shopingCatForm == null) {
            shopingCatForm = new ShopingCatForm();
        }
        shopingCatForm.setVisible(true);
        shopingCatForm.click();

    }

    private void orderMenuActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void ideaMenu3ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }


    private String[][] select() {
        List<Book> books;
        Object selectedItem = comboBox1.getSelectedItem();
        String text = textField1.getText();
        if (selectedItem.equals("图书")) {
            books = bookService.queryByName(text);

        } else {
            books = bookService.queryAll();
        }
        String[][] datas = new String[books.size()][10];
        for (int i = 0; i < datas.length; i++) {
            if (books.get(i).getFlag() != 1) {
                continue;
            }
            datas[i][0] = books.get(i).getName();
            datas[i][1] = books.get(i).getAuthor();
            datas[i][2] = books.get(i).getPublisher();
            datas[i][3] = books.get(i).getPrice().toString();
            datas[i][4] = books.get(i).getType();
            datas[i][5] = books.get(i).getDisc();
            datas[i][6] = books.get(i).getDiscount().toString();
            datas[i][7] = books.get(i).getStore().toString();
            datas[i][8] = bookstatu.get(books.get(i).getFlag());
            datas[i][9] = books.get(i).getId().toString();


        }
        return datas;
    }


    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void insertShopCartButton2ActionPerformed(ActionEvent e) {
        Book book = null;
        int index = table1.getSelectedRow();
        // 如果下标不为-1，则选中行为数据行
        if (index != -1) {
            // 取得表格对象的数据模型
            TableModel model = table1.getModel();
            // 在表格对象模型中，根据选中的行和列，获取相应的数据值
            Integer statu = bookstatu2.get(model.getValueAt(index, 8).toString());
            Integer primaryKey = Integer.parseInt(model.getValueAt(index, 9).toString());
            book = bookService.queryById(primaryKey);
            Cart cart = new Cart(UserData.userId, book.getId(), 1, book.getPrice(), book.getName());
            if (statu == 1) {
                if (cartService.insert(cart) > 0) {
                    JOptionPane.showMessageDialog(null, "提示：" + book.getName() + "加入购物车成功！");
                } else {
                    JOptionPane.showMessageDialog(null, "提示：加入购物车失败！");
                }
            } else {
                JOptionPane.showMessageDialog(null, "提示：商品已下架！");
            }
        } else {
            JOptionPane.showMessageDialog(null, "提示：请选择需要加入购物车的书籍！");
        }
    }

    private void button1ActionPerformed(ActionEvent e) {
        showData();
    }

    public void showData() {

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                                    select(),
                                    new String[]{
                                            "\u4e66\u540d", "\u4f5c\u8005", "\u51fa\u7248\u793e", "\u4ef7\u683c", "\u7c7b\u578b", "\u662f\u5426\u6709\u5149\u789f", "\u6298\u6263", "\u5e93\u5b58", "\u72b6\u6001", "ID"
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
    }

    private void menu2ActionPerformed(ActionEvent e) {
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
    }

    private void menu2MouseClicked(MouseEvent e) {
        // TODO add your code here
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
//        UserMainFrame userMainFrame = new UserMainFrame();
        this.setVisible(false);
    }

    private void menu1MouseClicked(MouseEvent e) {
        // TODO add your code here
//        用户信息修改
//        用户修改界面跳转
        UserUpdateForm userUpdateForm = new UserUpdateForm();
        userUpdateForm.setVisible(true);
    }

    private void menu3MouseClicked(MouseEvent e) {
        // TODO add your code here
        TestIdea testIdea = new TestIdea();
        testIdea.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        shoppingCartMenu = new JMenu();
        orderMenu = new JMenu();
        ideaMenu3 = new JMenu();
        menu1 = new JMenu();
        menu3 = new JMenu();
        menu2 = new JMenu();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        textField1 = new JTextField();
        button1 = new JButton();
        comboBox1 = new JComboBox<>();
        insertShopCartButton2 = new JButton();

        //======== this ========
        setTitle("\u7528\u6237\u754c\u9762");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {

            //======== shoppingCartMenu ========
            {
                shoppingCartMenu.setText("\u8d2d\u7269\u8f66");
                shoppingCartMenu.addActionListener(e -> shoppingCartMenuActionPerformed(e));
                shoppingCartMenu.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        shoppingCartMenuMouseClicked(e);
                    }
                });
            }
            menuBar1.add(shoppingCartMenu);

            //======== orderMenu ========
            {
                orderMenu.setText("\u8ba2\u5355\u4ea4\u6613");
                orderMenu.addActionListener(e -> orderMenuActionPerformed(e));
                orderMenu.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        orderMenuMouseClicked(e);
                    }
                });
            }
            menuBar1.add(orderMenu);

            //======== ideaMenu3 ========
            {
                ideaMenu3.setText("\u610f\u89c1\u53cd\u9988");
                ideaMenu3.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        ideaMenu3MouseClicked(e);
                    }
                });
            }
            menuBar1.add(ideaMenu3);

            //======== menu1 ========
            {
                menu1.setText("\u4fee\u6539\u4fe1\u606f");
                menu1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        menu1MouseClicked(e);
                    }
                });
            }
            menuBar1.add(menu1);

            //======== menu3 ========
            {
                menu3.setText("\u667a\u80fd\u5ba2\u670d");
                menu3.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        menu3MouseClicked(e);
                    }
                });
            }
            menuBar1.add(menu3);

            //======== menu2 ========
            {
                menu2.setText("\u9000\u51fa");
                menu2.addActionListener(e -> {
			menu2ActionPerformed(e);
			menu2ActionPerformed(e);
		});
                menu2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        menu2MouseClicked(e);
                    }
                });
            }
            menuBar1.add(menu2);
        }
        setJMenuBar(menuBar1);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null},
                },
                new String[] {
                    "\u4e66\u540d", "\u4f5c\u8005", "\u51fa\u7248\u793e", "\u4ef7\u683c", "\u7c7b\u578b", "\u662f\u5426\u6709\u5149\u789f", "\u6298\u6263", "\u5e93\u5b58", "\u72b6\u6001", "ID"
                }
            ));
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(10, 60, 815, 320);
        contentPane.add(textField1);
        textField1.setBounds(520, 0, 105, 35);

        //---- button1 ----
        button1.setText("\u56fe\u4e66\u67e5\u8be2");
        button1.addActionListener(e -> {
			button1ActionPerformed(e);
			button1ActionPerformed(e);
		});
        contentPane.add(button1);
        button1.setBounds(640, 0, button1.getPreferredSize().width, 35);

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "\u56fe\u4e66",
            "\u4f5c\u8005",
            "\u4ef7\u683c"
        }));
        contentPane.add(comboBox1);
        comboBox1.setBounds(430, 5, comboBox1.getPreferredSize().width, 35);

        //---- insertShopCartButton2 ----
        insertShopCartButton2.setText("\u52a0\u5165\u8d2d\u7269\u8f66");
        insertShopCartButton2.addActionListener(e -> {
			button2ActionPerformed(e);
			insertShopCartButton2ActionPerformed(e);
		});
        contentPane.add(insertShopCartButton2);
        insertShopCartButton2.setBounds(new Rectangle(new Point(0, 5), insertShopCartButton2.getPreferredSize()));

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
    private JMenuBar menuBar1;
    private JMenu shoppingCartMenu;
    private JMenu orderMenu;
    private JMenu ideaMenu3;
    private JMenu menu1;
    private JMenu menu3;
    private JMenu menu2;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JTextField textField1;
    private JButton button1;
    private JComboBox<String> comboBox1;
    private JButton insertShopCartButton2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
