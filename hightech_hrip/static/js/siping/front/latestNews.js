$(function(){
    $('#header li').mouseover(function(){
        $('.child-menu').hide();
        $(this).find('.child-menu').show();
    });
    $('#header li .child-menu').mouseout(function(){
        $(this).hide();
    });
    $('article').hide();
    $('article').find('.show').show();
    
    $('#hyzxPage').hide();
    $('#mtgzPage').hide();
    $("li[name='pageTypehyzx']", '.pagination').hide();
    $("li[name='pageTypemtgz']", '.pagination').hide();
    
    /*scroll to top*/
    $(".to-top").click(function () {
        $('html, body').animate({ scrollTop: 0 }, 400);
        return false;
    });

    //行业资讯
    $(".nav-box li").click(function(){
        $(this).addClass("active").siblings().removeClass("active");
    });

    $(".pic-block").mouseover(function(){
        $(this).find("img").css("transform","scale(1.1)");
    });
    $(".pic-block").mouseout(function(){
        $(this).find("img").css("transform","scale(1)");
    });

    $(".menu-3 li").click(function(){
        var choose=$(this).attr("class");
        $(".nav-box li").removeClass("active");
        $(".nav-box").find("."+choose).addClass("active");
        $("#new-notice ul").css("display","none");
        $("#new-notice").find("."+choose).css("display","block");
        
        $("#new-page ul").hide();
        $("#new-page").find("#"+choose+'Page').show();
    });

    $(".nav-box li").click(function(){
        var choose=$(this).attr("id");
        $("#new-notice ul").css("display","none");
        $("#new-notice").find("."+choose).css("display","block");
        
        $("#new-page ul").hide();
        $("#new-page").find("#"+choose+'Page').show();
    });
    loadLatestNews('101' , 2, 'xwdt');//第几页、类型、每页加载条数、id
    loadLatestNews('102' , 4, 'hyzx');
    loadLatestNews('103' , 2, 'mtgz');
});    

//初始化页面
function loadLatestNews(type, pageSize, parentId){
    var contentId = parentId + 'Content', pageId = parentId + 'Page', pageNo = 1; 
    var model = {
            parentId : parentId,
            type : type,
            pageNo : pageNo,
            pageSize : pageSize,
    };
    
    $.ajax({
        url:createUrl('article/list'),
        type:'GET',
        async:true,
        data:{type : type, pageNo : pageNo, pageSize : pageSize, orderPublish : 1},
        contentType:"application/json",
        success:function(json){
            //加载内容
            $(contentId).empty();
            for (var i = 0; i < json.records.length; i++) {
                $('#' + contentId).append(getTemplateTr(json.records[i]));
            } 
            //加载分页条
            var totalPage = Math.ceil(json.total/pageSize);
            $('#' + pageId).append(getPageTemplate());
            for(var j = 1; j < totalPage; j++){
                $('li[name="Next"]', '#' + pageId).before('<li><a href="javascript:void(0);" onclick="pageNumber(this)">'+ (j+1) +'</a></li>');
            }
            $('#' + pageId).data('totalPage'+parentId, totalPage);
            $('#' + pageId).data('pageSize' + parentId, pageSize);
        }
    });
}


function pageNumber(obj){
    getPage($(obj).text());
}

function lastPage(){
    var pageNo = "last";
    getPage(pageNo);
}

function nextPage(){
    var pageNo = "next";
    getPage(pageNo);
}

/**
 * 获取第几页
 */
function getPage(pageNo){
    var typeObj = {xwdt : '101', hyzx : '102', mtgz : '103'}, parentId = $('.nav-box .active').attr('id'),
    type = typeObj[''+parentId+''], pageId = parentId + 'Page', pageSize = $('#' + pageId).data('pageSize' + parentId);
    var totalPage = $('#' + pageId).data('totalPage'+parentId);
    var currentPage = parseInt($('#' + pageId).find('.active a').text());
    if(pageNo === undefined){
        pageNo = totalPage;
    }else if(pageNo == "last"){
        pageNo = currentPage - 1;
    }else if(pageNo == "next"){
        pageNo = currentPage + 1;
    }
    
    if(pageNo < 1 || pageNo > totalPage){return false;}
                    
    var initData = {type : type, pageNo : pageNo, pageSize : pageSize , orderPublish : 1};
    var contentId = parentId + 'Content';
    //获取第几页
    $.getJSON(createUrl('article/list'), initData, function(data){
        $('#' + contentId).empty();
        for (var i = 0; i < data.records.length; i++) {
            $('#' + contentId).append(getTemplateTr(data.records[i]));
        } 
    }); 
    //加载样式
    $('#'+pageId).find('.active').removeClass('active');
    $('#'+pageId).find('li').get(parseInt(pageNo)+1).className = 'active';
}

function getTemplateTr(article){
    var templateTr = '<li><div class="box"><div class="line"><div class="pic-block">' ;
    templateTr += '<img src="' + article.picPath +'">' ;//图片地址
    templateTr += '</div>' ;
    templateTr += '<p>' + article.title +'</p>' ;//标题
    templateTr += '<a href="#">' + article.content +'</a>' ;//内容
    templateTr += '<span class="resource"><i class="fa fa-mail-forward"></i>' + article.author + '</span>' ;//新闻来源
    templateTr += '<span><i class="fa fa-clock-o"></i>'+ article.publishTime+'</span>' ;
    templateTr += '</div></div></li>' ; 
    return templateTr;
}

var getPageTemplate = function(){
    var templatePage = '<li><a href="javascript:void(0);" onclick="getPage(1);"><i class="fa fa-angle-double-left"></i></a></li>';//第一页
    templatePage += '<li><a aria-label="Previous" href="javascript:void(0);" onclick="lastPage()">';//上一页
    templatePage += '<span aria-hidden="true"><i class="fa fa-angle-left"></i></span></a></li>';
    templatePage += '<li class="active"><a href="javascript:void(0);" onclick="getPage(1);">1</a></li>';//第一页
    templatePage += '<li name="Next"><a aria-label="Next" href="javascript:void(0);" onclick="nextPage()">';//下一页
    templatePage += '<span aria-hidden="true"><i class="fa fa-angle-right"></i></span></a> </li>';
    templatePage += '<li><a href="javascript:void(0);"onclick="getPage();"><i class="fa fa-angle-double-right"></i></a></li>';//最后一页
    return templatePage;
}
