package com.mallplus.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mallplus.common.entity.pms.PmsProduct;
import com.mallplus.goods.vo.CartProduct;
import com.mallplus.goods.vo.PmsProductResult;
import com.mallplus.goods.vo.PromotionProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商品信息 Mapper 接口
 * </p>
 *
 * @author zscat
 * @since 2019-04-19
 */
public interface PmsProductMapper extends BaseMapper<PmsProduct> {

    List<PromotionProduct> getPromotionProductList(@Param("ids") List<Long> ids);

    PmsProductResult getUpdateInfo(Long id);

    CartProduct getCartProduct(@Param("id") Long id);

    Integer countGoodsByToday(@Param("id") Long id);

    List<PmsProduct> listByDate(@Param("date") String date, @Param("type") Integer type);
}
