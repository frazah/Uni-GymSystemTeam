$(".upload-button").on('click', function() {
  
  var urlImmagine = prompt("Inserisci URL della foto che vuoi caricare");
  var nomeUtente = document.getElementById("nomeUtente").value;
  //alert(urlImmagine);
  //alert(nomeUtente);
  var asyncRequest;
  function start(){
	    try
	    {
	        asyncRequest = new XMLHttpRequest();
	        asyncRequest.addEventListener("readystatechange", stateChange, false);
	        asyncRequest.open('GET', 'UploadFoto?urlImmagine=' + urlImmagine+'&nomeUtente='+nomeUtente, true);    
	        asyncRequest.send(null);
	    }
	    catch(exception)
	   {
	    alert("Request failed");
	   }
	}
  
  function stateChange(){
		if(asyncRequest.readyState == 4 && asyncRequest.status == 200)
		{
			
		}
	}
  
  	window.addEventListener("load", start(), false);
});
