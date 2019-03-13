package com.system.domain.model.output;


import com.system.domain.entity.Attachment;

public class AttachmentOutput extends Attachment {

//连表查询使用
    public String projectName;

    public String projectNo;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    private String typeName;
    public String getTypeName() {
        if(this.getType()!=null)
        {
            switch (this.getType())
            {
                case 0:
                    typeName="";
                    break;
                case 1:
                    typeName="报批文件";
                    break;
                case 3:
                    typeName="佐证资料";
                    break;
                case 5:
                    typeName="其他";
                    break;
                default:
                    typeName="";
                    break;

            }
        }
        return typeName;
    }
    public void setTypeName() { this.typeName = typeName == null ? null : typeName.trim();}







}
