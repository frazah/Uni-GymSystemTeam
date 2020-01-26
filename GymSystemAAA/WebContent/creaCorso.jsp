<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
    <form method="POST" action="CreaCorso" onsubmit="return confirm('Confermi la creazione del corso?')">
    	<div class="form-group col-xl-auto" >
            <label>Nome Corso</label>
            <input type="text" name = "nome" class="form-control" placeholder="Inserisci nome del corso" required>
        </div>
        <div class="form-group col-xl-auto" >
            <label>Descrizione del corso</label>
            <input type="text" name = "descrizione" class="form-control" placeholder="Inserisci descrizione del corso" required>
        </div>
                <div class="form-group col-xl-auto" >
            <label>Link video YouTube</label>
            <input type="text" name = "linkVideo" class="form-control" placeholder="Inserisci link di un video riguardante il corso" required>
        </div>
        <div class="pricing-levels-3">
	          <p><strong>Seleziona i giorni (MAX 3 Giorni)</strong></p>
	          <input class="single-checkbox" type="checkbox" name="giorno" value="1">Lunedi'<br>
	          <input class="single-checkbox" type="checkbox" name="giorno" value="2">Martedi'<br>
	          <input class="single-checkbox" type="checkbox" name="giorno" value="3">Mercoledi'<br>
	          <input class="single-checkbox" type="checkbox" name="giorno" value="4">Giovedi'<br>
	          <input class="single-checkbox" type="checkbox" name="giorno" value="5">Venerdi'<br>
	          <input class="single-checkbox" type="checkbox" name="giorno" value="6">Sabato<br>  
        </div>
        <div class="form-group col-xl-auto" >
        <p>Seleziona la fascia oraria:</p>
            <select name="fasciaOra">
   			 <option value="1">8.00-10.00</option>
    		 <option value="2">10.00-12.00</option>
    		 <option value="3">14.00-16.00</option>
    		 <option value="4">16.00-18.00</option>
    		 <option value="5">18.00-20.00</option>
  		   </select>
        </div>
        <div class="form-group col-xl-auto" >
        <p>Seleziona Trainer da assegnare:</p>
        <select name="trainer">
        <c:forEach items="${trainer}" var="trainer" varStatus="loop">
        	<c:if test="${trainer.getCorso() == null}">
        		<option value="${loop.index}">${trainer.getNome()} ${trainer.getCognome()}</option>
        	</c:if>
        </c:forEach>
        </select>
        </div>
        <div class="form-group col-xl-auto">
            <button id = "submit" type="submit" class="btn btn-primary">Crea corso</button>
        </div>
    </form>
    
    <c:if test="${not empty nomeErrore}">
    	<script>
         	alert("${nomeErrore}");
    	</script>
	</c:if>

</div>

<script src = "js/creaCorso.js"></script>

<script>
  $('#submit').prop("disabled", true);
  
  $('input:checkbox').click(function() {
   if ($(this).is(':checked')) {
   $('#submit').prop("disabled", false);
   }
   
   if ($('.single-checkbox').filter(':checked').length == 0 ) {
	  
	   $('#submit').attr('disabled',true);
   }
   
   if ($('.single-checkbox').filter(':checked').length > 0) {

	   $('#submit').attr('disabled',false);
   }
  });
  </script>


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
