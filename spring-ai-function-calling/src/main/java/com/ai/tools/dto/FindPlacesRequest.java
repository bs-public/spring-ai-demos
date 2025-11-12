package com.ai.tools.dto;

public class FindPlacesRequest {
  private String city;
  private String category;

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }
}
