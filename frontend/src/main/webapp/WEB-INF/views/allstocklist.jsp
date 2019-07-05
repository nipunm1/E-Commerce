<%@ page import = "com.niit.backend.model.StockDetails" %>
<%@ page import = "com.niit.backend.dao.StockDetailsDAO" %>
<%@ page import = "com.niit.backend.daoimpl.StockDetailsDAOImpl" %>
<%@page import = "com.niit.backend.model.productDetails" %>
<%@page import = "com.niit.backend.dao.productDetailsDAO" %>
<%@page import = "com.niit.backend.daoimpl.productDetailsDAOImpl" %>
<%@ page import = "java.util.*" %>
<%@ page import = "java.io.*" %>
<%@ page import = "javax.servlet.ServletContext" %>
<div class ="container">
<h2>Sock Table</h2>
<div class ="table-responsive">
<table class="table">
<thead>
<tr>
<th>Stock ID</th>
<th>In Stock</th>
<th>Product ID</th>
</tr>
</thead>    
<%
List<StockDetails> list;
list = (List)session.getAttribute("stock_list");
if(list==null){
	out.println("stock list is null");
}
else{
	Iterator item = list.iterator();
	while(item.hasNext()){
		StockDetails stockdetails = (StockDetails) item.next();
		productDetails productdetails = stockdetails.getProduct();
		out.println("<tr>");
		out.println("<td>"+stockdetails.getStockId()+"</td>");
		out.println("<td>"+stockdetails.getIn_stock()+"</td>");
		out.println("<td>"+productdetails.getProductID()+"</td>");
		out.println("<td> <a href='editst?StockID="+stockdetails.getStockId()+"&instock="+stockdetails.getIn_stock()+"&productid="+productdetails.getProductID()+"'>Edit</a> </td>");
		out.println("<td> <a href='delst?StockID="+stockdetails.getStockId()+"'>Delete </a> </td>");
		out.println("</tr>");

		
	}
}
%>
</table>
</div>
</div>
