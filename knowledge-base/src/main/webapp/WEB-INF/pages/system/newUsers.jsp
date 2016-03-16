<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商品列表</title>
<link rel="stylesheet" href="/resources/css/common.css" />

<script src="/resources/js/jquery/jquery-1.10.2.js" type="text/javascript"></script>
<script src="/resources/js/layer/v21/layer.js" type="text/javascript"></script>
<script src="/resources/js/siping/siping.js" type="text/javascript"></script>
<script src="/resources/js/siping/system/system.js" type="text/javascript"></script>

<style>
body {
    _background: url(about:blank) fixed;
}
.fixable {
    position:fixed;
    top:100px;
    _position:absolute;
    _top:expression((document).documentElement.scrollTop+100);
}
</style>
</head>
<body>
<div class="list_page">
    <div class="search_section">
        <div class="partner_text_div common_text_div">
            <div class="common_text_title">关键字</div>
            <div class="common_text_val">
                <input id="product_name_key" class="input_text_common my_radius" data-click-tip="名称关键字" placeholder="商品名称" >
                <button class="btn_common my_radius btn_search" onclick="getProductList(1, 10);">查询</button>
                <button class="btn_common my_radius btn_search" onclick="deleteKnow();">删除</button>
                <button class="btn_common my_radius btn_search" onclick="numKnow();">修改</button>
            </div>
        </div>
    </div>
    <div id="product_list_grid"></div>
</div>
</body>
</html>