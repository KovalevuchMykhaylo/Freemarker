<#include "layout/standardPage.ftl" />
<@standardPage title="Home">
    <h1>Hello</h1>
    <button onclick="reloadPage()">Reload page</button>

    <a href="/page">Page</a>

    <button onclick="showHideForm()">Show/Hide Form</button>
    <div id="listAuthors" style="display: block">
        <p>Authors names</p>
        <#list authors as authr>
            <div>
                <p>${authr.name} ${authr.lastName}</p>
            </div>
        </#list>
    </div>
        <br>
        <form action="/testForm" method="post" id="parentId" style="display: none">
            <input type="text" name="firstName">
            <input type="text" name="lastName">
            <a onclick="notMyFunction()">Add Book</a>
            <button type="submit">Add</button>
        </form>
</@standardPage>

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

    function showHideForm() {

        var x = document.getElementById("parentId");
        if (x.style.display === "none") {
            x.style.display = "block";
        } else {
            x.style.display = "none";
        }

        var y = document.getElementById("listAuthors");
        if (y.style.display === "block") {
            y.style.display = "none";
        } else {
            y.style.display = "block";
        }
    }

    function reloadPage() {
        location.reload();
    }
</script>