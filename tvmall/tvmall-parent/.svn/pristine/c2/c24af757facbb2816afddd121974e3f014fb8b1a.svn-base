package com.zhengke.business.service.home;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zhengke.common.dao.CommonDao;
import com.zhengke.common.pojo.IndexPic;
import com.zhengke.common.pojo.ReturnVisit;
import com.zhengke.common.pojo.TvUser;


@Service @Transactional
public class HomeServiceImpl implements HomeService {
	@Resource CommonDao commonDao;
	
	@Override
	public TvUser queryUser(String tvnNO) {
		
		return null;
	}

	/**
	 * 查询首页图片
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<IndexPic> queryIndexPics(String provinceId,String cityId,
			String servicePointId,String picId) {
       StringBuffer buffer = new StringBuffer();       
       buffer.append("select ip.id,ip.name,") 
			.append(" ifnull((select pic_path from index_pic_sub ips" ) 
			.append(" where ips.province_id=:provinceId")
			.append(" and ips.city_id=:cityId")
			.append(" and ips.service_point_id=:servicePointId")
			.append(" and ips.pic_id=ip.id),ip.pic_path) as pic_path ,")			
			.append(" ip.default_pic,ip.update_time,ip.update_user from index_pic ip");
       Map<String,String> param = new HashMap<String,String>();
        if(picId!=null) {
        	buffer.append(" where ip.id=:picId");
        	param.put("picId", picId);
        }
        param.put("provinceId", provinceId);
        param.put("cityId", cityId);
        param.put("servicePointId", servicePointId);
        List<IndexPic> list = (List<IndexPic>)commonDao.queryBySql2(buffer.toString(), param, IndexPic.class);
		return list;
	}

	/**
	 * 生成回访记录
	 */
	public void save(ReturnVisit rv){
		if(rv!=null)
			commonDao.save(rv);
	}

	
}
