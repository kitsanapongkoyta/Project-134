<%-- 
    Document   : checkout
    Created on : Nov 26, 2020, 12:28:37 AM
    Author     : USER
--%>

<%@page import="java.util.Iterator"%>
<%@page import="model.DvdcartTable"%>
<%@page import="java.util.Vector"%>
<%@page import="model.Dvdcart"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <jsp:useBean id="emp" class="model.Dvdcart" scope="request"/>
    <%
            EntityManager em = (EntityManager) session.getAttribute("entitymanager");
            Vector<Dvdcart> empList = DvdcartTable.findAllDvdcart(em);
            Iterator<Dvdcart> itr = empList.iterator();
     %>
    <body>
        <h1><%="Your Order Is Comfirmed! Total Amont Is "+request.getAttribute("checkout1s") + "  " %> </h1>
        </br>
        <a href="menu.jsp">Back To Catalog</a>
    </body>
</html>
