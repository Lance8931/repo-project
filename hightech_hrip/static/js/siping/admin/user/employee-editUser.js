/* 表单验证 */
$(document).ready(function() {
    $('#employeeForm').bootstrapValidator({
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
          max: 20,
          message: '用户名长度最少需要6位，最多20位'
          },
          regexp: {
            regexp: /^[a-zA-Z0-9_\.]+$/,
            message: '用户名只能由字母、数字、点和下划线组成'
            }
          }
        },
        empNo: {
          validators: {
              notEmpty: {
                  message: '员工编号是必备的，不能为空'
                  },
                  stringLength: {
                  min: 6,
                  max: 10,
                  message: '员工编号长度最少需要6位，最多10位'
                  },
                  regexp: {
                    regexp: /[0-9]+$/,
                    message: '员工编号只能由数字组成'
                    }
          }
        },
        empName: {
            validators: {
                notEmpty: {
                    message: '员工姓名是必备的，不能为空'
                },
                stringLength: {
                    min: 2,
                    max: 10,
                    message: '员工姓名长度最多10个字'
                    }
            }
        },
        email: {
            message: '邮箱验证不通过',
            validators: {
                notEmpty: {
                    message: '邮箱是必备的，不能为空'
                },
                stringLength: {
                    max: 30,
                    message: '邮箱长度最多只能30位'
                },
                regexp: {
                    regexp: /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/,
                    message: '邮箱格式不正确'
                }
            }
        },
        telephone: {
            message: '固定电话验证不通过',
            validators: {
                regexp: {
                    regexp: /^(\(\d{3,4}\)|\d{3,4}-|\s)?\d{7,14}$/,
                    message: '固定电话格式不正确'
                }
            }
        },
        cellphone: {
            message: '手机号验证不通过',
            validators: {
                notEmpty: {
                    message: '手机号是必备的，不能为空'
                },
                regexp: {
                    regexp: /^1[3|4|5|7|8]\d{9}$/,
                    message: '手机应为11位纯数字'
                }
            }
        },
        position: {
            validators: {
                notEmpty: {
                    message: '员工职位是必备的，不能为空'
                },
                stringLength: {
                    min: 2,
                    max: 20,
                    message: '员工职位长度最多20个字'
                    }
            }
        },
        department: {
            validators: {
                notEmpty: {
                    message: '员工部门是必备的，不能为空'
                },
                stringLength: {
                    min: 2,
                    max: 10,
                    message: '员工部门长度最多10个字'
                }
            }
        },
      }
      });   
})

$(function(){
   initData();
})
/**
 * 如果是个人查看，初始化时禁止编辑所有信息
 */
function initData(){
    var types = $("#types").val();
    if(types == "1"){
        $("#empName").attr({"readonly":"readonly"});
        $("#department").attr({"readonly":"readonly"}); 
        $("#position").attr({"readonly":"readonly"}); 
        $("#telephone").attr({"readonly":"readonly"}); 
        $("#cellphone").attr({"readonly":"readonly"}); 
        $("#email").attr({"readonly":"readonly"}); 
        $("#sex").attr({"disabled":"disabled"}); 
        $("#save").hide();
        $("#edit").show();
    }else{
        $("#edit").hide();
        $("#save").show();
    }
}
/**
 * 个人查看信息，点击编辑时解禁可变字段，
 */
function editData(){
    $("#empName").removeAttr("readonly"); 
    $("#department").removeAttr("readonly"); 
    $("#position").removeAttr("readonly"); 
    $("#telephone").removeAttr("readonly"); 
    $("#cellphone").removeAttr("readonly"); 
    $("#email").removeAttr("readonly"); 
    $("#sex").attr({"disabled":false}); 
    $("#edit").hide();
    $("#save").show();
}
/*提交修改信息*/
function saveData(){
    $("#employeeForm").data("bootstrapValidator").validate();
    if(!$("#employeeForm").data("bootstrapValidator").isValid()){
        return;
    }
    $("#employeeForm").ajaxSubmit({
        success:function(data){
            if(data.success){
                layer.alert(data.msg, {icon: 1},function(index){
                    initData();
                    layer.close(index);
                });
            }else{
                layer.alert(data.msg, {icon: 2});
            }
        }
    })
}