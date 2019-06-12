package com.ssf.spring.cloud.weather.service;

import com.ssf.spring.cloud.weather.vo.Weather;
/**
 * 天气预报服务
 * @author SunShiFu
 *
 */
public interface WeatherReportService {

	/**
	 * 根据城市ID查询天气信息
	 * 
	 * @param cityId
	 * @return
	 */
	Weather getDataByCityId(String cityId);

}
