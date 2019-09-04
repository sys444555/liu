package com.jckc_backer.modules.management.controller;

import com.jckc_backer.common.utils.ResponseUtil;
import com.jckc_backer.modules.management.entity.AdvertisementEntity;
import com.jckc_backer.modules.management.entity.AdvertisementVO;
import com.jckc_backer.modules.management.service.AdvertisementService;
import com.jckc_backer.modules.management.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/advertisement")
public class AdvertisementController {

    private final ResourceLoader resourceLoader;

    @Resource
    private AdvertisementService advertisementService;

    @Autowired
    public AdvertisementController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

/*    @Value("${web.upload-path}")
    private String path;*/

    /**
     * @param file 上传的文件
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResponseUtil insertPictureAddress(@RequestParam("file") MultipartFile file, AdvertisementEntity advertisementEntity) {
        //        // 拿到文件名
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
            advertisementEntity.setDateAdd(new Date());
            advertisementEntity.setDateUpdate(new Date());
            advertisementEntity.setPicUrl(filename);
            System.out.println(advertisementEntity + "      1111111111111111111");
            advertisementService.insertAdvertisement(advertisementEntity);
            return ResponseUtil.success();
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseUtil.error();
        }

    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseUtil showList() {
        List<AdvertisementVO> advertisementVO = advertisementService.showList();
        System.out.println(advertisementVO);
        return ResponseUtil.success(advertisementVO);
    }
}
