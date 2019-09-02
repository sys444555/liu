package com.jckc_backer.productinfo.controller;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zhao zhongren
 * @date 2019-08-30 18:05
 */
@Data
public class RequestMsg implements Serializable {

    @ApiModelProperty("同一门店同一秒内请求次数")
    private int count;

    @ApiModelProperty("同一秒内请求时间戳")
    private long timestamp;
}
