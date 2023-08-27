<!DOCTYPE html>
<html>
<head>
    <title>My tasks</title>
</head>
<body>
<h1>My Tasks</h1>
<hr>
<div>
    <table border="1">
        <tr>
            <th>Title</th>
            <th>Description</th>
            <th>Date of created</th>
            <th>Status</th>
            <th></th>
        </tr>
        <#list tasks as task>
            <tr>
                <td><a href="task/${task.id}">${task.title}</a></td>
                <td>${task.description}</td>
                <td>${task.dateOfCreated.format(("dd-MM-yyyy HH:mm:ss"))}</td>
                <td><a>${task.status.name()}</a></td>
                <td><a href="task/delete/${task.id}">Delete</a></td>
            </tr>
        <#else>
            <h3>No tasks</h3>
        </#list>
    </table>
</div>

<hr>
<h3>Create task</h3><br>
<form action="/task/create" method="post">
    Title: <input type="text" name="title"/><br>
    Description: <input type="text" name="description" size="100"/><br>
    <input type="submit" value="Add task">
</form>

</body>
</html>