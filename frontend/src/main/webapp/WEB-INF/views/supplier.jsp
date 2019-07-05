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
	   var name=document.myform.supname.value; 
	   var email=document.myform.supemail.value;
	   var address=document.myform.supaddress.value;
	   var number=document.myform.supnumber.value;
	   if (name==null || name=="")
		  {  
		    alert("supplier name cant be blank");  
		    return false;  
		  }
	   if (email==null || email=="")
		  {  
		    alert("supplier email cant be blank");  
		    return false;  
		  }
	   if (address==null || address=="")
		  {  
		    alert("supplier address cant be blank");  
		    return false;  
		  }
	   if (number==null || number=="")
		  {  
		    alert("supplier number cant be blank");  
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
SupplierDetails supplier =(SupplierDetails) session.getAttribute("supbyid");
if(supplier!=null)
{
	out.println("<form action='updatesup'>");
	out.println("<input type='text' value='"+supplier.getSupplierID()+"'name='supplier_id'>");
	out.println("<input type='text' value='"+supplier.getSupplierAddress()+"'name='supplier_address'>");
	out.println("<input type='text' value='"+supplier.getSupplierEmail()+"'name='supplier_email'>");
	out.println("<input type='text' value='"+supplier.getSupplierName()+"'name='supplier_name'>");
	out.println("<input type='text' value='"+supplier.getSupplierNumber()+"'name='supplier_number'>");
	out.println("<button type = 'submit'>Update</button>");
	session.setAttribute("supbyid", null);
	out.println("</form>");
}
%>
<form name="myform" method="GET" action="addsupplier" onsubmit="return validateform()" >
<div class="form-group">
      <label for="Name">Name:</label>
      <input type="Text" class="form-control" id="supname" placeholder="Enter Supplier Name" name="supname">
    </div>
     <div class="form-group">
      <label for="Email">Email:</label>
      <input type="Text" class="form-control" id="supemail" placeholder="Enter Supplier Email" name="supemail">
    </div>
     <div class="form-group">
      <label for="Address">Address:</label>
      <input type="Text" class="form-control" id="supaddress" placeholder="Enter Supplier Address" name="supaddress">
    </div>
     <div class="form-group">
      <label for="Phone Number">Phone Number:</label>
      <input type="Text" class="form-control" id="supnumber" placeholder="Enter Supplier Number" name="supnumber">
    </div>
   <button type="submit" class="btn btn-default">Add</button>
  </form>
<div>
  <%@include file="allsupplierlist.jsp"%>
  </div>
<div>
<%@include file="footer.jsp"%>
</div>