package com.bookshop.util;


import com.bookshop.ui.userForm.TestIdea;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Recevice implements Runnable {

    //负责读取服务端发送过来的信息
    private DataInputStream is;
    //线程标识
    private boolean isRun = true;


    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (isRun) {
            recevice();
        }
    }

    public Recevice(Socket client) {
        // TODO Auto-generated constructor stub
        try {
            is = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            CloseUtil.closeAll(is);
            isRun = false;
        }
    }

    public void recevice() {

        try {
            byte[] b = new byte[1024];
            int length = 0;
            while ((length = is.read(b)) != -1) {
                System.out.println(new String(b,0,length));
                TestIdea.textArea1.append("客服:"+new String(b,0,length)+"\n");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            CloseUtil.closeAll(is);
            isRun = false;
        }

    }

}

