<%@ page import = "com.niit.backend.dao.productDetailsDAO"%>
<%@ page import = "com.niit.backend.daoimpl.productDetailsDAOImpl"%>
<%@ page import = "com.niit.backend.model.productDetails" %>
<%@ page import = "com.niit.backend.model.CartDetails" %>
<%@ page import = "com.niit.backend.dao.CartDetailsDAO" %>
<%@ page import = "com.niit.backend.daoimpl.CartDetailsDAOImpl" %>
<%@ page import = "com.niit.backend.model.UserDetails" %>
<%@ page import = "com.niit.backend.dao.UserDetailsDAO" %>
<%@ page import = "com.niit.backend.daoimpl.UserDetailsDAOImpl" %>
<%@ page import = "com.niit.backend.model.StockDetails" %>
<%@ page import = "com.niit.backend.dao.StockDetailsDAO" %>
<%@ page import = "com.niit.backend.daoimpl.StockDetailsDAOImpl" %>
<%@ page import = "java.util.*" %>
<%@ page import = "java.io.*" %>
<%@ page import = "javax.servlet.ServletContext" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Online shopping</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="/path/to/bootstrap.min.css">
 <script src="/path/to/jquery.min.js"></script>
 <script src="/path/to/bootstrap.min.js"></script>
 <script src="js/jquery.mycart.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
  </style>
</head>
<div>
<%@include file="header.jsp"%>
</div>

<div>
<table class="table">
<thead>
<tr>
<th>Product ID</th>
<th>Items</th>
<th>Quantity</th>
<th>Amount</th>
<th>User Email</th>
<th>
</tr>
</thead>
<%
List<CartDetails> list;
list=(List)session.getAttribute("cartlist");
CartDetailsDAO cartdetailsdao = new CartDetailsDAOImpl();
productDetailsDAO productdetailsdao = new productDetailsDAOImpl();
StockDetailsDAO stockdetailsdao = new StockDetailsDAOImpl();
Iterator item = list.iterator();
int total = 0;
int grandtotal = 0;
while(item.hasNext()){
	CartDetails cartdetails = (CartDetails)item.next();
	char tran = cartdetails.getCarttran();
    UserDetails user = cartdetails.getUser();
	String user_email = (String) session.getAttribute("useremail");
	if(tran=='n' && user_email.equals(user.getUserEmail())){
		productDetails productdetails =cartdetails.getProduct();
		UserDetails userdetails = cartdetails.getUser();
		int id = productdetails.getProductID();
		StockDetails stockdetails = stockdetailsdao.getstockbyproductid(id);
		total = cartdetails.getCartTotalAmount();
		grandtotal = grandtotal + total;
		out.println("<tr>");
		out.println("<td>"+productdetails.getProductID()+"</td>");
		out.println("<td>"+productdetails.getProductName()+"</td>");
		out.println("<td>"+cartdetails.getCartQuantity()+"</td>");
		out.println("<td>"+total+"</td>");
		out.println("<td>"+userdetails.getUserEmail()+"</td>");
		out.println("<td><a href='remove?CartId="+cartdetails.getCartId()+"&ProductID="+productdetails.getProductID()+"&qty="+cartdetails.getCartQuantity()+"'>Remove</a></td>");
	    out.println("</tr>");
	}
}
out.println("<tr>");
out.println("<td><label for='total'>  Total Amount  = </label>"+grandtotal+"</td>");
out.println("<td><a href='contineshopping' class='btn btn-info btn-lg'><span class = 'cssButton button_continue_shopping'>Continue Shopping</span></a></td>");
out.println("<td><a href='checkout' class='btn btn-info btn-lg'><span class='cssButton button_checkout'>Checkout</span></a></td>");
out.println("</tr>");
%>
</table>
</div>

<div>
<%@include file="footer.jsp"%>
</div>
