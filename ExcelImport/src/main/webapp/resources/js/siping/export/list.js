$(function(){
	getProductList(1,10);
});
function getProductList(pageNo, pageSize){
    sipingUI.fillGrid({
        gridId : "product_list_grid",
        height : "520px",
        ajax : {
            type : "post",
            url : "/ExcelImport/getlist",
            async : true, 
            data: {pageNo:pageNo, pageSize:pageSize, keyword: $("#product_name_key").val()},
            contentType : 'application/json'
        },
        header : [
              {width : "10%",name : "商品货号"},
              {width : "20%",name : "商品名称"},
              {width : "10%",name : "外国名称"},
              {width : "5%",name : "商品类型"},
              {width : "5%",name : "品牌"},
              {width : "5%",name : "规格"},
              {width : "5%",name : "季节"},
              {width : "5%",name : "是否采购"},
              {width : "5%",name : "是否销售"},
              {width : "5%",name : "是否有存货"},
              {width : "5%",name : "单位"},
              {width : "10%",name : "国际编码"}
        ],
        column : ["materialNo","materialName","foreignName","materialType","brand","specificationsModel",
                  "season","isPurchase","isSell","isInventory","unitId","barcode"],
        page : {options : [10,20,30,50,80], fn : "getProductList"},
        rowNum : true
    });
}