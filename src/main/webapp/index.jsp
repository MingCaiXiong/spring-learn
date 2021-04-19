<%--
  Created by IntelliJ IDEA.
  User: xmc
  Date: 2021/4/19
  Time: 7:02 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="http://localhost:8080">
</head>
<body>
<h1>hello RESTful</h1>
<button id="get">get</button>
<button id="post">post</button>
<button id="put">put</button>
<button id="delete">delete</button>
<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    $("#get").click(function () {
        $.get("/restful/request", function (date) {
            console.log(arguments);
        })
    })
    $("#post").click(function () {
        $.post("/restful/request/100", function (date) {
            console.log(arguments);
        })
    })
    $("#put").click(function () {
        $.ajax({
            url: '/restful/request',
            type: 'PUT',
            success: function (result) {
                // Do something with the result
            }
        });
    })
    $("#delete").click(function () {
        $.ajax({
            url: '/restful/request',
            type: 'DELETE',
            success: function (result) {
                // Do something with the result
            }
        });
    })

</script>
</body>
</html>
