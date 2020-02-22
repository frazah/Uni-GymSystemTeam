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
  <c:if test="${utente.getCorso() == null}">
  	<link href="css/profiloTrainer.css" rel="stylesheet" type="text/css">
  </c:if>
  <link href="css/uploadFotocss.css" rel="stylesheet" type="text/css">

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
    <h1 class="mt-4 mb-3">Profilo
      <small>${utente.getNome()} ${utente.getCognome()}</small>
    </h1>

    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="index.jsp">Homepage</a>
      </li>
      <li class="breadcrumb-item active">Profilo</li>
    </ol>

    <!-- Portfolio Item Row -->
    <div class="row" id = "corsoTrainer">

       <div class="profile-img">

	  <img class="profile-thumb" src="${utente.getFotoProfilo()}" id="bannerImg" />
	  <!--<div class="upload">
	    <div class="upload-button"><img src="https://tinyurl.com/mrphx9r" alt="" /></div>
	    <input type="hidden" id = "nomeUtente" value = "${utente.getMail()}"></input>
	    <script src="js/uploadFoto.js"></script>
	
	  </div> -->
	  </div>
     
      
      
      <div class="col-md-6">
        <h2>Le mie informazioni</h2>
        	<b>Nome: </b>
        	<a>${utente.getNome()}</a>
        	<br>
        	<b>Cognome: </b>
        	<a>${utente.getCognome()}</a>
        	<br>
        	<b>Mail: </b>
        	<a>${utente.getMail()}</a>

      </div>
      
      <div id = "corsoTrainer" class="my-3">
      		<h3>Il tuo corso:</h3>
      
      		
      <div class="my-3">

      <c:if test="${utente.getCorso() == null}">

    		<button type="button" class="btn btn-primary" onclick = "window.location.href = 'richiestaNuovoCorso.jsp';">Richiedi corso</button>
		</c:if>
		
		
		
      </div>
      
      
      	<c:if test="${utente.getCorso() != null}">
		
      		
      			<table class="table table-bordered table-dark mx-0 my-2 text-center container" style="width: 300px; height : 50px">
		        <thead>
		        <tr>
		            <th scope="col"><a href="ReindirizzaCorso?corso=${utente.getCorso().getNome()}" style="color: yellow"> ${utente.getCorso().getNome()}</th>
		        </tr>
		        
		        
		        </thead>
   				</table>
   				
   				<tr>
		            <button type="button" class="btn btn-primary" onclick = "window.location.href = 'richiestaModificaCorso.jsp';">Modifica o rimuovi corso</button>
		        </tr> 

      		<div class="py-5">
	            <h4 class="card-title">La media dei feedback del tuo corso</h4>
	            <c:if test="${utente.getCorso().getMediaFeedback() == 1}">
	            <h5 class="card-text">&#10032</h5>
	            </c:if>
	            <c:if test="${utente.getCorso().getMediaFeedback() == 2}">
	            <h5 class="card-text">&#10032 &#10032</h5>
	            </c:if>
	            <c:if test="${utente.getCorso().getMediaFeedback() == 3}">
	            <h5 class="card-text">&#10032 &#10032 &#10032</h5>
	            </c:if>
	            <c:if test="${utente.getCorso().getMediaFeedback() == 4}">
	            <h5 class="card-text">&#10032 &#10032 &#10032 &#10032</h5>
	            </c:if>
	            <c:if test="${utente.getCorso().getMediaFeedback() == 5}">
	            <h5 class="card-text">&#10032 &#10032 &#10032 &#10032 &#10032</h5>
	            </c:if>
            </div> 
            
            <c:if test = "${utente.getCorso().getFeedbackMigliore() != null }">
            	<div class = "card bg-info" style = "color : white"> <h4>Il feedback migliore :</h4>
            		<c:if test="${utente.getCorso().getFeedbackMigliore().getVoto() == 1}">
	            <h5 class="card-text">&#10032</h5>
	            </c:if>
	            <c:if test="${utente.getCorso().getFeedbackMigliore().getVoto() == 2}">
	            <h5 class="card-text">&#10032 &#10032</h5>
	            </c:if>
	            <c:if test="${utente.getCorso().getFeedbackMigliore().getVoto() == 3}">
	            <h5 class="card-text">&#10032 &#10032 &#10032</h5>
	            </c:if>
	            <c:if test="${utente.getCorso().getFeedbackMigliore().getVoto() == 4}">
	            <h5 class="card-text">&#10032 &#10032 &#10032 &#10032</h5>
	            </c:if>
	            <c:if test="${utente.getCorso().getFeedbackMigliore().getVoto() == 5}">
	            <h5 class="card-text">&#10032 &#10032 &#10032 &#10032 &#10032</h5>
	            </c:if>
            		
            		<h5>${utente.getCorso().getFeedbackMigliore().getTesto() }</h5>
            		
            	</div>
            </c:if>
            
            <c:if test = "${utente.getCorso().getFeedbackPeggiore() != null }">
            	<div class = "card bg-secondary" style = " color : white;" > <h4>Il feedback peggiore :</h4>
            		<c:if test="${utente.getCorso().getFeedbackPeggiore().getVoto() == 1}">
	            <h5 class="card-text">&#10032</h5>
	            </c:if>
	            <c:if test="${utente.getCorso().getFeedbackPeggiore().getVoto() == 2}">
	            <h5 class="card-text">&#10032 &#10032</h5>
	            </c:if>
	            <c:if test="${utente.getCorso().getFeedbackPeggiore().getVoto() == 3}">
	            <h5 class="card-text">&#10032 &#10032 &#10032</h5>
	            </c:if>
	            <c:if test="${utente.getCorso().getFeedbackPeggiore().getVoto() == 4}">
	            <h5 class="card-text">&#10032 &#10032 &#10032 &#10032</h5>
	            </c:if>
	            <c:if test="${utente.getCorso().getFeedbackPeggiore().getVoto() == 5}">
	            <h5 class="card-text">&#10032 &#10032 &#10032 &#10032 &#10032</h5>
	            </c:if>
            		
            		<h5>${utente.getCorso().getFeedbackPeggiore().getTesto() }</h5>
            		
            	</div>
            </c:if>
      		
      	</c:if>
      </div>
      
      
      <div class="my-5 col-md-6"> 
      	
      </div>

    </div>
    <!-- /.row -->

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
