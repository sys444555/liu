package com.jckc_backer.modules.shoop.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jckc_backer.common.utils.ResponseUtil;
import com.jckc_backer.modules.shoop.entity.ShoopEntity;
import com.jckc_backer.modules.shoop.service.ShoopService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/shoop")
public class ShoopController {

    @Resource
    private ShoopService shoopService;

    @RequestMapping(value="/insert",method= RequestMethod.POST)
    public ResponseUtil insertShoopEntity(ShoopEntity shoopEntity){
        shoopService.insertShoop(shoopEntity);
        return ResponseUtil.success();
    }

    @RequestMapping(value="/select",method= RequestMethod.POST)
    public ResponseUtil selectShoopEntity(String name){
       ShoopEntity shoopEntity= shoopService.selectByName(name);
        return ResponseUtil.success(shoopEntity);
    }

    @RequestMapping(value="/update",method=RequestMethod.POST)
    public ResponseUtil updateShoopEntity(ShoopEntity shoopEntity){
        shoopService.updateShoop(shoopEntity);
        return ResponseUtil.success();
    }

    @RequestMapping(value="/delete/{id}",method=RequestMethod.POST)
    public ResponseUtil deleteById(@PathVariable Integer id){
        shoopService.deleteById(id);
        return ResponseUtil.success();
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseUtil shoopEntityList(int pageNo, int pageSize){
        PageHelper.startPage(pageNo, pageSize);
        EntityWrapper<ShoopEntity> wrapper = new EntityWrapper<ShoopEntity>();
        List<ShoopEntity> pageList =shoopService.getList(wrapper);
        PageInfo<ShoopEntity> pageInfo=new PageInfo<>(pageList);
        return ResponseUtil.success(pageInfo);
    }
}
