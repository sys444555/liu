package com.jckc_backer.modules.goods.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * @author ：fenghuang
 * @date ：Created in 2019/9/3 16:10
 * @description：
 * @modified By：
 * @version:
 */
@Data
public class GoodsEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增ID",name = "id")
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String categoryName;

    @ApiModelProperty(value = "商品名",name="name")
    private String name;
    /**
     * 颜色
     */
    private String colour;
    /**
     * 尺寸
     */
    private String size;


    @ApiModelProperty(value = "价钱",name="name")
    private BigDecimal minPrice;

    /**
     * 时间
     */
    private Date dateAdd;
    /**
     * 圖片
     */
    private String pic;

}
