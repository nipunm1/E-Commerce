<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "com.niit.backend.dao.SupplierDetailsDAO"%>
<%@ page import = "com.niit.backend.daoimpl.SupplierDetailsDAOImpl"%>
<%@ page import = "com.niit.backend.model.SupplierDetails" %>
<%@ page import = "java.util.*" %>



<div class ="container">
<h2>Supplier Table</h2>
<div class ="table-responsive">
<table class="table">
<thead>
<tr>
<th>Supplier ID</th>
<th>Supplier Address</th>
<th>Supplier Email</th>
<th>Supplier Name</th>
<th>Supplier Number</th>
</tr>
</thead>
<%

List<SupplierDetails> list;
list=(List) session.getAttribute("list");

if(list==null){
	out.println("supplier list is null");
}
else{
	Iterator item = list.iterator();
	
	while(item.hasNext()){
		SupplierDetails supplierdetails = (SupplierDetails) item.next();
		
		out.println("<tr>");
		out.println("<td>"+supplierdetails.getSupplierID()+"</td>");
		out.println("<td>"+supplierdetails.getSupplierAddress()+"</td>");
		out.println("<td>"+supplierdetails.getSupplierEmail()+"</td>");
		out.println("<td>"+supplierdetails.getSupplierName()+"</td>");
		out.println("<td>"+supplierdetails.getSupplierNumber()+"</td>");
		out.println("<td> <a href='editsup?SupplierID="+supplierdetails.getSupplierID()+"&supaddress="+supplierdetails.getSupplierAddress()+"&supemail="+supplierdetails.getSupplierEmail()+"&supname="+supplierdetails.getSupplierName()+"&supnumber="+supplierdetails.getSupplierNumber()+"'>Edit</a> </td>");
		out.println("<td> <a href='delsup?SupplierID="+supplierdetails.getSupplierID()+"'>Delete </a> </td>");
		out.println("</tr>");
	}
}

%>


</table>
</div>
</div>
