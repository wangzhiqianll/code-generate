package com.aek.shop.service.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.aek.shop.persistence.mapper.ShopScrollInfoMapper;
import com.aek.shop.service.biz.ShopScrollInfoBizService;
import com.aek.shop.persistence.bean.ShopScrollInfo;
import com.aek.shop.api.bo.ShopScrollInfoBO;
import com.aek.shop.api.vo.ShopScrollInfoVO;
import com.aek.shop.api.vo.ShopScrollInfoPageVO;
import com.aek.shop.api.bo.ShopScrollInfoPageQueryBO;
import javax.annotation.Resource;
import com.aek.core.copiers.Copiers;
import org.springframework.transaction.annotation.Transactional;
import com.aek.core.datasource.annotation.TargetDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import com.aek.core.util.AekListUtil;
import java.util.ArrayList;
import com.baomidou.mybatisplus.plugins.Page;

/** 
 * @Description 店铺轮播
 * @author ansen.zhu
 * @date 2019-05-05 14:03:53
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ShopScrollInfoBizServiceImpl implements ShopScrollInfoBizService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ShopScrollInfoBizServiceImpl.class);

	@Resource
    private  ShopScrollInfoMapper shopScrollInfoMapper;

    @Override
    @TargetDataSource(name = "readDataSource")
    public ShopScrollInfoVO get(Long id) {
    	ShopScrollInfoVO shopScrollInfoVO=new ShopScrollInfoVO();
    	ShopScrollInfo shopScrollInfo = shopScrollInfoMapper.get(id);
    	if (shopScrollInfo != null) {
    		shopScrollInfoVO = Copiers
            	.create(ShopScrollInfo.class, ShopScrollInfoVO.class)
            	.copy(shopScrollInfo);
         }
         
         return shopScrollInfoVO;
    }

    @Override
    @TargetDataSource(name = "readDataSource")
    public List<ShopScrollInfoVO> list(Map<String, Object> map) {
        List<ShopScrollInfoVO> result;
        List<ShopScrollInfo> shopScrollInfos;
        shopScrollInfos = shopScrollInfoMapper.list(map);
        if (AekListUtil.isNotEmpty(shopScrollInfos)) {
        	result = Copiers
 				.createMapper(ShopScrollInfo.class, ShopScrollInfoVO.class)
 				.register()
 				.map(shopScrollInfos);
 		} else {
 			result = new ArrayList<>(0);
 		}
 		return result;
    }

	@Override
    @TargetDataSource(name = "readDataSource")
	public ShopScrollInfoPageVO page(Page<ShopScrollInfo> page, ShopScrollInfoPageQueryBO shopScrollInfoPageQueryBO){
	
		final List<ShopScrollInfo> shopScrollInfos = shopScrollInfoMapper.page(page,shopScrollInfoPageQueryBO);
        // 设置返回对象
        final ShopScrollInfoPageVO pageVO =
                        new ShopScrollInfoPageVO(page.getCurrent(), page.getSize(), page.getTotal());
        if (shopScrollInfos != null && !shopScrollInfos.isEmpty()) {
            pageVO.setShopScrollInfos(Copiers.create(ShopScrollInfo.class, ShopScrollInfoVO.class)
                            .map(shopScrollInfos));
        }
        return pageVO;
	}

    @Override
    public int count(Map<String, Object> map) {
        return shopScrollInfoMapper.count(map);
    }

    @Override
    @TargetDataSource(name = "writeDataSource")
    public int save(ShopScrollInfoBO shopScrollInfoBO) {
    	ShopScrollInfo shopScrollInfo = Copiers.create(ShopScrollInfoBO.class, ShopScrollInfo.class).copy(shopScrollInfoBO);
    	shopScrollInfo.settingCreatingDefaultValue(shopScrollInfoBO.getOperateBy(), shopScrollInfoBO.getOperateName());
        return shopScrollInfoMapper.save(shopScrollInfo);
    }

    @Override
    @TargetDataSource(name = "writeDataSource")
    public int update(ShopScrollInfoBO shopScrollInfoBO) {
    	ShopScrollInfo shopScrollInfo = Copiers.create(ShopScrollInfoBO.class, ShopScrollInfo.class).copy(shopScrollInfoBO);
    	shopScrollInfo.settingCreatingDefaultValue(shopScrollInfoBO.getOperateBy(), shopScrollInfoBO.getOperateName());
        return shopScrollInfoMapper.update(shopScrollInfo);
    }

    @Override
    @TargetDataSource(name = "writeDataSource")
    public int remove(Long id) {
        return shopScrollInfoMapper.remove(id);
    }

    @Override
    @TargetDataSource(name = "writeDataSource")
    public int batchRemove(Long[] id) {
        return shopScrollInfoMapper.batchRemove(id);
    }

}
