<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
            <a class="nav-link" href="SchedaOrari">Corsi</a>
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



<div class="my-5 text-center container" style="width: 500px; height: 500px">
    <form method="POST" action="IscriviAtleta">
    	<div class="form-group col-xl-auto" >
            <label for="exampleInputText1">Nome</label>
            <input type="text" name = "nome" class="form-control" id="exampleInputText1"  placeholder="Inserisci nome">
        </div>
        <div class="form-group col-xl-auto" >
            <label for="exampleInputText2">Cognome</label>
            <input type="text" name = "cognome" class="form-control" id="exampleInputText2"  placeholder="Inserisci cognome">
        </div>
                <div class="form-group col-xl-auto" >
            <label for="exampleInputEmail1">Indirizzo email</label>
            <input type="email" name = "mail" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Inserisci email">
        </div>
        <div class="form-group col-xl-auto" >
            <label for="exampleInputPassword1">Password</label>
            <input type="password" name = "password" class="form-control" id="exampleInputPassword1" placeholder="Password">
        </div>
        <div class="form-group col-xl-auto">
            <button type="submit" class="btn btn-primary">Registrati</button>
        </div>
    </form>

</div>


<!-- Footer -->
<footer class="fixed-bottom py-5 bg-dark">
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
