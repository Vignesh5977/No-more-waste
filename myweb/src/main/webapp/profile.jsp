
<%@ page import="java.util.List" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="home.css">
    <link rel="stylesheet" href="profile.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


</head>
<body>
<header>
        <div class="logo">No MORE <b style="color: #06C167;">WASTE</b></div>
        <div class="hamburger">
            <div class="line"></div>
            <div class="line"></div>
            <div class="line"></div>
        </div>
        <nav class="nav-bar">
            <ul>
                <li><a href="index.html">Home</a></li>
                <li><a href="contact.html"  >Request</a></li>
                <li><a href="profile.jsp"  class="active">Food Available List</a></li>
                <li><a href="request1.jsp" >Request List</a></li>
            </ul>
        </nav>
    </header>
    <script>
        hamburger=document.querySelector(".hamburger");
        hamburger.onclick =function(){
            navBar=document.querySelector(".nav-bar");
            navBar.classList.toggle("active");
        }
    </script>
  
    
    



   
        
              <br>
              <br>

            
            
         <hr>
         <br>
         <p class="heading">Food Available List</p>
         <!-- <p class="" style="font-family: 'Times New Roman', Times, serif; font-size: 20px;">Your donations</p><br> -->
         <!-- <img src="profilecover1.jpg" alt="" width='100%' height='auto'> -->
   <div class="table-container">
         <!-- <p id="heading">donated</p> -->
         <div class="table-wrapper">
        <table class="table table-bordered">
				<thead>
					<tr>
						<th>Name</th>
						<th>Quantity</th>
						<th>Email</th>
						<th>Phno</th>
						<th>Address</th>
					</tr>
				</thead>
			<!--  	<tbody>
				
					<c:forEach var="food" items="${foodd}">
              <tr>
        
        </tr>
					</c:forEach>
		
				</tbody>-->
		
     
      <c:forEach var="user" items="${userList}">
    <tr>
        <td>${user.name}</td>
        <td>${user.quanlity}</td>
        <td>${user.email}</td>
        <td>${user.phno}</td>
        <td>${user.address}</td>
    </tr>
</c:forEach>


			</table>
         </div>
   </div>          

       


   
    
    
</body>
</html>
