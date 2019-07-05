<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "com.niit.backend.dao.productDetailsDAO"%>
<%@ page import = "com.niit.backend.daoimpl.productDetailsDAOImpl"%>
<%@ page import = "com.niit.backend.model.productDetails" %>
<%@ page import = "com.niit.backend.dao.CategoryDetailsDAO"%>
<%@ page import = "com.niit.backend.daoimpl.CategoryDetailsDAOImpl"%>
<%@ page import = "com.niit.backend.model.CategoryDetails" %>
<%@ page import = "com.niit.backend.dao.SupplierDetailsDAO"%>
<%@ page import = "com.niit.backend.daoimpl.SupplierDetailsDAOImpl"%>
<%@ page import = "com.niit.backend.model.SupplierDetails" %>
<%@ page import = "com.niit.backend.model.StockDetails" %>
<%@ page import = "com.niit.backend.dao.StockDetailsDAO" %>
<%@ page import = "com.niit.backend.daoimpl.StockDetailsDAOImpl" %>
<%@ page import = "java.util.*" %>
<%@ page import = "java.io.*" %>
<%@ page import = "javax.servlet.ServletContext" %>

<div class ="container">
<h2>Product Table</h2>
<div class ="table-responsive">
<table class="table">
<thead>
<tr>
<th>Product ID</th>
<th>Category ID</th>
<th>Supplier ID</th>
<th>Product Description</th>
<th>Product Name</th>
<th>Product Image</th>
<th>Product Price</th>
</tr>
</thead>    
<%
String image;
List<productDetails> list;
list=(List) session.getAttribute("list");

if(list==null){
	out.println("product list is null");
}
else{
	Iterator item = list.iterator();
	
	while(item.hasNext()){
		productDetails productdetails = (productDetails) item.next();
		CategoryDetails categorydetails = productdetails.getCategory();
		SupplierDetails supplierdetails =  productdetails.getSupplier();
		out.println("<tr>");
		out.println("<td>"+productdetails.getProductID()+"</td>");
		out.println("<td>"+categorydetails.getCategoryId()+"</td>");
		out.println("<td>"+supplierdetails.getSupplierID()+"</td>");
		out.println("<td>"+productdetails.getProductDiscription()+"</td>");
		out.println("<td>"+productdetails.getProductName()+"</td>");
		image = productdetails.getProductImage();
		BufferedInputStream bin=new BufferedInputStream(new  FileInputStream("E:/image/"+image));
	     System.out.println(image);    
		bin.close();
		out.println("<td><img src='E:/image/"+image+"' width='50' height='50'/>" + productdetails.getProductImage()+"</td>");
		out.println("<td>"+productdetails.getProductPrice()+"</td>");
		out.println("<td> <a href='editpr?ProductID="+productdetails.getProductID()+"&desc="+productdetails.getProductDiscription()+"&prname="+productdetails.getProductName()+"&price="+productdetails.getProductPrice()+"&file="+productdetails.getProductImage()+"&categoryid="+categorydetails.getCategoryId()+"&supplierid="+supplierdetails.getSupplierID()+"'>Edit</a> </td>");
		out.println("<td> <a href='delpr?ProductID="+productdetails.getProductID()+"'>Delete </a> </td>");
		out.println("</tr>");
	}
}
%>
</table>
</div>
</div>
