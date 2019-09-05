package com.jckc_backer.modules.management.service;

import com.jckc_backer.modules.management.entity.AdvertisementEntity;
import com.jckc_backer.modules.management.entity.AdvertisementVO;

import java.util.List;

public interface AdvertisementService {
    void insertAdvertisement(AdvertisementEntity advertisementEntity);


    public List<AdvertisementVO> showList();
}
