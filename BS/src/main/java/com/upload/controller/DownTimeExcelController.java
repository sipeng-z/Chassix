package com.upload.controller;

import com.domain.model.PageData;
import com.model.AppConsts;
import com.project.domain.entity.G38ASSYOEEDataTemporary;
import com.project.service.G38ASSYOEEDataTemporaryService;
import com.project.service.G38V21OEEDataTemporaryService;
import com.project.service.G38V22OEEDataTemporaryService;
import com.project.service.G38V23OEEDataTemporaryService;
import com.response.ResponseResult;
import com.upload.domain.model.FileOutput;
import com.upload.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;


import com.project.domain.model.input.G38ASSYOEEDataTemporaryInput;
import com.project.domain.model.input.G38V21OEEDataTemporaryInput;
import com.project.domain.model.input.G38V22OEEDataTemporaryInput;
import com.project.domain.model.input.G38V23OEEDataTemporaryInput;

/**
 * For downtime : overtime ; reason downtime
 */
@RestController
public class DownTimeExcelController {


    private static final Logger logger = LoggerFactory.getLogger(DownTimeExcelController.class);


    @Autowired
    private FileService fileService;

    @Autowired
    private  ExcelController excelController;

    @Autowired
    private G38ASSYOEEDataTemporaryService g38ASSYOEEDataTemporaryService;

    @Autowired
    private G38V21OEEDataTemporaryService g38V21OEEDataTemporaryService;

    @Autowired
    private G38V22OEEDataTemporaryService g38V22OEEDataTemporaryService;


    @Autowired
    private G38V23OEEDataTemporaryService g38V23OEEDataTemporaryService;




    @RequestMapping(value = "uploaddowntime", method = RequestMethod.POST)
    public ResponseResult uploadnew(HttpServletRequest request, HttpServletResponse response, String action) {
        ResponseResult result = new ResponseResult();
        String rtMge = "";
        List<FileOutput> returnList = new ArrayList<FileOutput>();
        MultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        MultipartHttpServletRequest Murequest = resolver.resolveMultipart(request);

        Map<String, MultipartFile> files = Murequest.getFileMap();//get map obj
        for (MultipartFile pic : files.values()) {
            try {
                FileOutput fileOutput = fileService.uploadReturn(pic, new PageData(request), request);
                returnList.add(fileOutput);

                String filename= fileOutput.getFileName();
                String[] A = filename.split("\\.");
                if(!A[1].equals("xls")&&!A[1].equals("xlxs")){
                    //Should be deleted here

                    result.setMessage("Error! Format xls only");
                    result.setSuccess(false);
                    return result;
                }
                String filePath = fileOutput.getFilePath();
                Collection<Map> importExcel =  excelController.importXlsx(filePath);

                for(Map m : importExcel){
                    String line = m.get("LINE").toString();
                    String deviceName = m.get("DEVICE").toString();
                    String shiftName = m.get("SHIFT").toString();
                    String weekNo = m.get("Week").toString();

                    String mon = "";
                    String tue = "";
                    String wed = "";
                    String thu = "";
                    String fri = "";
                    String sat = "";
                    String sun = "";

                    Integer num = 0;

                    if(m.get("Monday")!=null){
                        mon = m.get("Monday").toString();
                     Boolean flag =  this.switchDevice(deviceName,weekNo,shiftName,0);
                    }
                    if(m.get("Tuesday")!=null){
                        tue = m.get("Tuesday").toString();
                        Boolean flag =  this.switchDevice(deviceName,weekNo,shiftName,1);

                    }
                    if(m.get("Wednesday")!=null){
                        wed = m.get("Wednesday").toString();
                        Boolean flag =  this.switchDevice(deviceName,weekNo,shiftName,2);
                    }
                    if(m.get("Thursday")!=null){
                        thu = m.get("Thursday").toString();
                        Boolean flag =  this.switchDevice(deviceName,weekNo,shiftName,3);
                    }
                    if(m.get("Friday")!=null){
                        fri = m.get("Friday").toString();
                        Boolean flag =  this.switchDevice(deviceName,weekNo,shiftName,4);
                    }
                    if(m.get("Saturday")!=null){
                        sat = m.get("Saturday").toString();
                        Boolean flag =  this.switchDevice(deviceName,weekNo,shiftName,5);
                    }
                    if(m.get("Sunday")!=null){
                        sun = m.get("Sunday").toString();
                        Boolean flag =  this.switchDevice(deviceName,weekNo,shiftName,6);
                    }



                    System.out.println("~~~~~~~~~Down time upload success~~~~~~~~~");
                }


            } catch (IllegalStateException e) {
                rtMge = "upload error";
                e.printStackTrace();
                result.setMessage(rtMge);
                result.setSuccess(false);
                result.setData(returnList);
                return result;
            } catch (IOException e) {
                rtMge = "upload error";
                e.printStackTrace();
                result.setMessage(rtMge);
                result.setSuccess(false);
                result.setData(returnList);
                return result;
            } catch (Exception ee) {
                rtMge = "upload error";
                logger.error(ee.toString());
                result.setMessage(rtMge);
                result.setSuccess(false);
                result.setData(returnList);
                return result;
            }
        }
        result.setMessage(rtMge);
        result.setSuccess(true);
        result.setData(returnList);
        return result;
    }


