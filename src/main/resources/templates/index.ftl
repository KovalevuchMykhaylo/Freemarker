<#include "layout/standardPage.ftl" />
<@standardPage title="Home">
<div class="bodyContent">
    <div class="col-md-12">
        <div class="row">
            <div class="col-md-6">
                <div>
                    <button class="btn btn-warning" onclick="showHideForm()">Show/Hide Form</button>
                </div>
                <div id="listAuthors" style="display: block">
                    <p>Authors names</p>
                    <#list authors as author>
                        <div>
                            <p>${author.name} ${author.lastName} <a href="/books/${author.id}" class="button">Books</a>
                            </p>
                        </div>
                    </#list>
                </div>
            </div>
                <#if authorBooks??>
                    <div class="col-md-6" id="listOfBooks" style="display: block">
                        <div style="height: 400px; overflow-y: scroll; background: white;">
                         ${authorBooks}
                        </div>
                    </div>
                </#if>
            <div class="col-md-12">
                <form action="/testForm" method="post" id="parentId" style="display: none">
                    <div>
                        <label for="firstName">First Name</label>
                        <input type="text" name="firstName" required/>
                    </div>
                    <div>
                        <label for="lastName">Last Name</label>
                        <input type="text" name="lastName" required/>
                    </div>
                    <a onclick="notMyFunction()" class="customBtn">Add Book</a>
                    <button type="submit" class="btn btn-success">Add</button>
                </form>
            </div>
        </div>
    </div>
</div>
</@standardPage>