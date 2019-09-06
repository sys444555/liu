package com.jckc_backer.modules.goods.service.impl;

import com.jckc_backer.modules.goods.entity.GoodsEntity;
import com.jckc_backer.modules.goods.entity.Specification;
import com.jckc_backer.modules.goods.mapper.GoodsMapper;
import com.jckc_backer.modules.goods.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/8/20 17:26
 * @description：
 * @modified By：
 * @version:
 */
@Service
public class GoodsServiceImpl  implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;


    @Override
    public List<GoodsEntity> getGoodsList() {
        List<GoodsEntity> goodsList = goodsMapper.getGoodsList();
        for(int i=0;i<goodsList.size();i++){
            GoodsEntity goodsEntity = goodsList.get(i);
            Integer id = goodsEntity.getId();
            List<Specification> colourList = goodsMapper.getColourList(id);
            System.out.println("colourList = " + colourList);
            String colour = "";
            for(int j=0;j<colourList.size();j++){
                Specification specification = colourList.get(j);
                colour += specification.getValue();
                if(j < colourList.size()-1){
                    colour += ";";
                }
            }
            List<Specification> sizeList = goodsMapper.getSizeList(id);
            String size = "";
            for(int k=0;k<sizeList.size();k++){
                Specification specification = sizeList.get(k);
                size += specification.getValue();
                if(k < sizeList.size()-1){
                    size += ";";
                }
            }
            goodsEntity.setColour(colour);
            goodsEntity.setSize(size);
        }
        return goodsList;
    }

    @Override
    public Integer getCategoryIdByName(String name) {
        Integer id=goodsMapper.getCategoryId(name);
        return id;
    }

}
