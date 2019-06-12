package com.ssf.spring.cloud.weather.task;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.ssf.spring.cloud.weather.service.CityClient;
import com.ssf.spring.cloud.weather.service.WeatherDataCollectionService;
import com.ssf.spring.cloud.weather.vo.City;

/**
 * 天气数据同步任务
 * @author SunShiFu
 *
 */
@Component
public class ScheduledTasks {
	
	private final static Logger logger = LoggerFactory.getLogger(ScheduledTasks.class); 

	@Autowired
	private WeatherDataCollectionService weatherDataCollectionService;
	
	@Autowired
	private CityClient cityClient;
	

	// 每一小时执行一次
	@Scheduled(fixedRate = 3600000)
	protected void getWeatherData() {
		logger.info("Start 天气数据同步任务");
		
		// 由城市数据API微服务来提供数据
		List<City> cityList = null;
		try {
			// 调用城市数据API
			cityList = cityClient.listCity();
		} catch (Exception e) {
			logger.error("获取城市信息异常！", e);
			throw new RuntimeException("获取城市信息异常！", e);
		}

		for (City city : cityList) {
			String cityId = city.getCityId();
			logger.info("天气数据同步任务中，cityId:" + cityId);
			
			// 根据城市ID同步天气数据
			weatherDataCollectionService.syncDataByCityId(cityId);
		}
		
		logger.info("End 天气数据同步任务");
	}

}
