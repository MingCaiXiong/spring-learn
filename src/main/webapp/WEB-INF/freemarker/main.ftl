<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<#if Session ["login_user"]?exists>
    <p>当前用户:${Session ["login_user"]} <a href="/logout">退出</a></p>
<#else>
    <a href="/login">login</a>
</#if>

</body>
</html>