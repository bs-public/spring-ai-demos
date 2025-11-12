package com.ai.tools.dto;

public class GetWeatherResponse {
  private String city;
  private Integer temperatureC;
  private String condition;

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Integer getTemperatureC() {
    return temperatureC;
  }

  public void setTemperatureC(Integer temperatureC) {
    this.temperatureC = temperatureC;
  }

  public String getCondition() {
    return condition;
  }

  public void setCondition(String condition) {
    this.condition = condition;
  }
}
