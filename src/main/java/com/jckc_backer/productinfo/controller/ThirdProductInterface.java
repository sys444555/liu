package com.jckc_backer.productinfo.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhao zhongren
 * @date 2019-08-30 17:33
 */
@Slf4j
@RestController
public class ThirdProductInterface {

    /**
     * 模拟redis缓存
     */
    private volatile Map<String, RequestMsg> redisTemplate = new HashMap<>();

    /**
     * 模拟第三方平台接口，该接口一次最多同步同一门店同一状态商品200个，阈值1秒5次
     *
     * @param productInfoList
     * @return
     */
    @ApiOperation(value = "批量同步商品到第三方平台（京东）", tags = "第三方接口")
    @PostMapping(value = "/demo")
    public R<String> syncProductInfo(@RequestBody List<ProductInfo> productInfoList){

        if(CollectionUtils.isEmpty(productInfoList)){
            return R.error(-1, "参数为空！");
        }

        if(productInfoList.size() > 200){
            return R.error(-2, "一次最多200个商品");
        }

        for(int i = 0; i < productInfoList.size() - 1; i++){
            if(!productInfoList.get(i).getStoreCode().equals(productInfoList.get(i + 1).getStoreCode()) ||
                    !productInfoList.get(i).getSellStatus().equals(productInfoList.get(i + 1).getSellStatus())){
                return R.error(-3, "所有门店或者上下架必须一致");
            }
        }

        String storeCode = productInfoList.get(0).getStoreCode();
        RequestMsg requestMsg = redisTemplate.get(storeCode);
        if(requestMsg == null){
            requestMsg = new RequestMsg();
            requestMsg.setCount(1);
            requestMsg.setTimestamp(System.currentTimeMillis());
            redisTemplate.put(storeCode, requestMsg);

        }else {
            long timeStamp = requestMsg.getTimestamp();
            long currentTime = System.currentTimeMillis();
            if (currentTime - timeStamp > 1000) {
                requestMsg.setTimestamp(currentTime);
                requestMsg.setCount(1);
                requestMsg.setTimestamp(currentTime);
                redisTemplate.put(storeCode, requestMsg);

            } else {
                if (requestMsg.getCount() >= 5) {
                    return R.error(-4, "阈值超限");
                } else {
                    requestMsg.setCount(requestMsg.getCount() + 1);
                    redisTemplate.put(storeCode, requestMsg);
                }

            }
        }

        /****************************************/
        /**            存入第三方数据库         **/
        /****************************************/
        log.info("执行业务逻辑：{}",JSON.toJSONString(productInfoList));


        return R.success("同步成功");

    }
}
