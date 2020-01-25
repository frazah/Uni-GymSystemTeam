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
  
  <div class = "mx-5 my-5">
  	<button type="submit" class="btn btn-primary" id = "nuovoCorso" onclick = "window.location.href = 'creaCorso.jsp' "">Crea corso</button>
  </div>
  
  <c:choose>
  	<c:when test="${empty corsi}">
  		<h1>Nel sistema non è presente nessun corso</h1>
  	</c:when>
  	<c:when test="${not empty corsi}">
  		<c:forEach items="${corsi}" var="corso">
	    <table class="table table-bordered table-dark mx-5 my-5 text-center container" style="width: 500px; height : 500px">
			<thead>
				<tr>
					<td scope="col">
					<a href="ReindirizzaCorso?corso=${corso.getNome()}" style="color: yellow"> ${corso.getNome()}</a>
					<c:if test="${corso.getTrainer() != null}">
						<div>
			             	<a style = "color: white">Trainer associato: ${corso.getTrainer().getNome()} ${corso.getTrainer().getCognome()}</a>
			        	</div>
			        </c:if>
			        <c:if test="${corso.getTrainer() == null}">
			        	<form method = "POST" action = "assegnaTrainerCorso.jsp" class = "my-2">
			        	<input type = "hidden" name = "corso" value = ${corso.getNome()} >
			        		<button type="submit" class="btn btn-primary" onclick = "window.location.href = 'assegnaTrainerCorso.jsp';">Assegna trainer</button>
			        	</form>
			        </c:if>
			        <c:if test="${corso.getTrainer() != null}">
						<form method = "POST" action = "RimuoviTrainerCorso" class = "my-2">
			        		<button type="submit" class="btn btn-primary" name ="trainer" value = "${corso.getTrainer().getMail() }">Rimuovi trainer</button>
			        	</form>			        
			        </c:if>
			        	<form method = "POST" action = "EliminaCorso">
			        		<button type="submit" class="btn btn-primary" name = "nome" value = "${corso.getNome()}">Elimina corso</button>
			        	</form>
			        </td>
			    </tr>
			</thead>
	 	</table>
 		</c:forEach>
  	</c:when>
  </c:choose>

  	
  
  

    </div>
    <!-- /.row -->

    <hr>

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
    