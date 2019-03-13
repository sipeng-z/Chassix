package com.upload.controller;




import com.model.AppConsts;
import com.project.domain.model.input.G38ASSYShiftInput;
import com.project.domain.model.input.G38V21ShiftInput;
import com.project.domain.model.input.G38V22ShiftInput;
import com.project.domain.model.input.G38V23ShiftInput;

import com.project.domain.model.output.G38ASSYShiftOutput;
import com.project.domain.model.output.G38V21ShiftOutput;
import com.project.domain.model.output.G38V22ShiftOutput;
import com.project.domain.model.output.G38V23ShiftOutput;
import com.project.service.*;
import com.upload.domain.model.FileInfoOutput;
import com.upload.domain.model.FileOutput;
import com.upload.domain.model.FunOutput;
import com.domain.model.PageData;
import com.response.ResponseResult;
import com.upload.service.FileService;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

@RestController
public class FileController {


    private static final Logger logger = LoggerFactory.getLogger(FileController.class);



    @Autowired
    private FileService fileService;


    @Autowired
    private  ExcelController excelController;

    @Autowired
    private G38ASSYShiftService g38ASSYShiftService;

    @Autowired
    private G38V21ShiftService g38V21ShiftService;

    @Autowired
    private G38V22ShiftService g38V22ShiftService;

    @Autowired
    private G38V23ShiftService g38V23ShiftService;


    @Autowired
    private G38WholeLineService g38WholeLineService;





    @RequestMapping(value = "uploadfile", method = RequestMethod.POST)
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

