package com.upload.controller;

import com.model.AppConsts;
import com.utils.excel.ExcelLogs;
import com.utils.excel.ExcelUtil;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;

@RestController
public class ExcelController {


    public  Collection<Map> importXlsx(String PathName) throws FileNotFoundException {
        File f=new File(PathName);


        String filePath = AppConsts.filePathServer;  //PROPERTIES
        filePath+=f;
        InputStream inputStream= new FileInputStream(filePath);
        ExcelLogs logs =new ExcelLogs();
        Collection<Map> importExcel = ExcelUtil.importExcel(Map.class, inputStream, "yyyy/MM/dd HH:mm:ss", logs , 0);


        return importExcel;
    }


    public  Collection<Map> importXlsLocal(String PathName) throws FileNotFoundException {
        File f=new File(PathName);
        String filePath  = "/Users/yangyuhuan/Desktop/BarCodeCheck/";
        filePath+=f;
        InputStream inputStream= new FileInputStream(filePath);
        ExcelLogs logs =new ExcelLogs();
        Collection<Map> importExcel = ExcelUtil.importExcel(Map.class, inputStream, "yyyy/MM/dd HH:mm:ss", logs , 0);


        return importExcel;
    }






}
