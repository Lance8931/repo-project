$(function(){
	getProductList(1,10);
});
function getProductList(pageNo, pageSize){
    sipingUI.fillGrid({
        gridId : "product_list_grid",
        height : "520px",
        ajax : {
            type : "post",
            url : "/product/getlist/data",
            async : true, 
            data: {pageNo:pageNo, pageSize:pageSize, keyword: $("#product_name_key").val()},
            contentType : 'application/json'
        },
        header : [
              {width : "10%",name : "商品货号"},
              {width : "10%",name : "国际编码"},
              {width : "20%",name : "商品名称"},
              {width : "10%",name : "商品类型"},
              {width : "10%",name : "单位"},
              {width : "10%",name : "品牌"},
              {width : "10%",name : "规格"},
              {width : "10%",name : "有效期限"},
              {width : "10%",name : "添加时间"}
        ],
        column : ["materialNo","barcode","materialName","typeName","unitName","brand","specification","expirationDate","addTime"],
        page : {options : [10,20,30,50,80], fn : "getProductList"},
        rowNum : true
    });
}