<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
        <title>Add Todo</title> 
    </head>
    <body>
        <%@ include file="common/navigation.jspf" %>
        <div class="container">
            <pre>Please enter the todo details</pre>
            <form:form method="post" modelAttribute="todo">
                <fieldset class="mb-3">
                    <form:label path="description">Description</form:label>
                    <form:input type="text" path="description" required="required"/>
                    <form:errors path="description" cssClass="text-warning"/>
                </fieldset>

                <fieldset class="mb-3">
                    <form:label path="targetDate">Target Date</form:label>
                    <form:input type="text" path="targetDate" required="required"/>
                    <form:errors path="targetDate" cssClass="text-warning"/>
                </fieldset>
				<form:input type="hidden" path="id"/>
				<form:input type="hidden" path="isCompleted"/>
				<input type="submit" class="btn btn-success"/>
			
			</form:form>
        </div>
        <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
        <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    </body>
</html>