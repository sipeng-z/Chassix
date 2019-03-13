package com.project.service;

import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Vector;

@Service
public class FileGeter {

    //获取所有文件
    public Vector<File> getAllFile(String datasetpath,Vector<File> vecFile) {
        File file = new File(datasetpath);
        File[] subFile = file.listFiles();
        for (int i = 0; i < subFile.length; i++) {
            if (subFile[i].isDirectory()) {
                getAllFile(subFile[i].getAbsolutePath(),vecFile);
            } else {
                vecFile.add(subFile[i]);
            }
        }
        return vecFile;
    }

    //获取所有Json的绝对路径
    public Vector<String> getAllPath(String path) {
        File file = new File(path);
        File[] subFile = file.listFiles();//返回一个抽象路径名数组，这些路径名表示此抽象路径名表示的目录中的文件。
        Vector<String> vecPath=new Vector<String>();
        for (int i = 0; i < subFile.length; i++) {
            if (subFile[i].isDirectory()) {
                getAllPath(subFile[i].getAbsolutePath());
            } else {
                vecPath.add(subFile[i].getAbsolutePath());
            }
        }
        return vecPath;
    }





}