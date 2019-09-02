package com.jckc_backer.modules.management.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/8/13 16:22
 * @description：
 * @modified By：
 * @version:
 */
@Data
@TableName("banner")
public class PictureEntity  implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增ID",name = "id")
    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "商品id",name="businessId")
    @TableField("businessId")
    private Integer businessId;

    @ApiModelProperty(value = "日期",name="dateAdd")
    @TableField("dateAdd")
    private Date dateAdd;

    @ApiModelProperty(value = "日期",name="dateUpdate")
    @TableField("dateUpdate")
    private Date dateUpdate;

    @ApiModelProperty(value = "跳转路径",name="linkUrl")
    @TableField("linkUrl")
    private String linkUrl;

    @ApiModelProperty(value = "排序",name="paixu")
    @TableField("paixu")
    private Integer paixu;

    @ApiModelProperty(value = "图片路径",name="picUrl")
    @TableField("picUrl")
    private String picUrl;

    @ApiModelProperty(value = "留言",name="remark")
    @TableField("remark")
    private String remark;

    @ApiModelProperty(value = "状态",name="status")
    @TableField("status")
    private Integer status;

    @ApiModelProperty(value = "状态值",name="statusStr")
    @TableField("statusStr")
    private String statusStr;

    @ApiModelProperty(value = "标题",name="title")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "类型",name="type")
    @TableField("type")
    private String type;

    @ApiModelProperty(value = "用户id",name="userId")
    @TableField("userId")
    private Integer userId;


}
