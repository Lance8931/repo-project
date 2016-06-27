
<div class="container-fluid">
    <div class="col-lg-3">
        <div class="input-group">
            <input type="text" class="form-control" name="title" placeholder="输入文章标题进行搜索"> <span class="input-group-btn">
                <button class="btn btn-default" type="button">
                    <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                </button>
            </span>
        </div>
    </div>
    <div class="col-lg-2">
        <select class="form-control" id="selectEnableds" onchange="searchs()">
            <option value="1">启用</option>
            <option value="0">禁用</option>
        </select>
    </div>
</div>
<div class="container-fluid">
    <div id="article_toolbarr" class="btn-group">
        <button title="添加" type="button" class="btn btn-default" onClick="redirectAdds()">
            <i class="glyphicon glyphicon-plus"></i>
        </button>
        <button title="修改" id="edits" type="button" class="btn btn-default" onClick="redirectEdits()">
            <i class="glyphicon glyphicon-pencil"></i>
        </button>
        <button title="删除" id="deletes" type="button" class="btn btn-default" onClick="changeStatuss('delete')">
            <i class="glyphicon glyphicon-trash"></i>
        </button>
    </div>
    <table id="articleListt"></table>
</div>
<script type="text/javascript">
    $(function() {
        $("#edits").attr({"disabled":"disabled"});
        $("#deletes").attr({"disabled":"disabled"});
        $('#articleListt').bootstrapTable({
            idField : 'id',
            showRefresh : true,
            showColumns : true,
            minimumCountColumns : 2,
            pagination : true,
            pageList : [ 10, 25, 50, 80 ],
            sidePagination : 'server',
            toolbar : "#article_toolbarr",
            url : createUrl('/article/list?type=002'),
            columns : [ {
                checkbox : true
            }, {
                field : 'id',
                title : 'id',
                visible : false
            }, {
                field : 'title',
                title : '标题'
            }, {
                field : 'msgType.typeName',
                title : '类型'
            }, {
                field : 'enabled',
                title : '状态',
                formatter : formatterEnabled
            }, {
                field : 'author',
                title : '作者'
            }, {
                field : 'publishTime',
                title : '发布时间'
            } ],
            responseHandler : function(res) {
                res.rows = res.records;
                res.total = res.total;
                return res;
            },
            queryParams : function(params) {
                params.pageSize = this.pageSize;
                params.pageNo = this.pageNumber;
                params.enabled = $("#selectEnableds").val();
                return params;
            },
            onCheck:function(){
                buttonControl('#articleListt','#edits','#deletes');
            },
            onCheckAll:function(){
                buttonControl('#articleListt','#edits','#deletes');
            },
            onUncheckAll:function(){
                buttonControl('#articleListt','#edits','#deletes');
            },
            onUncheck:function(){
                buttonControl('#articleListt','#edits','#deletes');
            }
        });
    });

    function searchs() {
        $('#articleListt').bootstrapTable('refresh');
        $("#edits").attr({"disabled":"disabled"});
        $("#deletes").attr({"disabled":"disabled"});
    }
    function redirectAdds() {
        window.location = "redirectAdd?type=002";
    }

    function redirectEdits() {
        var selections = $('#articleListt').bootstrapTable('getSelections');
        if (selections.length == 1) {
            window.location = "redirectEdit?id=" + selections[0].id+"&type=002";
        } else {
            layer.alert("请至少选择一行数据！");
        }
    }

    function changeStatuss(type) {
        var selections = $('#articleListt').bootstrapTable('getSelections');
        if (selections.length >= 1) {
            var ids = new Array();
            for (var i = 0; i < selections.length; i++) {
                ids.push(selections[i].id);
            }
            $.ajax({
                url : createUrl('article/updateStatus'),
                data : {
                    ids : ids.join(),
                    action : type
                },
                success : function(result) {
                    if (result.success) {
                        layer.alert(result.msg,{icon:1});
                        $('#articleListt').bootstrapTable('refresh');
                        $("#edits").attr({"disabled":"disabled"});
                        $("#deletes").attr({"disabled":"disabled"});
                    } else {
                        layer.alert(result.msg,{icon:2});
                    }
                }
            });
        } else {
            layer.alert("请至少选择一行数据！");
        }
    }

    function formatterEnabled(value, row, index) {
        return row.enabled == 1 ? '启用' : '禁用';
    }
</script>