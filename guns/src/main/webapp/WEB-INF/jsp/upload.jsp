<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css"/>
</head>


<form action="/user/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <br>

    <button type="button" id="btn">上传</button>

</form>
<%--<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>--%>
<%--<script src="webjars/jquery/3.1.0/jquery.min.js"></script>--%>
<script src="/webjars/jquery/3.1.0/jquery.min.js"></script>
<script>
    ($(function () {

        $("#btn").click(function () {
            var type = $("form")[0].submit();
        });

    }))
</script>


<body>
