$(document).ready(
        function(){
            bootstrapValidatorForm();
        }
)
//注册账号--保存
function add(){
    $('#registeredForm').data('bootstrapValidator').validate();
    if($('#registeredForm').data('bootstrapValidator').isValid()){
        var radio = $("#userType input[name='userType']:checked").val();
        $('#registeredForm').ajaxSubmit({
            success: function (data) {
                if(data.success){
                    layer.alert("0", {
                        skin: 'layui-layer-molv' //样式类名
                        ,closeBtn: 0,
                        icon:1
                      });
                }else{
                    layer.alert("1", {
                        skin: 'layui-layer-molv' //样式类名
                        ,closeBtn: 0,
                        icon:2
                      });
                }
            },
            error: function(){
                layer.alert("系统发生异常，请联系管理员", {
                    skin: 'layui-layer-molv' //样式类名
                    ,closeBtn: 0,
                    icon:2
                  });
            }
        });
    }
}

//注册账号--表单校验初始化
function bootstrapValidatorForm(){
    $('#registeredForm').bootstrapValidator({
        message: 'This value is not valid',
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
                max: 20,
                message: '用户名长度最少需要6位，最多20位'
                },
                regexp: {
                  regexp: /^[a-zA-Z0-9_\.]+$/,
                  message: '用户名只能由字母、数字、点和下划线组成'
                  }
                }
              },
            pwdHash: {
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
                    },
                    different: {
                        field: 'orgCode',
                        message: '密码不能与账号一样'
                    }
                }
            },
            testPwdHash: {
                validators: {
                  notEmpty: {
                  message: '不能为空'
                  },
                  identical: {
                  field: 'pwdHash',
                  message: '密码不一致'
                  },
                  different: {
                  field: 'orgCode',
                  message: '密码不能与账号一样'
                  }
                }
              },
            email: {
                message: '邮箱验证不通过',
                validators: {
                    stringLength: {
                        max: 30,
                        message: '邮箱长度最多只能30位'
                    },
                    regexp: {
                        regexp: /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/,
                        message: '邮箱格式不正确'
                    }
                }
            }
        }
    });
}