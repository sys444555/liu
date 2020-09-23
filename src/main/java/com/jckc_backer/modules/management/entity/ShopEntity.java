package com.jckc_backer.modules.management.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("价格管理列表")
@Data
@TableName("shop_management")
public class ShopEntity {

    @ApiModelProperty(value = "自增ID",name = "id")
    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "商品名称",name="shop")
    private String shop;

}
