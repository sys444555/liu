package com.jckc_backer.modules.management.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jckc_backer.common.utils.ResponseUtil;
import com.jckc_backer.modules.management.entity.PictureEntity;
import com.jckc_backer.modules.management.service.PictureService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/picture")
public class PictureController {

    @Resource
    private PictureService pictureService;

    @RequestMapping(value="/updown/{id}",method=RequestMethod.POST)
    public ResponseUtil updownById(@PathVariable Integer id){
        pictureService.updownById(id);
        return ResponseUtil.success();
    }

    @RequestMapping(value="/update",method=RequestMethod.POST)
    public ResponseUtil updatePictureEntity(PictureEntity pictureEntity){
        pictureService.updatePicture(pictureEntity);
        return ResponseUtil.success();
    }
/*

    @RequestMapping(value="/list",method=RequestMethod.GET)
    public ResponseUtil getList(String type){
        List<PictureEntity> getList=pictureService.getListBytype(type);
        return ResponseUtil.success(getList);
    }
*/

   /* *
     *
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseUtil pictureEntityList(int pageNo, int pageSize){
        PageHelper.startPage(pageNo, pageSize);
        EntityWrapper<PictureEntity> wrapper = new EntityWrapper<PictureEntity>();
        List<PictureEntity> pageList =pictureService.getList(wrapper);
        PageInfo<PictureEntity> pageInfo=new PageInfo<>(pageList);
        return ResponseUtil.success(pageInfo);
    }
}
