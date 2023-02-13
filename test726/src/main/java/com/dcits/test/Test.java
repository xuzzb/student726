package com.dcits.test;

import java.io.*;

/**
 * @Author xuzzb
 * @Create 2023/1/5
 */
public class Test {
    public static void main(String[] args) throws IOException {
        System.out.println("test");


            String fileName = "D:\\a\\"+2+".txt";
            FileOutputStream outputStream = new FileOutputStream(new File(fileName));
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            for(int j=20001;j<40000;j++){
                String sql = "INSERT INTO info VALUES ("+j+", 'lisi', 22, NULL, '1', '1', '1');";
                System.out.println(sql);
                outputStreamWriter.write(sql);
                outputStreamWriter.write("\n");
                outputStreamWriter.flush();
            }
            outputStreamWriter.close();
    }
}
