package com.ssf.spring.cloud.weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssf.spring.cloud.weather.vo.Weather;
import com.ssf.spring.cloud.weather.vo.WeatherResponse;

/**
 * 天气预报服务
 * @author SunShiFu
 *
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {
	
	@Autowired
	private DataClient dataClient;
	
	@Override
	public Weather getDataByCityId(String cityId) {
		
		// 由天气数据API微服务来提供数据
		WeatherResponse response = dataClient.getDataByCityId(cityId);
		return response.getData();
	}

}
