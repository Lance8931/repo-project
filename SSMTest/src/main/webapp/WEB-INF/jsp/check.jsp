<%@ page language="java" pageEncoding="utf-8"%>  
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<script type="text/javascript" src="/SSMTest/resources/jquery-2.2.1.min.js" charset="utf-8" ></script>
	</head>
<body>
	<script type="text/javascript">
		function check(){
			$("#region p span").each(function (){
				var reg=new RegExp('^[0123456789]','g');
				var kkk = $(this);
				if(!reg.test($(this).text())){
					$.ajax({
						url:"/SSMTest/user/check",
						data:{area:$(this).text(),areaID:$(this).prev().text()},
						success:function(result){
							kkk.text(kkk.text()+"   "+result.msg);
						}
					});
				}
				
			});
		}
		
		function insert(){
			$("#region p span").each(function (){
				var reg=new RegExp('^[0123456789]','g');
				var kkk = $(this);
				if(!reg.test($(this).text())){
					$.ajax({
						url:"/SSMTest/user/add",
						data:{name:$(this).text(),id:$(this).prev().text()},
						success:function(result){
							kkk.text(kkk.text()+"   "+result.msg);
						}
					});
				}
				
			});
		}
	</script>
	<div>
		<button onclick="check()">验证</button>
		<button onclick="insert()">插入</button>
	</div>
	<div id="region">
		<jsp:include page="check_anhui.jsp" />
		<jsp:include page="check_beijing.jsp" />
		<jsp:include page="check_chongqing.jsp" />
		<jsp:include page="check_fujian.jsp" />
		<jsp:include page="check_gansu.jsp" />
		<jsp:include page="check_guangdong.jsp" />
		<jsp:include page="check_guangxi.jsp" />
		<jsp:include page="check_guizhou.jsp" />
		<jsp:include page="check_hainan.jsp" />
		<jsp:include page="check_hebei.jsp" />
		<jsp:include page="check_heilongjiang.jsp" />
		<jsp:include page="check_henan.jsp" />
		<jsp:include page="check_hubei.jsp" />
		<jsp:include page="check_hunan.jsp" />
		<jsp:include page="check_jiangsu.jsp" />
		<jsp:include page="check_jiangxi.jsp" />
		<jsp:include page="check_jilin.jsp" />
		<jsp:include page="check_liaoning.jsp" />
		<jsp:include page="check_neimeng.jsp" />
		<jsp:include page="check_ningxia.jsp" />
		<jsp:include page="check_qinghai.jsp" />
		<jsp:include page="check_shangdong.jsp" />
		<jsp:include page="check_shanghai.jsp" />
		<jsp:include page="check_shanxi.jsp" />
		<jsp:include page="check_shanxi1.jsp" />
		<jsp:include page="check_sichuan.jsp" />
		<jsp:include page="check_tianjin.jsp" />
		<jsp:include page="check_xinjiang.jsp" />
		<jsp:include page="check_xizang.jsp" />
		<jsp:include page="check_yunnan.jsp" />
		<jsp:include page="check_zhejiang.jsp" />
	</div>
</body>
</html>
