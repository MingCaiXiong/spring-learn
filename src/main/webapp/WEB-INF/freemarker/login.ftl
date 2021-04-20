<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>登录页</title>
    <link rel="stylesheet" href="/assets/style/main.css">
</head>
<body>
<#if Session ["message"]?exists>
    <p>当前用户:${Session ["message"]}</p>
</#if>
<form action="/login" method="post">
    <fieldset>
        <legend>用户登录</legend>
        <label>
            <span>用户名:</span>
            <input name="name" type="text">
        </label>
        <label>
            <span>用户名:</span>
            <input name="password" type="text">
        </label>

        <button type="submit"> 登录</button>
    </fieldset>
</form>
</body>
</html>