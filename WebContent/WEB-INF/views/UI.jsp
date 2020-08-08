<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="hcltaskmodel.DBFields" %>
<%
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "transactions";
String userId = "root";
String password = "root";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>TRANSACTIONS</h2>
<table>
<tr>
<tr bgcolor="blue">
<td>Transaction ID</td>
<td>Credited TO</td>
<td>Amount Debited</td>
</tr>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM record";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>

<tr>
<td><%=resultSet.getInt("Tid") %></td>
<td><%=resultSet.getString("reciever_name") %></td>
<td><%=resultSet.getInt("amount") %></td>
</tr>
<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>

</table>
<div>

<h1>ACCOUNT BALANCE : </h1><%=out.print(resultSet.getInt("bal")) %>
</div>
<div>
<h2 align="center" >PAYMENT</h2>

<form action="<%= request.getContextPath() %>/UI" method="post">
<table>
<tr>
<td><h3>RECIEVER NAME : </h3></td>
<td><input type="text" name="receiver_name"></td>
</tr>
<tr>
<td><h3>Amount to be paid : </h3></td>
<td><input type="number" name="amount"></td>
</tr>
</table>
<input type="submit" name="transfer" value="FundTransfer">

</form>
</div>

</body>
</html>