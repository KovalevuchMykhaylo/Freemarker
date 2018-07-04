<!DOCTYPE html>
<html>
<head>
    <title>Home page</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<h1>Hello</h1>
<p>${test}</p>
<#list authors as authr>
            <div>
                <p>${authr.name}</p>
            </div>
</#list>
</body>