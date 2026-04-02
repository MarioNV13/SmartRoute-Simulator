package com.transport.model;

import java.util.List;

public class RouteResponse {
    private List<String> cityList; // Cities list (eg: ["Bucuresti", "Ploiesti", "Brasov"])
    private String formattedTime; // Formated time (ex: "3h 45min")

    public RouteResponse(List<String> cityList, String formattedTime) {
        this.cityList = cityList;
        this.formattedTime = formattedTime;
    }

    // Getters are necesary because spring will transform the objects in JSON
    public List<String> getCityList() { return cityList; }
    public String getFormattedTime() { return formattedTime; }
}