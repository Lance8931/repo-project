    $(function(){
        //表格初始化
        bootstrapTableValitor();
    });
    
    //企业列表--表格初始化
    function bootstrapTableValitor(){
        $('#slideList').bootstrapTable({
            height : 550,
            undefinedText : '-',
            striped: true, // 是否显示行间隔色
            pagination : true,//分页
            uniqueId: "id", // 每一行的唯一标识
            pageSize:5,
            pageList : [5, 10, 50, 80],
            queryParams : queryParams,
            toolbar : '#slide_toolbar',
            url : createUrl('/slidePic/list'),
            sidePagination : 'server', // 设置为服务器端分页
            columns : [ {
                field : 'state',
                checkbox : true,
                align : 'center',
                valign : 'middle',
            },{
                title : '序号',
                align : 'center',
                valign : 'middle',
                formatter: function (value, row, index) {
                    return index+1;
                }
            },{
                field : 'picPath',
                title : '图片',
                align : 'center',
                formatter: function(value){
                    var url = staticUrl("/imgs/slide/" + value);
                    return '<img onclick="previewPic(this)" title="单击预览" style="width: 100px; height: 55px; cursor:pointer;" src='+ url +'>';
                },
            },{
                field : 'picPath',
                title : '图片名称',
                align : 'center',
                valign : 'middle',
                formatter: function(value){
                    var arr = value.split("/");
                    return arr[arr.length-1];
                } 
            },{
                field : 'hoverTips',
                title : '悬停提示',
                align : 'center',
                valign : 'middle'
            },{
                field : 'enabled',
                title : '状态',
                align : 'center',
                valign : 'middle',
                formatter: function(value){
                    if(value == 1){
                        return '<h4><span class="label label-default" style="background-color:green;">可用</span></h4>';
                    }else{
                        return '<h4><span class="label label-default">禁用</span></h4>'
                    }
                }         
            }/*,{
                field : 'enabled',
                title : '操作',
                align : 'center',
                valign : 'middle',
                formatter: function(value, row){
                    if(value == 1){
                        return '<i class="glyphicon glyphicon-lock" id='+row.id+' onclick="update(this, 0);" title="禁用" style="cursor: pointer;"></i>'+
                        '<i class="glyphicon glyphicon-trash" style="padding-left:10px;cursor: pointer;" id='+row.id+' onclick="deleteSingle(this);" title="删除" style="cursor: pointer;"></i>';
                    }else{
                        return '<i class="glyphicon glyphicon-ok" id='+row.id+' onclick="update(this, 1);" title="启用" style="cursor: pointer;"></i>'+
                        '<i class="glyphicon glyphicon-trash" style="padding-left:10px;cursor: pointer;" id='+row.id+' onclick="deleteSingle(this);" title="删除" style="cursor: pointer;"></i>';
                    }
                }  
            }*/],
            responseHandler : function(res) {
                return {
                    total : res.total,
                    rows : res.records
                };
            },
            onCheck :  function(){
                personlBtnCont("#slideList", '#edit', '#delete');
            },
            onUncheck :  function(){
                personlBtnCont("#slideList", '#edit', '#delete');
            },
            onCheckAll : function(){
                personlBtnCont("#slideList", '#edit', '#delete');
            },
            onUncheckAll : function(){
                personlBtnCont("#slideList", '#edit', '#delete');   
            },
        });
    }
    // 查询条件与分页数据 
    function queryParams(pageRequest) {
        pageRequest.enabled = $("#enabled").val();
        pageRequest.pageSize = this.pageSize;
        pageRequest.pageNo = this.pageNumber;
        return pageRequest;
    }
    
    function previewPic(obj){
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
    
    
    //启用或禁用单个幻灯片
    function update(obj, enabled){
        var slidePics = [];
        slidePics.push({id : $(obj).attr('id'), enabled : enabled});
        $.ajax({
            type:'POST',
            url:createUrl('slidePic/image/update'), 
            data:JSON.stringify(slidePics),
            contentType:'application/json',
            success:function(data){
                if(data.success){
                    // TODO 执行成功
                }else{
                    layer.alert(data.msg,{
                        skin: 'layui-layer-molv' //样式类名
                        ,closeBtn: 0,
                        icon:2
                      });
                }
                
                $('#slideList').bootstrapTable('refresh');
                $('#edit').attr("disabled", true); //设置按钮不可用
                $('#delete').attr("disabled", true);
            },
            error: function(){
                layer.alert("系统发生异常，请稍后再试", {
                    skin: 'layui-layer-molv' //样式类名
                    ,closeBtn: 0,
                    icon:2
                  });
            }
        })
    }
    //删除单条数据--表格操作按钮
    function deleteSingle(obj){
        layer.confirm('删除是不可恢复的，你确认要删除吗？',{
            icon:3
          },function(){
              var ids = [];
              ids.push($(obj).attr('id'));
              var data = {ids : ids};
              $.ajax({
                  url:createUrl('slidePic/image/delete'), 
                  traditional: true,  //阻止深度序列化，向后台传送数组
                  data:{ids:ids},
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
                      
                      $('#slideList').bootstrapTable('refresh');
                      $('#edit').attr("disabled", true); //设置按钮不可用
                      $('#delete').attr("disabled", true);
                  },
                  error: function(){
                      layer.alert("系统发生异常，请稍后再试", {
                          skin: 'layui-layer-molv' //样式类名
                          ,closeBtn: 0,
                          icon:2
                        });
                  }
              })
          });
    }
    //批量删除幻灯片
    function deleteSlide(){
        layer.confirm('删除是不可恢复的，你确认要删除吗？',{
            icon:3
          },function(){
              var slides = $("#slideList").bootstrapTable('getSelections');
              var ids = [];
              for (var i=0;i<slides.length;i++){
                  ids.push(slides[i].id);
              }
              var data = {ids : ids};
              $.ajax({
                  url:createUrl('slidePic/image/delete'), 
                  traditional: true,  //阻止深度序列化，向后台传送数组
                  data:{ids:ids},
                  contentType:'application/json',
                  success:function(data){
                      if(data.success){
                          layer.alert(data.msg,{
                        	  icon:1
                            }, function(index){
                            	layer.close(index);
                            	$('#slideList').bootstrapTable('refresh',{query:{pageNo:1}});
                                $('#edit').attr("disabled", true); //设置按钮不可用
                                $('#delete').attr("disabled", true);
                            });
                      }else{
                          layer.alert(data.msg,{
                              icon:2
                            });
                      }
                  },
                  error: function(){
                      layer.alert("系统发生异常，请稍后再试", {
                          skin: 'layui-layer-molv' //样式类名
                          ,closeBtn: 0,
                          icon:2
                        });
                  }
              })
          });
    }
    
    
    //启用、禁用下拉框变化事件
    function enabledChg(value){
        refresh();
        if(value == 1){
            $('#edit').attr('title', '禁用');
            $('#edit').attr('onclick', 'updateMulti(0);');
            $('#edit i').attr('class', 'glyphicon glyphicon-ban-circle');
        }else{
            $('#edit').attr('title', '启用');
            $('#edit').attr('onclick', 'updateMulti(1);');
            $('#edit i').attr('class', 'glyphicon glyphicon-ok-circle');
        }
    }
    
  //跳转到上传图片页面
    function add(){
        layer.open({
            type: 2,
            title: '上传幻灯片',
            shadeClose: true,
            shade: 0.5,
            maxmin: false, //开启最大化最小化按钮
            area: ['80%', '90%'],
            content: createUrl('slidePic/image/upload/page'),
            end : function(){
                refresh();
            }
          });
        /*
        var index = layer.open({
            type: 2,
            content: createUrl('slidePic/image/upload/page'),
            area: ['100%', '100%'],
            closeBtn: 0,
            title: false,
            maxmin: false
          });
          layer.full(index);*/
    }
    
    
    function preview(){
        layer.open({
            type: 2,
            title: '',
            scrollbar:false,
            shadeClose: true,
            shade: 0.8,
            area: ['1118px', '575px'],
            content: createUrl('slidePic/preview') ,
          }); 
    }
    
    function cropImge(){
        var index = layer.open({
            type: 2,
            content: createUrl('slidePic/jcrop/page'),
            area: ['100%', '100%'],
            closeBtn: 0,
            title: false,
            maxmin: false
          });
          layer.full(index);
    }
    
    // 刷新页面 
    function refresh() {
        $('#slideList').bootstrapTable('refresh');
    }
    
  //批量启用、禁用幻灯片
    function updateMulti(enabled){
        var slides = $("#slideList").bootstrapTable('getSelections');
        var slidePics = [];
        
        for (var i=0;i<slides.length;i++){
            slidePics.push({id : slides[i].id, enabled : enabled});
        }
        var requestData = JSON.stringify(slidePics);
        requestServer(createUrl('slidePic/image/update'), requestData, 'POST');
    }
    
    /**
     * 默认参数为：type：get, data:null, contenType:'application/json';
     * @param url
     */
    function requestServer(url){
        var type = 'GET', data = null, args = arguments.length, contentType = 'application/json', flag = false;
        switch(args){
            case 2:
                data = arguments[1];//第二个参数为data
                break;
            case 3:
                data = arguments[1];
                type = arguments[2];//第三个参数为请求类型
                break;
            case 4:
                data = arguments[1];//contentType
                type = arguments[2];
                contentType = arguments[3];
                break;
            default:
                return false;
        }
        return $.ajax({
            url : url, 
            data : data,
            type : type,
            contentType : contentType,
            success : function(data){
            	if(data.success){
                    layer.alert(data.msg,{
                  	  icon:1
                      }, function(index){
                      	layer.close(index);
                      	$('#slideList').bootstrapTable('refresh',{query:{pageNo:1}});
                        $('#edit').attr("disabled", true); //设置按钮不可用
                        $('#delete').attr("disabled", true);
                      });
                }else{
                    layer.alert(data.msg,{
                        icon:2
                      });
                }
            },
            error: function(){
                layer.alert("发生了一个错误，请稍后再试", {
                    icon:5
                  },function(index){
                	  layer.close(index);
                  });
            }
        });
    }
    
    //按钮控制
    function personlBtnCont(tableId, editId, deleteId){
        var index = $(tableId).bootstrapTable('getSelections').length;
        if(index >= 1){
            $(editId).attr("disabled", false);
            $(deleteId).attr("disabled", false);
        }else{
            $(editId).attr("disabled", true);
            $(deleteId).attr("disabled", true);
        }
    }

