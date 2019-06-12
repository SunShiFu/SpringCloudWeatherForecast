package com.ssf.spring.cloud.weather.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ssf.spring.cloud.weather.service.DataClient;
import com.ssf.spring.cloud.weather.service.WeatherReportService;
import com.ssf.spring.cloud.weather.vo.City;

/**
 * 天气预报API
 * @author SunShiFu
 *
 */
@RestController
@RequestMapping("/report")
public class WeatherReportController {

	private final static Logger logger = LoggerFactory.getLogger(WeatherReportController.class);

	@Autowired
	private DataClient dataClient;

	@Autowired
	private WeatherReportService weatherReportService;

	@GetMapping("/cityId/{cityId}")
	public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception {
		// 由城市数据API微服务来提供数据
		List<City> cityList = null;
		try {
			// 调用城市数据API
			cityList = dataClient.listCity();
		} catch (Exception e) {
			logger.error("获取城市信息异常！", e);
			throw new RuntimeException("获取城市信息异常！", e);
		}

		model.addAttribute("title", "SpringCloud天气预报系统");
		model.addAttribute("cityId", cityId);
		model.addAttribute("cityList", cityList);
		model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
		return new ModelAndView("weather/report", "reportModel", model);
	}

}
