package com.jckc_backer.productinfo.controller;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zhao zhongren
 * @date 2019-08-30 17:36
 */
@Data
public class ProductInfo implements Serializable {

    @ApiModelProperty("门店编码")
    private String storeCode;

    @ApiModelProperty("商品编码")
    private String productCode;

    @ApiModelProperty("上下架状态，1-上架，0下架")
    private String sellStatus;

}
