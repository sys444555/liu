package com.jckc_backer.modules.goods.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jckc_backer.common.exception.JcException;
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
<<<<<<< HEAD
    public void updateGoods(GoodsEntity goodsEntity) {

        Integer integer = goodsMapper.updateGoods(goodsEntity);

        if(integer == null || integer != 1){
            throw new JcException("修改商品失败");
        }
        updateColour(goodsEntity);

        updateSize(goodsEntity);

        updateProduct(goodsEntity);

    }

    public void updateColour(GoodsEntity goodsEntity){
        List<Specification> colourList = goodsMapper.getColourList(goodsEntity.getId());
        String colour = goodsEntity.getColour();
        String[] colours = colour.split(";");
        System.out.println("colours = " + colours);
        if(colourList.size() == colours.length){
            System.out.println("mm = ");
            /*goodsMapper.deleteSpecification(goodsEntity.getId());*/
            for(int i=0;i<colourList.size();i++){
                if(colours[i] != colourList.get(i).getValue()){
                    goodsMapper.updateColour(goodsEntity.getId(), colours[i],colourList.get(i).getValue());
                }
            }

        }
        if(colourList.size() > colours.length){
            for(int k=0;k<colourList.size()-colours.length;k++){
                goodsMapper.deleteColourSpecification(goodsEntity.getId(),colourList.get(colourList.size()-1-k).getValue());
            }
            for(int j=colours.length-1;j>=0;j--){
                if(colours[j] != colourList.get(j).getValue()){
                    System.out.println("colours[j] = " + colours[j]);
                    System.out.println("colourList.get(j).getValue() = " + colourList.get(j).getValue());
                    goodsMapper.updateColour(goodsEntity.getId(), colours[j],colourList.get(j).getValue());
                }
            }
        }
        if(colourList.size() < colours.length){
            for(int g=0;g<colourList.size();g++){
                if(colours[g] != colourList.get(g).getValue()){
                    goodsMapper.updateColour(goodsEntity.getId(), colours[g],colourList.get(g).getValue());
                }
            }
            for(int l=0;l<colours.length-colourList.size();l++){
                Integer colourId = goodsMapper.selectColourId(goodsEntity.getId());
                goodsMapper.insertColourSpecification(goodsEntity.getId(), colours[colourList.size()+ l], colourId );
            }
        }
    }

    public void updateSize(GoodsEntity goodsEntity){
        List<Specification> sizeList = goodsMapper.getSizeList(goodsEntity.getId());
        String size = goodsEntity.getSize();
        String[] sizes = size.split(";");
        if(sizeList.size() == sizes.length){
            for(int i=0;i<sizeList.size();i++){
                if(sizes[i] != sizeList.get(i).getValue()){
                    goodsMapper.updateSize(goodsEntity.getId(), sizes[i],sizeList.get(i).getValue());
                }
            }

        }
        if(sizeList.size() > sizes.length){
            for(int k=0;k<sizeList.size()-sizes.length;k++){
                goodsMapper.deleteSizeSpecification(goodsEntity.getId(),sizeList.get(sizeList.size()-1-k).getValue());
            }
            for(int j=sizes.length-1;j>=0;j--){
                if(sizes[j] != sizeList.get(j).getValue()){
                    goodsMapper.updateSize(goodsEntity.getId(), sizes[j],sizeList.get(j).getValue());
                }
            }

        }
        if(sizeList.size() < sizes.length){
            for(int g=0;g<sizeList.size();g++){
                if(sizes[g] != sizeList.get(g).getValue()){
                    goodsMapper.updateSize(goodsEntity.getId(), sizes[g],sizeList.get(g).getValue());
                }
            }
            for(int l=0;l<sizes.length-sizeList.size();l++){
                Integer sizeId = goodsMapper.selectSizeId(goodsEntity.getId());
                goodsMapper.insertSizeSpecification(goodsEntity.getId(), sizes[sizeList.size()+ l], sizeId );
            }
        }
    }

    public void updateProduct(GoodsEntity goodsEntity){
        Integer integer = goodsMapper.deleteGoodsProduct(goodsEntity.getId());
        System.out.println("integer = " + integer);
        if(integer == null ||  integer == 0){
            throw new JcException("更新失败，服务器端异常");
        }
        String colour = goodsEntity.getColour();
        String size = goodsEntity.getSize();
        String[] colours = colour.split(";");
        String[] sizes = size.split(";");
        for(int i=0;i<colours.length;i++){
            for(int j=0;j<sizes.length;j++){
                String specification = colours[i] + ":" + sizes[j];
                Integer insertResult = goodsMapper.insertGoodsProduct(goodsEntity.getId(), specification);
                if(insertResult == null ||  insertResult == 0){
                    throw new JcException("更新失败，服务器端异常");
                }
            }
        }
=======
    public Integer getCategoryIdByName(String name) {
        Integer id=goodsMapper.getCategoryId(name);
        return id;
>>>>>>> c7b4e2cfd6678593bfde02f32e45de96ad4113ac
    }

}
