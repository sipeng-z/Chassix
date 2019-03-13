package com.casting.upload;

import com.casting.domain.model.input.CastingCPCGeneralShiftInput;
import com.casting.domain.model.output.CastingCPCGeneralShiftOutput;
import com.casting.service.CastingCPCGeneralOEEDataTemporaryService;
import com.casting.service.CastingCPCGeneralShiftService;
import com.casting.service.CastingCPCGeneralOEEDataTemporaryService;
import com.casting.service.CastingCPCGeneralShiftService;
import com.domain.model.PageData;
import com.model.AppConsts;
import com.response.ResponseResult;
import com.upload.controller.ExcelController;
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
import java.util.*;

@RestController
public class GeneralUpload4Casting {

    private static final Logger logger = LoggerFactory.getLogger(GeneralUpload4Casting.class);




    @Autowired
    private FileService fileService;


    @Autowired
    private ExcelController excelController;

    @Autowired
    private CastingCPCGeneralShiftService castingCPCGeneralShiftService;


    @Autowired
    private CastingCPCGeneralOEEDataTemporaryService castingCPCGeneralOEEDataTemporaryService;


    /**
     * Casting Shift upload and parse
     * all in one
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "GeneraluploadCPCShift", method = RequestMethod.POST)
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
                if(!A[1].equals("xls")&&!A[1].equals("xlsx")){
                    //Should be deleted here

                    result.setMessage("Error! Format xls/xlsx only");
                    result.setSuccess(false);
                    return result;
                }else {
                    //delete the document or do nothing(junk file)
                }
                String filePath = fileOutput.getFilePath();
                Collection<Map> importExcel =  excelController.importXlsx(filePath);
                String weekNo4Fix = "";
              List<String> deviceAll = new ArrayList<>();
                for(Map m : importExcel){
                    String Part = m.get("Part").toString();
                    String deviceName = m.get("DEVICE").toString();
                    String shiftName = m.get("SHIFT").toString();
                    String weekNo = m.get("Week").toString();
                    weekNo4Fix = weekNo;
                    deviceAll.add(deviceName);
                    String mon = "";
                    String tue = "";
                    String wed = "";
                    String thu = "";
                    String fri = "";
                    String sat = "";
                    String sun = "";

                    if(m.get("Monday")!=null){
                        mon = m.get("Monday").toString();
                    }
                    if(m.get("Tuesday")!=null){
                        tue = m.get("Tuesday").toString();
                    }
                    if(m.get("Wednesday")!=null){
                        wed = m.get("Wednesday").toString();
                    }
                    if(m.get("Thursday")!=null){
                        thu = m.get("Thursday").toString();
                    }
                    if(m.get("Friday")!=null){
                        fri = m.get("Friday").toString();
                    }
                    if(m.get("Saturday")!=null){
                        sat = m.get("Saturday").toString();
                    }
                    if(m.get("Sunday")!=null){
                        sun = m.get("Sunday").toString();
                    }
                    // need to build 16 different CPC service
                    //to do list : check with production about their format of shift plan


                        //judge for week if is exist
                        PageData  pageData4week = new PageData();
                        pageData4week.put("weekNo",weekNo4Fix);
                        List<CastingCPCGeneralShiftOutput> shiftlist = castingCPCGeneralShiftService.generallist(false,pageData4week,deviceName);

                        if(shiftlist.size()>=3){
                            rtMge = " Week shift exist!";
                            result.setMessage(rtMge);
                            result.setSuccess(false);
                            result.setData(returnList);
                            return result;
                        }

                        CastingCPCGeneralShiftInput input = new CastingCPCGeneralShiftInput();
                        input.setMon(mon);
                        input.setTue(tue);
                        input.setWed(wed);
                        input.setThu(thu);
                        input.setFri(fri);
                        input.setSat(sat);
                        input.setSun(sun);
                        input.setWeekNo(Integer.valueOf(weekNo));
                        input.setShiftName(shiftName);
                        input.setMark(0);
                        castingCPCGeneralShiftService.add(input);

                    System.out.println(" Upload shift plan cpc General success");


                }





                Date newDate = new Date(); //when : upload time  = real time

                Calendar date = Calendar.getInstance();
                String year = String.valueOf(date.get(Calendar.YEAR));


                List<String> deviceUnique = new ArrayList<>();
                for(int i=0;i<deviceAll.size();i++){

                    if(!deviceUnique.contains(deviceAll.get(i))){
                        deviceUnique.add(deviceAll.get(i));
                    }
                }

                for(String device :deviceUnique){
                    Boolean flag = castingCPCGeneralOEEDataTemporaryService.fixLnB(AppConsts.yearNo,Integer.valueOf(weekNo4Fix),device);

                }



            } catch (IllegalStateException e) {
                rtMge = "upload illegal state error";
                e.printStackTrace();
                result.setMessage(rtMge);
                result.setSuccess(false);
                result.setData(returnList);
                return result;
            } catch (IOException e) {
                rtMge = "upload io error";
                e.printStackTrace();
                result.setMessage(rtMge);
                result.setSuccess(false);
                result.setData(returnList);
                return result;
            } catch (Exception ee) {
                rtMge = "upload ee error";
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




}
