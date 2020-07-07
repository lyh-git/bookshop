/*
 * Created by JFormDesigner on Tue Jul 07 13:45:57 CST 2020
 */

package com.bookshop.ui.userForm;

import java.awt.event.*;

import com.bookshop.util.Client;
import com.bookshop.util.UserData;

import java.awt.*;
import java.io.IOException;
import javax.swing.*;

/**
 * @author °Ëµã°ë
 */
public final class TestIdea extends JFrame {
    public static void main(String[] args) {
        TestIdea testIdea = new TestIdea();
        testIdea.setVisible(true);
    }

    public TestIdea() {
        initComponents();
    }

    private void showtext() throws IOException {
//        textArea1.append(UserData.userContent);
        new Client().tell();
    }

    private void button1ActionPerformed(ActionEvent e) throws IOException {
        // TODO add your code here
//        发送
        String text = "我:" + textField1.getText() + "\n";
        textArea1.append(text);
        new Client().tell();
        textField1.setText("");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        textField1 = new JTextField();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();

        //======== this ========
        setFont(new Font("Arial Black", Font.PLAIN, 12));
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.add(textField1);
        textField1.setBounds(80, 320, 140, textField1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u53d1\u9001");
        button1.addActionListener(e -> {
            try {
                button1ActionPerformed(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(275, 320), button1.getPreferredSize()));

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.setFont(textArea1.getFont().deriveFont(textArea1.getFont().getSize() + 7f));
            scrollPane1.setViewportView(textArea1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(35, 15, 370, 280);

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
    public static JTextField textField1;
    private JButton button1;
    private JScrollPane scrollPane1;
    public static JTextArea textArea1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
