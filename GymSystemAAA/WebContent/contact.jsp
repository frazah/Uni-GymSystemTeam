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
  <div class="container">
 
    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">Chi siamo    </h1>
 
    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="index.jsp">Homepage</a>
      </li>
      <li class="breadcrumb-item active">Chi siamo</li>
    </ol>
 
    <!-- Content Row -->
    <div class="row">
      <!-- Map Column -->
      <div class="col-lg-8 mb-4">
        <!-- Embedded Google Map -->
        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3084.9997230174313!2d16.224760415223695!3d39.35624287950248!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x133f99a2cb39a49b%3A0x1a529d60540e6425!2sUnical!5e0!3m2!1sen!2sit!4v1578064244300!5m2!1sen!2sit" width="600" height="450" frameborder="0" style="border:0;" allowfullscreen=""></iframe>
      </div>
      <!-- Contact Details Column -->
      <div class="col-lg-4 mb-4">
        <h3>Come contattarci</h3>
        <p>
          Unical
          <br>87036 Arcavacata, Provincia di Cosenza
          <br>
        </p>
        <p>
          <abbr title="Phone">Tel</abbr>: 0984/493979
        </p>
        <p>
          <abbr title="Email">Email</abbr>:
          <a href="mailto:unical@email.com">unical@email.com
          </a>
        </p>
        <p>
          <abbr title="Hours">Orari</abbr>: LunedÃ¬ - Sabato: dalle 8:00 fino alle 20:00
        </p>
      </div>
 
    </div>
    <!-- /.row -->
 
 
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
 
<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
 
</body>
 
</html>