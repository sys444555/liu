package com.jckc_backer.modules.management.entity;

import lombok.Data;

import java.util.Date;

@Data
public class AdvertisementEntity {
    private Integer id;
    private Integer bannerId;
    private String picUrl;
    private String details;
    private String theme;
    private Integer status;
    private String statusStr;
    private Date dateAdd;
    private Date dateUpdate;
    private Integer shopId;
}
