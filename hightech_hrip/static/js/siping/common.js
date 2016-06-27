function loadData(type, url, data, contentType) {
    if(!contentType) {contentType = "application/x-www-form-urlencoded";}
    var datas = null;
    $.ajax({
        type : type,
        url : createUrl(url),
        async : false,
        data : data,
        dataType : "json",
        contentType : contentType,
        success : function(result) {
//            if(typeof result == 'string'){throw new Error('loadData方法的返回结果应为object类型，而不是string类型');}
            datas = result.records;
        }
    });
    return datas;
};
String.prototype.replaceStr = function(original, begin, end, replacement) {
    var m = original.substr(0, begin);
    var n = original.substring(end, original.length);
    return m + replacement + n;
};
Array.prototype.contains = function(item){
    return RegExp(item).test(this);
};
Date.prototype.Format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
};

/**
 * 初始化企业类型
 */
function initOrgType(){
    $.ajax({
        type:'GET',
        url:createUrl('userOrg/type/list'), 
        contentType:'application/json',
        success:function(data){
            if($('#orgTypeId :first') !== undefined){
                var key = $('#orgTypeId :first').val();
                $('#orgTypeId :first').text(data[key]);
            }
            for(i in data){
                $('#orgTypeId').append('<option value="' + i + '">' + data[i] + '</option>');
            }
        }
    });
}

/**
 * 初始化省份
 */
function initProvinceSelect(){
    var datas = loadData('post','area/getAreaDatas',null,'application/json');
    for(var i = 0; i < datas.length; i++){
        $("#selectProvince").append('<option value="'+datas[i].value+'">'+datas[i].name+'</option>');
    }
}

/**
 * 省市县联动-县、市变化
 * 
 * @param selector 当前值变化的select
 * @param selecType 当前值变化的selectType
 */
function changeSelectArea(selector, selectType) {
    var value = selector[selector.selectedIndex].value;
    var text = selector[selector.selectedIndex].text;
    var datas = loadData('post', 'area/getAreaDatas', {
        parentId : value,
        type : selectType
    });
    var selectCityLength = $("#selectCity").length;
    if (!selectCityLength > 0) {// 判断是否存在City的下拉框，不存在则添加
        $("#divProvince")
                .after(
                        '<div class="col-lg-1" id="divCity">' + '<select class="form-control" id="selectCity" name="city" onChange="changeSelectArea(this,\'city\')">'
                                + '<option>请选择市</option></select></div>');
    }
    if (text == '北京市' || text == '天津市' || text == '上海市' || text == '重庆市' || selectType == 'city') {
        if (selectType != 'city') {
            $("#divCity").remove();// 在直辖市下去除City选项
        }
        $("#selectCounty").empty();
        $("#selectCounty").append('<option>请选择区/县</option>');
        for (var i = 0; i < datas.length; i++) {
            $("#selectCounty").append('<option value="' + datas[i].value + '">' + datas[i].name + '</option>');
        }
    } else {
        $("#selectCity").empty();
        $("#selectCounty").empty();
        $("#selectCity").append('<option>请选择市</option>');
        $("#selectCounty").append('<option>请选择区/县</option>');
        for (var i = 0; i < datas.length; i++) {
            $("#selectCity").append('<option value="' + datas[i].value + '">' + datas[i].name + '</option>');
        }
    }
}

/**
 * 列表页面按钮控制方法
 * @param tableId 表格id，需带#号，例如：'#tableId'     
 * @param editId 编辑按钮id
 * @param deleteId 删除按钮id
 */
function buttonControl(tableId, editId, deleteId){
    var index = $(tableId).bootstrapTable('getSelections').length;
    if(index > 1){
        $(editId).attr("disabled", true);
        $(deleteId).attr("disabled", false);
        return;
    }
    switch(index){
        case 0:
            $(editId).attr("disabled", true);
            $(deleteId).attr("disabled", true);
            break;
        case 1:
            $(editId).attr("disabled", false);
            $(deleteId).attr("disabled", false);
            break;
    }
}

function chgOrgSelectArea(selector,selectType){
    var value = selector[selector.selectedIndex].value;
    var text = selector[selector.selectedIndex].text;
    var datas = loadData('post','area/getAreaDatas',{parentId:value,type:selectType});
    var selectCityLength = $("#selectCity").length;
    if(!selectCityLength > 0){//判断是否存在City的下拉框，不存在则添加
        $("#divProvince").after('<div class="btn-group col-sm" id="divCity">'
        +'<select class="form-control" id="selectCity" name="city" onChange="changeSelectArea(this,\'city\')">'
        +'<option value=" ">--所属市--</option></select></div>');
    }
    if(text == '北京市' || text == '天津市'
        || text == '上海市' || text == '重庆市' 
            || selectType == 'city'){
        if(selectType != 'city'){
            $("#divCity").remove();//在直辖市下去除City选项
        }
        $("#selectCounty").empty();
        $("#selectCounty").append('<option  value="">--所属区/县--</option>');
        for(var i = 0; i < datas.length; i++){
            $("#selectCounty").append('<option value="'+datas[i].value+'">'+datas[i].name+'</option>');
        }
    }else{
        $("#selectCity").empty();
        $("#selectCounty").empty();
        $("#selectCity").append('<option  value="">--所属市--</option>');
        $("#selectCounty").append('<option  value="">--所属区/县--</option>');
        for(var i = 0; i < datas.length; i++){
            $("#selectCity").append('<option value="'+datas[i].value+'">'+datas[i].name+'</option>');
        }
    }
}













