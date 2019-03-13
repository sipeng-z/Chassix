package com.project.domain.model.input;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.domain.entity.GeneralProductionTemporary;

import java.util.Date;

public class GeneralProductionTemporaryInput extends GeneralProductionTemporary {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date startDateTime;

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date endDateTime;

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    private Integer startRecord;

    public Integer getEndRecord() {
        return endRecord;
    }

    public void setEndRecord(Integer endRecord) {
        this.endRecord = endRecord;
    }

    private Integer endRecord;

    public Integer getStartRecord() {
        return startRecord;
    }

    public void setStartRecord(Integer startRecord) {
        this.startRecord = startRecord;
    }


    public String getLineId() {
        return LineId;
    }

    public void setLineId(String lineId) {
        LineId = lineId;
    }

    public String getLineName() {
        return LineName;
    }

    public void setLineName(String lineName) {
        LineName = lineName;
    }

    public String getStart1() {
        return Start1;
    }

    public void setStart1(String start1) {
        Start1 = start1;
    }

    public String getEnd1() {
        return End1;
    }

    public void setEnd1(String end1) {
        End1 = end1;
    }

    public String getOp1() {
        return Op1;
    }

    public void setOp1(String op1) {
        Op1 = op1;
    }

    public String getStart2() {
        return Start2;
    }

    public void setStart2(String start2) {
        Start2 = start2;
    }

    public String getEnd2() {
        return End2;
    }

    public void setEnd2(String end2) {
        End2 = end2;
    }

    public String getOp2() {
        return Op2;
    }

    public void setOp2(String op2) {
        Op2 = op2;
    }

    public String getStart3() {
        return Start3;
    }

    public void setStart3(String start3) {
        Start3 = start3;
    }

    public String getEnd3() {
        return End3;
    }

    public void setEnd3(String end3) {
        End3 = end3;
    }

    public String getOp3() {
        return Op3;
    }

    public void setOp3(String op3) {
        Op3 = op3;
    }

    public String getStart4() {
        return Start4;
    }

    public void setStart4(String start4) {
        Start4 = start4;
    }

    public String getEnd4() {
        return End4;
    }

    public void setEnd4(String end4) {
        End4 = end4;
    }

    public String getOp4() {
        return Op4;
    }

    public void setOp4(String op4) {
        Op4 = op4;
    }

    public Integer getDuration1() {
        return Duration1;
    }

    public void setDuration1(Integer duration1) {
        Duration1 = duration1;
    }

    public Integer getDuration2() {
        return Duration2;
    }

    public void setDuration2(Integer duration2) {
        Duration2 = duration2;
    }

    public Integer getDuration3() {
        return Duration3;
    }

    public void setDuration3(Integer duration3) {
        Duration3 = duration3;
    }

    public Integer getDuration4() {
        return Duration4;
    }

    public void setDuration4(Integer duration4) {
        Duration4 = duration4;
    }

    private String LineId;
    private String LineName;

    private String Start1;
    private String End1;
    private String Op1;

    private String Start2;
    private String End2;
    private String Op2;

    private String Start3;
    private String End3;
    private String Op3;

    private String Start4;
    private String End4;
    private String Op4;


    private Integer Duration1;
    private Integer Duration2;
    private Integer Duration3;
    private Integer Duration4;









}
