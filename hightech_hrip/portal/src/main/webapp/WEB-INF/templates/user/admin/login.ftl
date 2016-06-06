<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户登录</title>
    <link rel = "Shortcut Icon" href="">
    <@css href="css/bootstrap/bootstrap.min.css" />
    <@css href="css/font-awesome.min.css" />
    <@css href="css/index-1.css" />
    <@css href="css/login.css" />
</head>
<body onkeydown="if(event.keyCode==13){login();return false;}">
<section id="login">
    <div class="head">
        <h4>后台用户登录</h4>
        <a href="<@url value='/index' />">网站首页></a>
    </div>
    <form id="admin_login_form" class="form" action="<@url value='/user/login' />" 
          method="post" data-bv-message="必填字段">
        <div class="form-group has-feedback">
            <div>
                <input type="text" class="form-control input" id="username" name="username" placeholder="用户名" autofocus>
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
            </div>
        </div>
        <div class="form-group has-feedback">
            <div>
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                <input type="password" class="form-control input" id="password" name="password" placeholder="密码">
            </div>
        </div>
        <div id="divMsg" style="display:none">
            <span id="spanMsg" style="font-size:20px;color:red"></span>
        </div>
        <button type="button" id="btnLogin" onclick="login()" class="btn btn-primary btn-lg btn-block">登录</button>
    </form>

</section>
<@js src="js/jquery/jquery-1.10.2.js" />
<@js src="js/bootstrap/bootstrap.min.js" />
<@js src="js/bootstrap/bootstrapValidator.js" />
<@js src="js/jquery/jquery.form.js"/>
<script>
    $(function(){
        $('#admin_login_form').bootstrapValidator({
              message: 'This value is not valid',
              feedbackIcons: {
                  valid: 'glyphicon glyphicon-ok',
                  invalid: 'glyphicon glyphicon-remove',
                  validating: 'glyphicon glyphicon-refresh'
              },
              fields: {
                  username: {
                      message: '用户名验证不通过',
                      validators: {
                          notEmpty: {
                              message: '不能为空'
                          }
                      }
                  },password: {
                      message: '用户密码验证不通过',
                      validators: {
                          notEmpty: {
                              message: '不能为空'
                          }
                      }
                  }
              }
          });
    });

    var rootPath = '<@url value="/"/>';
    function createUrl(path) {
        return encodeURI(rootPath + path);
    }
    function login(){
        $("#btnLogin").attr("disabled", true);
        $("#admin_login_form").data("bootstrapValidator").validate();
        if(!$("#admin_login_form").data("bootstrapValidator").isValid()){
            $("#btnLogin").attr("disabled", false);
            return;
        }
        $("#admin_login_form").ajaxSubmit({
            success:function(data){
                if(data.success){
                    $("#divMsg").attr("style","display:block");
                    $("#spanMsg").text(data.msg);
                    window.location=createUrl("view/admin/index");
                }else{
                    $("#divMsg").attr("style","display:block");
                    $("#spanMsg").text(data.msg);
                    $("#btnLogin").attr("disabled", false);
                }
            }
        });
    }
</script>
</body>
</html>