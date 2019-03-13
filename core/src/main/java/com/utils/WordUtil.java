package com.utils;

public class WordUtil {

    public static String getFileTitle(String fileName) {
        String str = "<p style=\"text-align: center;\"><span style=\"font-size:58px\"><strong style=\"\">";
        String str1 = "</strong></span><br/></p>";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(fileName);
        sb.append(str1);
        return sb.toString();
    }


    public static String getSubtitle(String fileName) {
        String str = "<p style=\"text-align: center;\"><span style=\"font-size:48px\"><strong style=\"\">";
        String str1 = "</strong></span><br/></p>";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(fileName);
        sb.append(str1);
        return sb.toString();
    }

    public static String getLable(String lable) {
        String str = "<ul class=\" list-paddingleft-2\" style=\"list-style-type: disc;\"><li><p><span style=\"font-size: 36px;\"><strong>";
        String str1 = "</strong></span></p></li></ul>";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(lable);
        sb.append(str1);
        return sb.toString();
    }

    public static String getContent(String content) {
        String str = "<p class=\"__reader_view_article_wrap_8961006553330229__\" style=\"color: rgb(69, 69, 69); font-family: &quot;PingFang SC&quot;; font-size: 24px; white-space: normal; background-color: rgb(255, 255, 255);\">";
        String str1 = "</p><p><br/></p>";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(content);
        sb.append(str1);
        return sb.toString();
    }


}
