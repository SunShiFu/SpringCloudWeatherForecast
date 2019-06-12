package com.ssf.spring.cloud.weather.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ssf.spring.cloud.weather.vo.City;
import com.ssf.spring.cloud.weather.vo.WeatherResponse;

/**
 * DataClient Fallback
 * @author SunShiFu
 *
 */
@Component
public class DataClientFallback implements DataClient {

	@Override
	public List<City> listCity() throws Exception {
		List<City> cityList = null;
		cityList = new ArrayList<>();
		City city = new City();
		city.setCityId("101210204");
		city.setCityName("德清");
		cityList.add(city);
		
		city = new City();
		city.setCityId("101200101");
		city.setCityName("武汉");
		cityList.add(city);
		return cityList;
	}

	@Override
	public WeatherResponse getDataByCityId(String cityId) {
		return new WeatherResponse();
	}

}
