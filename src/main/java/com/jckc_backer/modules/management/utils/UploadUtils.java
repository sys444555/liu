package com.jckc_backer.modules.management.utils;

import java.io.File;

public class UploadUtils {

    public static final String LOADPATH = "http://120.78.157.175/img/";

    // 项目根路径下的目录  -- SpringBoot static 目录相当于是根路径下（SpringBoot 默认）
   /* public final static String IMG_PATH_PREFIX = "static/img/shopImg";*/

    public static File getImgDirFile(){

        // 构建上传文件的存放 "文件夹" 路径
        String fileDirPath = new String("/usr/local/liu/html/img");

        //访问路径


        File fileDir = new File(fileDirPath);
        if(!fileDir.exists()){
            // 递归生成文件夹
            fileDir.mkdirs();
        }
        return fileDir;
    }
}
