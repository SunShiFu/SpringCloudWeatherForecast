package com.ssf.spring.cloud.weather.service;

/**
 * 天气数据采集服务
 * @author SunShiFu
 *
 */
public interface WeatherDataCollectionService {
	
	/**
	 * 根据城市ID同步天气数据
	 * 
	 * @param cityId
	 * @return
	 */
	void syncDataByCityId(String cityId);

}
