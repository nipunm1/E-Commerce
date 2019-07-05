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
  <script>
  function validateform(){
	  var name = document.myform.f_name.value;
	  var address = document.myform.r_address.value;
	  var mail = document.myform.r_mail.value;
	  var phone = document.myform.ph_num.value;
	  var c_name = document.myform.owner_name.value;
      var c_cvv = document.myform.cvv.value;
      var c_num = document.myform.credit_num.value;
      var d_name = document.myform.owner_n.value;
	  var d_cvv = document.myform.cv.value;
	  var d_num = document.myform.debit_num.value;
	  
	  
	  if(name==null || name==""){
		  alert("Enter Name");
		  return false;
	  }
	  else if(address==null || address==""){
		  alert("Enter Address");
		  return false;
	  }
	  else if(mail==null || mail==""){
		  alert("Enter Mail Address");
		  return false;
	  }
	  else if(phone==null || phone==""){
		  alert("Enter Phone Number");
		  return false;
	  }
	  if(document.getElementById("cre").checked){
		  if(c_name==null || c_name==""){
	  		  alert("Enter name mention in credit card");
	  		  return false;
	  	  }
	        else if(c_cvv==null || c_cvv==""){
	  		  alert("Enter cvv mention in credit card");
	  		  return false;
	  		}
	        else if(c_num==null || c_num==""){
	  		  alert("Enter Credit card number");
	  		  return false;
	  	  }  
		  if(c_cvv.length>3 || c_cvv.length<3){
			  alert("Enter correct cvv");
			  return false;
		  }
		  if(c_num.length>16 || c_num.length<16){
			  alert("Enter correct credit card number");
			  return false;
		  }
	  }
	  else if(document.getElementById("deb").checked){
		  if(d_name==null || d_name==""){
			  alert("Enter name mention in debit card");
			  return false;
		  }
		   else if(d_cvv==null || d_cvv==""){
			  alert("Enter cvv mention in debit card");
			  return false;
		  }
		  
		   else if(d_num==null || d_num==""){
			  alert("Enter Debit card number");
			  return false;
		  }
		  if(d_cvv.length>3 || d_cvv.length<3){
			  alert("Enter correct cvv");
			  return false;
		  }
		  if(d_num.length>16 || d_num.length<16){
			  alert("Enter correct credit card number");
			  return false;
		  }
	   }
	  else if(document.getElementById("cash").checked){
		if(!myform.payment_cod.checked){
			alert("Please accept the policy in checkbox");
			return false;
		}
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
    .card
    {
     display:none;
    }
    .cc
    {
       display:block;
    }
  </style>
  <script type="text/javascript">
    function ShowHideDiv(value) 
    {
    	if( value == '1')
    	{
        document.getElementById("credit").classList.add("cc");
       	document.getElementById("debit").classList.remove("cc");
       	document.getElementById("cod").classList.remove("cc");
        }
        if( value == '2')
    	{
    	document.getElementById("debit").classList.add("cc");
        document.getElementById("credit").classList.remove("cc");
        document.getElementById("cod").classList.remove("cc");
          	    	 
        }
        if( value == '3'){
        document.getElementById("cod").classList.add("cc");
        document.getElementById("credit").classList.remove("cc");
        document.getElementById("debit").classList.remove("cc");
      }
}
</script>
  
  
</head>
<div>
<%@include file="header.jsp"%>
</div>
<form name="myform" method="GET" action="addpayment" onsubmit="return validateform()">
<div class="form-group">
<h1 align="center">Personal Information</h1>
      <label for="Name">Full Name:</label>
      <input type="Text" class="form-control" id="f_name" placeholder="Enter Receivers Name" name="f_name">
    </div>
<div class="form-group">
      <label for="Address">Address:</label>
      <input type="Text" class="form-control" id="r_address" placeholder="Enter Full Address" name="r_address">
    </div>
<div class="form-group">
      <label for="Email">Email:</label>
      <input type="Text" class="form-control" id="r_mail" placeholder="Enter Receivers mail" name="r_mail">
    </div>
<div class="form-group">
      <label for="Phone Number">Phone Number:</label>
      <input type="Number" class="form-control" id="ph_num" placeholder="Enter Receivers number" name="ph_num">
    </div>
<label for="Gender">Gender:</label>
<div class="radio">
<label class="radio-inline">
<input type="radio" name="gender" checked>Male
</label>
<label  class="radio-inline">
<input type="radio" name="gender">Female
</label>
<label  class="radio-inline">
<input type="radio" name="gender">Others
</label>
<h1 align="center">Payment Information</h1>      
</div>
<label for="Payment">Payment Type:</label>
<div class="radio">
<label>
<input type="radio" name="p_type" value="1" id="cre" checked onClick="ShowHideDiv('1')">Credit Card 
</label> <br>
<label>
<input type="radio" name="p_type" value="2" id="deb" onClick="ShowHideDiv('2')">Debit Card 
</label> <br>
<label>
<input type="radio" name="p_type" value="3" id="cash" onClick="ShowHideDiv('3')">Cash On Delivery 
</label> <br>
</div>

<div id="credit" class="card cc">
<h3> Credit Card Details</h3>
<div class="form-group">
                <label for="owner">Owner Name:</label>
                <input type="text" class="form-control" id="owner_name" placeholder="Enter Full Name" name="owner_name">
            </div>
<div class="form-group">
                <label for="cvv">CVV</label>
                <input type="Number" class="form-control" id="cvv" placeholder="Enter 3 digit cvv" name="cvv">
            </div>            
<div class="form-group" id="card-number-field">
      <label for="cardNumber">Card Number:</label>
      <input type="Number" class="form-control" id="credit_num" placeholder="Enter Card number" name="credit_num">
    </div>
 <div class="form-group" id="expiration-date">
      <label>Expiration Date</label>
      <select name="ex_month">
                    <option value="01">January</option>
                    <option value="02">February </option>
                    <option value="03">March</option>
                    <option value="04">April</option>
                    <option value="05">May</option>
                    <option value="06">June</option>
                    <option value="07">July</option>
                    <option value="08">August</option>
                    <option value="09">September</option>
                    <option value="10">October</option>
                    <option value="11">November</option>
                    <option value="12">December</option>
      </select>
      <select name=ex_date>
                    <option value="18"> 2018</option>
                    <option value="19"> 2019</option>
                    <option value="20"> 2020</option>
                    <option value="21"> 2021</option>
                    <option value="22"> 2022</option>
                    <option value="23"> 2023</option>
                    <option value="24"> 2024</option>
                    <option value="25"> 2025</option>
       </select>
       </div>  
</div>
<div id="debit" class="card">
<h3> Debit Card Details</h3>
<div class="form-group">
                <label for="owner">Owner Name:</label>
                <input type="text" class="form-control" id="owner_n" placeholder="Enter Full Name" name="owner_n">
            </div>
<div class="form-group">
                <label for="cvv">CVV</label>
                <input type="Number" class="form-control" id="cv" placeholder="Enter 3 digit cvv" name="cv">
            </div>            
<div class="form-group" id="card-number-field">
      <label for="cardNumber">Card Number:</label>
      <input type="Number" class="form-control" id="debit_num" placeholder="Enter Card number" name="debit_num">
    </div>
 <div class="form-group" id="expiration-date">
      <label>Expiration Date</label>
      <select name="e_month">
                    <option value="01">January</option>
                    <option value="02">February </option>
                    <option value="03">March</option>
                    <option value="04">April</option>
                    <option value="05">May</option>
                    <option value="06">June</option>
                    <option value="07">July</option>
                    <option value="08">August</option>
                    <option value="09">September</option>
                    <option value="10">October</option>
                    <option value="11">November</option>
                    <option value="12">December</option>
      </select>
      <select name=e_date>
                    <option value="18"> 2018</option>
                    <option value="19"> 2019</option>
                    <option value="20"> 2020</option>
                    <option value="21"> 2021</option>
                    <option value="22"> 2022</option>
                    <option value="23"> 2023</option>
                    <option value="24"> 2024</option>
                    <option value="25"> 2025</option>
       </select>
       </div>    
</div>
<div id="cod" class="card">
 <div class="checkbox">
      <label><input type="checkbox" id="payment_cod" name="payment_cod"> I agree to pay at time of delivery</label>
    </div>
</div>
<button type = "submit"  class="btn btn-info btn-lg">Finish</button>
</form>
<div>
<%@include file="footer.jsp"%>
</div>
