package com.project.service;

import org.junit.Test;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ConversionToolService {


    /**
     * String to Date
     * format  :    yyyyMMdd
     * @return  Date
     */
    public Date stringToDate(String dateString)throws Exception{

        SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMdd");
        Date resultDate = sdf.parse(dateString);
        return resultDate;

    }

    /**
     *  Date to String
     * format  :    yyyyMMdd
     * @return  String
     */
    public String dateToString(Date date)throws Exception{

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String resultString = sdf.format(date);
        return resultString;

    }

    /**
     * Year and weekNo to get first Monday in this week
     * @param year
     * @param weekNo
     * @return Date (Monday)
     */
    public Date weekNoFirstMonday(Integer year, Integer weekNo){

        Calendar cal = Calendar.getInstance(); //get calendar
        cal.set(Calendar.YEAR,year);
        cal.set(Calendar.WEEK_OF_YEAR, weekNo);
        cal.set(Calendar.DAY_OF_WEEK, 2); //2 means Monday
        Date resultDate = cal.getTime();
        return resultDate;
    }


    /**
     * Modify the date , plus, minus
     * @param date, number
     *              number >0 ;  +
     *              number <0 ;  -
     *
     * @return
     * @throws Exception
     */
    public Date dateModification(Date date,Integer number)throws Exception{
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_WEEK, number);
        Date resultDate = cal.getTime();
        return resultDate;
    }




    /**
     * Date time Minus result
     * @return
     * @throws Exception
     */
    public Integer DateMinus(Date date1 , Date date2)throws Exception{

        long diff = (date1.getTime() - date2.getTime())/1000; //ms

        return new Long(diff).intValue();

    }




    /**
     * parseStart1,End1 to Integer
     *
     * time to recordNO
     * exam,8:00-->33
     * @return
     */
    public List<Integer> parseString(String Start, String End) {

        List<Integer> list = new ArrayList<>();
        String[] startAfter = Start.split(":");
        String[] endAfter = End.split(":");


        Integer sRecordBase = (Integer.valueOf(startAfter[0]) * 4) + 1;
        Integer sRecordAdd = Integer.valueOf(startAfter[1]) / 15;
        Integer sRecordStart = sRecordBase + sRecordAdd;
        list.add(sRecordStart);


        Integer eRecordBase = (Integer.valueOf(endAfter[0]) * 4) + 1;
        Integer eRecordAdd = Integer.valueOf(endAfter[1]) / 15;
        Integer eRecordStart = eRecordBase + eRecordAdd;
        list.add(eRecordStart);

        return list;

    }

    /**
     *
     *parse Integer  to time
     *  recordNO to time
     * exam,33-->>08:00
     * @return
     */
    public List<String> parseRecord(Integer startRecord, Integer endRecord) {
        List<String> list = new ArrayList<>();
        String startTime = "";
        String endTime = "";

        String startBase = Integer.valueOf(startRecord/4).toString();
        String startAdd = String.valueOf(Integer.valueOf(startRecord%8)*15);

        String endBase = Integer.valueOf(endRecord/4).toString();
        String endAdd = String.valueOf(Integer.valueOf(endRecord%8)*15);


        if(startBase.length()<2){
            startBase= "0"+startBase;
        }
        if(endBase.length()<2){
            endBase= "0"+endBase;
        }

        if(startAdd.equals("0")){
            startAdd="00";
        }
        if(endAdd.equals("0")){
            endAdd="00";
        }
        startTime+=startBase+":"+startAdd;
        endTime+=endBase+":"+endAdd;
        list.add(startTime);
        list.add(endTime);


        return list;
    }


    /**
     * using date time to get time belog which record
     * 96 records per day
     * @param date
     * @return
     */
    public Integer timeToRecord(Date date){

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String hourMinutes = sdf.format(date);
        String[] hourMinutesAfter = hourMinutes.split(":");

        Integer RecordBase = (Integer.valueOf(hourMinutesAfter[0]) * 4) + 1;
        Integer RecordAdd = Integer.valueOf(hourMinutesAfter[1]) / 15;
        Integer RecordStart = RecordBase + RecordAdd;

        return RecordStart;


    }






//    @Test
//    public void test()throws Exception{
//        Date today1 = new Date();
//        Thread.sleep(5000);
//        Date today2 = new Date();
//
//       System.out.println( this.DateMinus(today2,today1));
//
//    }



}
