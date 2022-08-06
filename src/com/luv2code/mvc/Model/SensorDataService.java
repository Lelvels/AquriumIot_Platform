package com.luv2code.mvc.Model;

import java.util.Collection;

public interface SensorDataService {
    Collection<SensorData> getSensorDatas();
    SensorData addSensorData(SensorData data);
}