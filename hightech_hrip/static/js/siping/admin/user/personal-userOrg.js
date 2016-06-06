    
    $(function(){
        //初始化省市列表
        initProvinceSelect();
        //表格初始化
        bootstrapTableValitor();
        $('#enabled,#orgTypeId,#selectProvince,#selectCity,#selectCounty,#orgQuerys').on('change', function(){
            refresh();
        });
    });
    
    function addPage(){
        window.location.href = createUrl('userOrg/add/page');
    }
    
    function editOrg(){
        var selectRow = $("#orgInfoList").bootstrapTable('getSelections');
        var username = selectRow[0].username;
        if(selectRow.length == 1)
            window.location.href = createUrl('userOrg/edit/page?username='+username);
        else
            alert('请选择一行数据');
    }
    //企业列表--表格初始化
    function bootstrapTableValitor(){
        $('#orgInfoList').bootstrapTable({
            method : 'get',
            url : createUrl('/userOrg/list'),
            height : 550,
            undefinedText : '-',
            striped: true, // 是否显示行间隔色
            pagination : true,//分页
            uniqueId: "username", // 每一行的唯一标识
            pageSize : 10,
            queryParams : queryParams,
            queryParamsType: "limit",
            toolbar : '#org_toolbar',
            searchOnEnterKey : true,
            sidePagination : 'server', // 设置为服务器端分页
            columns : [ {
                field : 'state',
                checkbox : true,
                align : 'center',
                valign : 'middle'
            },{
                title : '序号',
                align : 'center',
            },{
                field : 'username',
                title : '用户名',
                align : 'center',
                formatter: function(value){
                    return '<a href="'+createUrl("userOrg/view/page?username="+value)+'">'+value+'</a>';
                }    
            },{
                field : 'orgName',
                title : '企业名称',
                align : 'center'
            },{
                title : '所属地区',
                align : 'center',
                formatter: function(value,row){
                    if(row.provinceName == null)
                        row.provinceName = "";
                    if(row.cityName == null)
                        row.cityName = "";
                    if(row.countyName == null)
                        row.countyName = "";
                    return row.provinceName + row.cityName;
                }
            },{
                field : 'contacts',
                title : '联系人',
                align : 'center'
            },{
                field : 'telephone',
                title : '联系电话',
                align : 'center'
            },{
                field : 'cellphone',
                title : '手机号码',
                align : 'center'
            },{
                field : 'mainIndustry',
                title : '公司主要行业',
                align : 'center'
            },{
                field : 'orgTypeId',
                title : '公司性质',
                align : 'center'
            },{
                field : 'employees',
                title : '公司规模',
                align : 'center'
            }],
            responseHandler : function(res) {
                return {
                    total : res.total,
                    rows : res.records
                };
            },
            onCheck :  function(){
                buttonControl("#orgInfoList", '#editOrg', '#deleteOrg');
            },
            onUncheck :  function(){
                buttonControl("#orgInfoList", '#editOrg', '#deleteOrg');
            },
            onCheckAll : function(){
                buttonControl("#orgInfoList", '#editOrg', '#deleteOrg');
            },
            onUncheckAll : function(){
                buttonControl("#orgInfoList", '#editOrg', '#deleteOrg');    
            }
        });
    }
    /* 查询条件与分页数据 */
    function queryParams(pageRequest) {
        pageRequest.enabled = $("#enabled").val();
        pageRequest.province = $("#selectProvince").val();
        pageRequest.city = $("#selectCity").val();
        pageRequest.county = $("#selectCounty").val();
        pageRequest.orgTypeId = $("#orgTypeId").val();
        pageRequest.querys = $("#orgQuerys").val();
        pageRequest.pageSize = this.pageSize;
        pageRequest.pageNo = this.pageNumber;
        return pageRequest;
    }
    
    //删除按钮
    function deleteOrg(){
        layer.confirm('删除是不可恢复的，你确认要删除吗？',{
            icon:3
          },function(){
              var orgs = $("#orgInfoList").bootstrapTable('getSelections');
              var userNames = [];
              for (var i=0;i<orgs.length;i++){
                      userNames.push(orgs[i].username);
              }
              $.ajax({
                  url:createUrl('userOrg/delete'), 
                  traditional: true,  //阻止深度序列化，向后台传送数组
                  data:{userNames:userNames},
                  contentType:'application/json',
                  success:function(data){
                      if(data.success){
                          layer.alert(data.msg,{
                              skin: 'layui-layer-molv' //样式类名
                              ,closeBtn: 0,
                              icon:1
                            });
                      }else{
                          layer.alert(data.msg,{
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
    
    /* 刷新页面 */
    function refresh() {
        $('#orgInfoList').bootstrapTable('refresh');
    }

    
