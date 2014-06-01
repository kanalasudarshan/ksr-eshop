<html>
<head>
<script src="../commons/Admin/jquery-1.11.1.js"></script>
<script>
$(document).ready(function(){
	$.getJSON("../hello/json.html",null,function(data){
		alert(data);
	});
});
</script>
</head>
<body>
</body>
</html>