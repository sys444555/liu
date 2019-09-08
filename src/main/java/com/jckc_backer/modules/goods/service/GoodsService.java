package com.jckc_backer.modules.goods.service;

import com.jckc_backer.modules.goods.entity.GoodsEntity;
import com.jckc_backer.modules.goods.entity.GoodsEntity;

import java.util.List;


/**
 * @author ：fenghuang
 * @date ：Created in 2019/8/20 18:52
 * @description：
 * @modified By：
 * @version:
 */
public interface GoodsService {

    public List<GoodsEntity> getGoodsList();

<<<<<<< HEAD
    public void updateGoods(GoodsEntity goodsEntity);


=======
    Integer getCategoryIdByName(String name);
>>>>>>> c7b4e2cfd6678593bfde02f32e45de96ad4113ac
}
