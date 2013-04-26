package com.comp1008.observatory;

public interface WeatherAPIClientDelegate {
    void clientDidReceiveNewData(WeatherAPIClient client);
}