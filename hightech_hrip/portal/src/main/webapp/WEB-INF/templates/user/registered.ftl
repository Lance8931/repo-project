<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户注册</title>
    <link rel = "Shortcut Icon" href="">
    <@css href="css/bootstrap/bootstrap.min.css" />
    <@css href="css/bootstrap/bootstrapValidator.css" />
    <@css href="css/font-awesome.min.css" />
    <@css href="css/regist.css" />
</head>
<body>
<#include "../front/header.ftl"/>

<div class="container">
    <div id="main">
        <div class="title">
            <div class="regist">
                <span>注册</span>
            </div>
            <div class="tologin">
                <span><a href="<@url value='/user/login' />" >已有账号，直接登录></a></span>
            </div>
        </div>
        <div class="content">
            <form id="registform" action="hr-about.html" method="post">
                    <div class="form-group" id="usertype">
                        <i class="fa fa-user"></i>
                        <!--<select class="form-control" class="usertype" name="usertype">
                            <option value="">用户类型</option>
                            <option value="pn">个人</option>
                            <option value="cn">企业</option>
                            <option value="sc">服务机构</option>
                        </select>
                        <div class="dropdown">
                            <button name="usertype" value="" class="usertype btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                用户类型
                                <i class="caret"></i>
                            </button>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                <li><a href="javascript:;">个人</a></li>
                                <li><a href="javascript:;">企业</a></li>
                                <li><a href="javascript:;">服务机构</a></li>
                            </ul>
                        </div> -->
                        <input type="radio" value="1" checked="checked" name="group" class="type">个人
                        <input type="radio" value="2" name="group" class="type">企业
                        <input type="radio" value="3" name="group" class="type">服务机构
                        <span class="error-tip"></span>
                    </div>
                    <div class="form-group" id="username">
                        <i class="fa fa-user"></i>
                        <input type="text" class="form-control" class="username" name="username" placeholder="用户名">
                        <span class="error-tip"></span>
                    </div>
                    <div class="form-group" id="password">
                        <i class="fa fa-lock"></i>
                        <input type="password" class="form-control" class="password" name="password" placeholder="密码">
                        <span class="error-tip"></span>
                    </div>
                    <div class="form-group" id="confirmpwd">
                        <i class="fa fa-lock"></i>
                        <input type="password" class="form-control"class="confirmpwd" name="confirmpwd" placeholder="确认密码">
                        <span class="error-tip"></span>
                    </div>
                    <div class="form-group" id="email">
                        <i class="fa fa-envelope"></i>
                        <input type="email" class="form-control" class="email" name="email" placeholder="ccyyhh@sipingsoft.com">
                        <span class="error-tip"></span>
                    </div>
                    <div class="form-group" id="acceptterm">
                        <div class="checkbox">
                                <input type="checkbox" class="acceptterm" name="acceptterm">
                                接受网站
                                <a data-toggle="modal" data-target="#showdetail">
                                    《服务协议》
                                </a>
                        </div>
                        <span class="error-tip"></span>
                    </div>
                <button type="submit" class="btn btn-default">注册</button>
            </form>
        </div>
        <div class="modal fade" id="showdetail" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">XXX网站服务协议</h4>
                    </div>
                    <div class="modal-body">
            啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊
                        <!--<ul>
                            <li>啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊</li>
                            <li>啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊</li>
                            <li>啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊</li>
                            <li>啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊</li>
                            <li>啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊</li>
                            <li>啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊</li>
                            <li>啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊</li>
                            <li>啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊</li>
                        </ul>-->
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<footer id="footer">
    <p>©2016 中国成都人力资源服务产业园 | 蜀ICP备10048374号 ｜ 蜀公网安备11010102123456号</p>
</footer>
<@js src="js/jquery/jquery-1.10.2.js" />
<@js src="js/bootstrap/bootstrap.min.js" />
<@js src="js/bootstrap/bootstrapValidator.js" />
<script>
    $('#header li').click(function(){
        $(this).find('.child-menu').toggle();
    });

    $('article').hide();
    $('article').find('.show').show();

    /*scroll to top*/
    $(".to-top").click(function () {
        $('html, body').animate({ scrollTop: 0 }, 400);
        return false;
    });

    $(document).ready(function() {
        $("#registform").bootstrapValidator({
            feedbackIcons: {
                valid: "fa fa-empty",
                invalid: "fa fa-exclamation-circle",
                validating: "fa fa-exclamation-circle"
            },
            fields: {
                usertype:{
                    trigger:"keyup",
                    container:$("#usertype").find("span"),
                    validators:{
                        notEmpty:{
                            message:"用户类型不能为空"
                        }
                    }
                },
                username: {
                    trigger: "keyup",
                    container: $("#username").find("span"),
                    validators: {
                        notEmpty: {
                            message: "用户名不能为空"
                        },
                        stringLength: {
                            max: 20,
                            message: "用户名长度须小于20位"
                        },
                        regexp: {
                            regexp: /^[a-zA-Z0-9_]+$/,
                            message: "用户名只能包含字母、数字和下划线"
                        }
                    }
                },
                password: {
                    trigger: "keyup",
                    container: $("#password").find("span"),
                    validators: {
                        notEmpty: {
                            message: "密码不能为空"
                        },
                        stringLength: {
                            min: 6,
                            max: 16,
                            message: "密码长度须在6-16位之间"
                        },
                        regexp: {
                            regexp: /^[a-zA-Z0-9_]+$/,
                            message: "密码只能包含字母、数字和下划线"
                        }
                    }
                },
                confirmpwd: {
                    trigger: "keyup",
                    container: $("#confirmpwd").find("span"),
                    validators: {
                        notEmpty: {
                            message: "请确认密码"
                        },
                        identical: {
                            field: "password",
                            message: "两次输入的密码不一致"
                        }
                    }
                },
                email: {
                    trigger: "keyup",
                    container: $("#email").find("span"),
                    validators: {
                        notEmpty: {
                            message: "邮箱不能为空"
                        },
                        emailAddress: {
                            message: "邮箱不合法"
                        }
                    }
                },
                acceptterm: {
                    container: $("#acceptterm").find("span"),
                    validators: {
                        notEmpty: {
                            message: "请勾选网站服务协议"
                        }
                    }
                }
            },
            submitHandler:function(validator,form,submitButton){
                $.post(form.attr('action'), form.serialize(), function(result) {
                }, 'json');
            }
        });
    });

    $(".dropdown-toggle").click(function(){
        if($("#usertype").find(".help-block").is(":hidden")){
            $(".dropdown-menu").css("top","3px");
        }else{
            $(".dropdown-menu").css("top","-37px");
        }
    });*/

    /*$(".dropdown-menu li").click(function(){
        var ut=$(this).find("a").text();
        $(".usertype").val(ut);
        $(".usertype").text(ut);
        $(".usertype").append('<i class="caret"></i>');
        $("#usertype").find(".form-control-feedback").hide();
        $("#usertype").find(".error-tip").hide();
    });
</script>
</body>
</html>