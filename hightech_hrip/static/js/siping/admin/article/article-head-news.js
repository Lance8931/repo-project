var tabType;// 文章类型，即tab类型
$(function(){
    tabType = 101;//初始化为园区动态(101)
    initTable();
    $("#tabs-news ul li a").click(function(){
        tabType = $(this).attr("data-type");
        initTable();
    });
});

/**
 * 初始化表格并加载数据
 * @param type 文章类型，即tab的类型
 */
function initTable(){
    initTableList();
    search();
}

/**
 * 初始化表格
 */
function initTableList(){
    $("#tableList").bootstrapTable("destroy");
    $("#edit").attr({"disabled":"disabled"});
    $("#delete").attr({"disabled":"disabled"});
    $("#use").attr({"disabled":$("#delete").attr("disabled")==undefined?false:true});
    $("#ban").attr({"disabled":$("#delete").attr("disabled")==undefined?false:true});
    $("#tableList").bootstrapTable({
        idField : 'id',
        showRefresh : true,
        showColumns : true,
        minimumCountColumns : 2,
        pagination : true,
        pageList : [10, 25, 50, 80],
        sidePagination : 'server',
        toolbar : '#table_toolbar',
        columns:[{
            checkbox : true
        },{
            field: 'id',
            title: 'id',
            visible: false
        },{
            field: 'title',
            title: '标题'
        },{
            field : 'picPath',
            title : '图片',
            align : 'center',
            formatter: function(value){ 
                if(value!=null){
                    return '<img onclick="previewPic(this)" title="点击放大图片" style="width: 100px; height: 55px" src="../../../static/imgs/'+ value +'">';
                }else{
                    return '-';
                }
            }
        }, {
            field : 'msgType.typeName',
            title : '类型',
            align : 'center',
        }, {
            field : 'displayPosition',
            title : '显示位置',
            align : 'center',
        }, {
            field : 'enabled',
            title : '状态',
            formatter : formatterEnabled,
            align : 'center',
        }, {
            field : 'author',
            title : '作者',
            align : 'center',
        }, {
            field : 'publishTime',
            title : '发布时间',
            align : 'center',
        } ],
        responseHandler: function (res) {
            res.rows = res.records;
            res.total = res.total;
            return res;
        },
        queryParams: function (params) {
            params.pageSize = this.pageSize;
            params.pageNo = this.pageNumber;
            params.enabled = $("#selectEnabled").val();
            return params;
        },
        onCheck:function(){
            buttonControl('#tableList','#edit','#delete');
            $("#use").attr({"disabled":$("#delete").attr("disabled")==undefined?false:true});
            $("#ban").attr({"disabled":$("#delete").attr("disabled")==undefined?false:true});
        },
        onCheckAll:function(){
            buttonControl('#tableList','#edit','#delete');
            $("#use").attr({"disabled":$("#delete").attr("disabled")==undefined?false:true});
            $("#ban").attr({"disabled":$("#delete").attr("disabled")==undefined?false:true});
        },
        onUncheckAll:function(){
            buttonControl('#tableList','#edit','#delete');
            $("#use").attr({"disabled":$("#delete").attr("disabled")==undefined?false:true});
            $("#ban").attr({"disabled":$("#delete").attr("disabled")==undefined?false:true});
        },
        onUncheck:function(){
            buttonControl(tableId,'#edit','#delete');
            $("#use").attr({"disabled":$("#delete").attr("disabled")==undefined?false:true});
            $("#ban").attr({"disabled":$("#delete").attr("disabled")==undefined?false:true});
        }
    });
}

/**
 * 数据查询并载入
 * @param type 文章类型
 */
function search(){
    $('#tableList').bootstrapTable('refresh',
            {url:createUrl('/article/list?type='+tabType+'&title='+$("#title").val()+'&enabled='+$("#selectEnabled").val()),
            query:{pageSize:10,pageNo:1}});
}

/**
 * 文章添加
 */
function redirectAdd(){
    window.location="redirectAdd?type="+tabType;
}

/**
 * 文章修改
 */
function redirectEdit(){
    var selections = $("#tableList").bootstrapTable('getSelections');
    if(selections.length == 1){
        window.location="redirectEdit?id="+selections[0].id+"&type="+tabType;
    }else{
        alert("请至少选择一行数据！");
    }
}

/**
 * 修改状态
 * @param operateType 操作状态
 */
function changeStatus(operateType){
    var selections = $("#tableList").bootstrapTable('getSelections');
    if(selections.length > 1){
        var ids = new Array();
        for(var i = 0; i < selections.length; i++){
            ids.push(selections[i].id);
        }
        $.ajax({
            url : createUrl('article/updateStatus'),
            data : {ids : ids.join(), action : operateType},
            success : function(result){
                if(result.success){
                    alert(result.msg);
                    window.location=createUrl("article/redirectArticle?type=2");
                }else{
                    alert(result.msg);
                }
            }
        });
    }else{
        alert("请至少选择一行数据！");
    }
}
/**
 * 预览图片
 * @param obj
 */
previewPic = function(obj){
    $('#previewImg').attr('src', $(obj).attr('src'));
    layer.open({
        type: 1,
        title: false,
        closeBtn: 1,
        area: '800px',
        skin: 'layui-layer-nobg', //没有背景色
        shadeClose: true,
        content: $('#previewImg')
      });
}

function formatterEnabled(value,row,index){
    return row.enabled == 1?'是':'否';
}
