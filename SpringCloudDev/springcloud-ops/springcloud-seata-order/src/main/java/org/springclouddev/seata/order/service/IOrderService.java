package org.springclouddev.seata.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springclouddev.seata.order.entity.Order;

/**
 * IOrderService
 *
 * @author zhaobo
 */
public interface IOrderService extends IService<Order> {

	/**
	 * 创建订单
	 *
	 * @param userId        用户id
	 * @param commodityCode 商品代码
	 * @param count         数量
	 * @return boolean
	 */
	boolean createOrder(String userId, String commodityCode, Integer count);

}
