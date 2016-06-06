$(function(){
	initSelectNational();
	initProvinceSelect();
	initReProvinceSelect();
	initStartWorkYearSel();
	bootstrapValidatorForm();
});
function initSelectNational(){
	$("#selectNational").append('<option value="汉族">汉族</option><option value="蒙古族">蒙古族</option><option value="彝族">彝族</option><option value="侗族">侗族</option><option value="哈萨克族">哈萨克族</option><option value="畲族">畲族</option><option value="纳西族">纳西族</option><option value="仫佬族">仫佬族</option><option value="仡佬族">仡佬族</option><option value="怒族">怒族</option><option value="保安族">保安族</option><option value="鄂伦春族">鄂伦春族</option><option value="回族">回族</option><option value="壮族">壮族</option><option value="瑶族">瑶族</option><option value="傣族">傣族</option><option value="高山族">高山族</option><option value="景颇族">景颇族</option><option value="羌族">羌族</option><option value="锡伯族">锡伯族</option><option value="乌孜别克族">乌孜别克族</option><option value="裕固族">裕固族</option><option value="赫哲族">赫哲族</option><option value="藏族">藏族</option><option value="布依族">布依族</option><option value="白族">白族</option>'
			+'<option value="黎族">黎族</option><option value="拉祜族">拉祜族</option><option value="柯尔克孜族">柯尔克孜族</option><option value="布朗族">布朗族</option><option value="阿昌族">阿昌族</option><option value="俄罗斯族">俄罗斯族</option><option value="京族">京族</option><option value="门巴族">门巴族</option><option value="维吾尔族">维吾尔族</option><option value="朝鲜族">朝鲜族</option><option value="土家族">土家族</option><option value="傈僳族">傈僳族</option><option value="水族">水族</option><option value="土族">土族</option><option value="撒拉族">撒拉族</option><option value="普米族">普米族</option><option value="鄂温克族">鄂温克族</option><option value="塔塔尔族">塔塔尔族</option><option value="珞巴族">珞巴族</option><option value="苗族">苗族</option><option value="满族">满族</option><option value="哈尼族">哈尼族</option><option value="佤族">佤族</option><option value="东乡族">东乡族</option><option value="达斡尔族">达斡尔族</option><option value="毛南族">毛南族</option>'
			+'<option value="塔吉克族">塔吉克族</option><option value="德昂族">德昂族</option><option value="独龙族">独龙族</option><option value="基诺族">基诺族</option>');
}
function initReProvinceSelect(){
    var datas = loadData('post','area/getAreaDatas',null,'application/json');
    for(var i = 0; i < datas.length; i++){
        $("#selectReProvince").append('<option value="'+datas[i].value+'">'+datas[i].name+'</option>');
    }
}

function initStartWorkYearSel(){
    var year = new Date().getFullYear();
    for(var i=1950; i <= year; year--){
        $("#selectStartWorkYear").append('<option value="'+year+'">'+year+'</option>');
    }
}

function changeSelectReArea(selector,selectType){
    var value = selector[selector.selectedIndex].value;
    var text = selector[selector.selectedIndex].text;
    var datas = loadData('post','area/getAreaDatas',{parentId:value,type:selectType});
    $("#selectReCity").empty();
    $("#selectReCity").append('<option>请选择市</option>');
    for(var i = 0; i < datas.length; i++){
        $("#selectReCity").append('<option value="'+datas[i].value+'">'+datas[i].name+'</option>');
    }
}

function save(){
	$("#personal_user_add_form").data("bootstrapValidator").validate();
    if(!$("#personal_user_add_form").data("bootstrapValidator").isValid()){
        return;
    }
    $("#personal_user_add_form").ajaxSubmit({
        success:function(data){
            if(data.success){
                layer.alert(data.msg, {
                    skin: 'layui-layer-molv' //样式类名
                    ,closeBtn: 0,
                    icon:1
                 },function(){
                     window.location=createUrl("userPsersonal/redirectList");
                 });
                
            }else{
                layer.alert(data.msg, {
                    skin: 'layui-layer-molv' //样式类名
                    ,closeBtn: 0,
                    icon:1
                });
            }
        }
    });
}

//添加个人用户--表单校验初始化
function bootstrapValidatorForm(){
  $('#personal_user_add_form').bootstrapValidator({
      message: 'This value is not valid',
      feedbackIcons: {
          valid: 'glyphicon glyphicon-ok',
          invalid: 'glyphicon glyphicon-remove',
          validating: 'glyphicon glyphicon-refresh'
      },
      fields: {
          idCode: {
              message: '身份证验证不通过',
              validators: {
                  notEmpty: {
                      message: '不能为空'
                  },
                  stringLength: {
                      min: 16,
                      max: 18,
                      message: '身份证长度为18位或16位'
                  }
              }
          },
          province:{
	    	  message:'失败',
	    	  validators:{
	    		  callback:{
	    			  message:'失败',
	    			  callback:function(value,validator){
		    			  if(value == 1){
		    				  return false;
		    			  }else{
		    				  return true;
		    			  }
		    		  }
	    		  }
	    	  }
    	  },
          nickname: {
              message: '昵称不通过',
              validators: {
                  notEmpty: {
                      message: '不能为空'
                  },
                  stringLength: {
                      min: 6,
                      max: 20,
                      message: '长度只能为6-20个位'
                  }
              }
          },
          realname: {
              validators: {
                notEmpty: {
                	message: '不能为空'
                },
                stringLength: {
                    min: 6,
                    max: 20,
                    message: '长度只能为6-20个位'
                }
              }
            },
          address: {
              message: '详细地址验证不通过',
              validators: {
                  notEmpty: {
                      message: '不能为空'
                  },
                  stringLength: {
                      max: 20,
                      message: '长度不能超过20个位'
                  }
              }
          },
          telephone: {
        	  message: '联系电话验证不通过',
              validators: {
            	  notEmpty: {
                      message: '不能为空'
                  },
                  stringLength: {
                      max: 30,
                      message: '账号长度为6-30'
                  },
                  regexp: {
                      regexp: /^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$|(^(13[0-9]|15[0|3|6|7|8|9]|18[8|9])\d{8}$)/,
                      message: '电话格式不正确'
                  }
              }
          },
          email: {
        	  message: '邮箱验证不通过',
              validators: {
            	  notEmpty: {
                      message: '不能为空'
                  },
                  stringLength: {
                      max: 30,
                      message: '邮箱长度最多只能30位'
                  },
                  regexp: {
                      regexp: /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/,
                      message: '邮箱格式不正确'
                  }
              }
          },
          fax: {
        	  message: '传真号验证不通过',
              validators: {
            	  notEmpty: {
                      message: '不能为空'
                  },
                  stringLength: {
                      min: 6,
                      max: 20,
                      message: '传真号长度为6-20'
                  },
                  regexp: {
                      regexp: /[0-9]+$/,
                      message: '密码只能是数字和字母'
                  }
              }
          },
          website: {
        	  message: '网址验证不通过',
              validators: {
            	  notEmpty: {
                      message: '不能为空'
                  },
                  stringLength: {
                      max: 30,
                      message: '网址长度最长为30'
                  },
                  regexp: {
                      regexp: /^[0-9a-zA-Z]+\.[a-zA-Z]+$/,
                      message: '网址格式不正确'
                  }
             }
         },
      }
  });
}
