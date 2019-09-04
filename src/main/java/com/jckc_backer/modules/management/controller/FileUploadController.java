package com.jckc_backer.modules.management.controller;

import com.jckc_backer.common.utils.ResponseUtil;
import com.jckc_backer.modules.management.entity.PictureEntity;
import com.jckc_backer.modules.management.service.PictureService;
import com.jckc_backer.modules.management.utils.UploadUtils;
import com.mchange.v2.sql.filter.SynchronizedFilterDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.constraints.Max;
import java.io.File;
import java.io.IOException;
import java.sql.SQLSyntaxErrorException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/upload")
public class FileUploadController {

    private final ResourceLoader resourceLoader;

    @Resource
    private PictureService pictureService;

    @Autowired
    public FileUploadController(ResourceLoader resourceLoader){
        this.resourceLoader = resourceLoader;
    }

/*    @Value("${web.upload-path}")
    private String path;*/

    /**
     * @param file 上传的文件
     * @return
     *
     */
    @RequestMapping(value = "/fileUpload",method= RequestMethod.POST)
    public ResponseUtil insertPictureAddress(@RequestParam("file") MultipartFile file, PictureEntity pictureEntity){
        // 拿到文件名
        String filename = file.getOriginalFilename();
        // 存放上传图片的文件夹
        File fileDir = UploadUtils.getImgDirFile();
        // 输出文件夹绝对路径  -- 这里的绝对路径是相当于当前项目的路径而不是“容器”路径
        System.out.println(fileDir.getAbsolutePath());

        try {
            // 构建真实的文件路径
            File newFile = new File(fileDir.getAbsolutePath() + File.separator + filename);
            System.out.println(newFile.getAbsolutePath());

            // 上传图片到 -》 “绝对路径”
            file.transferTo(newFile);
            pictureEntity.setDateAdd(new Date());
            pictureEntity.setPicUrl(filename);
            pictureService.insertPicture(pictureEntity);
            System.out.println(pictureEntity.getId());
            return ResponseUtil.success(pictureEntity.getId());
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseUtil.error();
        }

    }

   /* *//**
     * 显示图片
     * @param fileName 文件名
     * @return
     *//*
    @RequestMapping("show1")
    public ResponseEntity show(String fileName){
        System.err.println("-------------------------------");
        try{
            //由于是读取本机的文件，file是一定要加上的，path是在application配置文件中的路径
            return ResponseEntity.ok(resourceLoader.getResource("file:" + path + fileName));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }*/

}
