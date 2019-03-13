package com.upload.BarcodeCheck;

import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class TxtReaderUtil {


    /**
     *  File f  = new File("fullPath")
     *
     * @param file
     * @return
     */
    public   List<String>  txt2String(File file){

        StringBuilder result = new StringBuilder();
        List<String> list = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
                list.add(s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }




}