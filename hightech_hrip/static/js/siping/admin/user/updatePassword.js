/* 表单验证 */
$(document).ready(function() {
    $('#updatePassWordForm').bootstrapValidator({
        message: '有错误的填入项',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
          fields: {
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
          qpassWord: {
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
/*提交注册信息*/
function save(){
    $("#updatePassWordForm").data("bootstrapValidator").validate();
    if(!$("#updatePassWordForm").data("bootstrapValidator").isValid()){
        return;
    }
    var oldPwd = $('#oldPassWord').val();
    var newPwd = $('#passWord').val();
    $.post(createUrl("user/pwd/reset"), { oldPwd: oldPwd, pwd: newPwd },function(data){
        if(data.success){
            layer.alert(data.msg,{icon:1});
        }else{
            layer.alert(data.msg,{icon:2});
        }
    });
}