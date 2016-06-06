$(function(){
    initFileUpload('#uploadImage');
    $("button[title='上传选中文件']").click(function(){
        var inputList = document.getElementsByTagName("input");
        for(var i=0; (inputList != null) && (i<inputList.length); i++){
            if(inputList[i].value == null || $.trim(inputList[i].value) == ""){
                $('input[name="' + inputList[i].name + '"]').get(0).focus();
                return false;
            }
        }
        
        $('#uploadImageForm').ajaxSubmit({
            success: function (data) {
                if(data.success){
                    layer.alert(data.msg, {
                        icon:1
                      },function(index){
                          layer.close(index);
                          parent.layer.close(parent.layer.getFrameIndex(window.name));
                      });
                }else{
                    layer.alert(data.msg, {
                        icon:2
                      },function(index){
                          layer.close(index);
                          //$("button[title='清除选中文件']").trigger("click");
                      });
                }
            },
            error : function (data) {
                layer.alert("上传失败，请稍后再试！", {
                    icon:5
                  },function(index){
                      layer.close(index);
                      $("button[title='清除选中文件']").trigger("click");
                  });
            }
        });
        return false;
    });
}); 

 var closeBtn = function(){
     var index = parent.layer.getFrameIndex(window.name);
     parent.layer.close(index);
 }

 function initFileUpload(ctrlName, uploadUrl){
     $(ctrlName).fileinput({
         uploadUrl : uploadUrl,
         language : 'zh', // 设置语言
         maxFileCount : 4, // 表示允许同时上传的最大文件个数
         allowedFileExtensions : [ 'jpeg', 'jpg', 'png', 'gif', 'bmp', 'tif' ],// 接收的文件后缀
         autoReplace :true,//超过最大上传个数 覆盖
         showPreview : true, // 是否显示预览
         showUpload : true, // 是否显示上传按钮
         showCaption : true, // 是否显示标题
         showClose : false, // 关闭窗口
         showUploadedThumbs : false,
         dropZoneEnabled : true, // 是否允许拖拽
         initialPreviewShowDelete : true, // 修改初始化时显示删除按钮
         overwriteInitial : false, // 修改时不覆盖原有文件
         maxImageWidth : 2000,
         maxImageHeight : 2000,
         defaultPreviewContent : '<img style="height:262px">',
         previewSettings : {
             image : {
                 width : "396px",
                 height : "202px"
             },
         }
     });
 }
 

