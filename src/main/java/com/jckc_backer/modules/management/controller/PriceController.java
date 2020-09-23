package com.jckc_backer.modules.management.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jckc_backer.common.utils.ResponseUtil;
import com.jckc_backer.modules.management.entity.PriceEntity;
import com.jckc_backer.modules.management.service.PriceService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/price")
public class PriceController {

    @Resource
    private PriceService priceService;

    @RequestMapping(value="/insert",method= RequestMethod.POST)
    public ResponseUtil insertShoopEntity(PriceEntity priceEntity){
        priceService.insertPrice(priceEntity);
        return ResponseUtil.success();
    }

    @RequestMapping(value="/update",method=RequestMethod.POST)
    public ResponseUtil updatePriceEntity(PriceEntity priceEntity){
        priceService.updatePrice(priceEntity);
        return ResponseUtil.success();
    }

    @RequestMapping(value="/delete/{id}",method=RequestMethod.POST)
    public ResponseUtil deleteById(@PathVariable Integer id){
        priceService.deleteById(id);
        return ResponseUtil.success();
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseUtil priceEntityList(int pageNo, int pageSize){
        PageHelper.startPage(pageNo, pageSize);
        EntityWrapper<PriceEntity> wrapper = new EntityWrapper<PriceEntity>();
        List<PriceEntity> pageList =priceService.getList(wrapper);
        PageInfo<PriceEntity> pageInfo=new PageInfo<>(pageList);
        return ResponseUtil.success(pageInfo);
    }
}
