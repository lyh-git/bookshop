package com.bookshop.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JythonServer {

    public static void main(String[] args) {


            // TODO Auto-generated method stub
            String pyPath = "I:\\BookShop\\BookShop\\charrobot\\DEMO01\\CS1\\server.py"; //python文件路径

            String[] args1 = new String[] { "H:\\编程\\charrobot\\venv\\Scripts\\python", pyPath};
            try {
                Process proc = Runtime.getRuntime().exec(args1);  //执行py文件
                BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
                String line = null;
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }
                in.close();
                proc.waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


