package com.jckc_backer.modules.management.service.impl;

import com.jckc_backer.modules.management.entity.AdvertisementEntity;
import com.jckc_backer.modules.management.entity.AdvertisementVO;
import com.jckc_backer.modules.management.mapper.AdvertisementMapper;
import com.jckc_backer.modules.management.service.AdvertisementService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    @Resource
    private AdvertisementMapper advertisementMapper;

    @Override
    public void insertAdvertisement(AdvertisementEntity advertisementEntity) {
        advertisementMapper.insert(advertisementEntity);
    }

    @Override
    public List<AdvertisementVO> showList() {
        List<AdvertisementVO> list = advertisementMapper.select();
        return list;
    }
}
