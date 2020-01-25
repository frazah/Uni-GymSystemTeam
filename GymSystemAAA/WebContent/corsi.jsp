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


<div class="my-5 text-center">
    <b>
        Clicca sul nome del corso per visualizzarne la pagina
    </b>
</div>


<div>
    <table class="table table-bordered table-dark my-5 text-center container" style="width: 2000px; height : 500px">
        <thead>
        <tr>
            <th scope="col">Orari</th>
            <th scope="col">Lunedi'</th>
            <th scope="col">Martedi'</th>
            <th scope="col">Mercoledi'</th>
            <th scope="col">Giovedi'</th>
            <th scope="col">Venerdi'</th>
            <th scope="col">Sabato</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="row">8.00-10.00</th>
            
	            <td>
	            <c:forEach var = "corso" items = "${corsi}">
	            	<c:if test = "${corso.getFasciaOraria().equals('1') && corso.contieneGiorno('1')}">
	            		<a href="ReindirizzaCorso?corso=${corso.getNome()}" style="color: yellow"> ${corso.getNome()}</a>
	            			</c:if>
	            				</c:forEach>
	            					</td>
	            <td>
	            <c:forEach var = "corso" items = "${corsi}">
	            	<c:if test = "${corso.getFasciaOraria().equals('1') && corso.contieneGiorno('2')}">
	            		<a href="ReindirizzaCorso?corso=${corso.getNome()}" style="color: yellow"> ${corso.getNome()}</a>
	            			</c:if>
	            				</c:forEach>
	            					</td>
	            <td>
	            <c:forEach var = "corso" items = "${corsi}">
	            	<c:if test = "${corso.getFasciaOraria().equals('1') && corso.contieneGiorno('3')}">
	            		<a href="ReindirizzaCorso?corso=${corso.getNome()}" style="color: yellow"> ${corso.getNome()}</a>
	            			</c:if>
	            				</c:forEach>
	            					</td>
	            <td>
	            <c:forEach var = "corso" items = "${corsi}">
	            	<c:if test = "${corso.getFasciaOraria().equals('1') && corso.contieneGiorno('4')}">
	            		<a href="ReindirizzaCorso?corso=${corso.getNome()}" style="color: yellow"> ${corso.getNome()}</a>
	            			</c:if>
	            				</c:forEach>
	            					</td>
	            <td>
	            <c:forEach var = "corso" items = "${corsi}">
	            	<c:if test = "${corso.getFasciaOraria().equals('1') && corso.contieneGiorno('5')}">
	            		<a href="ReindirizzaCorso?corso=${corso.getNome()}" style="color: yellow"> ${corso.getNome()}</a>
	            			</c:if>
	            				</c:forEach>
	            					</td>
	            <td>
	            <c:forEach var = "corso" items = "${corsi}">
	            	<c:if test = "${corso.getFasciaOraria().equals('1') && corso.contieneGiorno('6')}">
	            		<a href="ReindirizzaCorso?corso=${corso.getNome()}" style="color: yellow"> ${corso.getNome()}</a>
	            			</c:if>
	            				</c:forEach>
	            					</td>
            
            
        </tr>
        <tr>
            <th scope="row">10.00-12.00</th>
            <td>
	            <c:forEach var = "corso" items = "${corsi}">
	            	<c:if test = "${corso.getFasciaOraria().equals('2') && corso.contieneGiorno('1')}">
	            		<a href="ReindirizzaCorso?corso=${corso.getNome()}" style="color: yellow"> ${corso.getNome()}</a>
	            			</c:if>
	            				</c:forEach>
	            					</td>
	            <td>
	            <c:forEach var = "corso" items = "${corsi}">
	            	<c:if test = "${corso.getFasciaOraria().equals('2') && corso.contieneGiorno('2')}">
	            		<a href="ReindirizzaCorso?corso=${corso.getNome()}" style="color: yellow"> ${corso.getNome()}</a>
	            			</c:if>
	            				</c:forEach>
	            					</td>
	            <td>
	            <c:forEach var = "corso" items = "${corsi}">
	            	<c:if test = "${corso.getFasciaOraria().equals('2') && corso.contieneGiorno('3')}">
	            		<a href="ReindirizzaCorso?corso=${corso.getNome()}" style="color: yellow"> ${corso.getNome()}</a>
	            			</c:if>
	            				</c:forEach>
	            					</td>
	            <td>
	            <c:forEach var = "corso" items = "${corsi}">
	            	<c:if test = "${corso.getFasciaOraria().equals('2') && corso.contieneGiorno('4')}">
	            		<a href="ReindirizzaCorso?corso=${corso.getNome()}" style="color: yellow"> ${corso.getNome()}</a>
	            			</c:if>
	            				</c:forEach>
	            					</td>
	            <td>
	            <c:forEach var = "corso" items = "${corsi}">
	            	<c:if test = "${corso.getFasciaOraria().equals('2') && corso.contieneGiorno('5')}">
	            		<a href="ReindirizzaCorso?corso=${corso.getNome()}" style="color: yellow"> ${corso.getNome()}</a>
	            			</c:if>
	            				</c:forEach>
	            					</td>
	            <td>
	            <c:forEach var = "corso" items = "${corsi}">
	            	<c:if test = "${corso.getFasciaOraria().equals('2') && corso.contieneGiorno('6')}">
	            		<a href="ReindirizzaCorso?corso=${corso.getNome()}" style="color: yellow"> ${corso.getNome()}</a>
	            			</c:if>
	            				</c:forEach>
	            					</td>
        </tr>
        <tr>
            <th scope="row">14.00-16.00</th>
            <td>
	            <c:forEach var = "corso" items = "${corsi}">
	            	<c:if test = "${corso.getFasciaOraria().equals('3') && corso.contieneGiorno('1')}">
	            		<a href="ReindirizzaCorso?corso=${corso.getNome()}" style="color: yellow"> ${corso.getNome()}</a>
	            			</c:if>
	            				</c:forEach>
	            					</td>
	            <td>
	            <c:forEach var = "corso" items = "${corsi}">
	            	<c:if test = "${corso.getFasciaOraria().equals('3') && corso.contieneGiorno('2')}">
	            		<a href="ReindirizzaCorso?corso=${corso.getNome()}" style="color: yellow"> ${corso.getNome()}</a>
	            			</c:if>
	            				</c:forEach>
	            					</td>
	            <td>
	            <c:forEach var = "corso" items = "${corsi}">
	            	<c:if test = "${corso.getFasciaOraria().equals('3') && corso.contieneGiorno('3')}">
	            		<a href="ReindirizzaCorso?corso=${corso.getNome()}" style="color: yellow"> ${corso.getNome()}</a>
	            			</c:if>
	            				</c:forEach>
	            					</td>
	            <td>
	            <c:forEach var = "corso" items = "${corsi}">
	            	<c:if test = "${corso.getFasciaOraria().equals('3') && corso.contieneGiorno('4')}">
	            		<a href="ReindirizzaCorso?corso=${corso.getNome()}" style="color: yellow"> ${corso.getNome()}</a>
	            			</c:if>
	            				</c:forEach>
	            					</td>
	            <td>
	            <c:forEach var = "corso" items = "${corsi}">
	            	<c:if test = "${corso.getFasciaOraria().equals('3') && corso.contieneGiorno('5')}">
	            		<a href="ReindirizzaCorso?corso=${corso.getNome()}" style="color: yellow"> ${corso.getNome()}</a>
	            			</c:if>
	            				</c:forEach>
	            					</td>
	            <td>
	            <c:forEach var = "corso" items = "${corsi}">
	            	<c:if test = "${corso.getFasciaOraria().equals('3') && corso.contieneGiorno('6')}">
	            		<a href="ReindirizzaCorso?corso=${corso.getNome()}" style="color: yellow"> ${corso.getNome()}</a>
	            			</c:if>
	            				</c:forEach>
	            					</td>
        </tr>
        <tr>
            <th scope="row">16.00-18.00</th>
            <td>
	            <c:forEach var = "corso" items = "${corsi}">
	            	<c:if test = "${corso.getFasciaOraria().equals('4') && corso.contieneGiorno('1')}">
	            		<a href="ReindirizzaCorso?corso=${corso.getNome()}" style="color: yellow"> ${corso.getNome()}</a>
	            			</c:if>
	            				</c:forEach>
	            					</td>
	            <td>
	            <c:forEach var = "corso" items = "${corsi}">
	            	<c:if test = "${corso.getFasciaOraria().equals('4') && corso.contieneGiorno('2')}">
	            		<a href="ReindirizzaCorso?corso=${corso.getNome()}" style="color: yellow"> ${corso.getNome()}</a>
	            			</c:if>
	            				</c:forEach>
	            					</td>
	            <td>
	            <c:forEach var = "corso" items = "${corsi}">
	            	<c:if test = "${corso.getFasciaOraria().equals('4') && corso.contieneGiorno('3')}">
	            		<a href="ReindirizzaCorso?corso=${corso.getNome()}" style="color: yellow"> ${corso.getNome()}</a>
	            			</c:if>
	            				</c:forEach>
	            					</td>
	            <td>
	            <c:forEach var = "corso" items = "${corsi}">
	            	<c:if test = "${corso.getFasciaOraria().equals('4') && corso.contieneGiorno('4')}">
	            		<a href="ReindirizzaCorso?corso=${corso.getNome()}" style="color: yellow"> ${corso.getNome()}</a>
	            			</c:if>
	            				</c:forEach>
	            					</td>
	            <td>
	            <c:forEach var = "corso" items = "${corsi}">
	            	<c:if test = "${corso.getFasciaOraria().equals('4') && corso.contieneGiorno('5')}">
	            		<a href="ReindirizzaCorso?corso=${corso.getNome()}" style="color: yellow"> ${corso.getNome()}</a>
	            			</c:if>
	            				</c:forEach>
	            					</td>
	            <td>
	            <c:forEach var = "corso" items = "${corsi}">
	            	<c:if test = "${corso.getFasciaOraria().equals('4') && corso.contieneGiorno('6')}">
	            		<a href="ReindirizzaCorso?corso=${corso.getNome()}" style="color: yellow"> ${corso.getNome()}</a>
	            			</c:if>
	            				</c:forEach>
	            					</td>
        </tr>
        <tr>
            <th scope="row">18.00-20.00</th>
            <td>
	            <c:forEach var = "corso" items = "${corsi}">
	            	<c:if test = "${corso.getFasciaOraria().equals('5') && corso.contieneGiorno('1')}">
	            		<a href="ReindirizzaCorso?corso=${corso.getNome()}" style="color: yellow"> ${corso.getNome()}</a>
	            			</c:if>
	            				</c:forEach>
	            					</td>
	            <td>
	            <c:forEach var = "corso" items = "${corsi}">
	            	<c:if test = "${corso.getFasciaOraria().equals('5') && corso.contieneGiorno('2')}">
	            		<a href="ReindirizzaCorso?corso=${corso.getNome()}" style="color: yellow"> ${corso.getNome()}</a>
	            			</c:if>
	            				</c:forEach>
	            					</td>
	            <td>
	            <c:forEach var = "corso" items = "${corsi}">
	            	<c:if test = "${corso.getFasciaOraria().equals('5') && corso.contieneGiorno('3')}">
	            		<a href="ReindirizzaCorso?corso=${corso.getNome()}" style="color: yellow"> ${corso.getNome()}</a>
	            			</c:if>
	            				</c:forEach>
	            					</td>
	            <td>
	            <c:forEach var = "corso" items = "${corsi}">
	            	<c:if test = "${corso.getFasciaOraria().equals('5') && corso.contieneGiorno('4')}">
	            		<a href="ReindirizzaCorso?corso=${corso.getNome()}" style="color: yellow"> ${corso.getNome()}</a>
	            			</c:if>
	            				</c:forEach>
	            					</td>
	            <td>
	            <c:forEach var = "corso" items = "${corsi}">
	            	<c:if test = "${corso.getFasciaOraria().equals('5') && corso.contieneGiorno('5')}">
	            		<a href="ReindirizzaCorso?corso=${corso.getNome()}" style="color: yellow"> ${corso.getNome()}</a>
	            			</c:if>
	            				</c:forEach>
	            					</td>
	            <td>
	            <c:forEach var = "corso" items = "${corsi}">
	            	<c:if test = "${corso.getFasciaOraria().equals('5') && corso.contieneGiorno('6')}">
	            		<a href="ReindirizzaCorso?corso=${corso.getNome()}" style="color: yellow"> ${corso.getNome()}</a>
	            			</c:if>
	            				</c:forEach>
	            					</td>
        </tr>
        </tbody>
    </table>
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
