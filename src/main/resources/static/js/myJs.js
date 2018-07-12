var inputId = 1;

function notMyFunction() {

    var div = document.createElement("div");
    div.setAttribute("id", inputId);
    document.getElementById("parentId").appendChild(div);

    var node = document.createElement("INPUT");
    node.setAttribute("type", "text");
    node.setAttribute("name", "bookArray");
    node.setAttribute("placeholder", "Book name");
    node.setAttribute("required", "required");
    document.getElementById(inputId).appendChild(node);

    var btn = document.createElement("span");
    btn.setAttribute("class", "bodyContent");
    btn.innerHTML ="<a class=\"customBtn\" onclick=\"removeElementById(" + inputId + ")\">Remove</a>";
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

    var z = document.getElementById("listOfBooks");
    if(z != null) {
        if (z.style.display === "block") {
            z.style.display = "none";
        } else {
            z.style.display = "block";
        }
    }
}

function reloadPage() {
    location.reload();
}