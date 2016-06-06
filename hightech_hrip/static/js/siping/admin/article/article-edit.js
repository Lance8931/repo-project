var ue;
$(function(){
    ue = UE.getEditor('editor');
    ue.addListener( 'ready', function( types ) {
    	var editor = this;
    	$.ajax({
    		url : createUrl('article/getArticle'),
    		type : 'post',
    		data : {id : $("#hiddenId").val()},
    		success : function(result){
    			$("#inputTitle").val(result.title);
    			$("#inputAuthor").val(result.author);
    			$("#inputPubTime").val(result.publishTime);
    			$("#hiddenType").val(result.type);
    			$("#selectMsgType").val(result.msgTypeId);
    			$("#hiddenPicPath").val(result.picPath);
    			$("#inputDisplayPosition").val(result.displayPosition);
    			initFileUpload('#uploadImage',result.picPath);
    			if(result.enabled){
    				$("#selectEnabled").val(1);
    			}else{
    				$("#selectEnabled").val(0);
    			}
    			editor.setContent(result.content);
    		}
    	});
    } );
});

function edit(){
    $("#article").ajaxSubmit({
        url:'edit',
        type:'POST',
        contentType : false, 
        processData :false,
        data:{id:$("#hiddenId").val(),content:UE.getEditor('editor').getContent(),
              msgTypeId:$("#selectMsgType").val(),type:$("#hiddenType").val(),
              enabled:$("#selectEnabled").val(),title:$("#inputTitle").val(),
              author:$("#inputAuthor").val(),picPath:$("#hiddenPicPath").val(),
              publishTime:$("#inputPubTime").val(),
              displayPosition:$("#inputDisplayPosition").val()
        },
        success:function(result){
            if(result.success){
                layer.alert(result.msg,{icon:1},function(){
                    if($("#hiddenType").val()=='001' || $("#hiddenType").val()=='002'){
                        window.location=createUrl("article/redirectArticle?type=1");
                    }else{
                        window.location=createUrl("article/redirectArticle?type=2");
                    }
                });
            }else{
                layer.alert(result.msg,{icon:2});
            }
        },
        error:function(result){
            layer.alert("系统发生错误！",{icon:2});
        }
    });
}

/**
 * 图片上传
 */
$(function(){
    //initFileUpload('#uploadImage','1463556666192.jpg');
});   
function _getOtherData(){//获取表单其他数据
    var inputList = document.getElementsByTagName("input");
    var inputValue = {};
    for(var i=0; (inputList != null) && (i<inputList.length); i++){
        inputValue[inputList[i].name] = inputList[i].value;
    }           
    inputValueArr = JSON.stringify(inputValue)
    return inputValueArr;
}

function _deletePreviewPic(obj){//删除图片时同时清除预览表格图片
    
}

function _fileChgEvent(files){//自定义选择事件
    
}


 function initFileUpload(ctrlName,value){
     $(ctrlName).fileinput({
         language : 'zh', // 设置语言
         maxFileCount : 1, // 表示允许同时上传的最大文件个数
         allowedFileExtensions : [ 'jpeg', 'jpg', 'png', 'gif', 'bmp', 'tif' ],// 接收的文件后缀
         autoReplace :true,//超过最大上传个数 覆盖
         showPreview : true, // 是否显示预览
         showUpload : false, // 是否显示上传按钮
         showCaption : true, // 是否显示标题
         showClose : true, // 关闭窗口
         showUploadedThumbs : false,
         dropZoneEnabled : true, // 是否允许拖拽
         initialPreviewShowDelete : true, // 修改初始化时显示删除按钮
         overwriteInitial : false, // 修改时不覆盖原有文件
         maxImageWidth : 1500,
         maxImageHeight : 1500,
         initialPreview:[
       '<img src="../../../static/imgs/'+value+'"'+' class="file-preview-image" alt="圖片加載失敗" title="显示图片">'
       ],
     });
 }
 