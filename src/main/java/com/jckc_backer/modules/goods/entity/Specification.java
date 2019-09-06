package com.jckc_backer.modules.goods.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/9/6 15:34
 * @description：
 * @modified By：
 * @version:
 */
@Data
public class Specification implements Serializable {

    private static final long serialVersionUID = 1L;


    private String value;

}
