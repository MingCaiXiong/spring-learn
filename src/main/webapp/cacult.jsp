<%--
  Created by IntelliJ IDEA.
  User: xmc
  Date: 2021/4/19
  Time: 12:12 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/calculate" method="post">
    <fieldset style="display: inline-block">
        <legend>计算BMI身体指数</legend>
        <label>
            <span>身高:</span>
            <input type="text" name="height" value="160">
            <span>cm</span>
        </label>
        <label>
            <span>体重:</span>
            <input type="text" name="bodyWeight" value="55">
            <span>kg</span>
        </label>
        <button type="submit"> 提交测试</button>
    </fieldset>
</form>
</body>
</html>
