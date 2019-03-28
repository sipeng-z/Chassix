package com.upload.controller;

import com.project.service.FileGeter;
import com.upload.BarcodeCheck.TxtReaderUtil;
import com.upload.Model;
import com.upload.entity.HKVALS;
import com.utils.excel.ExcelUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.*;

@RestController
public class AnalysisHKRController {


    @Autowired
    private TxtReaderUtil txtReaderUtil;

    @Test
    public void analysis(){

        try{

            FileGeter obj = new FileGeter();
            String datasetpath ="C:/Users/yyhuan/Desktop/Training/Example2/"; //Folder path;
            Vector<File> vecFile = new Vector<>();
            Vector<File> vecFileResult = obj.getAllFile(datasetpath,vecFile);
            List<String> pathList = new ArrayList<>();
            //1.all path from

            for(File f:vecFileResult){
                pathList.add(f.getPath()); // 1.5put all path
                System.out.println(f);
            }

//2. path list already , loop to get contents for each path
            Map<Double,Double> resultMap = new HashMap<>();

            Map<HKVALS,File> fullInfo = new HashMap<>();
            for(String path : pathList){

                List<String>  fileContent =   this.txt2String(new File(path));

                String HKRX = "";
                String HKRY = "";
                for(String s : fileContent ){
                    if(s.contains("HKRX_1")){
                        HKRX = s;
                    }
                    if(s.contains("HRYM_1")){
                        HKRY =s;
                    }

                }


//3.content     already ,need to make an analysis


                String HKRXCUT = HKRX.substring(7,HKRX.length());
                String HKRYCUT = HKRY.substring(7,HKRY.length());


                String[] HKRXSUB = HKRXCUT.split("\\|");
                String[] HKRYSUB = HKRYCUT.split("\\|");


//4.loop for HKRXSUB content
                for(int i=0;i<HKRXSUB.length;i++ ){

                    Double HKRXVAL = Double.parseDouble(HKRXSUB[i]);
                    if(HKRXVAL>=-1.1000&&HKRXVAL<=-0.9000){ // when x val equals ,put y val;
                        resultMap.putIfAbsent(HKRXVAL,Double.parseDouble(HKRYSUB[i]));
                        HKVALS hkvals = new HKVALS();
                        hkvals.setHKRX(HKRXVAL);
                        hkvals.setHKRY(Double.parseDouble(HKRYSUB[i]));
                        fullInfo.putIfAbsent(hkvals,new File(path));

                    }

                }

            }
//5.result map already , output to excel file
            Map<String,String> excelMap = new LinkedHashMap<>();
            Collection<Object> dataset=new ArrayList<Object>();
            excelMap.put("a","HKRXVAL");
            excelMap.put("b","HKRYVAL");
            excelMap.put("c","Path");
//            for (Map.Entry<Double,Double> entry : resultMap.entrySet()) {
//                dataset.add(new Model(entry.getKey().toString(),entry.getValue().toString(),"","","","","","","","",""));
//                System.out.println(entry.getKey() + ":" + entry.getValue()); //println to console
//            }

            for (Map.Entry<HKVALS,File> entry : fullInfo.entrySet()) {
                dataset.add(new Model(entry.getKey().getHKRX().toString(),entry.getKey().getHKRY().toString(),entry.getValue().getPath(),"","","","","","","",""));
                System.out.println(entry.getKey() + ":" + entry.getValue()); //println to console
            }



            String path ="";
            path += "C:/Users/yyhuan/Desktop/Training/Example2/generate/";    //PROPERTIES desktop
            path += "SingleEMP2Analysis.xls";
            File f=new File(path);
            OutputStream out =new FileOutputStream(f);

            ExcelUtil.exportExcel(excelMap, dataset, out);
            out.close();
        }catch (Exception e){
            System.out.println("Error——"+e);
        }



    }





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
