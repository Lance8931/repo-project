<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商品列表</title>
<link rel="stylesheet" href="/ExcelImport/resources/css/common.css" />

<script src="/ExcelImport/resources/js/jquery/jquery-1.10.2.js" type="text/javascript"></script>
<script src="/ExcelImport/resources/js/layer/v21/layer.js" type="text/javascript"></script>
<script src="/ExcelImport/resources/js/siping/siping.js" type="text/javascript"></script>
<script src="/ExcelImport/resources/js/siping/export/list.js" type="text/javascript"></script>
</head>
<body>
<div class="list_page">
    <div class="search_section">
        <div class="partner_text_div common_text_div">
            <div class="common_text_val">
                <input id="product_name_key" class="input_text_common my_radius" style="display:none" value="${tableName }" >
                <button class="btn_common my_radius btn_search" onclick="check();">审核</button>
            </div>
        </div>
    </div>
    <div id="product_list_grid"></div>
</div>
</body>
</html>