<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>问题列表</title>
<link rel="stylesheet" href="/resources/css/common.css" />

<script src="/resources/js/jquery/jquery-1.10.2.js" type="text/javascript"></script>
<script src="/resources/js/layer/v21/layer.js" type="text/javascript"></script>
<script src="/resources/js/siping/siping.js" type="text/javascript"></script>
<script src="/resources/js/siping/problem/problemDetail.js" type="text/javascript"></script>
</head>
<body>
<div class="list_page">
    <div class="search_section">
        <div class="partner_text_div common_text_div">
        	<div class="common_text_title"></div>
            <div class="common_text_val">
            	<input type="hidden" id="problem_id" value="${problem.id }">
                                        标题：<input id="problem_theme" class="input_text_common my_radius" data-click-tip="名称关键字" placeholder="标题" value="${problem.theme }" /><br />
                                        内容：<input id="problem_content" class="textarea_common my_radius" data-click-tip="名称关键字" dat="你好" placeholder="内容" value="${problem.content }"/><br />
                                        提问人昵称：<input id="problem_theme" class="input_text_common my_radius" data-click-tip="名称关键字" placeholder="标题" value="${problem.nickName }" /><br />
                                        提问时间：<input id="problem_date" class="input_text_common my_radius" value="${problem.problemDate }" />
            </div>
        </div>
    </div>
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <div id="answer_list_grid"></div>
    <br />
    <div class="search_section">
        <div class="partner_text_div common_text_div">
            <div class="common_text_title">回答问题</div>
            <div class="common_text_val">
                <input id="answer_content" class="textarea_common my_radius" data-click-tip="名称关键字" placeholder="内容" >
                <button class="btn_common my_radius btn_submit" onclick="submitAnswer();">回答</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>