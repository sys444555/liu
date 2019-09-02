package com.jckc_backer.modules.shoop.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.jckc_backer.basic.BasicEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("机会销售信息汇总表视图实体类")
@Data
@TableName("shoop_form")
public class ShoopEntity extends BasicEntity {

    @ApiModelProperty(value = "自增ID",name = "id")
    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "图片地址",name="pictureAddress")
    @TableField("picture_address")
    private String pictureAddress;

    @ApiModelProperty(value = "套餐",name="setMeal")
    @TableField("set_meal")
    private String setMeal;

    @ApiModelProperty(value = "成交金额",name="money")
    private String money;

    @ApiModelProperty(value = "姓名",name="name")
    private String name;

    @ApiModelProperty(value = "手机号",name="phone")
    private String phone;

    @ApiModelProperty(value = "省份",name="province")
    private String province;

    @ApiModelProperty(value = "市",name="city")
    private String city;

    @ApiModelProperty(value = "区",name="area")
    private String area;

    @ApiModelProperty(value = "详细地址",name="fullAddress")
    @TableField("full_address")
    private String fullAddress;

    @ApiModelProperty(value = "留言",name="leaveWord")
    @TableField("leave_word")
    private String leaveWord;

    @ApiModelProperty(value = "状态",name="status")
    private String status;

    @ApiModelProperty(value = "单号",name="number")
    private String number;

}
