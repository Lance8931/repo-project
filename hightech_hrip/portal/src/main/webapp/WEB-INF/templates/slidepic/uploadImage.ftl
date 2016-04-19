<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<@css href="css/bootstrap/bootstrap.min.css"/>
<@css href="css/bootstrap/fileinput.min.css"/>
<@js src="js/UEditor/third-party/jquery-1.10.2.js"/>
<@js src="js/bootstrap/bootstrap.min.js"/>
<@js src="js/bootstrap/fileinput.min.js"/>
<@js src="js/bootstrap/canvas-to-blob.min.js"/>
<@js src="js/bootstrap/fileinput_locale_zh.js"/>

</head>
<body>
    <form enctype="multipart/form-data">
        <div style="padding:200px">
            <input id="uploadImage" name="uploadImage" type="file" multiple class="file-loading" >
        </div>
    </form>
<script>

$(function (){
     $('#uploadImage').fileinput({
        uploadUrl : 'uploadImage',
        language : 'zh', // 设置语言
        maxFileCount : 9, // 表示允许同时上传的最大文件个数
        allowedFileExtensions : [ 'jpeg', 'jpg', 'png', 'gif', 'bmp', 'tif' ],// 接收的文件后缀
        overwriteInitial : false,
        showPreview : true, // 是否显示预览
        showUpload : true, // 是否显示上传按钮
        showCaption : true, // 是否显示标题
        showClose : false, // 关闭窗口
        showUploadedThumbs : false,
        dropZoneEnabled : false, // 是否允许拖拽
        initialPreviewShowDelete : true, // 修改初始化时显示删除按钮
        overwriteInitial : false, // 修改时不覆盖原有文件
        maxImageWidth : 1500,
        maxImageHeight : 1500,
    });
});

</script>
</body>
</html>