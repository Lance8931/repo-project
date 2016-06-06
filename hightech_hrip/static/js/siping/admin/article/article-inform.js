 $(function() {
        $("#edit").attr({"disabled":"disabled"});
        $("#delete").attr({"disabled":"disabled"});
        $('#articleList').bootstrapTable({
            idField : 'id',
            showRefresh : true,
            showColumns : true,
            minimumCountColumns : 2,
            pagination : true,
            pageList : [ 10, 25, 50, 80 ],
            sidePagination : 'server',
            toolbar : "#article_toolbar",
            url : createUrl('/article/list?type=001'),
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
            responseHandler : function(res) {
                res.rows = res.records;
                res.total = res.total;
                return res;
            },
            queryParams : function(params) {
                params.pageSize = this.pageSize;
                params.pageNo = this.pageNumber;
                params.enabled = $("#selectEnabled").val();
                return params;
            },
            onCheck:function(){
                buttonControl('#articleList','#edit','#delete');
            },
            onCheckAll:function(){
                buttonControl('#articleList','#edit','#delete');
            },
            onUncheckAll:function(){
                buttonControl('#articleList','#edit','#delete');
            },
            onUncheck:function(){
                buttonControl('#articleList','#edit','#delete');
            }
        });
    });

    function search() {
        $('#articleList').bootstrapTable('refresh');
        $("#edit").attr({"disabled":"disabled"});
        $("#delete").attr({"disabled":"disabled"});
    }
    function redirectAdd() {
        window.location = "redirectAdd?type=001";
    }

    function redirectEdit() {
        var selections = $('#articleList').bootstrapTable('getSelections');
        if (selections.length == 1) {
            window.location = "redirectEdit?id=" + selections[0].id+"&type=001";
        } else {
            layer.alert("请至少选择一行数据！");
        }
    }

    function changeStatus(type) {
        var selections = $('#articleList').bootstrapTable('getSelections');
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
                        $('#articleList').bootstrapTable('refresh');
                        $("#edit").attr({"disabled":"disabled"});
                        $("#delete").attr({"disabled":"disabled"});
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