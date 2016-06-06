/**
 * 添加角色信息
 */
function add(){
    $("#roleForm").ajaxSubmit({
        success:function(data){
            if(data.success){
                layer.alert(data.msg, {icon: 1},function(index){
                    layer.close(index);
                    var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                    parent.layer.close(index);
                });
            }else{
                layer.alert(data.msg, {icon: 2});
            }
        }
    })
}
/**
 * 保存修改信息
 */
function save(){
    $("#editRoleForm").ajaxSubmit({
        success:function(data){
            if(data.success){
                layer.alert(data.msg, {icon: 1},function(index){
                    layer.close(index);
                    var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                    parent.layer.close(index);
                });
            }else{
                layer.alert(data.msg, {icon: 2});
            }
        }
    })
}