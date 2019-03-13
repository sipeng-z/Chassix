package com.upload.BarcodeCheck;

import com.domain.model.PageData;
import com.model.AppConsts;
import com.upload.Model;
import com.utils.excel.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.util.*;

import  com.upload.BarcodeCheck.ExcelReaderUtil;

public class MainTest {

    @Autowired
    private ExcelReaderUtil excelReaderUtil;

    @Autowired
    private TxtReaderUtil txtReaderUtil;


    /**
     * read excel files
     */
    public void  readTest(){

        List<List<String>> lists  = excelReaderUtil.readExcel("");  //full Path
        for(List<String> list :lists){
            for(String s :list){
                System.out.println(s);
            }
        }
    }



    /**
     * outPut to excel files
     */
    @Test
    public  void outPutExcel() {
        try{
            //Map key and value is according to ExcelCell's index order
            Map<String,String> map = new LinkedHashMap<>();
            map.put("a","HKRXVAL");
            map.put("b","HKRYVAL");

            Collection<Object> dataset=new ArrayList<Object>();

            dataset.add(new Model("10.1010","-10.11","","","","","","","","",""));


            String path ="";
            path += "C:/Users/yyhuan/Desktop/DaFiles/";    //PROPERTIES
            path += "EMP2Analysis.xls";
            File f=new File(path);
            OutputStream out =new FileOutputStream(f);

            ExcelUtil.exportExcel(map, dataset, out);
            out.close();

        }catch (Exception e){
            System.out.println("Error during process");
        }




    }









}
