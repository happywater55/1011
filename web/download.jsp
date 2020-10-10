<%--
  Created by IntelliJ IDEA.
  User: QianXinBin
  Date: 2020/9/23
  Time: 下午9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>下载文件</title>
    <link rel="stylesheet" href="./css/bootstrap.css">
</head>
<body>
<c:if test="${ Downlist == null}" >
    无下载项
</c:if>

<c:forEach items="${Downlist}" var="dao" begin="0">
    <a href="/servlet/download?id=${dao.id}" class="list-group-item">
            <div>id:${dao.id }</div>
            <p>name:${dao.name }</p>
    </a>
</c:forEach>
</body>
</html>
