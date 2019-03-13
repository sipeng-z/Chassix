package com.upload.domain.model;

import java.io.Serializable;

public class FileInfoOutput implements Serializable {
    private String fileName;
    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }

    private String suffixName;
    public String getSuffixName() { return suffixName; }
    public void setSuffixName(String suffixName) { this.suffixName = suffixName; }

    private String filePath;
    public String getFilePath() { return filePath; }
    public void setFilePath(String filePath) { this.filePath = filePath; }

    private double fileSize;
    public double getFileSize() { return fileSize; }
    public void setFileSize(double fileSize) { this.fileSize = fileSize; }
}
