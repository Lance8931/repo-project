<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>UEditorDemo</title>
		<@js charset="utf-8" src="js/UEditor/ueditor.config.js" />
		<@js charset="utf-8" src="js/UEditor/ueditor.all.js" />
		<@js charset="utf-8" src="js/UEditor/lang/zh-cn/zh-cn.js" />
		<@js src="js/UEditor/third-party/jquery-1.10.2.js"/>
	</head>
<body>
	<h1>完整demo</h1>
    <script id="editor" type="text/plain" style="width:1024px;height:500px;"></script>
    <button onclick="getContent()">获得内容</button>
    <button onclick="submit1()">提交</button>
	<script type="text/javascript">
	    var ue = UE.getEditor('editor');
	    function getContent() {
            alert(UE.getEditor('editor').getContent());
        }
        
        function submit1(){
            $.ajax({
                url:'add',
                data:{content:UE.getEditor('editor').getContent()}
            });
        }
    </script>
    
</body>
</html>