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

  <!-- Page Content -->
  <div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">Iscrizione
      <small>Tessera</small>
    </h1>

    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="index.html">Homepage</a>
      </li>
      <li class="breadcrumb-item active">Abbonamento</li>
    </ol>
    
    <div class = "my-4">
    <h2>Ogni tipo di abbonamento ti permette di iscriverti a tre corsi che potrai scegliere in un secondo momento dal tuo profilo.</h2>
    </div>

    <!-- Content Row -->
    <form method="POST" action="ScegliAbbonamento">
    <div class="row">
      <div class="col-lg-4 mb-4">
        <div class="card h-100">
          <h3 class="card-header">Mensile</h3>
          <div class="card-body">
            <div class="display-4">Eur. 19.99</div>
          </div>
          <ul class="list-group list-group-flush">
            
            <li class="list-group-item">
              <input required name = "scelta" type = "radio" value = "mensile" class="btn btn-primary">Pacchetto 1 mese</a>
            </li>
          </ul>
        </div>
      </div>
      <div class="col-lg-4 mb-4">
        <div class="card card-outline-primary h-100">
          <h3 class="card-header">Semestrale</h3>
          <div class="card-body">
            <div class="display-4">Eur. 89.99</div>
          </div>
          <ul class="list-group list-group-flush">
            
            <li class="list-group-item">
			<input name = "scelta" type = "radio" value = "semestrale" class="btn btn-primary">Pacchetto 6 mesi</a>            </li>
          </ul>
        </div>
      </div>
      <div class="col-lg-4 mb-4">
        <div class="card h-100">
          <h3 class="card-header bg-primary text-white">Annuale</h3>
          <div class="card-body">
            <div class="display-4">Eur. 159.99</div>
          </div>
          <ul class="list-group list-group-flush">
            
            <li class="list-group-item">
			<input name = "scelta" type = "radio" value = "annuale" class="btn btn-primary">Pacchetto 12 mesi!!!</a>            </li>
          </ul>
        </div>
      </div>
    </div>
    
    <!-- /.row -->
    
    <div class = "my-5 mx-5 text-center">
    	<button type="submit" href = "profilo.jsp" class="btn btn-primary">Paga ora</button>
    </div>

  </div>
  </form>
  <!-- /.container -->

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
