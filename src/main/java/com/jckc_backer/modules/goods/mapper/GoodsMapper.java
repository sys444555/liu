package com.jckc_backer.modules.goods.mapper;


import com.jckc_backer.modules.goods.entity.GoodsEntity;
import com.jckc_backer.modules.goods.entity.Specification;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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


}
