package com.ssf.spring.cloud.weather.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.ssf.spring.cloud.weather.vo.City;

/**
 * 访问城市信息的客户端.
 * @author SunShiFu
 *
 */
@FeignClient(name="msa-weather-city-eureka")
public interface CityClient {

	@GetMapping("/cities")
	List<City> listCity() throws Exception;
}
