package com.aek.shop.service.biz;

import com.aek.shop.api.vo.ShopScrollInfoVO;
import com.aek.shop.api.bo.ShopScrollInfoBO;
import com.aek.shop.api.vo.ShopScrollInfoPageVO;
import com.aek.shop.api.bo.ShopScrollInfoPageQueryBO;
import com.aek.shop.persistence.bean.ShopScrollInfo;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;

/** 
 * @Description 店铺轮播
 * @author ansen.zhu
 * @date 2019-05-05 14:03:53
 */
public interface ShopScrollInfoBizService {

	ShopScrollInfoVO get(Long id);

	List<ShopScrollInfoVO> list(Map<String, Object> map);
	
	ShopScrollInfoPageVO page(Page<ShopScrollInfo> page, ShopScrollInfoPageQueryBO shopScrollInfoPageQueryBO);

	int count(Map<String, Object> map);

	int save(ShopScrollInfoBO shopScrollInfoBO);

	int update(ShopScrollInfoBO shopScrollInfoBO);

	int remove(Long id);

	int batchRemove(Long[] ids);
}
