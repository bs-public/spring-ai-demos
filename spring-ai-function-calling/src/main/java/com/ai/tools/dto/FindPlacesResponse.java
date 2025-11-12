package com.ai.tools.dto;

import java.util.List;

public class FindPlacesResponse {
  private String city;
  private String category;
  private List<String> places;

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

  public List<String> getPlaces() {
    return places;
  }

  public void setPlaces(List<String> places) {
    this.places = places;
  }
}
