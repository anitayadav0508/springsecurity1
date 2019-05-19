<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title> Registration Form</title>
</head>
<body>
<h1> Register Form</h1>
<form action="/home/register">
    <table style="with: 50%">


        <tr>
            <td>UserName</td>
            <td><input type="text" name="username" /></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" /></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email" /></td>
        </tr>
        <tr>
            <td><label>Multiple Selection </label>&nbsp;</td>
            <td><select name="select2" size="3" multiple="multiple" tabindex="1">
                <option  value="role_employee">ROLE_EMPLOYEE</option>
                <option  value="role_manager">ROLE_MANAGER</option>
            </select>
            </td>
        </tr>
       </table>
    <input type="submit" value="Submit" /></form>
</body>
</html>