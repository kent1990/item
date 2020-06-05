package com.zhengke.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhengke.common.dao.CommonDao;
import com.zhengke.common.object.Result;
import com.zhengke.pojo.TvOrder;

@Service(dynamic=true)
public class OrderServiceImpl implements OrderService {
    
	@Autowired
	private CommonDao dao;
	@SuppressWarnings("unchecked")
	@Override
	public Result queryAll(String orderSn, String userId, String userName, String orderState,int pageNum,int size) throws Exception {
		Map<String,String> param = new HashMap<String,String>();
		param.put("orderSn", orderSn);
		param.put("userId", userId);
		param.put("userName", userName);
		param.put("orderState", orderState);
		
		PageHelper.startPage(pageNum, size, true);
		
		List<TvOrder> rtnList = (List<TvOrder>)dao.findForList("orderMapper.queryOrder", param);
		PageInfo<TvOrder> pageInfo = new PageInfo<TvOrder>(rtnList);
		
		Result rs = new Result();
		rs.setCode("0");
		rs.setCount(pageInfo.getTotal());
        rs.setData(rtnList);		
		return rs;
	}

}
