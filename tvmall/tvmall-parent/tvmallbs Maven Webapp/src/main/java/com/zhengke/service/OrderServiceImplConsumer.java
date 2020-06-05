package com.zhengke.service;


import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import com.zhengke.common.object.Result;

@Service
public class OrderServiceImplConsumer implements OrderServiceConsumer {
	@Reference
	private OrderService service;
	
	@Override
	public Result queryAll(String orderSn, String userId, String userName, String orderState,int pageNum,int size) throws Exception {
		return service.queryAll(orderSn, userId, userName, orderState, pageNum, size);
	}

}
