package com.jckc_backer.productinfo.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 *
 * @author fenghuang
 * @email 
 * @date 2019-08-30 16:40:17
 */
@TableName("product_info")
@Data
public class ProductInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 门店编码
	 */
	private String storeCode;
	/**
	 * 商品编码
	 */
	private String productCode;
	/**
	 * 上下架状态，1-上架，0-下架
	 */
	private String sellStatus;
	/**
	 * 创建时间
	 */
	private Date createdTime;
	/**
	 * 创建者
	 */
	private String createdBy;
	/**
	 * 更新时间
	 */
	private Date updatedTime;
	/**
	 * 更新者
	 */
	private String updatedBy;
}


