package com.jckc_backer.modules.management.mapper;

import com.jckc_backer.modules.management.entity.AdvertisementEntity;
import com.jckc_backer.modules.management.entity.AdvertisementVO;

import java.util.List;

public interface AdvertisementMapper {

    void insert(AdvertisementEntity advertisementEntity);


    public List<AdvertisementVO> select();
}
