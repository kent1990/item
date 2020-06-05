package com.zhengke.business.service.detail;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zhengke.common.dao.CommonDao;
import com.zhengke.common.pojo.MallServiceGoods;
import com.zhengke.common.pojo.TvOrder;
import com.zhengke.common.pojo.TvOrderGoods;
import com.zhengke.common.pojo.TvUser;

@Service @Transactional
public class GoodsDetailServiceImpl implements GoodsDetailService {
	@Resource CommonDao commonDao;
	
	/**
	 * 设置用户信息
	 */
	@Override
	public void setTvUser(TvUser tu) {
		if(tu!=null)
			commonDao.update(tu);
	}
	
	/**
	 * 生成订单号码
	 */
	public String createOrderSn(String tvnNo) {
		return tvnNo+String.format("%013d",(new Date().getTime()));
	}

	/**
	 * 生成订单
	 */
	@Override
	public void createOrder(TvOrder to, TvOrderGoods tog,MallServiceGoods msg) {
		if(to!=null){
			commonDao.save(to);
		   if(tog!=null){
			   tog.setOrderId(to.getOrderId());			   
			   commonDao.save(tog);
		   }
			   
		}
		if(msg!=null){
			commonDao.update(msg);
		}
		
	}
	
	/**
	 * 查询商品详情
	 * @param goodsId
	 * @return
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Object[]> findGoodsDetail(String goodsId) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("select gd.goods_id,cg.goods_name,cg.common_price,gd.goods_price,gd.shipping_fee,")
				.append("ms.supplier_id,ms.supplier_name,cg.picPath1,cg.picPath2,cg.picPath3,cg.picPath4,")
				.append("cg.picPath5,cg.info_picPath,gd.awarded_integral,cg.specifications from goods_detail gd ")
				.append(" inner join common_goods cg on gd.common_goods_id=cg.goods_common_id ")
				.append(" left join mall_supplier ms on cg.brand_id=ms.supplier_id ")
				.append(" where gd.goods_id="+goodsId);		
		List<Object[]> rtnList = commonDao.queryBySql(buffer.toString(), null);
		return rtnList;
	}
	
	/**
	 * 查询打包商品详情
	 * @param goodsId
	 * @return
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Object[]> findGoodsDetail2(String goodsId) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("select cg.goods_common_id,cg.goods_name,cg.common_price,cg.common_price,cg.shipping_fee,")
				.append("ms.supplier_id,ms.supplier_name,cg.picPath1,cg.picPath2,cg.picPath3,cg.picPath4,")
				.append("cg.picPath5,cg.info_picPath,cg.send_inte,cg.specifications from common_goods cg ")
				.append(" left join mall_supplier ms on cg.brand_id=ms.supplier_id ")
				.append(" where cg.goods_common_id="+goodsId);		
		List<Object[]> rtnList = commonDao.queryBySql(buffer.toString(), null);
		return rtnList;
	}
	
	/**
	 * 查询打包数量
	 * @param object
	 * @return
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Object[]> findBaleGoods(String object) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("select bd.bale_id,bd.common_goods_id,bd.goods_id,bd.goods_price,bd.goods_num from bale_goods_detail bd");
		List<Object[]> rtnList = commonDao.queryBySql(buffer.toString(), null);
		return rtnList;
	}
	
	/**
	 * 查询商品库存
	 * @param stationId
	 * @param goodsId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<MallServiceGoods> findServiceGoods(String stationId,
			String goodsId,String goodType) {
		StringBuffer buffer = new StringBuffer();
		Map<String,String> param = new HashMap<String,String>();
		buffer.append("from MallServiceGoods where 1=1 ");
		if(stationId!=null&&!"".equals(stationId)){
			buffer.append(" and servicePointId =:stationId ");
			param.put("stationId", stationId );
		}
		if(goodsId!=null&&!"".equals(goodsId)){
			buffer.append(" and goodsId =:goodsId ");
			param.put("goodsId", goodsId );
		}
		if(goodType!=null&&!"".equals(goodType)){
			buffer.append(" and goodsType =:goodType ");
			param.put("goodType", goodType );
		}
		List<MallServiceGoods> list = (List<MallServiceGoods>) commonDao.queryByHql(buffer.toString(), param);
		return list;
	}
	
	/**
	 * 查询商品预订数量
	 * @param goodsId
	 * @param type
	 * @return
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Object[]> findTvGoods(String goodsId, String type) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("select sum(tog.goods_num) a,tog.goods_id from tv_order_goods tog where ")
				.append(" date(now())=substring(tog.goods_time,1,10) and tog.goods_id ='"+goodsId+"' and tog.goods_type ='"+type+"' group by tog.goods_id");
		List<Object[]> rtnList = commonDao.queryBySql(buffer.toString(), null);
		return rtnList;
	}
	
	/**
	 * 查询用户未处理积分商城订单
	 * @param tvnNo
	 * @return
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Object[]> findInteGoods(String tvnNo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("select sum(tod.order_amount) a,tog.goods_id from tv_order tod inner join tv_order_goods tog on tod.order_id=tog.order_id ")
				.append(" where tod.order_state>0 and tod.order_state<50 and (tog.goods_type=3 or tog.goods_type=7) and tod.user_id ='"+tvnNo+"' group by tog.goods_id");
		List<Object[]> rtnList = commonDao.queryBySql(buffer.toString(), null);
		return rtnList;
	}

}
