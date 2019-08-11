<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>chart exam</title>
	<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.css">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.min.js"></script>
</head>

<body>
	${num}

	<div id="myfirstchart" style="height: 250px; width:500px"></div>
	
	<script>
    $(function(){
       var mychar = new Morris.Bar({
            element: 'myfirstchart',
            data: [
                 { year: '2008', value: 20, value1: 34 },
                 { year: '2009', value: 10, value1: 4 },
                 { year: '2010', value: 5, value1: 54 },
                 { year: '2011', value: 5, value1: 64 },
                 { year: '2012', value: 20, value1: 4 }
            ],
            xkey: 'year',
            ykeys: ['value','value1'],
            labels: ['출력내용', '출력내용1']
       });
       
       
       //127.0.0.1:8090/web/    json/chart1
       setInterval(function(){
       		$.get('http://127.0.0.1:8090/web/json/chart1', function(data){
    			console.log(data);
    	   		//넘어온 값을 chart에 적용
    	   		mychar.setData(data);
       		},'json');
       }, 500);
       
    });
    </script>	
</body>
</html>