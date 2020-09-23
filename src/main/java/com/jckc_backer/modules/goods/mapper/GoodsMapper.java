package com.jckc_backer.modules.goods.mapper;


import com.jckc_backer.modules.goods.entity.GoodsEntity;
import com.jckc_backer.modules.goods.entity.Specification;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Date;
/**
 * @author ：fenghuang
 * @date ：Created in 2019/8/13 16:27
 * @description：
 * @modified By：
 * @version:
 */

public interface GoodsMapper  {

    public List<GoodsEntity> getGoodsList();

    public List<Specification> getColourList(@Param(value = "id") Integer id);

    public List<Specification> getSizeList(@Param(value = "id") Integer id);

    public Integer updateGoods(GoodsEntity goodsEntity);

    public void deleteColourSpecification(@Param(value = "goodsId") Integer goodsId,
                                          @Param(value = "value") String value);

    public Integer updateColour(@Param(value = "goodsId") Integer goodsId,
                                @Param(value = "changeValue") String changeValue,
                                @Param(value = "value") String value);

    public Integer insertColourSpecification(@Param(value = "goodsId") Integer goodsId,
                                             @Param(value = "value") String value,
                                             @Param(value = "sid") Integer sid);

    public Integer selectColourId(@Param(value = "goodsId") Integer goodsId);

    public void deleteSizeSpecification(@Param(value = "goodsId") Integer goodsId,
                                          @Param(value = "value") String value);

    public Integer updateSize(@Param(value = "goodsId") Integer goodsId,
                                @Param(value = "changeValue") String changeValue,
                                @Param(value = "value") String value);

    public Integer insertSizeSpecification(@Param(value = "goodsId") Integer goodsId,
                                             @Param(value = "value") String value,
                                             @Param(value = "sid") Integer sid);

    public Integer selectSizeId(@Param(value = "goodsId") Integer goodsId);

    public Integer deleteGoodsProduct(@Param(value = "goodsId") Integer goodsId);

    public Integer insertGoodsProduct(@Param(value = "goodsId") Integer goodsId,
                                      @Param(value = "specification") String specification);

    Integer getCategoryId(@Param(value = "name") String name);

    Integer insertGoods(GoodsEntity goodsEntity);

    Integer insertPic(GoodsEntity goodsEntity);

    Integer insertGoodsColourSpecification(Specification specification);

    Integer insertGoodsSizeSpecification(Specification specification);

    Integer insertCol(@Param(value = "goodsId") Integer goodsId,
                      @Param(value = "value") String value,
                      @Param(value = "sid") Integer sid);

    Integer insertSiz(@Param(value = "goodsId") Integer goodsId,
                      @Param(value = "value") String value,
                      @Param(value = "sid") Integer sid);

}
