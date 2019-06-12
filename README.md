# SpringCloudWeatherForecast
基于SpringCloud的天气预报系统

## 环境
* java1.8
* springBootVersion = '2.1.4.RELEASE'
* springCloudVersion = 'Greenwich.RELEASE'

## 依赖关系
* weather-eureka-server 注册中心
* weather-collection-eureka-feign 依赖 weather-city-eureka
* weather-report-eureka-feign-gateway-hystrix 依赖 weather-data-eureka
* weather-eureka-client-zuul 负载均衡

## 启动顺序
1. weather-eureka-server
2. weather-city-eureka
3. weather-collection-eureka-feign
4. weather-data-eureka
5. weather-report-eureka-feign-gateway-hystrix
6. weather-eureka-client-zuul

![运行截图](https://github.com/SunShiFu/SpringCloudWeatherForecast/blob/master/TIM%E6%88%AA%E5%9B%BE20190612132816.png)
