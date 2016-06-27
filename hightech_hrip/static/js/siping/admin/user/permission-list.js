$(function(){
    $.ajax({
       url:createUrl(""), 
    });
    $("#listRole").bootstrapTable({
        url : createUrl('/permission/permission/listHrEmployee'),
        height : '500',
        undefinedText : '-',
        pagination : true, // 分页
        striped : true, // 是否显示行间隔色
        queryParams : queryParams,
        cache : false, // 是否使用缓存
        pageList : [ 5, 10, 20 ],
        toolbar : "#toolbar",// 指定工具栏
        showColumns : true, // 显示隐藏列
        showRefresh : true, // 显示刷新按钮
        uniqueId : "userName", // 每一行的唯一标识
        sidePagination : "server", // 服务端处理分页
        columns : [ {
            field : 'state',
            checkbox : true,
            align : 'center',
            valign : 'middle'
        }, {
            title : '用户账号',
            field : 'userName', // 字段
            align : 'center', // 对齐方式（左 中 右）
            valign : 'middle', //
            sortable : true
        }, {
            title : '员工姓名',
            field : 'empName', // 字段
            align : 'center', // 对齐方式（左 中 右）
            valign : 'middle', //
            sortable : true
        }, {
            title : '菜单权限',
            field : 'id', // 字段
            align : 'center', // 对齐方式（左 中 右）
            valign : 'middle', //
            formatter : function (id){
                
            }
        }, {
            title : '操作',
            field : 'id', // 字段
            align : 'center', // 对齐方式（左 中 右）
            valign : 'middle', //
            formatter : function(id){
                return '<button title="分配菜单权限" onclick="roles('+id+');" type="button" id="add"'+
                ' class="btn btn-default" > <i class="glyphicon glyphicon-cog"></i></button>';
            }
        }],
        responseHandler : function(res) {
            return {
                total : res.total,
                rows : res.records
            };
        }
    })
})
/**查询条件与分页数据 */
function queryParams(pageReqeust) {
    pageReqeust.querys = $("#querys").val();
    pageReqeust.pageNo = this.offset;
    pageReqeust.pageSize = this.pageNumber;
    return pageReqeust;
}
/**
 * 获取添加页面
 */
function add(){
    layer.open({
        type: 2,
        title: '添加角色',
        shadeClose: true,
        shade: 0.5,
        maxmin: false, //开启最大化最小化按钮
        area: ['80%', '90%'],
        content: [createUrl('permission/role/addPage'),'no'],
        end : function(){
            refresh();
        }
      });
}
// 刷新页面 
function refresh() {
    $('#listRole').bootstrapTable('refresh');
}
/**
 * 显示权限组页面
 */
function roles(id){
    layer.open({
        type:2,
        title:'菜单列表',
        shadeClose: true,
        shade: 0.5,
        maxmin: false, //开启最大化最小化按钮
        area: ['80%', '90%'],
        content: [createUrl('permission/userGroup/listRolePage?hrId='+id),'no'],
        end : function(){
            refresh();
        }
    });
}
/**
 * 编辑角色组信息
 */
function editPage(){
    var role = $("#listRole").bootstrapTable("getSelections");
    if(role.length != 1){
        layer.alert('请选择并只能选择一条数据进行编辑！', {icon: 2});
        return false;
    }else{
        layer.open({
            type:2,
            title:'菜单列表',
            shadeClose: true,
            shade: 0.5,
            maxmin: false, //开启最大化最小化按钮
            area: ['80%', '90%'],
            content: [createUrl('permission/role/editPage?groupId='+role[0].id),'no'],
            end : function(){
                refresh();
            }
        });
    }
}
/**
 * 删除角色组
 */
function deleteRole(){
    var role = $("#listRole").bootstrapTable("getSelections");
    if(role.length < 1){
        layer.alert('请至少选择一条数据进行删除！', {icon: 2});
        return false;
    }else{
        layer.confirm('确定要删除所选数据？', {icon: 3, title:'提示'}, function(){
            var roles = [];
            for (var i=0;i<role.length;i++){
                    roles.push(role[i].id);
            }
            $.ajax({
                type:'POST',
                url:createUrl('permission/role/deleteRole'),
                data:JSON.stringify(roles),
                contentType:'application/json',
                success:function(msg){
                    if(msg.success){
                        layer.alert(msg.msg,{icon:1});
                    }else{
                        layer.alert(msg.msg,{icon:2});
                    }
                    refresh();
                    $("#edit").attr({"disabled":"disabled"});
                    $("#delete").attr({"disabled":"disabled"});
                }
            })
          });
    }
}