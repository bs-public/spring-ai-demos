package com.ai.tools;

import com.ai.tools.dto.EstimateBudgetRequest;
import com.ai.tools.dto.EstimateBudgetResponse;
import com.ai.tools.dto.FindPlacesRequest;
import com.ai.tools.dto.FindPlacesResponse;
import com.ai.tools.dto.GetWeatherRequest;
import com.ai.tools.dto.GetWeatherResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

/**
 * Travel-related tools exposed to the model via Spring AI's tools API. Methods annotated with @Tool
 * become callable by the model.
 */
@Component
public class TravelTools {

  @Tool(description = "Get mock weather information for a city")
  public GetWeatherResponse getWeather(GetWeatherRequest req) {
    GetWeatherResponse response = new GetWeatherResponse();
    response.setCity(req.getCity());
    response.setTemperatureC(30);
    response.setCondition("Sunny");
    return response;
  }

  @Tool(description = "Find popular places to visit in a city")
  public FindPlacesResponse findPlaces(FindPlacesRequest req) {
    List<String> places = new ArrayList<String>();
    places.add("Test Place 1");
    places.add("Test Place 2");
    places.add("Test Place 3");

    FindPlacesResponse response = new FindPlacesResponse();
    response.setCity(req.getCity());
    response.setCategory(req.getCategory() == null ? "tourist" : req.getCategory());
    response.setPlaces(places);
    return response;
  }

  @Tool(description = "Estimate travel budget for a city and number of days (INR)")
  public EstimateBudgetResponse estimateBudget(EstimateBudgetRequest req) {
    int basePerDay = 1500;
    int days = req.getDays() != null && req.getDays() > 0 ? req.getDays() : 1;
    EstimateBudgetResponse response = new EstimateBudgetResponse();
    response.setCity(req.getCity());
    response.setDays(days);
    response.setEstimatedBudget(days * basePerDay);
    return response;
  }
}
