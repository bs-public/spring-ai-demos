package com.ai.tools.dto;

public class EstimateBudgetResponse {
  private String city;
  private Integer days;
  private Integer estimatedBudget;

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

  public Integer getEstimatedBudget() {
    return estimatedBudget;
  }

  public void setEstimatedBudget(Integer estimatedBudget) {
    this.estimatedBudget = estimatedBudget;
  }
}
