<%-- 
    Document   : menu
    Created on : Nov 25, 2020, 10:45:22 PM
    Author     : USER
--%>

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
    <body>
        <h1></h1>
   <jsp:useBean id="emp" class="model.Dvdcat1" scope="request"/>
    <%
            EntityManager em = (EntityManager) session.getAttribute("entitymanager");
            Vector<Dvdcat1> empList = Dvdcat1Table.findAllDvdcat1(em);
            Iterator<Dvdcat1> itr = empList.iterator();
     %>
    <body>
        <center>
<h1>DVD Catalog</h1>
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
                   <td><%=emp.getDvdnames()%></td>
                   <td><%=emp.getRate()%></td>
                   <td><%=emp.getYears()%></td>
                   <td><%=emp.getPrice()%></td>
                  <form name='Quantity' action ='AddToCartController' method='POST'>
                  <input name="name" type="hidden" value="<%=emp.getDvdnames()%>"></td>
                  <input name="rate" type="hidden" value="<%=emp.getRate()%>"></td>
                  <input name="years" type="hidden" value="<%=emp.getYears()%>"></td>
                  <input name="price" type="hidden" value="<%=emp.getPrice()%>"></td>
                  <td><input type="number" name="quantity" value=""size="7"/></td>
                  <td><input type="submit" name="submit" value="AddToCart"/></td>
                  </form>
                  <tr>
               <%}%>  
 </table>
 </center>
       
    </body>
    <center>
    <a href="Shoppingcart.jsp">Go to Shopping Cart</a>
    </center>
</html>
