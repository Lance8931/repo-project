<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>UEditorDemo</title>
        <script type="text/javascript" src="resources/ueditor.config.js" charset="utf-8" ></script>
        <script type="text/javascript" src="resources/ueditor.all.js" charset="utf-8" ></script>
        <script type="text/javascript" src="resources/lang/zh-cn/zh-cn.js" charset="utf-8" ></script>
        <script type="text/javascript" src="resources/third-party/jquery-1.10.2.js" charset="utf-8" ></script>
    </head>
<body>
	<h1>完整demo</h1>
    <script id="editor" type="text/plain" style="width:1024px;height:500px;"></script>
    <button onclick="getContent()">获得内容</button>
    <button onclick="insertMusic()">插入音乐</button>
    <button onclick="submit1()">提交</button>
    <button onclick="preview()">预览</button>
    <button onclick="getEdit()">获取编辑</button>
    <button onclick="saveEdit()">保存编辑</button>
    <button onclick="testException()">测试异常信息抛出</button>
    <script type="text/javascript">
        var ue = UE.getEditor('editor');
        function getContent() {
            alert(UE.getEditor('editor').getContent());
        }
        
        function insertMusic(){
             ue.execCommand( 'music' , {
                 width: 400,
                 height: 95,
                 align: "center",
                 url: "http://127.0.0.1/static/img/ueditor/upload/video/20160414/1460599575454058678.mp3"
             } );
        }
       
        function submit1(){
            $.ajax({
                url:'add',
                type:'POST',
                data:{content:UE.getEditor('editor').getContent()},
                success:function(result){
                    if(result.success){
                        alert(result.msg);
                    }else{
                        alert(result.msg);
                    }
                },
                error:function(result){
                    alert(result.msg);
                }
            });
        }
        
        function preview(){
            $.ajax({
                url:'preview',
                data:{id:1},
                success:function(result){
                    $("#previewdddddddd").html(result.msg);
                }
            });
        }
        
        function getEdit(){
            $.ajax({
                url:'preview',
                data:{id:1},
                success:function(result){
                    $("#articleId").val(result.billNumber);
                    UE.getEditor('editor').setContent(result.msg);
                }
            });
        }
        
        function saveEdit(){
            $.ajax({
                url:'edit',
                type:'POST',
                data:{id:$("#articleId").val(),content:UE.getEditor('editor').getContent(),type:'1',msgTypeId:1},
                success:function(result){
                    alert(result.msg);
                }
            });
        }
        
        function testException(){
            $.ajax({
                url:'exceptionTest',
                success:function(result){
                    alert(result.msg);
                }
            });
        }
    </script>
    <input type="text" id="articleId" style="display:none;" />
    <div id="previewdddddddd">
        
    </div>
</body>
</html>