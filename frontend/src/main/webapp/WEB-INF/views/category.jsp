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
	   var name=document.myform.catname.value; 
	   if (name==null || name=="")
		  {  
		    alert("category name cant be blank");  
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
CategoryDetails category =(CategoryDetails) session.getAttribute("catbyid");
if(category!=null)
{
	out.println("<form action='update'>");
	out.println("<input type='text' value='"+category.getCategoryId()+"'name='category_id'>");
	out.println("<input type='text' value='"+category.getCategoryName()+"'name='category_name'>");
	out.println("<button type = 'submit'>Update</button>");
	session.setAttribute("catbyid", null);
	out.println("</form>");
}
%>
<form name="myform" method="GET" action="addcategory" onsubmit="return validateform()">
    <div class="form-group">
      <label for="Name">Name:</label>
      <input type="Text" class="form-control" id="catname" placeholder="Enter Category Name" name="catname">
    </div>
   <button type="submit" class="btn btn-default">Add</button>
  </form>
  <div>
  <%@include file="allcategorylist.jsp"%>
  </div>
<div>
<%@include file="footer.jsp"%>
</div>

