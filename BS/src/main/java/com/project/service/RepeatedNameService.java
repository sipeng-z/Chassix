package com.project.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;


//Detection mark content {
//1.same file name in different folders
//2.content contains "#"
// }
public class RepeatedNameService {


    public  void repeatNameDetection(String[] args) {

        System.out.println("Process started;");

        FileGeter obj = new FileGeter();
        String datasetpath ="/Volumes/SeagateYYH/EMP22/";
        Vector<File> vecFile = new Vector<>();
        Vector<File> vecFileResult = obj.getAllFile(datasetpath,vecFile);


        Map<String, String> map = new HashMap<String, String>();  //map name and date

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();




        for(File f:vecFileResult){
            cal.setTimeInMillis(f.lastModified());
            map.put(f.getPath(),sdf.format(cal.getTime()));
        }


        System.out.println(map);
        System.out.println("Total Size:"+map.size());


        String code = "";
      List<String> codelist = new ArrayList<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {




                        if(entry.getKey().contains("#")){
                            System.out.println("Repeated Name= " + entry.getKey() + " ——————and—————— LastModified DateTime= "
                                    + entry.getValue());

                            code= entry.getKey().replace("#","");
                            codelist.add(code);

                        }



        }

        System.out.println();
        System.out.println(codelist);
        System.out.println();
        String filename ="";
        for(String item :codelist){
            filename = item;

            for (Map.Entry<String, String> entry : map.entrySet()) {
                if(entry.getKey().equals(filename)){
                    System.out.println("Repeated Name before= " + entry.getKey() + " ——————and—————— LastModified DateTime= "
                            + entry.getValue());
                }
            }



        }







        System.out.println("Process finished;");

    }


}
