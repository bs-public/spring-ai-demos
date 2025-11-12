package com.ai.tools.dto;

public class EstimateBudgetRequest {
  private String city;
  private Integer days;

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Integer getDays() {
    return days;
  }

  public void setDays(Integer days) {
    this.days = days;
  }
}
