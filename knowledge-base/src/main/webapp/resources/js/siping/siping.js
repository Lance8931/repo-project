//存放分页参数的全局变量
var _pageParam = {pageNo : 1,pageSize : 10,totalRecords : 0,totalPages : 1};
var _orderColumnWidth = 30;
//替换从begin到end的字符串
String.prototype.replaceStr = function(begin, end, replacement) {
    if(begin > end){throw new Error('"begin" must be greater than "end"!');}
    if(isNaN(begin) || isNaN(end)){throw new Error('"begin" and "end" must be numerical !');}
    var m = this.substring(0, begin);
    var n = this.substring(end+1, this.length);
    return m + replacement + n;
};
//存放私有方法
var OwnMethod = function(){
    this._getPageHtml = function(pageNo, pageSize, totalRecords, totalPages, pageFn, options){
        if(!pageFn){throw new Error('"fn" is undefined for attribute "page"');}
        var first0 = "/resources/icons/first0.png",
            previous0 = "/resources/icons/previous0.png",
            first = "/resources/icons/first.png",
            previous1 = "/resources/icons/previous1.png",
            next0 = "/resources/icons/next0.png",
            last0 = "/resources/icons/last0.png",
            next1 = "/resources/icons/next1.png",
            last = "/resources/icons/last.png";
        var pageHtml = '<div class="page_nav"><div class="page_sizes"><span>显示条数</span>'+
            '<select class="my_radius" id="_selected_page_size" onchange="'+pageFn+'('+1+',this.value)">';
        if(options){
            for(var i=0;i<options.length;i++){
                pageHtml += '<option value="'+options[i]+'">'+options[i]+'</option>';
            }
        }else{
            pageHtml += '<option selected="selected" value="10">10</option><option value="20">20</option><option value="30">30</option>'+
                '<option value="50">50</option><option value="80">80</option>';
        }
        pageHtml += '</select></div><div class="page_ctrol">';
        if (pageNo == 1) {
            pageHtml += '<span><img src="'+first0+'"></span>';
            pageHtml += '<span><img src="'+previous0+'"></span>';
        }else{
            pageHtml += '<span><a onclick="'+pageFn+'(1,'+pageSize+')"><img src="'+first+'"></a></span>';
            pageHtml += '<span><a onclick="'+pageFn+'('+(pageNo-1)+','+pageSize+')"><img src="'+previous1+'"></a></span>';
        }
        pageHtml += '<span>第&nbsp;<font id="_current_page_num">'+pageNo+'</font>&nbsp;页</span>';
        if (pageNo >= totalPages) {
            pageHtml += '<span><img src="'+next0+'"></span>';
            pageHtml += '<span><img src="'+last0+'"></span>';
        }else{
            pageHtml += '<span><a onclick="'+pageFn+'('+(pageNo+1)+','+pageSize+')"><img src="'+next1+'"></a></span>';
            pageHtml += '<span><a onclick="'+pageFn+'('+totalPages+','+pageSize+')"><img src="'+last+'"></a></span>';
        }
        pageHtml += '<span>共&nbsp;<font id="total_pages_cnts">'+totalPages+'</font>&nbsp;页</span></div>';
        pageHtml += '<div class="page_to"><span>共&nbsp;<font id="_total_records_cnt">'+totalRecords+'</font>&nbsp;条</span></div></div>';
        return pageHtml;
    };
    this._formatStrToNumber = function(str){
        if(str.indexOf("%") == -1 && str.toLowerCase().indexOf("px") == -1){
            return Number(str);
        }else if(str.indexOf("%") != -1){
            return Number(str.substring(0, str.indexOf("%")))/100;
        }else if(str.toLowerCase().indexOf("px") != -1){
            return Number(str.substring(0, str.toLowerCase().indexOf("px")));
        }
    };
    this._restructureHeader = function(gridId, header, isOrder){
        var headerObj = new Object();
        var width = 0;
        var gridWidth = $("#"+gridId).width();
        if(isOrder){
            width = width + _orderColumnWidth;
            gridWidth = gridWidth - _orderColumnWidth;
        }
        for(var i=0;i<header.length;i++){
            var colWidth = header[i].width;
            if(colWidth.indexOf("%") != -1){
                var factor = this._formatStrToNumber(colWidth);
                colWidth = gridWidth * factor;
            }else{
                colWidth = this._formatStrToNumber(colWidth);
            }
            header[i].width = Math.floor(colWidth);
            width += Math.floor(colWidth);
        }
        headerObj.header = header;
        headerObj.width = width;
        return headerObj;
    };
};
var sipingUI = {
    ajax : function(opt) {
        index = layer.load(2, {
            time : 5 * 1000
        });
        function fn() {}
        var url = opt.url || "", async = opt.async !== false, type = opt.type || 'GET', datas = opt.data || null, success = opt.success || fn;
        var contentType = opt.contentType || "application/x-www-form-urlencoded";
        $.ajax({
            type : type,
            url : url,
            async : async,
            data : datas,
            dataType : "json",
            contentType : contentType,
            success : function(data) {
                layer.close(index);
                success(data);
            }
        });
    },
    fillGrid : function(opt){
        var ownMethod = new OwnMethod();
        var loadIndex = layer.load(2, { time : 30 * 1000 });
        var content = opt.gridId;
        var width = opt.width || '100%';
        var height = opt.height || '420px';
        var ajax = opt.ajax;
        var header = opt.header;
        var dataColumn = opt.column;
        var page = opt.page;
        var method = ajax.type || 'get';
        var async = ajax.async !== false;
        var isOrder = opt.rowNum !== false;
        var isEdit = opt.isEdit == true;
        var resetPass = opt.resetPass == true;
        var contentType = ajax.contentType || 'application/x-www-form-urlencoded';
        var data = ajax.data;
        var checkbox = opt.checkbox;
        if(contentType == "application/json"){
            data = JSON.stringify(ajax.data);
        }
        var headerObj = ownMethod._restructureHeader(content, header, isOrder);
        width = headerObj.width + "px";
        var gridHtml = '<div id="_grid_box" style="overflow-x:auto;"><div id="_grid_header_box" style="width: '+width+';"><table style="width: 100%;"><thead><tr>';
        if(isOrder){
            gridHtml += '<td style="width: '+_orderColumnWidth+'px;text-align:center;"></td>';
        }
        for(var i=0;i<headerObj.header.length;i++){
            gridHtml += '<td style="width:'+headerObj.header[i].width+'px;"><div class="lf_table_cell_padding">'+headerObj.header[i].name+'</div></td>';
        }
        gridHtml += '</tr></thead></table></div><div id="_grid_body_box" style="overflow-y:auto;width: '+width+';height:'+height+';"><table style="width: 100%;"><tbody></tbody></table></div></div>';
        $("#"+content).html(gridHtml);
        var grid_width = $("#"+content + " #_grid_box").width();
        var pageBoxWidth = headerObj.width > grid_width ? grid_width : headerObj.width;
        var pageBox = '<div id="_page_model_box" style="width: '+pageBoxWidth+'px"></div>';
        $("#"+content).append(pageBox);
        if(page){
            var pageFn = page.fn;
            var options = page.options;
            var pageHtml = ownMethod._getPageHtml(_pageParam.pageNo, _pageParam.pageSize, _pageParam.totalRecords, _pageParam.totalPages, pageFn, options);
            $("#_page_model_box").html(pageHtml);
            $("#_selected_page_size").val(_pageParam.pageSize);
        }
        var headerHeight = $('#'+content+' #_grid_header_box').height();
        var pageHeight = 0;
        if(page){
            pageHeight = $("#_page_model_box").height();
        }
        if(height.indexOf("%") != -1){
            var factor = ownMethod._formatStrToNumber(height);
            height = $("body").height() * factor - headerHeight - pageHeight + "px";
        }else{
            height = ownMethod._formatStrToNumber(height) - headerHeight - pageHeight + "px";
        }
        $('#'+content+' #_grid_body_box').css("height",height);
        $.ajax({
            type : method,
            url : ajax.url,
            async : async,
            data : data,
            dataType : "json",
            contentType : contentType,
            success : function(data) {
                setTimeout(function() {
                    layer.close(loadIndex);
                    var rowData = data.rows;
                    var rowHtml = "";
                    for(var i=0;i<rowData.length;i++){
                        if(isOrder){
                            rowHtml += '<tr><td style="width: '+_orderColumnWidth+'px;text-align: center;color: rgb(94, 94, 247);">'+(i+1)+'</td>';
                        }else{
                            rowHtml += '<tr>';
                        }
                        for(var j=0;j<dataColumn.length;j++){
                            var col = dataColumn[j];
                            if(typeof col == "string"){
                                var celldata = rowData[i][col];
                                if(celldata == null || celldata == undefined){ celldata = ""; }
                                if(typeof celldata == "number"){
                                    celldata = Number(celldata);;
                                    celldata = Math.round(celldata*100)/100;
                                }
                                rowHtml += '<td style="width:'+headerObj.header[j].width+'px;"><div class="lf_table_cell_padding">'+celldata+'</div></td>';
                            }
                        }
                        if(isEdit){
                            rowHtml += '<td style="width:280px;"><button class="btn_common my_radius btn_search" onclick="examineUser('+rowData[0]["id"]+',1);">通过</button>'
                            +'&nbsp;&nbsp;<button class="btn_common my_radius btn_search" onclick="examineUser('+rowData[i]["id"]+',3);">不通过</button></td>';
                        }
                        if(resetPass){
                            rowHtml += '<td style="width:140px;"><button class="btn_common my_radius btn_chong" onclick="resetPass('+rowData[i]["id"]+');">重置密码</button>';
                        }
                        rowHtml += '</tr>';
                    }
                    $("#"+content).find("tbody").html(rowHtml);
                    if(page){
                        var pageNo = data.pageNo;
                        var pageSize = data.pageSize;
                        var totalRecords = data.total;
                        var pageFn = page.fn;
                        var options = page.options;
                        var totalPages = parseInt((totalRecords + pageSize -1)/pageSize);
                        var pageHtml = ownMethod._getPageHtml(pageNo, pageSize, totalRecords, totalPages, pageFn, options);
                        $("#_page_model_box").html(pageHtml);
                        $("#_selected_page_size").val(pageSize);
                        _pageParam = {pageNo : pageNo,pageSize : pageSize,totalRecords : totalRecords,totalPages : totalPages};
                    }
                    //判断是否出现竖轴滚动条，若出现则header也显示竖直滚动条
                    var divHeight = $('#'+content+' #_grid_body_box').height();
                    var tableHeight = $('#'+content+' #_grid_body_box table').height();
                    if(tableHeight > divHeight){
                        $('#'+content+' #_grid_header_box').css({"overflow-y":"scroll","overflow-x":"hidden"});
                    }
                }, 500);
            }
        });
    },
    fillSelect : function(opt){
        var id = opt.id;
        var type = opt.type;
        var url = opt.url;
        var param = opt.param;
        if(!param){param = null;}
        var optionValue = opt.optionValue;
        var optionText = opt.optionText;
        $.ajax({
            type : type,
            url : createUrl(url),
            async : true,
            data : param,
            dataType : "json",
            success : function(data) {
                var options = '<option value="">--请选择--</option>';
                for(var i=0;i<data.length;i++){
                    options += '<option value="'+data[i][optionValue]+'">'+data[i][optionText]+'</option>';
                }
                $("#"+id).append(options);
            }
        });
    },
    fillGridBySelf:function(opt){
        var ownMethod = new OwnMethod();
        var loadIndex = layer.load(2, { time : 30 * 1000 });
        var content = opt.gridId;
        var width = opt.width || '100%';
        var height = opt.height || '420px';
        var ajax = opt.ajax;
        var header = opt.header;
        var dataColumn = opt.column;
        var page = opt.page;
        var method = ajax.type || 'get';
        var async = ajax.async !== false;
        var isOrder = opt.rowNum !== false;
        var isCheck = opt.checkBox != false; // 是否有CheckBox控件
        var contentType = ajax.contentType || 'application/x-www-form-urlencoded';
        var data = ajax.data;
        var checkbox = opt.checkbox;
        if(contentType == "application/json"){
            data = JSON.stringify(ajax.data);
        }
        var headerObj = ownMethod._restructureHeader(content, header, isOrder);
        width = headerObj.width + "px";
        var gridHtml = '<div id="_grid_box" style="overflow-x:auto;"><div id="_grid_header_box" style="width: '+width+';"><table style="width: 100%;"><thead><tr>';
        if(isOrder){
            gridHtml += '<td style="width: '+_orderColumnWidth+'px;text-align:center;"></td>';
        }
        if(isCheck){
            gridHtml += '<td style="width: '+_orderColumnWidth+'px;"><input name="checkBoxs" onclick="mm(this)" type="checkBox"></td>';
        }
        for(var i=0;i<headerObj.header.length;i++){
            gridHtml += '<td style="width:'+headerObj.header[i].width+'px;"><div class="lf_table_cell_padding">'+headerObj.header[i].name+'</div></td>';
        }
        gridHtml += '</tr></thead></table></div><div id="_grid_body_box" style="overflow-y:auto;width: '+width+';height:'+height+';"><table style="width: 100%;"><tbody></tbody></table></div></div>';
        $("#"+content).html(gridHtml);
        var grid_width = $("#"+content + " #_grid_box").width();
        var pageBoxWidth = headerObj.width > grid_width ? grid_width : headerObj.width;
        var pageBox = '<div id="_page_model_box" style="width: '+pageBoxWidth+'px"></div>';
        $("#"+content).append(pageBox);
        if(page){
            var pageFn = page.fn;
            var options = page.options;
            var pageHtml = ownMethod._getPageHtml(_pageParam.pageNo, _pageParam.pageSize, _pageParam.totalRecords, _pageParam.totalPages, pageFn, options);
            $("#_page_model_box").html(pageHtml);
            $("#_selected_page_size").val(_pageParam.pageSize);
        }
        var headerHeight = $('#'+content+' #_grid_header_box').height();
        var pageHeight = 0;
        if(page){
            pageHeight = $("#_page_model_box").height();
        }
        if(height.indexOf("%") != -1){
            var factor = ownMethod._formatStrToNumber(height);
            height = $("body").height() * factor - headerHeight - pageHeight + "px";
        }else{
            height = ownMethod._formatStrToNumber(height) - headerHeight - pageHeight + "px";
        }
        $('#'+content+' #_grid_body_box').css("height",height);
        $.ajax({
            type : method,
            url : ajax.url,
            async : async,
            data : data,
            dataType : "json",
            contentType : contentType,
            success : function(data) {
                setTimeout(function() {
                    layer.close(loadIndex);
                    var rowData = data.rows;
                    var rowHtml = "";
                    for(var i=0;i<rowData.length;i++){
                        rowHtml += "<tr>";
                        if(isOrder){
                            rowHtml += '<td style="width: '+_orderColumnWidth+'px;text-align: center;color: rgb(94, 94, 247);">'+(i+1)+'</td>';
                        }
                        if(isCheck){
                            rowHtml += '<td style="width: '+_orderColumnWidth+'px;"><input name="checkBox" value="'+rowData[i]["id"]+'" type="checkbox"></td>';
                        }
                        for(var j=0;j<dataColumn.length;j++){
                            var col = dataColumn[j];
                            if(typeof col == "string"){
                                var celldata = rowData[i][col];
                                if(celldata == null || celldata == undefined){ celldata = ""; }
                                if(typeof celldata == "number"){
                                    celldata = Number(celldata);
                                    celldata = Math.round(celldata*100)/100;
                                }
                                rowHtml += '<td style="width:'+headerObj.header[j].width+'px;"><div class="lf_table_cell_padding">'+celldata+'</div></td>';
                            }
                        }
                        rowHtml += '</tr>';
                    }
                    $("#"+content).find("tbody").html(rowHtml);
                    if(page){
                        var pageNo = data.pageNo;
                        var pageSize = data.pageSize;
                        var totalRecords = data.total;
                        var pageFn = page.fn;
                        var options = page.options;
                        var totalPages = parseInt((totalRecords + pageSize -1)/pageSize);
                        var pageHtml = ownMethod._getPageHtml(pageNo, pageSize, totalRecords, totalPages, pageFn, options);
                        $("#_page_model_box").html(pageHtml);
                        $("#_selected_page_size").val(pageSize);
                        _pageParam = {pageNo : pageNo,pageSize : pageSize,totalRecords : totalRecords,totalPages : totalPages};
                    }
                    //判断是否出现竖轴滚动条，若出现则header也显示竖直滚动条
                    var divHeight = $('#'+content+' #_grid_body_box').height();
                    var tableHeight = $('#'+content+' #_grid_body_box table').height();
                    if(tableHeight > divHeight){
                        $('#'+content+' #_grid_header_box').css({"overflow-y":"scroll","overflow-x":"hidden"});
                    }
                }, 500);
            }
        });
    },
    eventBinding : function(dom) {
        $(dom).each(function() {
            if ($(this).attr("data-click-tip") != undefined) {
                $(this).click(function() {
                    layer.tips($(this).attr("data-click-tip"), $(this), {
                        tips : [ 1, '#34A7FF' ]
                    });
                });
            }
            if ($(this).attr("dat") != undefined) {
                $(this).mouseover(function() {
                    index = layer.tips($(this).attr("dat"), $(this), {
                        tips : [ 1, '#34A7FF' ]
                    });
                });
                $(this).mouseout(function() {
                    layer.close(index);
                });
            }
        })
    }
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
}