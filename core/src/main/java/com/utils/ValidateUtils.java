package com.utils;

import java.util.UUID;

import com.model.AppConsts;

public class ValidateUtils {


    /**
     * 字符串是否为Guid类型
     *
     * @param uuid
     * @return
     */
    public static boolean IsUUID(String uuid) {
        boolean result = false;
        if (uuid != null && !uuid.equals("") && uuid.length() == 36) {
            try {
                UUID uid = UUID.fromString(uuid);
                result = true;
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        return result;
    }


    public static boolean isDefaultValue(String uuid){
        if(ValidateUtils.IsUUID(uuid) && !uuid.equals(AppConsts.defaultGuId)){
            return true;
        }
        return false;
    }
    /**
     * 字符串是否不为空GUID
     *
     * @param uuid
     * @return true-证明当前guid是空GUID()  false-则为合格guid
     */
    public static boolean UUIDIsEmpty(String uuid) {
        return UUIDIsEmpty(StringUtils.StringToGuid(uuid));
    }


    /**
     * 是否为空uuid
     *
     * @param guid
     * @return true-证明当前guid是空GUID()  false-则为合格guid
     */
    public static boolean UUIDIsEmpty(UUID guid) {
        return guid.equals(UUID.fromString(AppConsts.defaultGuId));
    }

    public static void main(String[] args) {
        System.out.println(UUIDIsEmpty(AppConsts.defaultGuId));
        System.out.println(isDefaultValue(AppConsts.defaultGuId));
    }


}
