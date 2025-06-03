<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 6/3/2025
  Time: 3:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Form</h1>
<form:form action="/form" method="post" modelAttribute="formRequest">
    <form:input path="name" placeholder="Enter your name"/>
    <form:errors path="name" cssStyle="color: red" element="p" />
    <form:input path="email" placeholder="Enter your email" />
    <form:errors path="email" cssStyle="color: red" element="p" />
    <form:input path="age" placeholder="Enter your age" />
    <form:errors path="age" cssStyle="color: red" element="p" />

    <form:button>Submit</form:button>

<%--    <form:checkboxes path="hobbies" items="${list}" itemValue="name" itemLabel="email"/>--%>
<%--    <form:radiobuttons path="hobbies" items="${list}" itemValue="name" itemLabel="email"/>--%>
<%--    <form:options items=""/>    --%>
</form:form>
</body>
</html>
