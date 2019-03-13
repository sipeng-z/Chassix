package com.upload.service;

import com.core.dao.Dao;
import com.domain.model.*;
import com.model.AppConsts;
import com.upload.domain.model.FileInfoOutput;
import com.upload.domain.model.FileOutput;
import com.upload.domain.model.FunOutput;
import com.upload.entity.AttachmentConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.List;

@Service
public class FileService {
    @Autowired
    private Dao daoImp;

    private static final String MAPPERNAME = "com.mybatis.mapper.AttachmentConfigMapper.";

    public FileOutput uploadReturn(MultipartFile file, PageData pageData, HttpServletRequest request) throws Exception {
        AttachmentConfig attachmentConfig = null;
        FileOutput fileOutput = new FileOutput();
        long fileSize = file.getSize();
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));

        int index = fileName.lastIndexOf("\\");
        if (index != -1) {
            fileName = fileName.substring(index + 1);
        }
        int hashCode = fileName.hashCode();
        //把hash值转换为十六进制
        String hex = Integer.toHexString(hashCode);

        // String filePath = request.getSession().getServletContext().getRealPath("/");
        String filePath = AppConsts.filePathServer;  //PROPERTIES


        String returnPath =  "/" + new Date().getTime() + "_" + fileName;

        filePath += returnPath;


        File dest = new File(filePath);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        file.transferTo(dest);
        fileOutput.setFilePath(returnPath);
        fileOutput.setFileName(fileName);
        fileOutput.setSuffixName(suffixName);
        fileOutput.setFileSize((double) fileSize / 1024.0);
        fileOutput.setSuccess(true);
        fileOutput.setMessage("上传成功");
        return fileOutput;
    }

    /**
     * 上传文件校验 out
     *
     * @Author: yyhuan
     * @Date: 20180903
     * @Description:
     */
    public FunOutput<FileInfoOutput> checkedFile(MultipartFile file, PageData pageData, HttpServletRequest request) throws Exception {

        FunOutput<FileInfoOutput> retOut = new FunOutput<FileInfoOutput>();
        retOut.setSuccess(false);
        retOut.setMessage("操作失败");
        retOut.setData(null);

        //查询配置
        AttachmentConfig attachmentConfig = null;
        List<AttachmentConfig> list = (List<AttachmentConfig>) daoImp.findForList(MAPPERNAME + "findByResoutceType", pageData);
        if (list != null && list.size() > 0) {
            attachmentConfig = list.get(0);//默认
            if (pageData != null &&
                    pageData.containsKey("resourceType")) {
                String _resourceType = pageData.getString("resourceType");
                for (AttachmentConfig config : list) {
                    if (config.getResourceType().equals(_resourceType)) {
                        attachmentConfig = config;
                        break;
                    }
                }
            }
        }

        if (attachmentConfig == null) {
            retOut.setMessage("上传配置信息错误无法配置");
            return retOut;
        }
        //大小
        long fileSize = file.getSize();
        if (attachmentConfig.getMaxSize() < fileSize) {
            retOut.setMessage("文件超过最大限制");
            return retOut;
        }
        //文件格式
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        if (attachmentConfig.getAllowFiles().indexOf(suffixName) < 0) {
            retOut.setMessage("文件类型错误");
            return retOut;
        }
        //保存
        int index = fileName.lastIndexOf("\\");
        if (index != -1) {
            fileName = fileName.substring(index + 1);
        }
        int hashCode = fileName.hashCode();
        //把hash值转换为十六进制
        String hex = Integer.toHexString(hashCode);

        //路劲头
        //String pathHeader = "E://nginx-1.13.9//html//";//正式
        String pathHeader = "C://Program Files//Apache Software Foundation//nginx-1.13.8//html//";//测试路径

        StringBuilder sb = new StringBuilder();
        sb.append("/" + hex.charAt(0));
        sb.append("/" + hex.charAt(1));
        sb.append("/" + new Date().getTime() + "_" + fileName);
        String pathEnd = sb.toString();

        File fileInfo = new File(pathHeader + pathEnd);
        if (!fileInfo.getParentFile().exists()) {
            fileInfo.getParentFile().mkdirs();
        }
        file.transferTo(fileInfo);

        //组装数据
        FileInfoOutput fileInfoOutput = new FileInfoOutput();
        fileInfoOutput.setFileName(fileName);
        fileInfoOutput.setFilePath(pathEnd);
        fileInfoOutput.setFileSize((double) fileSize / 1024.0);
        fileInfoOutput.setSuffixName(suffixName);

        retOut.setSuccess(true);
        retOut.setMessage("上传成功");
        retOut.setData(fileInfoOutput);

        return retOut;
    }
}
