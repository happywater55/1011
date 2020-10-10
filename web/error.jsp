<%--
  Created by IntelliJ IDEA.
  User: QianXinBin
  Date: 2020/9/23
  Time: 下午9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>error</title>
    <script>
        onload = function () {
            <%
                String error = "请登录";
            if(request.getAttribute("error")!=null){
                error = (String)request.getAttribute("error");
            }
            %>
            var s = '<%=error%>';
            p = document.getElementsByTagName("p")[0];
            p.innerHTML = s;
            // console.log('sdf');
        }

    </script>
</head>
<body>
<h2>错误</h2>
<p style="color: red"></p>
<p>还有<span id="second"></span>秒自动跳转到登录 <a href="/login.html"><span id="link">如果未跳转请点击此处</span></a></p>
</body>
<script>
    var time = 10;

    function uptime() {
        document.querySelector("#second").innerHTML = time;
        time--;
        if (time == 0) {
            document.querySelector("#link").click();
            clearInterval(timer);
        }

    }

    timer = setInterval('uptime()', 1000);
</script>
</html>
