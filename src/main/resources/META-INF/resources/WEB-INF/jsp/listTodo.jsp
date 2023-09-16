    <body>
        <div class="container">
            <pre>Welcome, ${username}</pre>
            <hr>
            <body>
                <%@ include file="common/header.jspf" %>
                <%@ include file="common/navigation.jspf" %>
               <table class="table">
                   <thead>
                       <tr>
                           <!-- <th>id</th> -->
                           <th>Description</th>
                           <th>target date</th>
                           <th>is Done?</th>
                           <th></th>
                           <th></th>
                       </tr>
                   </thead>
                   <tbody>
                       <c:forEach items = "${todos}" var="todo">
                           <tr>
                               <!-- <td>${todo.id}</td> -->
                               <td>${todo.description}</td>
                               <td>${todo.targetDate}</td>
                               <td>${todo.isCompleted}</td>
                               <td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a></td>
                               <td><a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a></td>
                           </tr>
                        </c:forEach>
                   </tbody>
               </table>
               <a href="add-todo" class="btn btn-primary">Add Todo</a>
        </div>  
        <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
        <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    </body>
</html>