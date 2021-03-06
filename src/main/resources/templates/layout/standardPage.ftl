<#macro standardPage title="">
<#--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>-->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${title}</title>

    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/myJs.js"></script>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body class="container-fluid">
    <#include "header.ftl">

    <#nested/>

    <#include "footer.ftl">
</body>
</html>
</#macro>