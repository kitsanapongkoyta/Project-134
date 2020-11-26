<%-- 
    Document   : Shoppingcart
    Created on : Nov 25, 2020, 11:22:17 PM
    Author     : USER
--%>

<%@page import="model.Dvdcart"%>
<%@page import="model.DvdcartTable"%>
<%@page import="model.Dvdcat1Table"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Vector"%>
<%@page import="model.Dvdcat1"%>
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
        <center>
<h1>Shopping Cart</h1>
 <table border="1">
          <tr>
            <th>DVDNames</th>
            <th>Rate</th>
            <th>Year</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Add Cart</th>
          </tr>
          <%
               while(itr.hasNext()) {
                   emp = itr.next();%>
                   
                 <tr>
                   <td><%=emp.getCDvdnames()%></td>
                   <td><%=emp.getCRate()%></td>
                   <td><%=emp.getCYears()%></td>
                   <td><%=emp.getCPrice()%></td>
                   <td><%=emp.getCQuantity()%></td>
                  <form name='Quantity' action ='ShoppingCartController' method='POST'>
                  <input name="name" type="hidden" value="<%=emp.getCDvdnames()%>"></td>
                  <input name="rate" type="hidden" value="<%=emp.getCRate()%>"></td>
                  <input name="years" type="hidden" value="<%=emp.getCYears()%>"></td>
                  <input name="price" type="hidden" value="<%=emp.getCPrice()%>"></td>
                  <td><input type="submit" name="remove" value="Remove"/></td>
                  </form>
                  <tr>
               <%}%>  
 </table>
 </center>
 
    <center>
    <form name='Quantity' action ='CheckOutController' method='POST'>
        <input type="submit" name="checkout" value="checkout"/>
    </form>
    </center>
    </body>
</html>
