<%@ page import = "java.io.*" %>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">

    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="home">Home</a></li>
     </ul>
       <ul class="nav navbar-nav" role="search">
        <li><input type="text" class="form-control" placeholder="Search" name="search" size="45"></li>
        <li><button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button></li>
      </ul>
      
      
      
      
      <% 
      
      String struseremail =(String) session.getAttribute("useremail");
      String struserrole =(String) session.getAttribute("userRole"); 
      
      if(struseremail != null)

      {
      %>
      
       <ul class="nav navbar-nav navbar-right">
       <li><a href="logout11"><span class="glyphicon glyphicon-log-out"></span> Logout </a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="cart"><span class="glyphicon glyphicon-shopping-cart"></span> Cart </a></li>
      </ul>
      <%
      
       if( struserrole.equals("Admin"))
       { 
     %>
   
      <ul class="nav navbar-nav navbar-right">
        <li class="active"><li><a href="supplier">Supplier</a></li>
        <li><a href="category">Category</a></li>
        <li><a href="product">Product</a></li>
        <li><a href="stock">Stock</a></li>
      </ul>
      <%
      }
      }
      else 
      {
      %>
      
      <ul class="nav navbar-nav navbar-right">
        <li><a href="register"><span class="glyphicon glyphicon-log-in"></span> Register</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="loginadd"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
       <%}
      %>
      
      
     </div>
  </div>
</nav>
  