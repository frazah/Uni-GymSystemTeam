$(".upload-button").on('click', function() {
  
  var urlImmagine = prompt("Inserisci URL della foto che vuoi caricare");
  var nomeUtente = document.getElementById("nomeUtente").value;
  var asyncRequest;
 
  function start(){
	    try
	    {
	        asyncRequest = new XMLHttpRequest();
	        asyncRequest.addEventListener("readystatechange", stateChange, false);
	        if (urlImmagine != null && urlImmagine.localeCompare(""))
	        	asyncRequest.open('GET', 'UploadFoto?urlImmagine=' + urlImmagine+'&nomeUtente='+nomeUtente,false);    
	        asyncRequest.send(null);
	    }
	    catch(exception)
	   {
	    alert("Inserisci un URL valido");
	   }
	}
  
  function stateChange(){
		if(asyncRequest.readyState == 4 && asyncRequest.status == 200)
		{
			
		}
	}
  
  	window.addEventListener("load", start(), false);
});
