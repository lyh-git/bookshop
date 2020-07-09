package com.bookshop.ui.userForm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JythonTest {

        public static void main1( String data1) {
            // TODO Auto-generated method stub
            String pyPath = "G:\\destop\\下载\\Java-xunfei-master\\java-test\\src\\jYTHON\\douban.py"; //python文件路径

            String[] args1 = new String[] { "H:\\编程\\charrobot\\venv\\Scripts\\python", pyPath,data1};
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


