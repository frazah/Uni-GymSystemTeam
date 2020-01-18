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
    			<a class="nav-link" href="profilo.jsp">Il mio profilo</a>
			</c:if>
          </li>

        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Content -->
  <div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">CORSO
      <small>PUGILATO</small>
    </h1>

    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="index.jsp">Homepage</a>
      </li>
      <li class="breadcrumb-item">
        <a href="corsi.html">Corsi</a>
      </li>
      <li class="breadcrumb-item active">Pugilato</li>
    </ol>

    <!-- Intro Content -->
    <div class="row">
      <div class="col-lg-6">
        <iframe width="560" height="315" src="https://www.youtube.com/embed/3gHcQe8Q56s?autoplay=1" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
      </div>
      <div class="col-lg-6">
        <h2>Dettagli corso</h2>
        <p>Anni fa, i pugili spinti dai film di Rocky o di Bruce Lee, si dilettavano a fine allenamento in qualche trazione alla sbarra oppure in qualche serie di piegamenti sulle braccia. Si pensava che questi esercizi a corpo libero, fossero una manna per un pugile e che l'allenamento pesi non era da prendere in considerazione perchÃ© rendeva goffi ed impacciati come un body builder.</p>
        <p>ADD</p>
        <p>ADD</p>
      </div>
    </div>
    <!-- /.row -->

    <!-- Team Members -->
    <div class="py-3">
      <h2>Il Trainer</h2>
    </div>

    <div class="row">
      <div class="col-md-6 mb-4">
        <div class="card h-100 text-center">
          <img class="card-img-top" src="immagini/trainerMikeTyson.jpeg" alt="">
          <div class="card-body">
            <h4 class="card-title">Mike Tyson</h4>
            <h6 class="card-subtitle mb-2 text-muted">Trainer</h6>
            <p class="card-text">Il nostro Trainer responsabile del corso di pugilato Ã¨ il pluricampione del mondo Mike Tyson, The baddest man on the planet.</p>
          </div>
          <div class="card-footer">
            <a href="mailto:miketyson@punchman.com">miketyson@punchman.com</a>
          </div>
        </div>
      </div>
      <div class="col-md-6 mb-4">
        <div class="card h-100 text-center">
          <img class="card-img-top" src="http://placehold.it/750x450" alt="">
          <div class="card-body">
            <h4 class="card-title">Feedback corso</h4>
            <p class="card-text">FEEDBACK.</p>
          </div>
        </div>
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