<!DOCTYPE html>
<html>

<head>

    <title>Home page</title>
    <meta charset="UTF-8">

</head>

<body>

<h1>Hello</h1>

<#list authors as authr>
            <div>
                <p>${authr.name}</p>
            </div>
</#list>
<br>
<a href="/test" class="button">Test</a>

<form action="/testForm" method="post" id="parentId">
    <input type="text" name="firstName">
    <input type="text" name="lastName">
    <a onclick="notMyFunction()">Add Book</a>
    <button type="submit">Add</button>
</form>

</body>

<script>
    function notMyFunction() {
        var node = document.createElement("INPUT");
        node.setAttribute("type", "text");
        node.setAttribute("name", "bookArray");
        document.getElementById("parentId").appendChild(node);
    }
</script>