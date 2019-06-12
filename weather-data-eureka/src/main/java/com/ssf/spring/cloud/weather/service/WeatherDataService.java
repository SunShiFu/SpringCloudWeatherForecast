package com.ssf.spring.cloud.weather.service;

import com.ssf.spring.cloud.weather.vo.WeatherResponse;

/**
 * 天气数据服务
 * @author SunShiFu
 *
 */
public interface WeatherDataService {

	/**
	 * 根据城市ID查询天气数据
	 * 
	 * @param cityId
	 * @return
	 */
	WeatherResponse getDataByCityId(String cityId);

	/**
	 * 根据城市名称查询天气数据
	 * 
	 * @param cityId
	 * @return
	 */
	WeatherResponse getDataByCityName(String cityName);

}
