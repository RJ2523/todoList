<html>
    <head>
        <link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
        <title>Welcome Page</title>
    </head>
    <body>
        <%@ include file="common/navigation.jspf" %>
        <div class="container">
            <h2>Welcome ${username}, How are you feeling today?</h2>
            <hr>
            <a href="/show-todos" class="btn btn-primary">Show Todo Lists</a>
        </div>
        <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
        <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    </body>
</html>