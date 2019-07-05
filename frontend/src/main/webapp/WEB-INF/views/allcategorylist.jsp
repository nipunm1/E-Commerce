<%@ page import = "com.niit.backend.dao.CategoryDetailsDAO"%>
<%@ page import = "com.niit.backend.daoimpl.CategoryDetailsDAOImpl"%>
<%@ page import = "com.niit.backend.model.CategoryDetails" %>
<%@ page import = "java.util.*" %>




<div class ="container">
<h2>Category Table</h2>
<div class ="table-responsive">
<table class="table">
<thead>
<tr>
<th>Category ID</th>
<th>Category Name</th>
</tr>
</thead>
<%

List<CategoryDetails> list;
list=(List) session.getAttribute("list");

if(list==null){
	out.println("category list is null");
}
else{
	Iterator item = list.iterator();
	
	while(item.hasNext()){
		CategoryDetails categorydetails = (CategoryDetails) item.next();
		
		out.println("<tr>");
		out.println("<td>"+categorydetails.getCategoryId()+"</td>");
		out.println("<td>"+categorydetails.getCategoryName()+"</td>");
		out.println("<td> <a href='editCat?CategoryId="+categorydetails.getCategoryId()+"&catname="+categorydetails.getCategoryName()+"'>Edit</a> </td>");
		out.println("<td> <a href='delcat?CategoryId="+categorydetails.getCategoryId()+"'>Delete </a> </td>");
		out.println("</tr>");
	}
}

%>
</table>
</div>
</div>

