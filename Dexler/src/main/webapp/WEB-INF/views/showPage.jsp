<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Preschool Enrollment</title>
    <style>
        .error {
            color: red;
            font-size: 13px;
        }
    </style>
</head>
<body style="background-color:lavender">
<h1><center>Preschool Enrollment</center></h1>

<form:form method="POST" action="register" modelAttribute="admission">
    <table align="center">
        <tr>
            <td>Child Name:</td>
            <td><form:input path="childName" id="childName" /></td>
            <td><form:errors path="childName" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Contact Number:</td>
            <td><form:input path="contactNumber" id="contactNumber" /></td>
            <td><form:errors path="contactNumber" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Age:</td>
            <td><form:input path="age" id="age" /></td>
            <td><form:errors path="age" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Email Id:</td>
            <td><form:input path="emailId" id="emailId" /></td>
            <td><form:errors path="emailId" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Program Name:</td>
            <td>
                <form:select path="programName" id="programName">
                    <form:options items="${programNames}" />
                </form:select>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" id="submit" value="Register"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>