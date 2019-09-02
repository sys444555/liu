package com.jckc_backer.productinfo.controller;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jckc_backer.common.utils.ResponseUtil;
import com.jckc_backer.productinfo.entity.ProductInfoEntity;
import com.jckc_backer.productinfo.service.ProductInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 
 *
 * @author fenghuang
 * @email 
 * @date 2019-08-30 16:40:17
 */
@RestController
@RequestMapping("/productinfo")
public class ProductInfoController {
    @Autowired
    private ProductInfoService productInfoService;

    /**
     * 列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseUtil list(@RequestParam Map<String, Object> params){
        EntityWrapper<ProductInfoEntity> entityEntityWrapper = new EntityWrapper<>();
        List<ProductInfoEntity> productInfoEntities = productInfoService.productInfoList(entityEntityWrapper);
        return ResponseUtil.success(productInfoEntities);
    }




}
