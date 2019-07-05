<%@ page import = "com.niit.backend.dao.productDetailsDAO"%>
<%@ page import = "com.niit.backend.daoimpl.productDetailsDAOImpl"%>
<%@ page import = "com.niit.backend.model.productDetails" %>
<%@ page import = "com.niit.backend.model.UserDetails" %>
<%@ page import = "com.niit.backend.dao.UserDetailsDAO" %>
<%@ page import = "com.niit.backend.daoimpl.UserDetailsDAOImpl" %>
<%@ page import = "com.niit.backend.model.CartDetails" %>
<%@ page import = "com.niit.backend.dao.CartDetailsDAO" %>
<%@ page import = "com.niit.backend.daoimpl.CartDetailsDAOImpl" %>
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
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <script>
   function increaseValue(strid,p,pr,st) {
	  var v = parseInt(strid.value);
	   v= isNaN(v) ? 0 : v;
	   v++;
	   strid.value = v;
      if(v>st){
    	  alert("out of stock");
    	  v--;
    	  strid.value = v;
      }
     var total=v*p;
     pr.value=total;
	 var qty=strid.value+v;
      
	   var url="http://localhost:8080/frontend/test?qty="+v+"&total="+total;  
	      
	   if(window.XMLHttpRequest){  
	   request=new XMLHttpRequest();  
	   }  
	   else if(window.ActiveXObject){  
	   request=new ActiveXObject("Microsoft.XMLHTTP");  
	   }  
	     
	   try  
	   {  
	   request.onreadystatechange=getInfo;  
	   request.open("GET",url,true);  
	   request.send();  
	   }  
	   catch(e)  
	   {  
	   alert("Unable to connect to server");  
	   }   
	 }
   function getInfo(){  
	   if(request.readyState==4){  
	   var val=request.responseText;
	  
	   //document.getElementById('amit').innerHTML=val;  
	   }
   }
   function decreaseValue(strid,p,pr,st) {
	   var v = parseInt(strid.value);
	   v = isNaN(v) ? 0 : v;
	   v < 1 ? v = 1 : '';
	   v--;
	   strid.value = v;
	   if(v>st){
	    	  alert("out of stock");
	    	  strid.value = v;
	      }
	   var total=v*p;
	   pr.value=total;
	   var qty=strid.value+v;
	   
	   var url="http://localhost:8080/frontend/test?qty="+v+"&total="+total;  
	     
	   if(window.XMLHttpRequest){  
	   request=new XMLHttpRequest();  
	   }  
	   else if(window.ActiveXObject){  
	   request=new ActiveXObject("Microsoft.XMLHTTP");  
	   }  
	     
	   try  
	   {  
	   request.onreadystatechange=getInfo;  
	   request.open("GET",url,true);  
	   request.send();  
	   }  
	   catch(e)  
	   {  
	   alert("Unable to connect to server");  
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
<div class ="table-responsive">
<table class="table">
<thead>
<tr>
<th>Product Image</th>
<th>Product Name</th>
<th>Product Price</th>
</tr>
</thead>    
<%
	String i;
    List<productDetails> list;
    list=(List) session.getAttribute("listpr");
    if(list==null)
    {
    	
    	
    }

    else
    {
    productDetailsDAO productdetailsdao = new productDetailsDAOImpl();
    
    
    StockDetailsDAO stockdetailsdao = new StockDetailsDAOImpl();
    
    Iterator item = list.iterator();
    while(item.hasNext()){
    	productDetails productdetails = (productDetails) item.next();
    	UserDetails userdetails = new UserDetails();
    	CartDetails cartdetails = new CartDetails();
    	out.println("<tr>");
    	int p=productdetails.getProductPrice();
    	int id=productdetails.getProductID();
    	StockDetails stockdetails = stockdetailsdao.getstockbyproductid(id);
    	int stock = stockdetails.getIn_stock();
    	i= productdetails.getProductImage();
    	String itemname=productdetails.getProductName();
    	BufferedInputStream bin=new BufferedInputStream(new  FileInputStream("E:/image/"+i));
	    bin.close();
    	out.println("<td><img src='E:/image/"+i+"' width='100' height='100'/></td>");
    	out.println("<td>"+itemname+"</td>");
    	out.println("<td>"+productdetails.getProductPrice()+"</td>");
    	String struemail=(String) session.getAttribute("useremail");
    	if(struemail!=null){
    	String pr="price"+p;
        String s="number"+id;
       out.println("<td><label for='quantity'>Select Quantity</label><div   onclick='decreaseValue("+s+","+p+","+pr+","+stock+")'> - </div><input type='number' id='"+s+"' value='0' name='number' readonly><div onclick='increaseValue("+s+","+p+","+pr+","+stock+")'> + </div></td>");
    	out.println("<td><label for='price'>Total Price</label><input type='number' id='"+pr+"' name='price' value='0' readonly></td>");
    	out.println("<td><a href='addtocart?ProductID="+productdetails.getProductID()+"&UserEmail="+struemail+"&itemnames="+itemname+"' class='btn btn-info btn-lg'><span class='glyphicon glyphicon-shopping-cart'>ADD TO CART</span></a></td>");
    	}
    	out.println("</tr>");
    }
    
    }
    
    %>
    </div>
</table>