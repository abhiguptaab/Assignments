<%@page import="java.util.HashSet"%>
<%@page import="org.eclipse.jdt.internal.compiler.ast.ForeachStatement"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Application Context</title>
</head>
<body>
<%@ page import="java.util.*" %>

<%! HashSet<String> s1 = new HashSet<String>();  
%>
<%! String displayProduct ="";%>
<%! String product ="";%>
<%! String AppProduct = ""; %>




<form action ="" method = "post">
<table>
	<tr>
		<td>Product</td>
		<td><input type ="text" name ="product" ></td>
	</tr>
	
	<tr>
		<td><input type ="submit" name ="submit" ></td>
	</tr>
	
</table>
</form>

<%if(request.getParameter("product")!=null){
 product = request.getParameter("product");

} %>



<%
AppProduct = product;
s1.add(AppProduct);
application.setAttribute("set", s1);
%>


<%
HashSet<String> s2 = new HashSet<String>();
if (application.getAttribute("set") != null) {
	s2 = (HashSet) application.getAttribute("set");
}
%>

<hr>

<h4> Suggestions::</h4>
<p> [
<% Iterator<String> i = s2.iterator(); 
        while (i.hasNext()) {%>
            <p><%= i.next() +"," %></h1> 
<%} %> ]</p>




</body>
</html>