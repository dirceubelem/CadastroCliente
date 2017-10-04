<%-- 
    Document   : index
    Created on : 02/10/2017, 21:46:25
    Author     : usuario
--%>

<%@page import="bo.BOCliente"%>
<%@page import="to.TOCliente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String filtro = request.getParameter("filtro");
    if (filtro == null) {
        filtro = "";
    }
    List<TOCliente> l = BOCliente.lista(filtro);

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%@include file="../menu.jsp" %>

        <h3>Clientes</h3>
        
        <input value="Inserir" type="button" onclick="location.href = 'inserir.jsp'"/><br/><br/>

        <form method="post" action="">
            Busca: <input name="filtro" value="<%=filtro%>"/> <input type="submit" value="Buscar"/>
        </form>
        
        <br/>
        
        <table border="1">
            <tr>
                <td>Id</td>
                <td>Nome</td>
                <td>Telefone</td>
                <td>E-mail</td>
                <td>Cadastro</td>
            </tr>
            <%for(TOCliente c : l){%>
            <tr>
                <td><%=c.getId()%></td>
                <td><%=c.getNome()%></td>
                <td><%=c.getTelefone()%></td>
                <td><%=c.getEmail()%></td>
                <td><%=c.getCadastro()%></td>
            </tr>
            <%}%>
        </table>

    </body>
</html>
