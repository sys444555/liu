package com.jckc_backer.modules.management.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jckc_backer.modules.management.entity.PictureEntity;
import com.jckc_backer.modules.management.mapper.PictureMapper;
import com.jckc_backer.modules.management.service.PictureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PictureServiceImpl extends ServiceImpl<PictureMapper, PictureEntity> implements PictureService {

    @Resource
    private PictureMapper pictureMapper;

    @Override
    public void insertPicture(PictureEntity pictureEntity) {
        String statusStr=pictureEntity.getStatusStr();
        if(statusStr.equals("显示")){
            pictureEntity.setStatus(0);
        }
        Integer userid=pictureEntity.getUserId();
        if(userid==1){
            pictureEntity.setUserId(9436);
        }
        if(pictureEntity.getRemark()==null){
            pictureEntity.setRemark("");
        }
        pictureMapper.insert(pictureEntity);

    }

    @Override
    public void updatePicture(PictureEntity pictureEntity) {
        /*SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String time=df.format(new Date());*/
        pictureEntity.setDateUpdate(new Date());
        pictureMapper.updateById(pictureEntity);
    }

    @Override
    public List<PictureEntity> getListBytype(String type) {

        return pictureMapper.selectByType(type);
    }

    @Override
    public List<PictureEntity> getList(EntityWrapper<PictureEntity> wrapper) {
        List<PictureEntity> entityList=pictureMapper.selectList(wrapper);
        return entityList;
    }

    @Override
    public void updownById(Integer id) {
        pictureMapper.updateStatus(id);
    }

}
