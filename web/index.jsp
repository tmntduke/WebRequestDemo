<%--
  Created by IntelliJ IDEA.
  User: tmnt
  Date: 2017/2/8
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script>

        if (window.XMLHttpRequest) {
            xhr = new XMLHttpRequest();
        }
        else {
            xhr = new ActiveXObject("Microsoft.XMLHTTP");
        }

        xhr.timeout = 16000;
        xhr.responseType = "text";
        xhr.open("POST", "/PrintServlet", true);
        xhr.onload = function () {
            if (this.status == 200 || this.status == 304) {
                var txt = this.responseText;
                console.log(txt);
                //var obj = JSON.parse(txt);
                //console.log(obj);
                document.getElementById("txt").innerHTML = txt
            }
        }
        xhr.send(null);
    </script>
</head>
<body>
<p id="txt"></p>
</body>


</html>
