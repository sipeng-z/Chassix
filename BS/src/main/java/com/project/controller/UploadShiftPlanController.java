package com.project.controller;

import com.domain.model.PageData;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "g38shiftplan")
public class UploadShiftPlanController {

    private static final Logger logger = LoggerFactory.getLogger(UploadShiftPlanController.class);

    @Autowired
    private FileService fileService;

    /**
     * G38 shift plan for xls  uploading and parsing
     * @param request
     * @param response
     * @param action
     * @return
     */
    @RequestMapping(value = "uploadplan", method = RequestMethod.POST)
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

                String  filePath = fileOutput.getFilePath();




            } catch (IllegalStateException e) {
                rtMge = "upload error";
                e.printStackTrace();
            } catch (IOException e) {
                rtMge = "upload error";
                e.printStackTrace();
            } catch (Exception ee) {
                rtMge = "upload error";
                logger.error(ee.toString());
            }
        }
        result.setMessage(rtMge);
        result.setSuccess(true);
        result.setData(returnList);
        return result;
    }







}
