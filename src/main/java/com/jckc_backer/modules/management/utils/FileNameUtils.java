package com.jckc_backer.modules.management.utils;

public class FileNameUtils {
    /**
     * 获取文件后缀
     * @param fileName
     * @return
     */
    public static String getSuffix(String fileName){
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 生成新的文件名
     */
    public static String getFileName(String fileOriginName){
        return UUIDUtils.getUUID() + FileNameUtils.getSuffix(fileOriginName);
    }
}
