package com.jckc_backer.modules.management.entity;

import lombok.Data;

import java.util.Date;

@Data
public class AdvertisementVO {
    private String picUrl;
    private String pic_url;
    private String theme;
    private String details;
    private String statusStr;
    private Date dateAdd;
    private Date dateUpdate;
    private Integer userId;
    private Integer id;
}
