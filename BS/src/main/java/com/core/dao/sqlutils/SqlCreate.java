package com.core.dao.sqlutils;

import com.domain.model.PageData;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class SqlCreate {
    public final static String LIKE = "_Like";
    public final static String DATE = "_Date";
    public final static String DATETIME = "_DateTime";
    public final static String EQUAL = "_Equal";
    public final static String START = "_Start";
    public final static String END = "_End";


    public static String where(PageData pageData) throws ParseException {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : pageData.getMap().entrySet()) {
            String keyName = entry.getKey();
            if (keyName.indexOf(LIKE) >= 0) {
                sb.append(" AND " + keyName.substring(0, keyName.length() - LIKE.length())
                        + " LIKE '%" + entry.getValue() + "%'");
            }

            if (keyName.indexOf(DATE) >= 0&&!"".equals(entry.getValue())) {
                if(getEndDate(entry.getValue()) == null){
                    continue;
                }
                if (keyName.indexOf(START) >= 0) {
                    sb.append(" AND " + keyName.substring(0, keyName.length() - (DATE.length() + START.length())) +
                            " > '" + entry.getValue()+"'");
                }

                if (keyName.indexOf(END) >= 0) {
                    sb.append(" AND " + keyName.substring(0, keyName.length() - (DATE.length() + END.length())) +
                            " < " + "'"+getEndDate(entry.getValue())+"'");
                }

            }

            if (keyName.indexOf(DATETIME) >= 0&&!"".equals(entry.getValue())) {
                if(getEndDate(entry.getValue()) == null){
                    continue;
                }
                if (keyName.indexOf(START) >= 0) {
                    sb.append(" AND " + keyName.substring(0, keyName.length() - (DATETIME.length() + START.length())) +
                            " > " + "'"+entry.getValue()+"'");
                }

                if (keyName.indexOf(END) >= 0) {
                    sb.append(" AND " + keyName.substring(0, keyName.length() - (DATETIME.length() + END.length())) +
                            " < " + "'"+entry.getValue()+"'");
                }
            }

            if (keyName.indexOf(EQUAL) >= 0) {
                sb.append(" AND " + keyName.substring(0, keyName.length() - EQUAL.length()) +
                        " = " + "'"+entry.getValue()+"'");
            }
        }
        return sb.toString();
    }


    private static String getEndDate(String date) throws ParseException {
        if(date == null || "".equals(date)){
            return null;
        }
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date time = fmt.parse(date);

        return sdf.format(new Date(time.getTime() + 1000 * 60 * 60 * 24));
    }


}
