package com.jckc_backer.modules.order.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/9/4 18:04
 * @description：
 * @modified By：
 * @version:
 */
@Data
public class OrderDetailEntity implements Serializable {

    private static final long serialVersionUID = 1L;

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
