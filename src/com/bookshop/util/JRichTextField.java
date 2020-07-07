package com.bookshop.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JTextField;

public class JRichTextField extends JTextField {

    /**
     *
     */
    private static final long serialVersionUID = -1985791340012812141L;

    public JRichTextField() {

    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        String text = getText();
        if((text == null || "".equals(text)) && !isFocusOwner()) {
            g2.setFont(new Font(getFont().getName(), Font.PLAIN, 12));
            g2.setColor(Color.GRAY);
            g2.drawString(getToolTipText(), 10, 22);
        }
    }

    class FlashThread extends Thread {

        private boolean focus = false;
        public FlashThread(boolean focus) { this.focus = focus; }

        @Override
        public void run() {
            for(int i = 0; i < 3; i++) {
                setBackground(Color.LIGHT_GRAY);
                try { Thread.sleep(100); } catch (InterruptedException e) {e.printStackTrace();}
                setBackground(null);
                try { Thread.sleep(100); } catch (InterruptedException e) {e.printStackTrace();}
            }

            if(focus) {
                setFocusable(true);
                requestFocus();
            }
        }
    }

    public void flash() {
        new FlashThread(false).start();
    }

    public void requestFocusAfterFlash() {
        new FlashThread(true).start();
    }

}