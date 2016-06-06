    $(function(){
        validatPic('#licenseImage');
        //表单校验初始化
        bootstrapValidatorForm();
        //初始化省市列表
        initProvinceSelect();
        initOrgType();
    });

//注册企业账号--保存
function add(){
    $('#enterprise_addForm').data('bootstrapValidator').validate();
    if($('#enterprise_addForm').data('bootstrapValidator').isValid()){
        $('#enterprise_addForm').ajaxSubmit({
            success: function (data) {
                if(data.success){
                    layer.alert(data.msg, {
                        skin: 'layui-layer-molv' //样式类名
                        ,closeBtn: 0,
                        icon:1
                      });
                }else{
                    layer.alert(data.msg, {
                        skin: 'layui-layer-molv' 
                        ,closeBtn: 0,
                        icon:2
                      });
                }
            },
            error: function(){
                layer.alert("系统发生异常，请联系管理员", {
                    skin: 'layui-layer-molv' 
                    ,closeBtn: 0,
                    icon:2
                  });
            }
        });
    }
}

//注册企业账号--图片初始化
function validatPic(picId){
    $(picId).on('change', function(e){
        if(e.target.files[0].size > 1024*1024*2){
            layer.alert('请选择小于2M的图片', {
                skin: 'layui-layer-molv' //样式类名
                ,closeBtn: 0
              });
            return false;
        }else{
            $(picId+'Path').val(this.value);
        }
    });
}

//校验后的样式处理 
function checkCss(valId, msg){
    var okStr = '<i class="form-control-feedback glyphicon glyphicon-ok" data-bv-icon-for="orgCode" style="display: block;"></i>';
    var errStr = '<small class="help-block" data-bv-validator="stringLength" data-bv-for="orgCode" data-bv-result="VALID" style="display: block;">'+msg+'</small>';
    if(msg == null){
        $(valId).append(okStr);
    }else{
        $(valId).append(errStr);
    }
}

//注册企业账号--表单校验初始化
function bootstrapValidatorForm(){
    $('#enterprise_addForm').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            orgCode: {
                message: '组织机构代码验证不通过',
                validators: {
                    notEmpty: {
                        message: '不能为空'
                    },
                    stringLength: {
                        min: 6,
                        max: 30,
                        message: '长度只能为6-30个位'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9]{8}-[a-zA-Z0-9]+$/,
                        message: '请输入正确的组织机构代码'
                    }
                }
            },
            
            registeredNo: {
                message: '工行注册号验证不通过',
                validators: {
                    stringLength: {
                        max: 15,
                        message: ''
                    }
                }
            },
            orgName: {
                message: '企业名称验证不通过',
                validators: {
                    notEmpty: {
                        message: '不能为空'
                },
                    stringLength: {
                        max: 25,
                        message: '长度不超过25个位'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_u4e00-u9fa5]+$/,
                        message: '只能输入汉字、数字、字母、下划线'
                    }
                }
            },
            industry: {
                message: '主营行业验证不通过',
                validators: {
                    stringLength: {
                        max: 100,
                        message: '长度不超过100'
                    }
                }
            },
            turnover: {
                message: '营业额验证不通过',
                validators: {
                    stringLength: {
                        max: 20,
                        message: '长度能不超过20个位'
                    }
                }
            },
            employees: {
                message: '公司规模验证不通过',
                validators: {
                    stringLength: {
                        max: 6,
                        message: '长度不能超过6个位'
                    }
                }
            },
            legalPerson: {
                message: '法定代表人验证不通过',
                validators: {
                    notEmpty: {
                        message: '不能为空'
                    },
                    stringLength: {
                        max: 10,
                        message: '长度不能超过10个位'
                    }
                }
            },
            street: {
                message: '企业注册地址验证不通过',
                validators: {
                    stringLength: {
                        max: 20,
                        message: '长度不能超过20个位'
                    }
                }
            },
            product,orgProfile: {
                message: '企业简介验证不通过',
                validators: {
                    stringLength: {
                        max: 200,
                        message: '长度不能超过200个位'
                    }
                }
            },
            businessScope: {
                message: '业务范围验证不通过',
                validators: {
                    stringLength: {
                        max: 40,
                        message: '长度不能超过40个位'
                    }
                }
            },
            contacts: {
                message: '联系人验证不通过',
                validators: {
                    stringLength: {
                        min: 6,
                        max: 30,
                        message: '账号长度为6-30'
                    }
                }
            },
            telephone: {
                message: '联系电话验证不通过',
                validators: {
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
            fax: {
                message: '传真号验证不通过',
                validators: {
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
            email: {
                message: '邮箱验证不通过',
                validators: {
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
            postcode: {
                message: '邮编验证不通过',
                validators: {
                    stringLength: {
                        min: 6,
                        max: 6,
                        message: '请输入6位数字的邮编'
                    },
                    regexp: {
                        regexp: /^[0-9]+$/,
                        message: '请输入6位数字的邮编'
                    }
                }
            },
            postcode: {
                message: '办公地点验证不通过',
                validators: {
                    stringLength: {
                        max: 20,
                        message: '办公地点最多为20位'
                    }
                }
            },
            website: {
                message: '网址验证不通过',
                validators: {
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