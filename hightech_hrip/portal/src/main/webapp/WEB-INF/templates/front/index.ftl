<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>高新区人力资源服务产业园</title>
    <link rel = "Shortcut Icon" href="">
    <#include "../common/base.ftl"/>
    <@css href="css/index-1.css" />
    <@css href="css/font-awesome.min.css" />
    <@js src="js/jquery/responsiveslides.min.js" />
    <@js src="js/jquery/jquery.scrollify.min.js" />
    <@js src="js/jquery/jquery.easing.min.js" />
    <@js src="js/jquery/move.js" />
    <@js src="js/siping/front/slide-front.js" />
</head>
<body>

<!--轮播图-->
<section id="slide" class="panel">
    <div class="logo">
        <a href="javascript:;"><img src="<@static value='/imgs/logo.png'/>" class="img-responsive"></a>
    </div>
    <div class="change">
       <a href="#">EN</a>
    </div>
    <div class="link">
        <a href="<@url value='/aboutus' />">关于产业园 &nbsp;&nbsp;<i class="fa fa-angle-right"></i></a>
    </div>
    <ul class="rslides" id='slide_ul'>
    
    </ul>
    <a class="next-section" href="#news"><i class="fa fa-angle-down"></i></a>
</section>

<section id="news" class="panel">
    <div class="container">
        <div class="row">
            <ul class="news-list" id="newMessage_ul">
                <li class="text" id = "newMessage_li">
                    <a href="#" class="button-1">最新通知</a>
                    <ul id="inform_ul">
                    </ul>
                </li>
                <li class="text">
                    <a href="#" class="button-1 yellow">公示公告</a>
                    <ul id = "notice_ul">
                    </ul>
                </li>
            </ul>
            <a href="javascript:;" class="more">查看更多</a>
            <a class="next-section gray-color" href="#strengths"><i class="fa fa-angle-down"></i></a>
        </div>
    </div>

</section>

