$(function(){
    $('#personalUserList').bootstrapTable({
        idField : 'id',
        showRefresh : true,
        showColumns : true,
        minimumCountColumns : 2,
        pagination : true,
        pageList : [10, 25, 50, 80],
        sidePagination : 'server',
        toolbar : "#personal_user_toolbar",
        url : createUrl('/userPsersonal/list'),
        columns:[{
            checkbox : true
        },{
            field: 'id',
            title: 'id',
            visible: false
        },{
            field: 'username',
            title: '用户名',
            formatter:formatterUsername
        },{
          field: 'personalInfo.sex',
          title: '性别',
          formatter: formatterSex
        },{
          field: 'age',
          title: '年龄',
          formatter: formatterAge
        },{
          field: 'personalInfo.realname',
          title: '真实姓名'
        },{
          field: 'zone',
          title: '所属地区',
          formatter: formatterZone
        },{
          field: 'personalInfo.address',
          title: '地址'
        },{
          field: 'email',
          title: '电子邮件'
        }],
        responseHandler: function (res) {
            res.rows = res.records;
            res.total = res.total;
            return res;
        },
        queryParams: function (params) {
            params.pageSize = this.pageSize;
            params.pageNo = this.pageNumber;
            return params;
        }
    });
});


function search(){
    $('#personalUserList').bootstrapTable('refresh',{url:createUrl('/userPsersonal/list'),query:{pageSize:10,pageNo:1}});
}
function redirectAdd(){
    var selections = $('#personalUserList').bootstrapTable('getSelections');
    if(selections.length == 1){
        window.location="redirectAdd?username="+selections[0].username+"&email="+selections[0].email;
    }else{
        alert("请至少选择一行数据！");
    }
}

function redirectEdit(){
    var selections = $('#personalUserList').bootstrapTable('getSelections');
    if(selections.length == 1){
        window.location="redirectEdit?username="+selections[0].username;
    }else{
        alert("请至少选择一行数据！");
    }
}

function changeStatus(type){
    var selections = $('#personalUserList').bootstrapTable('getSelections');
    if(selections.length > 1){
        var ids = new Array();
        for(var i = 0; i < selections.length; i++){
            ids.push(selections[i].id);
        }
        $.ajax({
            url : createUrl('article/updateStatus'),
            traditional: true,
            data : {ids : ids, action : type},
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
    
    layer.confirm('删除是不可恢复的，你确认要删除吗？',{icon:3},function(){
          var orgs = $("#personalUserList").bootstrapTable('getSelections');
          var userNames = [];
          for (var i=0;i<orgs.length;i++){
                  userNames.push(orgs[i].orgCode);
          }
          $.ajax({
              url:createUrl('admin/org/delete'), 
              traditional: true,  //阻止深度序列化，向后台传送数组
              data:{userNames:userNames},
              contentType:'application/json',
              success:function(data){
                  if(data.success){
                      layer.alert(data.msg+'数据    ',{
                          skin: 'layui-layer-molv' //样式类名
                          ,closeBtn: 0,
                          icon:1
                        });
                  }else{
                      layer.alert(data.msg+'数据    ',{
                          skin: 'layui-layer-molv' //样式类名
                          ,closeBtn: 0,
                          icon:2
                        });
                  }
                  
                  $('#orgInfoList').bootstrapTable('refresh');
                  $('#editOrg').attr("disabled", true); //设置按钮不可用
                  $('#deleteOrg').attr("disabled", true);
              },
              error: function(){
                  layer.alert("系统发生异常，请联系管理员", {
                      skin: 'layui-layer-molv' //样式类名
                      ,closeBtn: 0,
                      icon:2
                    });
              }
          })
      });
    
    
    
}

function formatterAge(value,row,index){
    if(row.personalInfo != null && row.personalInfo != undefined){
        if(row.personalInfo.birthday != null && row.personalInfo.birthday != undefined){
            var birthYear = row.personalInfo.birthday.slice(0,4);
            var year = new Date().getFullYear();
            return year - birthYear;
        }else{
            return '-';
        }
    }
}

function formatterSex(value,row,index){
    if(row.personalInfo != null && row.personalInfo != undefined){
        if(row.personalInfo.sex != null && row.personalInfo.sex != undefined){
            if(row.personalInfo.sex){
                return "男";
            }else{
                return "女";
            }
        }else{
            return '-';
        }
    }
}

function formatterZone(value,row,index){
	var value = "-";
	if(row.personalInfo != null && row.personalInfo != undefined){
	    if(row.personalInfo.provinceArea != null && row.personalInfo.provinceArea != undefined){
	        value = row.personalInfo.provinceArea.name;
	    }
	    if(row.personalInfo.cityArea != null && row.personalInfo.cityArea != undefined){
	        value += row.personalInfo.cityArea.name;
	    }
	    if(row.personalInfo.countyArea != null && row.personalInfo.countyArea != undefined){
	        value += row.personalInfo.countyArea.name;
	    }
	}
	return value;
}

function formatterUsername(value,row,index){
	var url = createUrl("userPsersonal/redirectView?username=")+value;
	return '<a href="'+url+'">'+value+'</a>';
}

