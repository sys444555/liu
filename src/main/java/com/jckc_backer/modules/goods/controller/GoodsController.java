package com.jckc_backer.modules.goods.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jckc_backer.common.utils.ResponseUtil;
import com.jckc_backer.modules.goods.entity.GoodsEntity;
import com.jckc_backer.modules.goods.service.GoodsService;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    private GoodsService goodsService;

    /**
     * 获取商品列表
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseUtil getGoodsList(int pageNo, int pageSize){
        PageHelper.startPage(pageNo, pageSize);
        List<GoodsEntity> goodsList = goodsService.getGoodsList();
        PageInfo<GoodsEntity> pageInfo = new PageInfo<>(goodsList);
        return ResponseUtil.success(pageInfo);
    }

    /**
     * 更新商品数据
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseUtil updateGoods(GoodsEntity goodsEntity){

         goodsService.updateGoods(goodsEntity);

        return ResponseUtil.success();
    }





}
