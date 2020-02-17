<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="js/mostraInfoCorso.js"></script>

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
  
  <div class="row">
  <div class = "col mx-5 my-5">
  	<button type="submit" class="btn btn-primary" id = "nuovoCorso" onclick = "window.location.href = 'creaCorso.jsp' ">Crea corso</button>
  </div>
  <div class = "col text-right mx-5 my-5">
  	<button type="submit" class="btn btn-primary" id = "nuovoTrainer" onclick = "window.location.href = 'creaTrainer.jsp' ">Registra trainer</button>
  </div>
  </div>
  
  <div class="row">
  
 <div class="col">
  <c:choose>
  	<c:when test="${empty corsi}">
  		<h1>Nel sistema non è presente nessun corso</h1>
  	</c:when>
  	<c:when test="${not empty corsi}">
  		<c:forEach items="${corsi}" var="corso">
  		<div>
	    <table class="table table-bordered table-dark mx-5 my-5 text-center container" >
			<thead>
				<tr>
					<td scope="col">
					<a href="ReindirizzaCorso?corso=${corso.getNome()}" style="color: yellow"> ${corso.getNome()}</a>
					<div id ="infoCorso">
					<button type= "button"class="btn btn-primary" id ="nomeCorso" value = ${corso.getNome()}  onclick="mostraInfoCorso()"> Mostra informazioni corso </button>
					</div>
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
						<form method = "POST" action = "RimuoviTrainerCorso" class = "my-2" onsubmit="return confirm('Sei sicuro di voler eliminare il trainer dal corso ?')">
			        		<button type="submit" class="btn btn-primary" name ="trainer" value = "${corso.getTrainer().getMail() }">Rimuovi trainer</button>
			        	</form>			        
			        </c:if> 
			        	<form method = "POST" action = "EliminaCorso" onsubmit="return confirm('Sei sicuro di eliminare il corso?')">
			        		<button type="submit" class="btn btn-primary" name = "nome" value = "${corso.getNome()}">Elimina corso</button>
			        	</form>
			        </td>
			    </tr>
			</thead>
	 	</table>
	 	</div>
 		</c:forEach>
  	</c:when>
  </c:choose>
</div>	

<div class="col text-right">
<c:choose>
  	<c:when test="${empty trainer}">
  		<h1>Nel sistema non è presente nessun trainer</h1>
  	</c:when>
  	<c:when test="${not empty trainer}">
  		<c:forEach items="${trainer}" var="trainer">
  		
	    <table class="table table-bordered table-dark mx-5 my-5 text-center container" >
			<thead>
				<tr>
					<td scope="col">
					<a style="color: yellow"> ${trainer.getNome()} ${trainer.getCognome()}</a>
			        	<form method = "POST" action = "EliminaTrainer" onsubmit="return confirm('Sei sicuro di eliminare il trainer?')">
			        		<button type="submit" class="btn btn-primary" name = "mail" value = "${trainer.getMail()}">Elimina trainer</button>
			        	</form>
			        </td>
			    </tr>
			</thead>
	 	</table>
	 	
 		</c:forEach>
  	</c:when>
  </c:choose>
  </div>
 
  </div>
  

    </div>
    <!-- /.row -->

    <hr>

  </div>
  <!-- /.container -->

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
    