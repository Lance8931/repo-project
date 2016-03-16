$(function(){
    knowAll(1,10);
});
/**
 * 分页查询待审核的用户
 * @param pageNo
 * @param pageSize
 */
function getProductList(pageNo, pageSize){
    sipingUI.fillGrid({
        gridId : "product_list_grid",
        height : "520px",
        ajax : {
            type : "post",
            url : "/system/newUser",
            async : true, 
            data: {pageNo:pageNo, pageSize:pageSize},
            contentType : 'application/json'
        },
        header : [
              {width : "10%",name : "ID"},
              {width : "10%",name : "账号"},
              {width : "10%",name : "昵称"},
              {width : "10%",name : "部门"},
              {width : "10%",name : "职位"},
              {width : "10%",name : "邮箱"},
              {width : "20%",name : "申请时间"},
              {width : "20%",name : "审核"},
        ],
        column : ["id","userName","nickName","userDepart","userPosition","userEmail","addTime"],
        page : {options : [10,20,30,50,80], fn : "getProductList"},
        rowNum : true,isEdit: true
    });
};
/**
 * 分页显示普通用户
 * @param pageNo
 * @param pageSize
 */
function userAll(pageNo, pageSize){
    sipingUI.fillGrid({
        gridId : "product_list_grid",
        height : "520px",
        ajax : {
            type : "post",
            url : "/system/Users",
            async : true, 
            data: {pageNo:pageNo, pageSize:pageSize},
            contentType : 'application/json'
        },
        header : [
              {width : "10%",name : "ID"},
              {width : "10%",name : "账号"},
              {width : "10%",name : "昵称"},
              {width : "10%",name : "部门"},
              {width : "10%",name : "职位"},
              {width : "10%",name : "邮箱"},
              {width : "10%",name : "操作"},
        ],
        column : ["id","userName","nickName","userDepart","userPosition","userEmail"],
        page : {options : [10,20,30,50,80], fn : "userAll"},
        resetPass:true,
    });
};
/**
 * 分页显示知识类别
 * @param pageNo
 * @param pageSize
 */
function knowAll(pageNo,pageSize){
    sipingUI.fillGridBySelf({
        gridId : "product_list_grid",
        height : "520px",
        ajax : {
            type : "post",
            url : "/system/getKnow",
            async : true, 
            data: {pageNo:pageNo, pageSize:pageSize},
            contentType : 'application/json'
        },
        header : [
              {width : "50%",name : "ID"},
              {width : "50%",name : "类别"},
        ],
        column : ["id","name"],
        page : {options : [10,20,30,50,80], fn : "knowAll"},
        isCheck:true,
    });
};
/**
 * 用户审核
 * @param id
 * @param examine
 */
function examineUser(id,examine){
    $.ajax({  
        type: "GET",  
        url: "/system/examineUser",  
        async : true,  
        data:{id:id,userType:examine},  
        contentType : 'application/json',
        success: function (jsonStr) {  
            alert(jsonStr.msg);
            getProductList(1,10);
        }  
    });  
};
/**
 * 重置用户密码为123456
 * @param id
 */
function resetPass(id){
    $.ajax({
        type:"GET",
        url:"/system/resetPass",
        data:{id:id},
        contentType:'application/json',
        success:function(jsonStr){
            alert(jsonStr.msg);
            userAll(1,10);
        }
    });
};
/**
 * 全选、全不选
 * @param o
 */
function mm(o){
    var a = document.getElementsByName("checkBox");
    for (var i=0;i<a.length;i++){
       a[i].checked = o.checked;
    }
};
/**
 * 删除选中的知识类别
 */
function deleteKnow(){
    var a = document.getElementsByName("checkBox");
    var id = [];
    for (var i=0;i<a.length;i++){
        if(a[i].checked==true){
            id.push(a[i].value);
        }
    }
    $.ajax({
        type:"GET",
        url:"/system/deleteKnow",
        traditional: true,//阻止深度序列化，向后台传送数组
        data:{"id":id},
        contentType:'application/json',
        success:function(jsonStr){
            alert(jsonStr.msg);
            knowAll(1,10);
        }
    });
};
/**
 * 获取被选中的ID
 */
function numKnow(){
    var c = document.getElementsByName("checkBox");
    var id = [];
    for (var i=0;i<c.length;i++){
        if(c[i].checked==true){
            id.push(c[i].value);
        }
    }
    if(id.length>1){
        alert("只能选择一个知识类别！");
    }else if(id.length<1){
        alert("请选择一个要修改的知识类别！");
    }else{
        updateKnow(id[0]);
    }
}
/**
 * 修改选择的知识类别
 * 
 */
function updateKnow(id){
    $.ajax({
        type:"GET",
        url:"/system/getKnowById",
        data:{"id":id},
        contentType:'application/json',
        success:function(jsonStr){
            layer.open({
                type: 1, //page层
                area: ['893px', '600px'],
                title: '知识类别详细信息',
                shade: 0.6, //遮罩透明度
                moveType: 1, //拖拽风格，0是默认，1是传统拖动
                shift: 0, //0-6的动画形式，-1不开启
                content: '<div style="padding:50px;"><form action="/system/updateKnow" method="GET"><table><tr><td >名称</td><td><input type="text" name="name" value="'+jsonStr.name+'"/></td></tr><tr><td>类型</td><td><input type="text" name="knowledgeType" value="'+jsonStr.knowledgeType+'"/></td></tr><tr><td><input type = "hidden" name="id" value="'+jsonStr.id+'"/></td><td></td><td><input type="submit" class="btn_common my_radius btn_search" value="确认"/></td></tr></table></form></div>',
                end:function(){
                    knowAll(1,10);
                }
            });
        }
    });
}


