package com.luv2code.mvc.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.mvc.Model.SensorData;

@Controller
@RequestMapping("/esp")
public class DataSensorController {
	List<SensorData> sensorDatas = new ArrayList<SensorData>();
	
	@GetMapping("/viewSensorData")
	public String viewSensorData(HttpServletRequest request) {
		request.setAttribute("sensorDatas", sensorDatas);
		return "view-sensordatas";
	}
	
	@GetMapping("/addSensorData")
	public String addSensorDataView(@RequestParam("temp") Float temp, @RequestParam("humid") Float humid) {
		SensorData sensorData = new SensorData(temp, humid);
		sensorDatas.add(sensorData);
        return "add-sensordata";
	}
	
	@GetMapping("/jsonData")
	public String getJsonData(HttpServletRequest request) {
		JSONArray ja = new JSONArray();
		for(SensorData sensorData : sensorDatas) {
			Map<String, Float> map = new HashMap<>();
			map.put("temperature", sensorData.getTemperature());
			map.put("humidity", sensorData.getHumidity());
			JSONObject jo = new JSONObject(map);
			ja.add(jo);
		}
		request.setAttribute("sensorDataJson", ja);
        return "json-sensordata";
	}
}
