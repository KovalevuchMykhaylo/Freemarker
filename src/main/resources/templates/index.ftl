<!DOCTYPE html>
<html>

<head>

    <title>Home page</title>
    <meta charset="UTF-8">

</head>

<body>

<h1>Hello</h1>

<a href="/page">Page</a>

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
    var inputId = 1;

    function notMyFunction() {
        var div = document.createElement("div");
        div.setAttribute("id", inputId);
        document.getElementById("parentId").appendChild(div);
        var node = document.createElement("INPUT");
        node.setAttribute("type", "text");
        node.setAttribute("name", "bookArray");
        node.setAttribute("placeholder", "Book name");
        document.getElementById(inputId).appendChild(node);
        var btn = document.createElement("span");
        btn.innerHTML = "<a onclick=\"removeElementById(" + inputId + ")\">Remove</a>";
        document.getElementById(inputId).appendChild(btn);
        inputId = inputId + 1
    }

    function removeElementById(elementId) {
        var elem = document.getElementById(elementId);
        elem.parentNode.removeChild(elem);
    }
</script>