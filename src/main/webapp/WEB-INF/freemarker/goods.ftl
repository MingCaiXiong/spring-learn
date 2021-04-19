<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <style>
        table {
            width: 100%;
            text-align: center;
        }
    </style>

</head>
<body>
<table border="1">
    <thead>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>price</th>
        <th>desp</th>
        <th>create_time</th>
    </tr>
    </thead>
    <tbody>

    <#list goods as g>
        <tr>
            <td>${g.id}</td>
            <td>${g.name}</td>
            <td>${g.price?string.currency}</td>
            <td>${g.desp}</td>
            <td>${g.create_time?date}</td>
        </tr>
    </#list>
    </tbody>
</table>
</body>
</html>