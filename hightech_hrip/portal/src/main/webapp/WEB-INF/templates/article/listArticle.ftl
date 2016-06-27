    <div class="container-fluid">
        <div class="col-lg-3">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="输入用户名、用户编号、姓名关键字">
                <span class="input-group-btn">
                    <button class="btn btn-default" type="button"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
                </span>
            </div>
        </div>
        <div class="col-lg-1">
            <select class="form-control" id="selectEnabled" onchange="search()">
                <option value="1">启用</option>
                <option value="0">禁用</option>
            </select>
        </div>
    </div>
    <div class="container-fluid">
        <div id="article_toolbar" class="btn-group">
            <button type="button" class="btn btn-default" onClick="redirectAdd()">
                <i class="glyphicon glyphicon-plus"></i>
            </button>
            <button type="button" class="btn btn-default" onClick="redirectEdit()">
                <i class="glyphicon glyphicon-heart"></i>
            </button>
            <button type="button" class="btn btn-default" onClick="changeStatus('delete')">
                <i class="glyphicon glyphicon-trash"></i>
            </button>
            <button type="button" class="btn btn-default" onClick="changeStatus('enabled')">
                <i class="glyphicon glyphicon-ok"></i>
            </button>
            <button type="button" class="btn btn-default" onClick="changeStatus('disabled')">
                <i class="glyphicon glyphicon-remove"></i>
            </button>
        </div>
        <table id="articleList"></table>
    </div>
    
    <script type="text/javascript">
        $(function(){
            $('#articleList').bootstrapTable({
                idField : 'id',
                showRefresh : true,
                showColumns : true,
                minimumCountColumns : 2,
                pagination : true,
                pageList : [10, 25, 50, 80],
                sidePagination : 'server',
                toolbar : "#article_toolbar",
                url : createUrl('/article/list'),
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
                    field: 'msgType.typeName',
                    title: '类型'
                },{
                    field: 'enabled',
                    title: '状态',
                    formatter:formatterEnabled
                },{
                    field: 'author',
                    title: '作者'
                },{
                    field: 'publishTime',
                    title: '发布时间'
                }],
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
                }
            });
        });
        
        
        function search(){
            $('#articleList').bootstrapTable('refresh',{url:createUrl('/article/list'),query:{pageSize:10,pageNo:1}});
        }
        function redirectAdd(){
            window.location="redirectAdd";
        }
        
        function redirectEdit(){
            var selections = $('#articleList').bootstrapTable('getSelections');
            if(selections.length == 1){
                window.location="redirectEdit?id="+selections[0].id;
            }else{
                alert("请至少选择一行数据！");
            }
        }
        
        function changeStatus(type){
            var selections = $('#articleList').bootstrapTable('getSelections');
            if(selections.length > 1){
                var ids = new Array();
                for(var i = 0; i < selections.length; i++){
                    ids.push(selections[i].id);
                }
                $.ajax({
                    url : createUrl('article/updateStatus'),
                    data : {ids : ids.join(), action : type},
                    success : function(result){
                        if(result.success){
                            alert(result.msg);
                            window.location=createUrl("article/redirectList");
                        }else{
                            alert(result.msg);
                        }
                    }
                });
            }else{
                alert("请至少选择一行数据！");
            }
        }
        
        function formatterEnabled(value,row,index){
            return row.enabled == 1?'是':'否';
        }
    </script>