package com.jckc_backer.modules.user.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 * @Author: Charles Chan
 * @Date: 2019/9/3 16:14
 * @Version 1.0
 */
@Data
@TableName("user")
public class CustomerEntity {

    private  String openId;

    private String nickName;

    private Integer gender;

    private String city;

    private String province;

    private String country;

    private String avatarUrl;

    private String unionId;

    private Integer vip;

    @TableField("sName")
    private String sName;

    @TableField("sPhone")
    private Integer sPhone;
}
