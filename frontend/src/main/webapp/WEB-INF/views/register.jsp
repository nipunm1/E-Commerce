
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
	  var email=document.myform.email.value;  
	  var pass1=document.myform.pwd.value;
	  var pass2=document.myform.pwd1.value;
	  var username=document.myform.username.value;
	  var address=document.myform.address.value;
	  var mobile=document.myform.mobile.value;
	  var aadharid=document.myform.aadharid.value;
	    
	  if (email==null || email=="")
	  {  
	    alert("Email cant be blank");  
	    return false;  
	  }
	  
	  else if(pass1==null || pass1 == "" )
	  {  
	    alert("Password cant be blank");  
	    return false;  
	   }
	  else if(pass2==null || pass2 == "")
	  {
		  alert("Conform Password cant be blank");
		  return false;
	  }
	
		  
	  
	  else if(username==null || username == "" )
	  {  
		    alert("Username cant be blank");  
		    return false;  
	   }
	  else if(address==null || address == "" )
	  {  
		    alert("Address cant be blank");  
		    return false;  
       }
	  else if(mobile==null || mobile == "" )
	   {  
		    alert("Mobile number cant be blank");  
		    return false;  
	    }
	   
	  else if(aadharid==null || aadharid == "" )
	  {  
		    alert("Aadharid cant be blank");  
		    return false;  
	}
	  
	  else if( pass1 != pass2)
	  {
		  alert("password must be same"); 
		 
		 	  
		  return false;
	  }
	  else
	  {
		 
		  return true;
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
     <form  name="myform" method="GET" action="addregister" onsubmit="return validateform()">
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
    </div>
     <div class="form-group">
      <label for="pwd1">Conform Password:</label>
      <input type="password" class="form-control" id="pwd1" placeholder="Conform password" name="pwd1">
    </div>
      <div class="form-group">
      <label for="name">name:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter name" name="username">
    </div>
      <div class="form-group">
      <label for="address">address:</label>
      <input type="text" class="form-control" id="address" placeholder="Enter address" name="address">
    </div>
     
       <div class="form-group">
      <label for="mobile">mobile:</label>
      <input type="text" class="form-control" id="mobile" placeholder="Enter mobile" name="mobile">
    </div>
     <div class="form-group">
      <label for="aadharid">aadharid:</label>
      <input type="text" class="form-control" id="aadharid" placeholder="Enter aadharid" name="aadharid">
    </div>
     
      
    <div class="checkbox">
      <label><input type="checkbox" name="remember"> Remember me</label>
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
  
<div>
<%@include file="footer.jsp"%>
</div>