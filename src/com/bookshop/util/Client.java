package com.bookshop.util;

import com.bookshop.ui.userForm.TestIdea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

    public static void tell() throws IOException {
        //从控制台获得输入
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        Socket client = null;
        try {
            //建立新连接，注意这里创建好就已经连接上了，要保证服务端已经开启
            client = new Socket("localhost", 8715);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
            System.err.println("连接失败");
        }
        String name = "3";
        name = name + "===" + TestIdea.textField1.getText();
        new Send(client, name);
        new Thread(new Recevice(client)).start();

    }

}


