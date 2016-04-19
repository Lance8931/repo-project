<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>图片切换幻灯片</title>
<@css href="css/bootstrap/style.css"/>
<@js src="js/UEditor/third-party/jquery-1.10.2.js"/>
</head>

<body>
<script type="text/javascript">
	$(function (){
		$.ajax({
				url:'getlist',
				type:'GET',
				contentType:"application/json",
				success: function(data){
				    var obj = eval(data);
				    $('#homeImageChg div img').attr('src', '../../static/imgs/' + obj[0].picPath);
					for(var i=0; i<obj.length; i++){
						var image_str = '<li class="num'+i+' img"><a href="'+obj[i].url+'" target＝> <img src="'+ '../../static/imgs/' + obj[i].picPath +'" alt="'+obj[i].picPath+'" title="'+obj[i].picPath+'"/></li>';
						$('#homeImageChg').append(image_str);
					}
				}
			});
	});
</script>

<center>
<section id="rt-showcase-surround">
    <div id="rt-showcase" class="slider-container rt-overlay-dark">
        <div class="rt-container slider-container">
            <div class="rt-grid-12 rt-alpha rt-omega">
                
                
                <!--[if IE]><link rel="stylesheet" href="css/ie.css"><![endif]-->
                <!--[if lte IE 9]><script type="text/javascript" src="js/ie.js"></script><![endif]-->

                <div class="csslider1 autoplay">
                    <input name="cs_anchor1" autocomplete="off" id="cs_slide1_0" type="radio" class="cs_anchor slide" >
                    <input name="cs_anchor1" autocomplete="off" id="cs_slide1_1" type="radio" class="cs_anchor slide" >
                    <input name="cs_anchor1" autocomplete="off" id="cs_slide1_2" type="radio" class="cs_anchor slide" >
                    <input name="cs_anchor1" autocomplete="off" id="cs_play1" type="radio" class="cs_anchor" checked>
                    <input name="cs_anchor1" autocomplete="off" id="cs_pause1" type="radio" class="cs_anchor" >
                    <ul id='homeImageChg'>
                        <div style="width: 100%; visibility: hidden; font-size: 0px; line-height: 0;">
                            <img src="" style="width: 100%;">
                        </div>
                    
                    </ul>
                    <div class="cs_description">
                        <label class="num0">
                            <span class="cs_title"><span class="cs_wrapper">Clouds</span></span>
                            
                        </label>
                        <label class="num1">
                            <span class="cs_title"><span class="cs_wrapper">Typewriter</span></span>
                            
                        </label>
                        <label class="num2">
                            <span class="cs_title"><span class="cs_wrapper">Bicycle</span></span>
                            
                        </label>
                    </div>
                    
                    <div class="cs_arrowprev">
                        <label class="num0" for="cs_slide1_0"></label>
                        <label class="num1" for="cs_slide1_1"></label>
                        <label class="num2" for="cs_slide1_2"></label>
                    </div>
                    <div class="cs_arrownext">
                        <label class="num0" for="cs_slide1_0"></label>
                        <label class="num1" for="cs_slide1_1"></label>
                        <label class="num2" for="cs_slide1_2"></label>
                    </div>
                    
                    <div class="cs_bullets">
                        <label class="num0" for="cs_slide1_0">
                            <span class="cs_point"></span>
                            <span class="cs_thumb"><img src="" alt="Clouds" title="Clouds" /></span>
                        </label>
                        <label class="num1" for="cs_slide1_1">
                            <span class="cs_point"></span>
                            <span class="cs_thumb"><img src="" alt="Typewriter" title="Typewriter" /></span>
                        </label>
                        <label class="num2" for="cs_slide1_2">
                            <span class="cs_point"></span>
                            <span class="cs_thumb"><img src="" alt="Bicycle" title="Bicycle" /></span>
                        </label>
                    </div>
                    
                </div>

            </div>
            <div class="clear"></div>
        </div>
    </div>
</section>        <!-- /slider -->
</center>

</body>
</html>
