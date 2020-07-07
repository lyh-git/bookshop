/*
 * Created by JFormDesigner on Mon Jul 06 10:29:32 CST 2020
 */

package com.bookshop.ui.AdminForm;

import com.bookshop.entity.Book;
import com.bookshop.entity.Ideas;
import com.bookshop.service.impl.IdeaServiceImpl;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author °Ëµã°ë
 */
public class AdnimIdeaForm extends JFrame {
    public static void main(String[] args) {
        AdnimIdeaForm adnimIdeaForm = new AdnimIdeaForm();
        adnimIdeaForm.setVisible(true);
    }
    IdeaServiceImpl ideaService = new IdeaServiceImpl();
    public AdnimIdeaForm() {
        initComponents();
    }

    public String[][] select() {
        List<Ideas> ideas;


        ideas = ideaService.queryAll();

        String[][] datas = new String[ideas.size()][5];
        for (int i = 0; i < ideas.size(); i++) {
            datas[i][0] = ideas.get(i).getId().toString();
            datas[i][1] = ideas.get(i).getTitle();
            datas[i][2] = ideas.get(i).getContent();
            datas[i][3] = ideas.get(i).getSender();
            datas[i][4] = ideas.get(i).getSendTime();



        }
        return datas;

    }

    public void showData() {


        //---- table1 ----
        table1.setModel(new DefaultTableModel(
                select(),
                new String[]{
                        "\u6807\u9898", "\u6b63\u6587", "\u53d1\u9001\u8005", "\u53d1\u9001\u65f6\u95f4"
                }
        ));
        scrollPane1.setViewportView(table1);

    }
    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
//        删除意见
        int[] selectedRows = table1.getSelectedRows();
        if (selectedRows.length > 0) {
            for (int index = 0; index < selectedRows.length; index++) {
                // 取得表格对象的数据模型
                TableModel model = table1.getModel();
                // 在表格对象模型中，根据选中的行和列，获取相应的数据值
                int id = Integer.parseInt(model.getValueAt(selectedRows[index], 0).toString());
               ideaService.delete(id);

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
                    {null, null, null, null},
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
                    "\u6807\u9898", "\u6b63\u6587", "\u53d1\u9001\u8005", "\u53d1\u9001\u65f6\u95f4"
                }
            ));
            scrollPane1.setViewportView(table1);
        }
        showData();
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(20, 15, 725, 330);

        //---- button1 ----
        button1.setText("\u5220\u9664");
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(325, 365), button1.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(765, 490));
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
