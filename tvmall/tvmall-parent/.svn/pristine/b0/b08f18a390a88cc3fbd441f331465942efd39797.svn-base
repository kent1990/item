package com.zhengke.business.service.detail;

import java.util.List;

import com.zhengke.common.pojo.MallServiceGoods;
import com.zhengke.common.pojo.TvOrder;
import com.zhengke.common.pojo.TvOrderGoods;
import com.zhengke.common.pojo.TvUser;


public interface GoodsDetailService {

	/**
	 * 设置用户信息
	 * @param tu
	 */
	void setTvUser(TvUser tu);	
	
	/**
	 * 生成订单
	 * @param to
	 * @param tog
	 * @param msg 
	 */
	void createOrder(TvOrder to,TvOrderGoods tog, MallServiceGoods msg);
	
	/**
	 * 生成订单号
	 * @param tvnNo
	 * @return
	 */
	String createOrderSn(String tvnNo);
	
	/**
	 * 查询商品详情
	 * @param goodsId
	 * @return
	 */
	List<Object[]> findGoodsDetail(String goodsId);
	
	/**
	 * 查询打包商品详情
	 * @param goodsId
	 * @return
	 */
	List<Object[]> findGoodsDetail2(String goodsId);
	
	/**
	 * 查询打包数量
	 * @param object
	 * @return
	 */
	List<Object[]> findBaleGoods(String object);
	
	/**
	 * 查询商品库存
	 * @param stationId
	 * @param goodsId
	 * @return
	 */
	List<MallServiceGoods> findServiceGoods(String stationId, String goodsId,String goodType);
	
	/**
	 * 查询商品预订数量
	 * @param goodsId
	 * @param type
	 * @return
	 */
	List<Object[]> findTvGoods(String goodsId, String type);
	
	/**
	 * 查询用户未处理积分商城订单
	 * @param tvnNo
	 * @return
	 */
	List<Object[]> findInteGoods(String tvnNo);
	
}