<section id="strengths" class="panel">
        <div class="container">
            <div class="row">
                <h1>我们的服务与优势</h1>
                <ul class="ico-list col-md-12">
                    <li class="col-md-2 active"><a href="#content-list-1"></a><span class="text">企业入园</span></li>
                    <li class="col-md-2"><a href="#content-list-2"></a><span class="text">创新创业</span></li>
                    <li class="col-md-2"><a href="#content-list-3"></a><span class="text">人力资源服务产业园</span></li>
                    <li class="col-md-2"><a href="#content-list-4"></a><span class="text">高层次人才</span></li>
                    <li class="col-md-2"><a href="#content-list-5"></a><span class="text">政府服务</span></li>
                </ul>
                <div class="content col-md-12">
                    <ul class="content-list">
                        <li class="col-md-12"  id="content-list-1">
                            <ul class="con-list">
                                <li class="str-bg">
                                    <h2>求职<br/>问津</h2>
                                    <a href="#">查看详情 ﹥</a>
                                </li>
                                <li class="str-bg">
                                    <h2>企业<br/>纳贤</h2>
                                    <a href="#">查看详情 ﹥</a>
                                </li>
                                <li>
                                    <ol>
                                        <li><a href="#">创新创业优势</a></li>
                                        <li><a href="#">创新创业优势</a></li>
                                        <li><a href="#">创新创业服务指南</a></li>
                                        <li><a href="#">创新创业申请</a></li>
                                    </ol>
                                </li>
                            </ul>
                        </li>
                        <li class="col-md-12"  id="content-list-2">
                            <ul class="con-list">
                                <li class="str-bg">
                                    <h2>求职<br/>问津</h2>
                                    <a href="#">查看详情 ﹥</a>
                                </li>
                                <li class="str-bg">
                                    <h2>企业<br/>纳贤</h2>
                                    <a href="#">查看详情 ﹥</a>
                                </li>
                                <li>
                                    <ol>
                                        <li><a href="#">创新创业优势</a></li>
                                        <li><a href="#">创新创业优势</a></li>
                                        <li><a href="#">创新创业服务指南</a></li>
                                        <li><a href="#">创新创业申请</a></li>
                                    </ol>
                                </li>
                            </ul>
                        </li>
                        <li class="col-md-12"  id="content-list-3">
                            <ul class="con-list">
                                <li class="str-bg">
                                    <h2>求职<br/>问津</h2>
                                    <a href="#">查看详情 ﹥</a>
                                </li>
                                <li class="str-bg">
                                    <h2>企业<br/>纳贤</h2>
                                    <a href="#">查看详情 ﹥</a>
                                </li>
                                <li>
                                    <ol>
                                        <li><a href="#">创新创业优势</a></li>
                                        <li><a href="#">创新创业优势</a></li>
                                        <li><a href="#">创新创业服务指南</a></li>
                                        <li><a href="#">创新创业申请</a></li>
                                    </ol>
                                </li>
                            </ul>
                        </li>
                        <li class="col-md-12"  id="content-list-4">
                        <ul class="con-list">
                            <li class="str-bg">
                                    <h2>求职<br/>问津</h2>
                                    <a href="#">查看详情 ﹥</a>
                                </li>
                                <li class="str-bg">
                                    <h2>企业<br/>纳贤</h2>
                                    <a href="#">查看详情 ﹥</a>
                                </li>
                            <li>
                                <ol>
                                    <li><a href="#">创新创业优势</a></li>
                                    <li><a href="#">创新创业优势</a></li>
                                    <li><a href="#">创新创业服务指南</a></li>
                                    <li><a href="#">创新创业申请</a></li>
                                </ol>
                            </li>
                        </ul>
                    </li>
                        <li class="col-md-12"  id="content-list-5">
                            <ul class="con-list">
                                <li class="str-bg">
                                    <h2>求职<br/>问津</h2>
                                    <a href="#">查看详情 ﹥</a>
                                </li>
                                <li class="str-bg">
                                    <h2>企业<br/>纳贤</h2>
                                    <a href="#">查看详情 ﹥</a>
                                </li>
                                <li>
                                    <ol>
                                        <li><a href="#">创新创业优势</a></li>
                                        <li><a href="#">创新创业优势</a></li>
                                        <li><a href="#">创新创业服务指南</a></li>
                                        <li><a href="#">创新创业申请</a></li>
                                    </ol>
                                </li>
                            </ul>
                        </li>
                        <!--<li class="col-md-12"  id="content-list-2">-->
                            <!--<div class="txt">-->
                                <!--<h2>创新创业优势</h2>-->
                                <!--<span class="pull-right">YOURS STRENGTHS</span>-->
                            <!--</div>-->
                            <!--<ul class="con-list">-->
                                <!--<li>-->
                                    <!--<a href="#"><i class="icon-comments-alt"></i><span>公共平台</span></a>-->
                                    <!--<p>公共技术平台支撑降低企业研发成本</p>-->
                                <!--</li>-->
                                <!--<li>-->
                                    <!--<a href="#"><i class="icon-comments-alt"></i><span>培训服务</span></a>-->
                                    <!--<p>创业辅导及培训服务</p>-->
                                <!--</li>-->
                                <!--<li>-->
                                    <!--<a href="#"><i class="icon-comments-alt"></i><span>交流平台</span></a>-->
                                    <!--<p>员工就餐、员工宿舍等日常工作生活服务</p>-->
                                <!--</li>-->
                                <!--<li>-->
                                    <!--<a href="#"><i class="icon-comments-alt"></i><span>科技创新基金申报</span></a>-->
                                    <!--<p>每年协助创业场团队成功取得创新基金350万</p>-->
                                <!--</li>-->
                            <!--</ul>-->
                        <!--</li>-->
                        <!--<li class="col-md-12"  id="content-list-3">-->
                            <!--<div class="txt">-->
                                <!--<h2>创新创业优势</h2>-->
                                <!--<span class="pull-right">YOURS STRENGTHS</span>-->
                            <!--</div>-->
                            <!--<ul class="con-list">-->
                                <!--<li>-->
                                    <!--<a href="#"><i class="icon-comments-alt"></i><span>公共平台</span></a>-->
                                    <!--<p>公共技术平台支撑降低企业研发成本</p>-->
                                <!--</li>-->
                                <!--<li>-->
                                    <!--<a href="#"><i class="icon-comments-alt"></i><span>培训服务</span></a>-->
                                    <!--<p>创业辅导及培训服务</p>-->
                                <!--</li>-->
                                <!--<li>-->
                                    <!--<a href="#"><i class="icon-comments-alt"></i><span>交流平台</span></a>-->
                                    <!--<p>员工就餐、员工宿舍等日常工作生活服务</p>-->
                                <!--</li>-->
                                <!--<li>-->
                                    <!--<a href="#"><i class="icon-comments-alt"></i><span>科技创新基金申报</span></a>-->
                                    <!--<p>每年协助创业场团队成功取得创新基金350万</p>-->
                                <!--</li>-->
                            <!--</ul>-->
                        <!--</li>-->
                        <!--<li class="col-md-12"  id="content-list-4">-->
                            <!--<div class="txt">-->
                                <!--<h2>创新创业优势</h2>-->
                                <!--<span class="pull-right">YOURS STRENGTHS</span>-->
                            <!--</div>-->
                            <!--<ul class="con-list">-->
                                <!--<li>-->
                                    <!--<a href="#"><i class="icon-comments-alt"></i><span>公共平台</span></a>-->
                                    <!--<p>公共技术平台支撑降低企业研发成本</p>-->
                                <!--</li>-->
                                <!--<li>-->
                                    <!--<a href="#"><i class="icon-comments-alt"></i><span>培训服务</span></a>-->
                                    <!--<p>创业辅导及培训服务</p>-->
                                <!--</li>-->
                                <!--<li>-->
                                    <!--<a href="#"><i class="icon-comments-alt"></i><span>交流平台</span></a>-->
                                    <!--<p>员工就餐、员工宿舍等日常工作生活服务</p>-->
                                <!--</li>-->
                                <!--<li>-->
                                    <!--<a href="#"><i class="icon-comments-alt"></i><span>科技创新基金申报</span></a>-->
                                    <!--<p>每年协助创业场团队成功取得创新基金350万</p>-->
                                <!--</li>-->
                            <!--</ul>-->
                        <!--</li>-->
                        <!--<li class="col-md-12"  id="content-list-5">-->
                            <!--<div class="txt">-->
                                <!--<h2>创新创业优势</h2>-->
                                <!--<span class="pull-right">YOURS STRENGTHS</span>-->
                            <!--</div>-->
                            <!--<ul class="con-list">-->
                                <!--<li>-->
                                    <!--<a href="#"><i class="icon-comments-alt"></i><span>公共平台</span></a>-->
                                    <!--<p>公共技术平台支撑降低企业研发成本</p>-->
                                <!--</li>-->
                                <!--<li>-->
                                    <!--<a href="#"><i class="icon-comments-alt"></i><span>培训服务</span></a>-->
                                    <!--<p>创业辅导及培训服务</p>-->
                                <!--</li>-->
                                <!--<li>-->
                                    <!--<a href="#"><i class="icon-comments-alt"></i><span>交流平台</span></a>-->
                                    <!--<p>员工就餐、员工宿舍等日常工作生活服务</p>-->
                                <!--</li>-->
                                <!--<li>-->
                                    <!--<a href="#"><i class="icon-money"></i><span>科技创新基金申报</span></a>-->
                                    <!--<p>每年协助创业场团队成功取得创新基金350万</p>-->
                                <!--</li>-->
                            <!--</ul>-->
                        <!--</li>-->
                    </ul>
                </div>
                <a class="next-section yellow-color" href="#contact"><i class="fa fa-angle-down"></i></a>
            </div>
        </div>
