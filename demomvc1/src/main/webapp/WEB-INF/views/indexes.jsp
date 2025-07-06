<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Registration Form</title>
</head>
<body>
    <h2>Register Student</h2>

    <form:form action="${pageContext.request.contextPath}/students/submit" modelAttribute="students" method="post">

        <label>Student ID:</label>
        <form:input path="sid" /><br><br>

        <label>Name:</label>
        <form:input path="name" /><br><br>

        <label>Email:</label>
        <form:input path="email" /><br><br>

        <label>Gender:</label>
        <form:radiobutton path="gender" value="Male" /> Male
        <form:radiobutton path="gender" value="Female" /> Female<br><br>

        <label>Course:</label>
        <form:select path="course">
            <form:options items="${courses}" />
        </form:select><br><br>

        <label>Timings:</label><br>
        <form:checkboxes path="timings" items="${timings}" /><br><br>

        <input type="submit" value="Register" />
    </form:form>

    <c:if test="${not empty msg}">
        <p style="color:green;">${msg}</p>
    </c:if>
</body>
</html>