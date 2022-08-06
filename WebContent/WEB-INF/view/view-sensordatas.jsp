<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>
<%@ page import="com.luv2code.mvc.Model.SensorData"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>ESP32 Sensor Data</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="https://canvasjs.com/assets/script/jquery-1.11.1.min.js"></script>
	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
	
	<script type="text/javascript">
		window.onload = function() { 
			var tempPoints = [];
			var humidPoints = [];
			
			var tempChart = new CanvasJS.Chart("tempChart", {
				theme: "light2",
				title: {
					text: "Temperature data from ESP"
				},
				axisX: {
					title: "Time"
				},
				axisY: {
					title: "°C",
					includeZero: true
				},
				data: [{
					type: "line",
					dataPoints : tempPoints
				}]
			});
			
			var humidChart = new CanvasJS.Chart("humidChart", {
				theme: "light2",
				title: {
					text: "Humidity data from ESP"
				},
				axisX: {
					title: "Time"
				},
				axisY: {
					title: "%",
					includeZero: true
				},
				data: [{
					type: "line",
					dataPoints : humidPoints
				}]
			});
			
			function addData(data) {
				for (var i = 0; i < data.length; i++) {
					tempPoints.push({
						x: i,
						y: data[i].temperature
					});
					humidPoints.push({
						x: i,
						y: data[i].humidity
					});
				}
				tempChart.render();
				humidChart.render();
			}
			 
			$.getJSON("http://localhost:8080/spring-mvc-demo/esp/jsonData", addData);
		}
	</script>
</head>
<body>
	<h1>ESP32 Sensor Data</h1>
	<div id="tempChart" style="height: 370px; width: 100%;"></div>
	<br/><br/>
	<div id="humidChart" style="height: 370px; width: 100%;"></div>
</body>
</html>