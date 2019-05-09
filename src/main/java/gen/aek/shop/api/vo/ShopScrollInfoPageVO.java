package com.aek.shop.api.vo;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/** 
 * @Description 店铺轮播
 * @author ansen.zhu
 * @date 2019-05-05 14:03:53
 */
public class ShopScrollInfoPageVO {

	/**
	 * 当前页
	 */
	private Integer current;

	/**
	 * 页容量
	 */
	private Integer pageSize;

	/**
	 * 总记录数
	 */
	private Integer total;

	/**
	 * 客户列表
	 */
	private List<ShopScrollInfoVO> shopScrollInfos = new ArrayList<>(30);

	/**
	 * 默认构造器
	 */
	public ShopScrollInfoPageVO() {
		super();
	}

	/**
	 * 带参构造器
	 */
	public ShopScrollInfoPageVO(final Integer current, final Integer pageSize, final Integer total) {
		super();
		this.current = current;
		this.pageSize = pageSize;
		this.total = total;
	}

	/**
	 * @return the current
	 */
	public final Integer getCurrent() {
		return this.current;
	}

	/**
	 * @param current the current to set
	 */
	public final void setCurrent(final Integer current) {
		this.current = current;
	}

	/**
	 * @return the pageSize
	 */
	public final Integer getPageSize() {
		return this.pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public final void setPageSize(final Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the total
	 */
	public final Integer getTotal() {
		return this.total;
	}

	/**
	 * @param total the total to set
	 */
	public final void setTotal(final Integer total) {
		this.total = total;
	}

	/**
	 * @return the customers
	 */
	public final List<ShopScrollInfoVO> getShopScrollInfos() {
		return this.shopScrollInfos;
	}

	/**
	 * @param shopScrollInfos the shopScrollInfos to set
	 */
	public final void setShopScrollInfos(final List<ShopScrollInfoVO> shopScrollInfos) {
		this.shopScrollInfos = shopScrollInfos;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ShopScrollInfoPageVO [current=" + this.current + ", pageSize=" + this.pageSize
			+ ", total=" + this.total + ", shopScrollInfos=" + this.shopScrollInfos + "]";
	}


}