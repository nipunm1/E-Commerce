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
	  var name=document.myform.prname.value; 
	  var descption=document.myform.desc.value; 
	  var p=document.myform.price.value;
	  
	  if (name==null || name=="")
	  {  
	    alert("product name cant be blank");  
	    return false;  
	  }
	  if (descption==null || descption=="")
	  {  
	    alert("descption cant be blank");  
	    return false;  
	  }
	  
	  if (p==null || p=="")
	  {  
	    alert("price cant be blank");  
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
productDetails product =(productDetails) session.getAttribute("prbyid");
List<CategoryDetails> list1;
list1=(List) session.getAttribute("list1");
List<SupplierDetails> list2;
list2=(List) session.getAttribute("list2");

if(product!=null)
{
	out.println("<form action='updatepr'  method='POST' modelAttribute='SpringWeb' enctype='multipart/form-data'>");
	out.println("<label> ProductID : </label><input type='text' value='"+product.getProductID()+"'name='product_id' readonly><br>");
	out.println("<label> Update CategoryID : </label><select name='cat_id'>");
	Iterator itemc = list1.iterator();
    while(itemc.hasNext())
    {
    	CategoryDetails c = (CategoryDetails)itemc.next();
    	out.println("<option>" + c.getCategoryId() + "</option>");
    }
    out.println("</select><br>");
    out.println("<label> Update SupplierID : </label><select name='sup_id'>");
    Iterator items = list2.iterator();
    while(items.hasNext())
    {
    	SupplierDetails s = (SupplierDetails)items.next();
    	out.println("<option>" + s.getSupplierID()+ "</option>");
    }
    out.println("</select><br>");
    out.println("<label> Update Discription: </label><input type='text' value='"+product.getProductDiscription()+"'name='product_discription'><br>");
	out.println("<label> Update Name : </label><input type='text' value='"+product.getProductName()+"'name='product_name'><br>");
	out.println("<label> Update Image : </label><input type='file' value='"+product.getProductImage()+"'name='file'><br>");
	out.println("<label> Update Price : </label><input type='text' value='"+product.getProductPrice()+"'name='product_price'><br>");
	out.println("<button type = 'submit'>Update</button>");
	session.setAttribute("prbyid", null);
	out.println("</form>");
}
%>
<form name="myform" method="POST" modelAttribute="SpringWeb" action="addproduct" onsubmit="return validateform()" enctype="multipart/form-data">
<dxa:csrf-token/>
 <div class="form-group">
    <label for="CategoryID">CategoryID:</label>
    <select name="categoryid">
    <%
    Iterator itemcat = list1.iterator();
    while(itemcat.hasNext())
    {
    	CategoryDetails c = (CategoryDetails)itemcat.next();
    	out.println("<option>" + c.getCategoryId() + "</option>");
    }
    %>
    </select>
    </div>
    <div class="form-group">
    <label for="SupplierID">SupplierID:</label>
    <select name="supplierid">
    <%
    Iterator itemsup = list2.iterator();
    while(itemsup.hasNext())
    {
    	SupplierDetails s = (SupplierDetails)itemsup.next();
    	out.println("<option>" + s.getSupplierID()+ "</option>");
    }
    %>
    </select>
    </div>
    <div class="form-group">
      <label for="Name">Name:</label>
      <input type="Text" class="form-control" id="prname" placeholder="Enter product Name" name="prname">
    </div>
    <div class="form-group">
      <label for="Description">Description:</label>
      <input type="Text" class="form-control" id="desc" placeholder="Enter description" name="desc">
    </div>
    Select Image:<input type="file" name="file"/><br/>
    <div class="form-group">
      <label for="Price">Price:</label>
      <input type="Text" class="form-control" id="price" placeholder="Enter product price" name="price">
    </div>
    
   <button type="submit" class="btn btn-default">Add</button>
  </form>
<div>
<%@include file="allproductlist.jsp"%>
</div>
<div>
<%@include file="footer.jsp"%>
</div>