</section>

<section id="contact" class="panel">
    <div class="container">
        <div class="row">
            <h1>联系我们</h1>
            <ul class="contact-list">
                <li class="col-md-4"><a href="#"><i class="fa fa-envelope"></i><span>cdcyy@gxq.com</span></a></li>
                <li class="col-md-4"><a href="#"><i class="fa fa-phone"></i><span>028-61888166</span></a></li>
                <li class="col-md-4"><a href="#"><i class="fa fa-map-marker"></i><span>锦城大道366号3号楼</span></a></li>
            </ul>

        </div>
    </div>
</section>

<section id="footer" class="panel">
    <div class="container">
        <div class="row">
            <ul class="lin">
                <li class="col-md-3">
                    <h6>友情链接</h6>
                    <ul class="link-list">
                        <li><a href="#">四川省人民政府</a></li>
                        <li><a href="#">四川省科技厅</a></li>
                        <li><a href="#">四川省教育厅</a></li>
                        <li><a href="#">中国气象局</a></li>
                        <li><a href="#">国家统计局</a></li>
                        <li><a href="#">省研究生创新网</a></li>
                        <li><a href="#">万达信息股份有限公司</a></li>
                    </ul>
                </li>
                <li class="col-md-3">
                    <h6>网站导航</h6>
                    <ul  class="link-list">
                        <li><a href="#">园区导引</a></li>
                        <li><a href="#">离岸创新创业</a></li>
                        <li><a href="#">人力资源服务</a></li>
                        <li><a href="#">企业入区</a></li>
                        <li><a href="#">园区管理机构</a></li>
                        <li><a href="#">省研究生创新网</a></li>
                        <li><a href="#">地图导航</a></li>
                    </ul>
                </li>
                <li class="col-md-3">
                    <h6>园区服务</h6>
                    <ul  class="link-list">
                        <li><a href="#">园区政策</a></li>
                        <li><a href="#">园区机会</a></li>
                        <li><a href="#">园区日常管理制度规范</a></li>
                        <li><a href="#">园区全景图</a></li>
                        <li><a href="#">园区背景</a></li>
                        <li><a href="#">规划管理设计</a></li>
                        <li><a href="#">地理区位</a></li>
                    </ul>
                </li>
                <li class="col-md-3">
                    <h6>关注微信</h6>
                    <img src="<@static value='/imgs/r-code.png'/>">
                    <span>微信号：gxqrlzycyy</span>
                </li>
            </ul>
            <div class="to-top"><img src="<@static value='/imgs/to-top.png'/>" class="img-responsive"></div>
        </div>
    </div>
    <p>©2016 中国成都人力资源服务产业园 | 蜀ICP备10048374号 ｜ 蜀公网安备11010102123456号</p>
</section>



<script>

    /*页面跳转*/
    $('.next-section').click(function(){
        $("html, body").animate({
            scrollTop: $($(this).attr("href")).offset().top + "px"
        }, {
            duration: 500,
            easing: "swing"
        });
        return false;
    });

    /*鼠标滚动*/
    $.scrollify({
        section:".panel",
        speed:'500'
    });
        
        

    /*scroll to top*/
    $(".to-top").click(function () {
        $('html, body').animate({ scrollTop: 0 }, 400);
        return false;
    });

</script>
</body>
</html>