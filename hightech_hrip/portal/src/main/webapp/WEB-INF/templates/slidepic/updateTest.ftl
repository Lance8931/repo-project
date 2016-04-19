<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>UEditorDemo</title>
        <@js src="js/UEditor/third-party/jquery-1.10.2.js"/>
    </head>
<body>
    <script type="text/javascript">
		function update(){
			var slidePics = [];
			var slidePic = new Object();
			slidePic.id = 16;
			slidePic.url = 'updateTest';
			slidePics.push(slidePic);
			var uploadData = JSON.stringify(slidePics);
			console.log(uploadData);
			$.ajax({
				url:'http://localhost:8080/portal/slidePic/updateImage',
				type:'POST',
				data: uploadData,
				dataType:"json",
				contentType:"application/json",
				success: function(data){
					alert("结果：" + data.msg);
				}
			});
		}
    </script>
	 <button onclick="update()">修改</button>
    
    
</body>
</html>