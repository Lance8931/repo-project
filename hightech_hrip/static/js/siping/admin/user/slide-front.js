$(function(){
    slide();
    $('.change').click(function(){
        if($('.change a').text() == 'ZH'){
            $('.change a').text('EN');
        }else{
            $('.change a').text('ZH');
        }
        
    });
});
        
    function slide(){
        $.ajax({
            url:'slidePic/list?enabled=1',
            type:'GET',
            contentType:"application/json",
            success: function(data){
                for (var i = 0; i < data.records.length; i++) {
                    var li = '<li class="col-md-12">' ; 
                    li += '<a href="'+ data.records[i].url +'"><img src="/static/imgs/slide/'+ data.records[i].picPath+'" ' ;
                    li += 'alt="'+ data.records[i].hoverTips +'" title="'+ data.records[i].hoverTips +'" class="img-responsive" width="100%" height="768px"></a></li>' ;
                    $('#slide_ul').append(li);
                }
                
                /*轮播图*/
                $(".rslides").responsiveSlides({
                    auto: true,
                    pager: false,
                    nav: true,
                    speed: 300
                });
                /*strengths内容切换*/
                var timer = null;
                var index = 0;
                var width = 1140;
                $(".ico-list li").mouseover(function() {
                    clearInterval(timer);
                    index = $(".ico-list li").index(this);
                    scrollLeft(index);
                });
                
                (function(){
                    timer = setInterval(function() {
                        scrollLeft(index);
                        index++;
                        if (index == data.records.length) {
                            index = 0;
                        }
                    }, 1000);})();
                function scrollLeft(index) {
                    $(".ico-list li").removeClass("active").eq(index).addClass("active");
                    $(".content-list").stop().animate({left: -width * index },1000/*,function(){
                     $(ul).css({left:0}).find("li:first").appendTo(ul);
                     }*/);
                }
            }
        });   
    }
