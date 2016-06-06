$(function(){
    var groupId = $("#groupId").val();
    $.ajax({
        url : createUrl('permission/permission/listPermission?groupId='+groupId),
        type : 'POST',
        contentType:'application/json',
        dataType:'json',
        success:function(listPms){
            $("#listMenu").bootstrapTable({
                url : createUrl('/menu/list'),
                height : '450',
                undefinedText : '-',
                pagination : false, // 分页
                striped : true, // 是否显示行间隔色
                cache : false, // 是否使用缓存
                pageList : [ 5, 10, 20 ],
                showColumns : false, // 显示隐藏列
                showRefresh : false, // 显示刷新按钮
                uniqueId : "id", // 每一行的唯一标识
                sidePagination : "server", // 服务端处理分页
                columns : [ {
                    title : '菜单名',
                    field : 'menuName', // 字段
                    align : 'center', // 对齐方式（左 中 右）
                    valign : 'middle', //
                    sortable : true
                }, {
                    title : '功能权限',
                    align : 'center', // 对齐方式（左 中 右）
                    valign : 'middle', //
                    field : 'id',
                    formatter : function(id){
                        for (var int = 0; int < listPms.length; int++) {
                            if(id == listPms[int].menuId){
                                return '<div>'+
                                '<label style="padding-right: 10px"><input '+(listPms[int].addible?"checked='checked'":"")+' type="checkbox" name="permission" value="addible'+id+'">新增</label>'+
                                '<label style="padding-right: 10px"><input '+(listPms[int].editable?"checked='checked'":"")+' type="checkbox" name="permission" value="editable'+id+'">修改</label>'+
                                '<label style="padding-right: 10px"><input '+(listPms[int].deletable?"checked='checked'":"")+' type="checkbox" name="permission" value="deletable'+id+'">删除</label>'+
                                '<label><input '+(listPms[int].readable?"checked='checked'":"")+' type="checkbox" name="permission" value="readable'+id+'">只读</label>'+
                                '</div>';
                            }
                        }
                        return '<div>'+
                        '<label style="padding-right: 10px"><input type="checkbox" name="permission" value="addible'+id+'">新增</label>'+
                        '<label style="padding-right: 10px"><input type="checkbox" name="permission" value="editable'+id+'">修改</label>'+
                        '<label style="padding-right: 10px"><input  type="checkbox" name="permission" value="deletable'+id+'">删除</label>'+
                        '<label><input type="checkbox" name="permission" value="readable'+id+'">只读</label>'+
                        '</div>';
                    }
                }],
                responseHandler : function(res) {
                    return {
                        total : res.total,
                        rows : res.records
                    };
                }
            })
        }
    })
})
/**
 * 确认菜单权限
 */
function save(){
    var groupId = $("#groupId").val();
    var obj;
    var x = $("#listMenu").bootstrapTable('getData',true);
    var objs = [];
    for (var int = 0; int < x.length; int++) {
        obj = new Object();
        obj.addible = $('input[value="addible' + x[int].id + '"]')[0].checked;
        obj.editable = $('input[value="editable' + x[int].id + '"]')[0].checked;
        obj.deletable = $('input[value="deletable' + x[int].id + '"]')[0].checked;
        obj.readable = $('input[value="readable' + x[int].id + '"]')[0].checked;
        obj.groupId = groupId;
        obj.menuId = x[int].id;
        objs.push(obj);
    }
    $.ajax({
        type:'POST',
        url:createUrl('permission/role/addUpdateMenu'),
        contentType:'application/json',
        data:JSON.stringify(objs),
        success:function(msg){
            var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
            if(msg.success){
                layer.alert(msg.msg,{icon:1},function(la){
                    parent.layer.close(index); //关闭菜单权限窗口
                });
            }else{
                layer.alert(msg.msg,{icon:2});
            }
        }
    })
}
