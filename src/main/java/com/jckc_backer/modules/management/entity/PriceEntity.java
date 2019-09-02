package com.jckc_backer.modules.management.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel("价格管理列表")
@Data
@TableName("coupons")
public class PriceEntity {

    @ApiModelProperty(value = "自增ID",name = "id")
    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "套餐",name="pwd")
    private String pwd;

    @ApiModelProperty(value = "套餐",name="setMeal")
    @TableField("date_add")
    private Date dateAdd;

    @ApiModelProperty(value = "套餐",name="dateEndType")
    @TableField("date_end_type")
    private Integer dateEndType;

    @ApiModelProperty(value = "套餐",name="dateEnd")
    @TableField("date_end")
    private Date dateEnd;

    @ApiModelProperty(value = "套餐",name="dateEndDays")
    @TableField("date_end_days")
    private Integer dateEndDays;

    @ApiModelProperty(value = "套餐",name="dateStartType")
    @TableField("date_start_type")
    private Integer dateStartType;

    @ApiModelProperty(value = "套餐",name="dateUpdate")
    @TableField("date_update")
    private Date dateUpdate;

    @ApiModelProperty(value = "套餐",name="moneyHreshold")
    @TableField("money_hreshold")
    private Float moneyHreshold;

    @ApiModelProperty(value = "套餐",name="moneyMax")
    @TableField("money_max")
    private Float moneyMax;

    @ApiModelProperty(value = "套餐",name="moneyMin")
    @TableField("money_min")
    private Float moneyMin;

    @ApiModelProperty(value = "套餐",name="name")
    private String name;

    @ApiModelProperty(value = "套餐",name="needScore")
    @TableField("need_score")
    private Integer needScore;

    @ApiModelProperty(value = "套餐",name="needSignedContinuous")
    @TableField("need_signed_continuous")
    private Integer needSignedContinuous;

    @ApiModelProperty(value = "套餐",name="numberGit")
    @TableField("number_git")
    private Integer numberGit;

    @ApiModelProperty(value = "套餐",name="numberGitNumber")
    @TableField("number_git_number")
    private Integer numberGitNumber;

    @ApiModelProperty(value = "套餐",name="numberLeft")
    @TableField("number_left")
    private Integer numberLeft;

    @ApiModelProperty(value = "套餐",name="numberPersonMax")
    @TableField("number_person_max")
    private Integer numberPersonMax;

    @ApiModelProperty(value = "套餐",name="numberTotle")
    @TableField("number_totle")
    private Integer numberTotle;

    @ApiModelProperty(value = "套餐",name="numberUsed")
    @TableField("number_used")
    private Integer numberUsed;

    @ApiModelProperty(value = "套餐",name="status")
    private Integer status;

    @ApiModelProperty(value = "",name="statusStr")
    @TableField("status_str")
    private String statusStr;

    @ApiModelProperty(value = "",name="type")
    private String type;


}
