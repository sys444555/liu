package com.jckc_backer.modules.personnel.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.jckc_backer.basic.BasicEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
/**
 * @author ：lyj
 * @date ：Created in 2019/9/3
 * @description：
 * @modified By：
 * @version:
 */

@ApiModel("员工信息汇总表视图实体类")
@Data
@TableName("personnel")
public class PersonnelEntity {

    @ApiModelProperty(value = "自增ID",name = "id")
    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "姓名",name="username")
    private String username;

    @ApiModelProperty(value = "性别",name="sex")
    private Integer sex;

    @ApiModelProperty(value = "年龄",name="age")
    private Integer age;

    @ApiModelProperty(value = "手机号",name="phone")
    private String phone;

    @ApiModelProperty(value = "qq",name="qq")
    private String qq;

    @ApiModelProperty(value = "微信",name="wexin")
    private String wexin;

    @ApiModelProperty(value = "邮箱",name="email")
    private String email;

    @ApiModelProperty(value = "状态",name="status")
    private Integer status;

    @ApiModelProperty(value = "家庭地址",name="address")
    private String address;

    @ApiModelProperty(value = "入职时间",name="date")
    private String date;
}
