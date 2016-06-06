/**
 * 用于操作introArticle页面的js文件
 */
$(function(){
    ue = UE.getEditor('editor');
    ue.addListener( 'ready', function( types ) {
        var editor = this;
        initIntro($("#tabs-intro ul li.active a").attr("data-type"), editor);
    } );
    $("#tabs-intro ul li a").click(function(){
        initIntro($(this).attr("data-type"),ue);
    });
});

var ue;

var introContent;

function initIntro(type, editor){
    $.ajax({
        url : createUrl('article/getIntroArticle'),
        type : 'post',
        data : {subTitle : type},
        success : function(result){
            editor.reset();
            if(null != result.content && undefined != result.content){
                editor.setContent(result.content);
            }else{
                editor.setContent("");
            }
            $("#hiddenIntroArticleId").val(result.id);
        }
    });
}

function update(){
    $.ajax({
        url : createUrl('article/editIntroArticle'),
        type:'POST',
        data:{id:$("#hiddenIntroArticleId").val(),content:ue.getContent()},
        success:function(result){
            if(result.success){
                layer.alert(result.msg,{icon:1});
            }else{
                layer.alert(result.msg,{icon:2});
            }
        },
        error:function(result){
            layer.alert(result.msg,{icon:2});
        }
    });
}
