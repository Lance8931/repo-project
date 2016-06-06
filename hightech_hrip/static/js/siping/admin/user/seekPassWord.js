/* 表单验证 */
$(document).ready(function() {
    $('#seekPassWordForm').bootstrapValidator({
        message: '有错误的填入项',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
          fields: {
              userName: {
                  message: '用户名不正确',
                  validators: {
                  notEmpty: {
                  message: '用户名不能为空'
                  },
                  stringLength: {
                  min: 6,
                  max: 30,
                  message: '用户名长度最少需要6位，最多20位'
                  },
                  regexp: {
                    regexp: /^[a-zA-Z0-9_\.]+$/,
                    message: '用户名只能由字母、数字、点和下划线组成'
                    }
                  }
                },
                psdAnswer: {
                    validators: {
                        notEmpty: {
                            message: '不能为空'
                        }
                    }
                },
                passWord: {
                    message: '密码验证不通过',
                    validators: {
                        notEmpty: {
                            message: '不能为空'
                        },
                        stringLength: {
                            min: 6,
                            max: 20,
                            message: '长度只能为6-20个位'
                        },
                        regexp: {
                            regexp: /^[a-zA-Z0-9]+$/,
                            message: '只能是数字和字母'
                        }
                    }
                },
                pwdHash: {
                    validators: {
                      notEmpty: {
                      message: '不能为空'
                      },
                      identical: {
                      field: 'passWord',
                      message: '密码不一致'
                      }
                    }
                  },
          }
      });   
})
/*验证账号*/
function getQuestion(){
    $("#seekPassWordForm").data("bootstrapValidator").validate();
    if(!$("#seekPassWordForm").data("bootstrapValidator").isValid()){
        return;
    }
    $("#seekPassWordForm").ajaxSubmit({
        url:createUrl('adminuser/user/getPsdQuestion'),
        method:'POST',
        success:function(data){
            if(data.success=='false'){
                layer.alert(data.psdQuestion,{icon:2});
            }else{
                $("#getPsdQuestion").hide();
                $("#psdQuestion").val(data.psdQuestion);
                $("#updatePwd").show();
                $("#userType").val(data.userType);
                $("#updatePassWord").show();
            }
        }
    })
}
/**
 * 找回密码
 */
function savePassWrod(){
    $("#seekPassWordForm").data("bootstrapValidator").validate();
    if(!$("#seekPassWordForm").data("bootstrapValidator").isValid()){
        return;
    }
    $("#seekPassWordForm").ajaxSubmit({
        url:createUrl('admin/user/seekPassWord'),
        method:'POST',
        success:function(data){
            if(data.success){
                layer.alert(msg.msg,{icon:1});
            }else{
                layer.alert(msg.msg,{icon:2});
            }
        }
    })
};