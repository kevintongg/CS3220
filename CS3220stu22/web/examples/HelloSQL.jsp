<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%-- set data source --%>
<sql:setDataSource
    driver="com.mysql.jdbc.Driver"
    url="jdbc:mysql://cs3.calstatela.edu/cs3220stu22"
    user="cs320stu22"
    password="!z6j98!z"/>

<%-- query --%>
<sql:query var="items" sql="SELECT * FROM items"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD><TITLE>JSTL SQL Example</TITLE></HEAD>

<table>
  <c:forEach items="${items.rows}" var="row">
    <c:forEach items="${row}" var="col">
      <tr>
        <td>${col.key}</td>
        <td>${col.value}</td>
      </tr>
    </c:forEach>
  </c:forEach>
</table>

</BODY>
</HTML>
