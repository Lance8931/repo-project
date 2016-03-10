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
<script src="/resources/js/siping/problem/listProblems.js" type="text/javascript"></script>
</head>
<body>
<div class="list_page">
    <div class="search_section">
        <div class="partner_text_div common_text_div">
            <div class="common_text_title">发表问题</div>
            <div class="common_text_val">
                <input id="problem_theme" class="input_text_common my_radius" data-click-tip="名称关键字" placeholder="标题" ><br>
                <input id="problem_content" class="textarea_common my_radius" data-click-tip="名称关键字" dat="你好" placeholder="内容" >
                <button class="btn_common my_radius btn_submit" onclick="submitProblem();">发布</button>
            </div>
        </div>
    </div>
    <br />
    <br />
    <br />
    <br />
    <br />
    <div class="search_section">
        <div class="partner_text_div common_text_div">
            <div class="common_text_title">关键字</div>
            <div class="common_text_val">
                <input id="problem_theme_search" class="input_text_common my_radius" data-click-tip="请输入标题" placeholder="标题" ><br>
                <button class="btn_common my_radius btn_search" onclick="getProblemList(1,10);">搜索</button>
                <button class="btn_common my_radius btn_submit" onclick="getOneProblem();">单个问题</button>
                
            </div>
        </div>
    </div>
    <br />
    <br />
    <br />
    <br />
    <br />
    <div id="problem_list_grid"></div>
</div>
</body>
</html>