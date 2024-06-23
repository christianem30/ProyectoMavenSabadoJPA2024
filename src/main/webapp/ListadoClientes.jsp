<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="java.util.*" %>
    <%@page import="model.TblCliente" %>
 
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Clientes</title>
</head>
<body bgcolor="#c5dec9">
<h1  align="center">Listado de Clientes Registrados en BD</h1>

<h2 align="center">
<a href="FormRegistrarCliente.jsp" style="text-decoration: none; color blue;">Registrar Cliente</a></h2>

<table border="2" align="center">


<tr>
<td>Nombre</td>
<td>Apellido</td>
<td>DNI</td>
<td>Email</td>
<td>Telofono</td>
<td>Sexo</td>
<td>Nacionalidad</td>
</tr>


<%

List<TblCliente> listadocliente=(List<TblCliente>)request.getAttribute("listadodeproductos");

//aplicamos una condicion..

if(listadocliente!=null){

	//aplicamos un bucle for..

	for(TblCliente lis:listadocliente){

		%>

		<tr>

		<td><%=lis.getIdcliente() %></td>
		<td><%=lis.getNombre() %></td>
		<td><%=lis.getApellido() %></td>
		<td><%=lis.getDni() %></td>
		<td><%=lis.getTelf() %></td>
		<td><%=lis.getSexo() %></td>
		<td><%=lis.getNacionalidad() %></td>
		
		
		</tr>
   <% 
	}  //fin del bucle for...
	%>
	
   <% 
} //fin de la condicion ...

%>
</table>

</body>
</html>