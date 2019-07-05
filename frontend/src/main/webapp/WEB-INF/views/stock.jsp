<!DOCTYPE html>
<html lang="en">
<head>
  <title>Online shopping</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script>
  function validateform(){
	var instock = document.myform.instock.value;
	
	if(instock==null || instock==""){
		alert("Must enter stock");
		return false;
	}
 }
  </script>
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
<%
StockDetails obj = (StockDetails)session.getAttribute("stocknull");
if(obj!= null)
{
	out.println(  "ID already exist");
}
StockDetails stock = (StockDetails) session.getAttribute("stbyid");
List<productDetails>productlist;
productlist=(List)session.getAttribute("product_list");
if(stock!=null){
	out.println("<form action='updatest'  method='GET'>");
	out.println("<label> StockID : </label><input type='text' value='"+stock.getStockId()+"'name='stock_id' readonly><br>");
	out.println("<label> Update ProductID : </label><select name='pr_id'>");
	Iterator itemst = productlist.iterator();
    while(itemst.hasNext())
    {
    	productDetails p = (productDetails)itemst.next();
    	out.println("<option>" + p.getProductID() + "</option>");
    }
    out.println("</select><br>");
	out.println("<label>Update In Stock : </label><input type='test' value='"+stock.getIn_stock()+"'name='in_stock'><br>");
	out.println("<button type = 'submit'>Update</button>");
	session.setAttribute("stbyid", null);
	out.println("</form>");
}
%>
<form name="myform" method="GET" action="addstock" onsubmit="return validateform()">
<dxa:csrf-token/>
<div class="form-group">
    <label for="ProductID">ProductID:</label>
    <select name="productid">
    <%
    Iterator itempr = productlist.iterator();
    while(itempr.hasNext())
    {
    	productDetails p = (productDetails)itempr.next();
    	out.println("<option>" + p.getProductID() + "</option>");
    }
    %>
    </select>
    </div>
<div class="form-group">
      <label for="Stock">In Stock:</label>
      <input type="Text" class="form-control" id="instock" placeholder="Set Stock" name="instock">
    </div>
 <button type="submit" class="btn btn-default">Add</button>    
</form> 
<div>
<%@include file="allstocklist.jsp"%>
</div>
<div>
<%@include file="footer.jsp"%>
</div>
