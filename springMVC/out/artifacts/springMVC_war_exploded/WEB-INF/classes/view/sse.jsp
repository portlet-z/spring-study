<taglib
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>SSE Demo</title>
    <script type="text/javascript" src="assets/js/jquery.js"></script>
</head>
<body>
<div id="msgFromPush"></div>
<script type="text/javascript">
    if(!!window.EventSource){
        var source = new EventSource('push');
        s = '';
        source.addEventListener('message', function (e) {
            s += e.data + "<br/>";
            $("#msgFromPush").html(s);
        });

        source.addEventListener('open', function (e) {
            console.log("链接打开.")
        },false);

        source.addEventListener('error', function (e) {
            if(e.readyState == EventSource.CLOSED){
                console.log("链接关闭");
            }else{
                console.log(e.readyState);
            }
        },false);
    }
</script>
</body>
</html>