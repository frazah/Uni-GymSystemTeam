if(localStorage.img) { 
debugger;
$('#bannerImg').attr('src', localStorage.img);
}
function readURL(input) {
  if (input.files && input.files[0]) {
    var reader = new FileReader();
    
    reader.onload = function(e) {
    localStorage.setItem('img', e.target.result);
    
    
    $('#bannerImg').attr('src', reader.result);
    $('#temp').attr('value', reader.result);
    
    }
    reader.readAsDataURL(input.files[0]);
    
    
    
  }
}

$(".file-upload").change(function() {
  readURL(this);
});

$(".upload-button").on('click', function() {
  $(".file-upload").click();
  
});
