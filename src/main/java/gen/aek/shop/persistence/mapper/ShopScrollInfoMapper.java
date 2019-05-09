package com.aek.shop.persistence.mapper;

import com.aek.shop.persistence.bean.ShopScrollInfo;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.aek.shop.api.bo.ShopScrollInfoPageQueryBO;

/** 
 * @Description 店铺轮播
 * @author ansen.zhu
 * @date 2019-05-05 14:03:53
 */
@Mapper
public interface ShopScrollInfoMapper {

    ShopScrollInfo get(Long id);

    List<ShopScrollInfo> list(Map<String, Object> map);
    
    List<ShopScrollInfo> page(Page<ShopScrollInfo> page, ShopScrollInfoPageQueryBO shopScrollInfoPageQueryBO);

    int count(Map<String, Object> map);

    int save(ShopScrollInfo shopScrollInfo);

    int update(ShopScrollInfo id);

    int remove(Long id);

    int batchRemove(Long[]id);
}
