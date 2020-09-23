package com.jckc_backer.modules.management.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUtils {
    /**
     * @param file 文件
     * @param path 文件存放路径
     * @param fileName 原文件名
     * @return
     */
    public static String upload(MultipartFile file, String path, String fileName) throws IOException {

        String str = FileNameUtils.getFileName(fileName);

        //生成新的文件名
        String realPath = path + "/" + str;

        //使用原文件名
        //String realPath = path + "/" +fileName;
        File dest = new File(realPath);

        //判断文件父目录是否存在
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }
            //保存文件
            file.transferTo(dest);
        return str;
    }
}