                    result.setMessage("Error! Format xls only");
                    result.setSuccess(false);
                    return result;
                }
                String filePath = fileOutput.getFilePath();
                Collection<Map> importExcel =  excelController.importXlsx(filePath);
                String weekNo4Fix = "";
                for(Map m : importExcel){
                    String line = m.get("LINE").toString();
                    String deviceName = m.get("DEVICE").toString();
                    String shiftName = m.get("SHIFT").toString();
                    String weekNo = m.get("Week").toString();
                    weekNo4Fix = weekNo;

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

                   if(deviceName.equals("ASSY")){
                        PageData pageData = new PageData();
                        pageData.put("weekNo",weekNo4Fix);
                        List<G38ASSYShiftOutput> list = g38ASSYShiftService.list(false,pageData);
//                        if(list.size()>=3){
//                            rtMge = " G38 ASSY Week shift exist!";
//                            result.setMessage(rtMge);
//                            result.setSuccess(false);
//                            result.setData(returnList);
//                            return result;
//                        }
                       G38ASSYShiftInput input = new G38ASSYShiftInput();
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
                       g38ASSYShiftService.add(input);
                   }

                    if(deviceName.equals("V21")){

                        PageData pageData = new PageData();
                        pageData.put("weekNo",weekNo4Fix);
                        List<G38V21ShiftOutput> list = g38V21ShiftService.list(false,pageData);
//                        if(list.size()>=3){
//                            rtMge = " G38 V21 Week shift exist!";
//                            result.setMessage(rtMge);
//                            result.setSuccess(false);
//                            result.setData(returnList);
//                            return result;
//                        }
                        G38V21ShiftInput input = new G38V21ShiftInput();
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
                        g38V21ShiftService.add(input);
                    }

                    if(deviceName.equals("V22")){

                        PageData pageData = new PageData();
                        pageData.put("weekNo",weekNo4Fix);
                        List<G38V22ShiftOutput> list = g38V22ShiftService.list(false,pageData);
//                        if(list.size()>=3){
//                            rtMge = " G38 V22 Week shift exist!";
//                            result.setMessage(rtMge);
//                            result.setSuccess(false);
//                            result.setData(returnList);
//                            return result;
//                        }
                        G38V22ShiftInput input = new G38V22ShiftInput();
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
                        g38V22ShiftService.add(input);

                    }

                    if(deviceName.equals("V23")){

                        PageData pageData = new PageData();
                        pageData.put("weekNo",weekNo4Fix);
                        List<G38V23ShiftOutput> list = g38V23ShiftService.list(false,pageData);
//                        if(list.size()>=3){
//                            rtMge = " G38 V23 Week shift exist!";
//                            result.setMessage(rtMge);
//                            result.setSuccess(false);
//                            result.setData(returnList);
//                            return result;
//                        }
                        G38V23ShiftInput input = new G38V23ShiftInput();
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
                        g38V23ShiftService.add(input);
                    }


                    System.out.println(" Upload shift plan success");
                }

                Date newDate = new Date();


                Calendar date = Calendar.getInstance();
                String year = String.valueOf(date.get(Calendar.YEAR));

                Boolean flag =   g38WholeLineService.fixLnBinLine(Integer.valueOf(year),Integer.valueOf(weekNo4Fix));

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
     * Single file Upload
     * @Author: Chassix_IT Developer
     * @Date: $params$
     * @Description:
     */
    @RequestMapping(value = "singlefileupload", method = RequestMethod.POST)
    public ResponseResult singlefileupload(HttpServletRequest request, HttpServletResponse response, String action) {
        ResponseResult result = new ResponseResult();
        result.setMessage("");
        result.setSuccess(false);

        MultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        MultipartHttpServletRequest Murequest = resolver.resolveMultipart(request);

        Map<String, MultipartFile> files = Murequest.getFileMap();//map obj
        if (files == null ||
                files.size() < 1) {
            result.setMessage("Params is null");
            return result;
        }
        //single only
        MultipartFile singleFile = null;
        for (MultipartFile file : files.values()) {
            singleFile = file;
            break;
        }
        if (singleFile == null) {
            result.setMessage("Params doc is null");
            return result;
        }

        try {
            FunOutput<FileInfoOutput> fileOutput = fileService.checkedFile(singleFile, new PageData(request), request);

            result.setSuccess(fileOutput.getSuccess());
            result.setMessage(fileOutput.getMessage());
            result.setData(fileOutput.getData());
        } catch (Exception ee) {
            result.setMessage("Exception Back");
            result.setSuccess(false);
            logger.error(ee.toString());
            return result;
        }

        return result;
    }




    /**
     * DOWNLOAD FUNCTION
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/ExportShiftPlan")
    public void downloadFile(Integer weekNo,HttpServletRequest request, HttpServletResponse response) throws Exception {
        if(weekNo==null||weekNo.equals("")){
            response.sendError(500,"weekNo ERROR");
            return;
        }
        File file = g38WholeLineService.exportXlsForShiftPlan(weekNo);
      String  path =  file.getPath();  //whole path
      String  fileName = file.getName();
      String header = "attachment;filename="+fileName;

        String folder = AppConsts.folderServer;  //PROPERTIES
        try(InputStream inputStream = new FileInputStream(new File(folder,fileName));
            OutputStream outputStream = response.getOutputStream();) {
            //设置内容类型为下载类型
            response.setContentType("application/x-download");
            //设置请求头 和 文件下载名称
            response.addHeader("Content-Disposition",header);
            //用 common-io 工具 将输入流拷贝到输出流
            IOUtils.copy(inputStream,outputStream);
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }






    @RequestMapping(value = "/download4testing", method = RequestMethod.GET)
    public void download(HttpServletRequest request, HttpServletResponse response){
        String folder ="/Users/yangyuhuan/Desktop/DADownload/";
        try(InputStream inputStream = new FileInputStream(new File(folder,"shiftPlanExport.xls"));
            OutputStream outputStream = response.getOutputStream();) {
            //设置内容类型为下载类型
            response.setContentType("application/x-download");
            //设置请求头 和 文件下载名称
            response.addHeader("Content-Disposition","attachment;filename=shiftPlanExport.xls");
            //用 common-io 工具 将输入流拷贝到输出流
            IOUtils.copy(inputStream,outputStream);
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }


















    //multi
    @RequestMapping(value = "/batch/upload", method = RequestMethod.POST)
    @ResponseBody
    public String handleFileUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request)
                .getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(
                            new File(file.getOriginalFilename())));
                    stream.write(bytes);
                    stream.close();

                } catch (Exception e) {
                    stream = null;
                    return "You failed to upload " + i + " => "
                            + e.getMessage();
                }
            } else {
                return "You failed to upload " + i
                        + " because the file was empty.";
            }
        }
        return "upload successful";
    }
}
