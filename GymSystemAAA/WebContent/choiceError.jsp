<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.ArrayList" %>
<%@ page import="it.mat.unical.ingsw.model.Corso" %>
<!DOCTYPE html>
<html>
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
    			<a class="nav-link" href="profilo.jsp">Il mio profilo</a>
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
  <!--   -->
  <div class="container">
  
  	<!-- Page Heading/Breadcrumbs -->
    	<h1 class="mt-4 mb-3">Selezione Piano</h1>

    	<ol class="breadcrumb">
      		<li class="breadcrumb-item">
        		<a href="index.jsp">Homepage</a>
      		</li>
      		<li class="breadcrumb-item active">Profilo</li>
    	</ol>

	    <div class="col-md-6">
	    	<!-- Page Heading/Breadcrumbs -->
		    <h1 class="mt-4 mb-3" style="color: red">Errore nella selezione</h1>
		    <h3>Errore nella selezione del piano di allenamento</h3>
		    <br>
		    Devi selezionare esattamente 3 corsi per il tuo piano.
		    <br>
		    Clicca sul seguente bottone per rieseguire la procedura di selezione!
			<div class = "col-md-12 text-center" style="padding-bottom: 20px;">
				<button type="submit" onclick = "window.location.href = 'sceltaPianoAllenamento.jsp';" class="btn btn-primary" style="margin-top: 20px">Reseleziona</button>
		   	</div>
	    </div>
	    
   </div>
	

  <!-- Footer -->
   <footer class=" py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; GymSystem 2020</p>
    </div>
    <!-- /.container -->
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>