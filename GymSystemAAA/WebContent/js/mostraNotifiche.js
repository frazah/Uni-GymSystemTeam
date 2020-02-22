function mostraNotifiche() {
	
	var asyncRequest;    
	function start(){
	    try
	    {
	        asyncRequest = new XMLHttpRequest();
	        asyncRequest.addEventListener("readystatechange", stateChange, false);
	        asyncRequest.open('GET', 'Notifiche', true);    
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
	    var text = document.getElementById("notifiche");       
	    text.innerHTML = asyncRequest.responseText;         
	    }
	}

	window.addEventListener("load", start(), false);
	
}