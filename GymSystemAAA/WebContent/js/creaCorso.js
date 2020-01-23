var limit = 3;
$('input.single-checkbox').on('change', function(evt) {
	if ($(this).siblings(':checked').length >= limit) {
	   this.checked = false;
	 }
});
	