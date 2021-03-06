package org.sonatype.mavenbook.web;

import org.sonatype.mavenbook.weather.model.Weather;
import org.sonatype.mavenbook.weather.WeatherService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class WeatherController implements Controller {

	private WeatherService weatherService; 

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String zip = request.getParameter("zip");
		Weather weather = weatherService.retrieveForecast(zip);
		return new ModelAndView("weather", "weather", weather);
	}

	public WeatherService getWeatherService() {
		return weatherService;
	}

	public void setWeatherService(WeatherService weatherService) {
		this.weatherService = weatherService;
	}

}