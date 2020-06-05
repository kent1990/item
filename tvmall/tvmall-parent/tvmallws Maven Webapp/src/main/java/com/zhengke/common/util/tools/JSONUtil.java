package com.zhengke.common.util.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.JSONSerializer;

public class JSONUtil {
	/**
	 * 由字符串反序列化成实体类 针对的是一个实体，此实体中的属性不包括自定义的类型，如Teacher类型，或者List<Teacher>类型
	 * 
	 * @param source    传入json中的字符串
	 * @param beanClass 实体类的类型
	 * @return 实体类
	 */
	/*
	 * @SuppressWarnings({ "unchecked", "rawtypes" }) public static Object
	 * getObjFromJsonArrStr(String source,Class beanClass) { JSONObject jsonObject =
	 * (JSONObject)JSONObject.toJSON(source); return
	 * JSONObject.toJavaObject(jsonObject,beanClass); }
	 *//**
		 * 由字符串反序列化成实体类 针对的是一个实体，此实体中的属性包括自定义的类型，如Teacher类型，或者List<Teacher>类型
		 * 
		 * @param jsonArrStr
		 * @param clazz
		 * @param classMap
		 * @return
		 */
	/*
	 * 
	 * @SuppressWarnings("rawtypes") public static Object
	 * getObjFromJsonArrStr(String jsonArrStr, Class clazz, Map classMap) {
	 * JSONObject jsonObj = (JSONObject)JSONObject.toJSON(jsonArrStr); return
	 * JSONObject.(jsonObj, clazz, classMap); }
	 * 
	 * 
	 *//**
		 * json to map
		 * 
		 * @param object
		 * @return
		 */
	/*
	 * public static HashMap<String, String> jsonObjToMap(Object object) {
	 * HashMap<String, String> data = new HashMap<String, String>(); //
	 * 将json字符串转换成jsonObject JSONObject jsonObject = JSONObject.fromObject(object);
	 * Iterator<?> it = jsonObject.keys(); // 遍历jsonObject数据，添加到Map对象 while
	 * (it.hasNext()) { String key = String.valueOf(it.next()); String value =
	 * (String) jsonObject.get(key); data.put(key, value); } return data; }
	 * 
	 * public static HashMap<String, String> jsonArrayToMap(Object object) {
	 * HashMap<String, String> data = new HashMap<String, String>(); //
	 * 将json字符串转换成jsonObject JSONArray jsonArray = JSONArray.fromObject(object);
	 * for(int i=0;i<jsonArray.size();i++){ JSONObject jsonObject =
	 * JSONObject.fromObject(jsonArray.get(0)); Iterator<?> it = jsonObject.keys();
	 * // 遍历jsonObject数据，添加到Map对象 while (it.hasNext()) { String key =
	 * String.valueOf(it.next()); String value = (String) jsonObject.get(key);
	 * data.put(key, value); } } return data; }
	 * 
	 * 
	 * 
	 *//**
		 * 将string转换成listBean 属性中包含实体类等 如List<Student> 而Student中含有属性List<Teacher>
		 * 
		 * @param jsonArrStr 需要反序列化的字符串
		 * @param clazz      反序列化后的类
		 * @param classMap   将属性中包含的如Teacher加入到一个Map中，格式如map.put("teacher",Teacher.class)
		 * @return 反序列化后的字符串 使用示例： Map classMap = new HashMap(); //必须要对Parent进行初始化 否则不识别
		 *         Teacher p = new Teacher(); classMap.put("teacher", p.getClass());
		 *         List mlist = JSONTransfer.getListFromJsonArrStr(resultStr,
		 *         Student.class, classMap);
		 *//*
			 * 
			 * @SuppressWarnings("rawtypes") public static List<Object>
			 * getListFromJsonArrStr(String jsonArrStr, Class clazz, Map classMap) {
			 * JSONArray jsonArr = JSONArray.fromObject(jsonArrStr); List<Object> list = new
			 * ArrayList<Object>(); for (int i = 0; i < jsonArr.size(); i++) {
			 * list.add(JSONObject.toBean(jsonArr.getJSONObject(i), clazz, classMap)); }
			 * return list; }
			 */
}
