<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>D3 Chart</title>
	<link href="resources/css/c3.min.css" rel="stylesheet" />
	<script src="resources/js/jquery.min.js"></script>
	<script src = "resources/js/d3.min.js"></script>
	<script src = "resources/js/c3.min.js"></script>
</head>
<body>
	<!--차트가 표시될 위치-->
	<div style="width:500px">
		<div id="chart"></div>
	</div>

	<script>
		$(function(){
			var chart = c3.generate({
				bindto : '#chart',
				data: {
			        columns: [
			            ['data1', 30, 200, 100, 400, 150, 250],
			            ['data2', 130, 100, 140, 200, 150, 50]
			        ],
			        type: 'spline'
			    }
			});
			
			
			//setTimeout 1회만
			setInterval(function () {
				//JSONController에서 1초 간격으로 값을 받음
				$.get('json/c3_chart', function(data){
					console.log(data);
					//넘어온 데이터를 tmp에 저장
					var tmp = eval(data.ret);
					//차트 새로 그림
				    chart.load({
				        columns: [
				            tmp
				        ]
				    });
				}, 'json')
			}, 1000);
			
			//data2
			setInterval(function () {
				//JSONController에서 1초 간격으로 값을 받음
				$.get('json/c3_chart', function(data){
					console.log(data);
					//넘어온 데이터를 tmp에 저장
					var tmp1 = eval(data.ret1);
					//차트 새로 그림
				    chart.load({
				        columns: [
				            tmp1
				        ]
				    });
				}, 'json')
			}, 1000);

		});
	</script>
</body>
</html>