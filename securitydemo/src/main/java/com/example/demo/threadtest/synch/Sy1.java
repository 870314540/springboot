package com.example.demo.threadtest.synch;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by lenovo on 2017/8/7.
 */
/*
* 读取文档，生成语句
 */
public class Sy1 {

    volatile int  i  ;
    public static  void main(String[] args){


        StringBuffer sb= new StringBuffer("");
        HashSet<String> set1 = new HashSet<String>();
        FileReader reader = null;
        try {
            reader = new FileReader("E://08141.txt");
            BufferedReader br = new BufferedReader(reader);

//            String str1 = "update t_recoup_job set job_status='failed' , fail_reason='20170811异常情况' " +
//                    "where job_status='execute' and job_desc like '锁%' and job_json_param like '%";
            String str = "";
//            String str2  ="select  rent_contract_code  from tb_contract where contract_type='2' and rent_contract_code in (";
            String str3 = "";
            int i  = 1 ;
            while((str = br.readLine()) != null) {
//                sb.append(str1);
//               sb.append(str+"%'"+"\r\n");



//                sb.append(str1);
//                String sb1 = str.split("\"")[0];

             // sb.append(sb1+"\r\n");
                set1.add(str);

                if( i %100 == 0){
                    sb.append("'"+str+"')"+"\r\n");
                }else{
                    sb.append("'"+str+"',");
                }
                i++ ;
//                sb.append(str2+str+";"+"\r\n");
//                System.out.println(str);
            }
            br.close();
            reader.close();
//            Iterator<String> it = set1.iterator();
//            while (it.hasNext()) {
//                sb.append(it.next()+"\r\n");
//            }



            // write string to file
            FileWriter writer = new FileWriter("E://08142.txt");
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write(sb.toString());

            bw.close();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}
