<!DOCTYPE html>
<html>
<head>
    <title>Task</title>
</head>
<body>
<form action="/task/edit/${task.id}" method="post">
    Title: <input type="text" name="title" placeholder="${task.title}"><br>
    Description <input type="text" name="description" placeholder="${task.description}"><br>
    <button type="submit">Save</button>
</form>
<a href="/">Back</a>
</body>
</html>