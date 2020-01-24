<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.ArrayList" %>
<%@ page import="it.mat.unical.ingsw.model.Corso" %>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Gym System</title>

  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/modern-business.css" rel="stylesheet">

</head>

<body>
	
  <!-- Navigation -->
  <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="index.jsp">Gym System</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link" href="contact.jsp">Chi siamo</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="corsi.jsp">Corsi</a>
          </li>
          <li class="nav-item">
          	<c:if test="${utente == null}">
    			<a class="nav-link" href="loginPage.jsp">Accedi</a>
			</c:if>
			<c:if test="${utente != null}">
				<c:if test="${utente.getClass().getSimpleName().equals('Atleta')}">
    			<a class="nav-link" href="ScadenzaTessera">Il mio profilo</a>
    			</c:if>
    			<c:if test="${utente.getClass().getSimpleName().equals('Trainer')}">
    			<a class="nav-link" href="profiloTrainer.jsp">Il mio profilo</a>
    			</c:if>
    			<c:if test="${utente.getClass().getSimpleName().equals('Admin')}">
    			<a class="nav-link" href="profiloAdmin.jsp">Il mio profilo</a>
    			</c:if>
    			
    			 <li class="nav-item">
    			<a class="nav-link" href="Login?logout=true">Logout</a>
			</c:if>
          </li>

        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Content -->
  <div class="container">

    <!-- Page Heading/Breadcr. -->
    <h1 class="mt-4 mb-3">Selezione Piano</h1>

    	<ol class="breadcrumb">
      		<li class="breadcrumb-item">
        		<a href="index.jsp">Homepage</a>
      		</li>
      		<li class="breadcrumb-item active">Profilo</li>
    	</ol>
    	
    	<div class="my-5 col-md-6">
	  		<h2>Seleziona i corsi da attribuire alla tua tessera:</h2>
	  		<br>
	  		Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
			Pidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. <br>
			Consectetur adipiscing elit, sed do eiusmod tempor incididunt
  		</div>
      	
      	<form method="POST" action="RegistraPianoAllenamento">
      		<div class="my-5 col-md-12"> 
			    <div class="row">
				  	<%
						ArrayList<Corso> corsi = (ArrayList<Corso>) request.getAttribute("arraylist");
					%>
					
					<%
						for(Corso c: corsi) {
						%>
							<div class="col-5">
							     <div class="form-check form-check-group">
							        <input class="checks" id="checkbox" type="checkbox" name="boxes" value=<%=c.getNome()%>>
							        <label for="checkbox"><b><%=c.getNome()%></b> - gestito da <b><%=c.getTrainer().getNome()%> <%=c.getTrainer().getCognome()%></b></label>
							     </div>
						     </div>
						<%
						}
					%>
			  	</div>
	 		</div>
	 	
		 	<div class = "col-md-12 text-center" style="padding-bottom: 20px;">
	    		<button id="submit" type="submit" value="Submit" class="btn btn-primary">Conferma piano</button>
	    	</div>
	  	</form>
			
  	</div>

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->

  <!-- Footer -->
   <footer class=" py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; GymSystem 2020</p>
    </div>
    <!-- /.container -->
  </footer>
  
  <script>
  $('#submit').prop("disabled", true);
  $('input:checkbox').click(function() {
   if ($(this).is(':checked')) {
   $('#submit').prop("disabled", false);
   } else {
   if ($('.checks').filter(':checked').length < 1){
   $('#submit').attr('disabled',true);}
   }
  });
  </script>

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>