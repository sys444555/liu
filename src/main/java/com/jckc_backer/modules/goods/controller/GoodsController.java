package com.jckc_backer.modules.goods.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jckc_backer.common.utils.ResponseUtil;
import com.jckc_backer.modules.goods.entity.GoodsEntity;
import com.jckc_backer.modules.goods.service.GoodsService;
import com.jckc_backer.modules.management.utils.UploadUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;


/**
 * @author ：fenghuang
 * @date ：Created in 2019/8/13 16:02
 * @description：
 * @modified By：
 * @version:
 */

@RestController
@Api(tags = "公告")
@RequestMapping("/goods")
public class GoodsController {

    private final ResourceLoader resourceLoader;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    public GoodsController(ResourceLoader resourceLoader) {
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
    public ResponseUtil insertPictureAddress(@RequestParam("file") MultipartFile file, GoodsEntity goodsEntity){
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
            goodsEntity.setDateAdd(new Date());
            goodsEntity.setPic(filename);
            String name=goodsEntity.getCategoryName();
            System.out.println(name);
            goodsService.getCategoryIdByName(name);
            /*pictureService.insertPicture(pictureEntity);*/
            return ResponseUtil.success();
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseUtil.error();
        }

    }


    /**
     * 获取订单
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseUtil getGoodsList(int pageNo, int pageSize){
        PageHelper.startPage(pageNo, pageSize);
        List<GoodsEntity> goodsList = goodsService.getGoodsList();
        PageInfo<GoodsEntity> pageInfo = new PageInfo<>(goodsList);
        return ResponseUtil.success(pageInfo);
    }





}
