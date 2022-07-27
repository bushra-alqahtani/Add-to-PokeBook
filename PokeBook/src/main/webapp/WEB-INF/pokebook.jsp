<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

   

<h1>Track an Expense</h1>
<form:form action="/books/new" method="post" modelAttribute="book" class="container m-5">
    <p>
        <form:label path="expense">expense</form:label>
        <form:errors path="expense"/>
        <form:input path="expense"/>
    </p>
    <p>
        <form:label path="vendor">vendor</form:label>
        <form:errors path="vendor"/>
        <form:textarea path="vendor"/>
    </p>
    <p>
        <form:label path="amount">amount</form:label>
        <form:errors path="amount"/>
        <form:input type="number" path="amount"/>
    </p>
    <p>
        <form:label path="deiscription">description</form:label>
        <form:errors path="deiscription"/>     
        <form:input  path="deiscription"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>

    
    
  