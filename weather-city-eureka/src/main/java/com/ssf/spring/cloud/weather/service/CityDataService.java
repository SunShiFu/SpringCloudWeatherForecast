package com.ssf.spring.cloud.weather.service;

import java.util.List;

import com.ssf.spring.cloud.weather.vo.City;

/**
 * 城市数据服务接口
 * @author SunShiFu
 *
 */
public interface CityDataService {

	/**
	 * 获取城市列表.
	 * 
	 * @return
	 * @throws Exception
	 */
	List<City> listCity() throws Exception;
}
