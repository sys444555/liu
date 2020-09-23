package com.jckc_backer.modules.order.entity;

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
public class OrderEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增ID",name = "id")
    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "订单号",name="orderOn")
    private String orderOn;
    /**
     * 联系人
     */
    private String linkMan;
    /**
     * 电话
     */
    private String mobile;


    @ApiModelProperty(value = "名字",name="name")
    private String name;
    /**
     * 價錢
     */
    private BigDecimal minPrice;
    /**
     * 圖片
     */
    private String pic;

    /**
     * 數量
     */
    private Integer number;

    private Integer orderId;

    /**
     * 規格
     */
    private String specification;

    /**
     * 备注
     */
    private String remark;

    private String logisticsCompany;

    private String logisticsOrderOn;



    @ApiModelProperty(value = "创建时间",name="createTime")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "状态",name="status")
    @TableField("status")
    private Integer status;


    @ApiModelProperty(value = "商品金额",name="goodsPrice")
    @TableField("goods_price")
    private BigDecimal goodsPrice;

    @ApiModelProperty(value = "实付金额",name="actualPrice")
    @TableField("actual_price")
    private BigDecimal actualPrice;

    /**
     * 地址
     */
    private String address;

    /**
     * 省
     */
    private String provinceStr;

    /**
     * 市
     */
    private String cityStr;

    /**
     * 区
     */
    private String districtStr;

    /**
     * 邮编
     */
    private String code;

    /**
     * 支付码
     */
    private String payId;
}
