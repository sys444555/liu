package com.jckc_backer.modules.management.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jckc_backer.common.utils.ResponseUtil;
import com.jckc_backer.modules.management.entity.ShopEntity;
import com.jckc_backer.modules.management.service.ShopService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/shop")
public class ShopController {

    @Resource
    private ShopService shopService;

    @RequestMapping(value="/insert",method= RequestMethod.POST)
    public ResponseUtil insertShopEntity(ShopEntity shopEntity){
        shopService.insertPrice(shopEntity);
        return ResponseUtil.success();
    }

    @RequestMapping(value="/update",method=RequestMethod.POST)
    public ResponseUtil updatePriceEntity(ShopEntity shopEntity){
        shopService.updatePrice(shopEntity);
        return ResponseUtil.success();
    }

    @RequestMapping(value="/delete/{id}",method=RequestMethod.POST)
    public ResponseUtil deleteById(@PathVariable Integer id){
        shopService.deleteById(id);
        return ResponseUtil.success();
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseUtil priceEntityList(int pageNo, int pageSize){
        PageHelper.startPage(pageNo, pageSize);
        EntityWrapper<ShopEntity> wrapper = new EntityWrapper<ShopEntity>();
        List<ShopEntity> pageList =shopService.getList(wrapper);
        PageInfo<ShopEntity> pageInfo=new PageInfo<>(pageList);
        return ResponseUtil.success(pageInfo);
    }
}
