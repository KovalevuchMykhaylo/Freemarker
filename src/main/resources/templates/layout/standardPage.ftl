<#macro standardPage title="">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
</head>
<body>
    <#include "header.ftl">

    <#nested/>

    <#include "footer.ftl">
</body>
</html>
</#macro>