    /**
     * @param deviceName
     * @param weekNo
     * @param shiftName
     * @param num for Mon,Tue,Wed.....
     * @return
     */

    public  boolean switchDevice(String deviceName,String weekNo,String shiftName,Integer num) throws Exception{

        //num mon=1 ++
        Calendar c = Calendar.getInstance();
        Date nowDate =  new Date();
        c.setTime(nowDate);
        Integer year =  c.get(Calendar.YEAR);
        Integer weekno = Integer.valueOf(weekNo);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,year);
        cal.set(Calendar.WEEK_OF_YEAR,weekno);
        cal.set(Calendar.DAY_OF_WEEK, 2);//monday 2
        Date MonDate = cal.getTime();

        Calendar calstart = Calendar.getInstance();
        calstart.setTime(MonDate);
        calstart.add(Calendar.DAY_OF_WEEK, num-1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date dateStart = calstart.getTime();


        if(deviceName.equals("ASSY")){

         if(shiftName.equals("SHIFT1")){
             G38ASSYOEEDataTemporaryInput input1 = new G38ASSYOEEDataTemporaryInput();
             G38ASSYOEEDataTemporaryInput input2 = new G38ASSYOEEDataTemporaryInput();

             input1.setType(0);
             input2.setType(0);
             input1.setIsProduction(3);
             input2.setIsProduction(3);
             calstart.add(Calendar.DAY_OF_WEEK, -1);
             Date dateStartBefore = calstart.getTime();
             input1.setStartDateTime(dateStartBefore);
             input1.setEndDateTime(dateStartBefore);        //Date
             input1.setStartRecord(AppConsts.shift1OverTime[0]);
             input1.setEndRecord(96);                       //Record

             g38ASSYOEEDataTemporaryService.addnewhalt(input1);//add day before

             input2.setStartDateTime(dateStart);
             input2.setEndDateTime(dateStart);
             input2.setStartRecord(1);
             input2.setEndRecord(AppConsts.shift1OverTime[1]);

             g38ASSYOEEDataTemporaryService.addnewhalt(input2);// add day

         }
         if(shiftName.equals("SHIFT2")){
             G38ASSYOEEDataTemporaryInput input = new G38ASSYOEEDataTemporaryInput();
             input.setType(0);
             input.setIsProduction(3);

             input.setStartDateTime(dateStart);
             input.setEndDateTime(dateStart);        //Date

             input.setStartRecord(AppConsts.shift2OverTime[0]);
             input.setEndRecord(AppConsts.shift2OverTime[1]);
             g38ASSYOEEDataTemporaryService.addnewhalt(input);// add day

         }
         if(shiftName.equals("SHIFT3")){

             G38ASSYOEEDataTemporaryInput input = new G38ASSYOEEDataTemporaryInput();
             input.setType(0);
             input.setIsProduction(3);
             input.setStartDateTime(dateStart);
             input.setEndDateTime(dateStart);        //Date
             input.setStartRecord(AppConsts.shift3OverTime[0]);
             input.setEndRecord(AppConsts.shift3OverTime[1]);
             g38ASSYOEEDataTemporaryService.addnewhalt(input);// add day
         }




        }

        if(deviceName.equals("V21")){

            if(shiftName.equals("SHIFT1")){
                G38V21OEEDataTemporaryInput input1 = new G38V21OEEDataTemporaryInput();
                G38V21OEEDataTemporaryInput input2 = new G38V21OEEDataTemporaryInput();
                input1.setType(0);
                input2.setType(0);
                input1.setIsProduction(3);
                input2.setIsProduction(3);
                calstart.add(Calendar.DAY_OF_WEEK, -1);
                Date dateStartBefore = calstart.getTime();
                input1.setStartDateTime(dateStartBefore);
                input1.setEndDateTime(dateStartBefore);        //Date
                input1.setStartRecord(AppConsts.shift1OverTime[0]);
                input1.setEndRecord(96);                       //Record

                g38V21OEEDataTemporaryService.addnewhalt(input1);//add day before

                input2.setStartDateTime(dateStart);
                input2.setEndDateTime(dateStart);
                input2.setStartRecord(1);
                input2.setEndRecord(AppConsts.shift1OverTime[1]);

                g38V21OEEDataTemporaryService.addnewhalt(input2);// add day

            }
            if(shiftName.equals("SHIFT2")){
                G38V21OEEDataTemporaryInput input = new G38V21OEEDataTemporaryInput();
                input.setType(0);
                input.setIsProduction(3);


                input.setStartDateTime(dateStart);
                input.setEndDateTime(dateStart);        //Date
                input.setStartRecord(AppConsts.shift2OverTime[0]);
                input.setEndRecord(AppConsts.shift2OverTime[1]);
                g38V21OEEDataTemporaryService.addnewhalt(input);// add day

            }
            if(shiftName.equals("SHIFT3")){

                G38V21OEEDataTemporaryInput input = new G38V21OEEDataTemporaryInput();
                input.setType(0);
                input.setIsProduction(3);
                input.setStartDateTime(dateStart);
                input.setEndDateTime(dateStart);        //Date
                input.setStartRecord(AppConsts.shift3OverTime[0]);
                input.setEndRecord(AppConsts.shift3OverTime[1]);
                g38V21OEEDataTemporaryService.addnewhalt(input);// add day
            }





        }

        if(deviceName.equals("V22")){
            if(shiftName.equals("SHIFT1")){
                G38V22OEEDataTemporaryInput input1 = new G38V22OEEDataTemporaryInput();
                G38V22OEEDataTemporaryInput input2 = new G38V22OEEDataTemporaryInput();
                input1.setType(0);
                input2.setType(0);
                input1.setIsProduction(3);
                input2.setIsProduction(3);
                calstart.add(Calendar.DAY_OF_WEEK, -1);
                Date dateStartBefore = calstart.getTime();
                input1.setStartDateTime(dateStartBefore);
                input1.setEndDateTime(dateStartBefore);        //Date
                input1.setStartRecord(AppConsts.shift1OverTime[0]);
                input1.setEndRecord(96);                       //Record

                g38V22OEEDataTemporaryService.addnewhalt(input1);//add day before

                input2.setStartDateTime(dateStart);
                input2.setEndDateTime(dateStart);
                input2.setStartRecord(1);
                input2.setEndRecord(AppConsts.shift1OverTime[1]);

                g38V22OEEDataTemporaryService.addnewhalt(input2);// add day

            }
            if(shiftName.equals("SHIFT2")){
                G38V22OEEDataTemporaryInput input = new G38V22OEEDataTemporaryInput();
                input.setType(0);
                input.setIsProduction(3);


                input.setStartDateTime(dateStart);
                input.setEndDateTime(dateStart);        //Date
                input.setStartRecord(AppConsts.shift2OverTime[0]);
                input.setEndRecord(AppConsts.shift2OverTime[1]);
                g38V22OEEDataTemporaryService.addnewhalt(input);// add day

            }
            if(shiftName.equals("SHIFT3")){

                G38V22OEEDataTemporaryInput input = new G38V22OEEDataTemporaryInput();
                input.setType(0);
                input.setIsProduction(3);
                input.setStartDateTime(dateStart);
                input.setEndDateTime(dateStart);        //Date
                input.setStartRecord(AppConsts.shift3OverTime[0]);
                input.setEndRecord(AppConsts.shift3OverTime[1]);
                g38V22OEEDataTemporaryService.addnewhalt(input);// add day
            }



        }

        if(deviceName.equals("V23")){
            if(shiftName.equals("SHIFT1")){
                G38V23OEEDataTemporaryInput input1 = new G38V23OEEDataTemporaryInput();
                G38V23OEEDataTemporaryInput input2 = new G38V23OEEDataTemporaryInput();
                input1.setType(0);
                input2.setType(0);
                input1.setIsProduction(3);
                input2.setIsProduction(3);
                calstart.add(Calendar.DAY_OF_WEEK, -1);
                Date dateStartBefore = calstart.getTime();
                input1.setStartDateTime(dateStartBefore);
                input1.setEndDateTime(dateStartBefore);        //Date
                input1.setStartRecord(AppConsts.shift1OverTime[0]);
                input1.setEndRecord(96);                       //Record

                g38V23OEEDataTemporaryService.addnewhalt(input1);//add day before

                input2.setStartDateTime(dateStart);
                input2.setEndDateTime(dateStart);
                input2.setStartRecord(1);
                input2.setEndRecord(AppConsts.shift1OverTime[1]);

                g38V23OEEDataTemporaryService.addnewhalt(input2);// add day

            }
            if(shiftName.equals("SHIFT2")){
                G38V23OEEDataTemporaryInput input = new G38V23OEEDataTemporaryInput();
                input.setType(0);
                input.setIsProduction(3);

                input.setStartDateTime(dateStart);
                input.setEndDateTime(dateStart);        //Date
                input.setStartRecord(AppConsts.shift2OverTime[0]);
                input.setEndRecord(AppConsts.shift2OverTime[1]);
                g38V23OEEDataTemporaryService.addnewhalt(input);// add day

            }
            if(shiftName.equals("SHIFT3")){

                G38V23OEEDataTemporaryInput input = new G38V23OEEDataTemporaryInput();
                input.setType(0);
                input.setIsProduction(3);
                input.setStartDateTime(dateStart);
                input.setEndDateTime(dateStart);        //Date
                input.setStartRecord(AppConsts.shift3OverTime[0]);
                input.setEndRecord(AppConsts.shift3OverTime[1]);
                g38V23OEEDataTemporaryService.addnewhalt(input);// add day
            }






        }

        return true;
    }







}
