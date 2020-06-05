package com.zhengke.service;


import com.zhengke.common.object.Result;

public interface OrderService {
   /**
    * * ���������������ѯ������Ϣ
    * @param orderSn
    * @param userId
    * @param userName
    * @param orderState
    * @return
    */
	Result queryAll(String orderSn,String userId,String userName,String orderState,int pageNum,int size) throws Exception;
}
