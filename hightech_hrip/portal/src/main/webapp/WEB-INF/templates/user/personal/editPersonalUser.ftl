<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>成都高新区人力资源产业园 后台管理</title>
    <#include "../../common/base.ftl"/>
    <@js src="js/jquery/jquery.form.js"/>
    <@js src="js/laydate/laydate.js" />
    <@js src="js/bootstrap/bootstrapValidator.js" />
    <@js charset="utf-8" src="js/siping/admin/user/personal-userEdit.js" />
</head>
<body onkeydown="if(event.keyCode==13){return false;}">
    <div>
        <ol class="breadcrumb">
            <li><a>系统管理</a></li>
            <li><a href="#">个人用户</a></li>
            <li class="active">编辑</li>
        </ol>
    </div>
    <form class="form-horizontal" role="form" method="post" id="personal_user_edit_form"
        action="<@url value='/userPsersonal/edit'/>" data-bv-message="必填字段">
        <input type="text" style="display:none" id="hiddenId" name="id" value="#{personal.id}" />
        <input type="text" style="display:none" id="hiddenSex" value="${(personal.sex)?string("1","0")}" />
        <input type="text" style="display:none" id="hiddenNation" value="${(personal.nation)!''}" />
        <input type="text" style="display:none" id="hiddenPoliticsStatus" value="${(personal.politicsStatus)!''}" />
        <input type="text" style="display:none" id="hiddenMaritalStatus" value="${(personal.maritalStatus)!''}" />
        <input type="text" style="display:none" id="hiddenStartWorkYear" value="${(personal.startWorkYear)!''}" />
      <div class="form-group">
        <label for="inputIdCode" class="col-lg-3 control-label">用户名</label>
        <div class="col-lg-2">
          <input type="text" class="form-control" id="inputUsername" name="username" value="${(personal.username)!''}" placeholder="请输入身份证号">
        </div>
      </div>
      <div class="form-group">
        <label for="inputNickName" class="col-lg-3 control-label">昵称</label>
        <div class="col-lg-2">
          <input type="text" class="form-control" id="inputNickname" name="nickname" value="${(personal.nickname)!''}" placeholder="请输入昵称">
        </div>
      </div>
      <div class="form-group">
        <label for="inputRealName" class="col-lg-3 control-label">真实姓名</label>
        <div class="col-lg-2">
          <input type="text" class="form-control" id="inputRealname" name="realname" value="${(personal.realname)!''}" placeholder="请输入真实姓名">
        </div>
      </div>
      <div class="form-group">
        <label for="inputBirthday" class="col-lg-3 control-label">出生日期</label>
        <div class="col-lg-2">
          <input class="laydate-icon form-control" onclick="laydate({istime: false, format: 'YYYY-MM-DD'});" id='inputBirthday'
                    name='birthday' placeholder="请选择出生日期" value="${(personal.birthday)!''}">
        </div>
      </div>
      <div class="form-group">
        <label for="selectProvince" class="col-lg-offset-1 col-lg-2 control-label">地区</label>
        <div class="col-lg-1" id="divProvince">
          <select class="form-control" id="selectProvince" name="province" onChange="changeSelectArea(this,'province')">
              <option value="1">请选择省份</option>
              <#list proList.records as temp>
                <option value="${temp.value}" <#if (personal.province??) && (personal.province?exists) && (temp.value==personal.province)>selected</#if> >${temp.name}</option>
              </#list>
          </select>
        </div>
        <#if isEnabledCity>
        <div class="col-lg-1" id="divCity">
          <select class="form-control" id="selectCity" name="city" onChange="changeSelectArea(this,'city')">
              <option>请选择市</option>
              <#list cityList.records as temp>
                <option value="${temp.value}" <#if (personal.city?exists) && (temp.value==personal.city)>selected</#if> >${temp.name}</option>
              </#list>
          </select>
        </div>
        </#if>
        <div class="col-lg-1">
          <select class="form-control" id="selectCounty" name="county">
              <option>请选择区/县</option>
              <#list countyList.records as temp>
                <option value="${temp.value}" <#if (personal.county?exists) && (temp.value==personal.county)>selected</#if>>${temp.name}</option>
              </#list>
          </select>
        </div>
      </div>
      <div class="form-group">
        <label for="inputAddress" class="col-lg-3 control-label">详细地址</label>
        <div class="col-lg-2">
          <input type="text" class="form-control" id="inputAddress" name="address" value="${(personal.address)!''}" placeholder="请输入详细地址">
        </div>
      </div>
      <div class="form-group">
        <label for="selectSex" class="col-lg-3 control-label">性别</label>
        <div class="col-lg-2">
          <select class="form-control" id="selectSex" name="sex">
              <option>请选择</option>  
              <option value="1">男</option>
              <option value="0">女</option>
          </select>
        </div>
      </div>
      <div class="form-group">
        <label for="selectNation" class="col-lg-3 control-label">民族</label>
        <div class="col-lg-2">
          <select class="form-control" id="selectNation" name="nation">
              <option value="1">请选择</option>
          </select>
        </div>
      </div>
      <div class="form-group">
        <label for="selectPoliticsStatus" class="col-lg-3 control-label">政治面貌</label>
        <div class="col-lg-2">
          <select class="form-control" id="selectPoliticsStatus" name="politicsStatus">
              <option>请选择</option>
              <option value="群众">群众</option>
              <option value="中共党员">中共党员</option>
              <option value="中共预备党员">中共预备党员</option> 
              <option value="共青团员">共青团员</option>
              <option value="民革党员">民革党员</option> 
              <option value="民盟盟员">民盟盟员</option> 
              <option value="民建会员">民建会员</option> 
              <option value="民进会员">民进会员</option> 
              <option value="农工党党员">农工党党员</option>
              <option value="致公党党员">致公党党员</option> 
              <option value="九三学社社员">九三学社社员</option>
              <option value="台盟盟员">台盟盟员</option>
              <option value="无党派人士">无党派人士</option>
          </select>
        </div>
      </div>
      <div class="form-group">
        <label for="selectMaritalStatus" class="col-lg-3 control-label">婚姻状况</label>
        <div class="col-lg-2">
          <select class="form-control" id="selectMaritalStatus" name="maritalStatus">
              <option value="1">请选择</option>
              <option value="未婚">未婚</option>
              <option value="已婚">已婚</option>
              <option value="离异">离异</option>
          </select>
        </div>
      </div>
      <div class="form-group">
        <label for="inputTele" class="col-lg-3 control-label">办公电话</label>
        <div class="col-lg-2">
          <input type="text" class="form-control" id="inputTele" name="telephone" value="${(personal.telephone)!''}" placeholder="请输入联系电话">
        </div>
      </div>
      <div class="form-group">
        <label for="inputEmail" class="col-lg-3 control-label">Email</label>
        <div class="col-lg-2">
          <input type="text" class="form-control" id="inputEmail" name="email" value="${(personal.email)!''}" placeholder="请输入Email">
        </div>
      </div>
      <div class="form-group">
        <label for="inputFax" class="col-lg-3 control-label">传真</label>
        <div class="col-lg-2">
          <input type="text" class="form-control" id="inputFax" name="fax" value="${(personal.fax)!''}" placeholder="请输入传真">
        </div>
      </div>
      <div class="form-group">
        <label for="inputWebSite" class="col-lg-3 control-label">个人网址/博客</label>
        <div class="col-lg-2">
          <input type="text" class="form-control" id="inputWebSite" name="website" value="${(personal.website)!''}" placeholder="请输入个人网址/博客">
        </div>
      </div>
      <div class="form-group">
        <label for="inputWebSite" class="col-lg-3 control-label">国籍</label>
        <div class="col-lg-2">
          <input type="text" class="form-control" id="inputNationality" name="nationality" value="${(personal.nationality)!''}" placeholder="请输入国籍">
        </div>
      </div>
      <div class="form-group">
        <label for="inputWebSite" class="col-lg-3 control-label">英文名字</label>
        <div class="col-lg-2">
          <input type="text" class="form-control" id="inputForeignName" name="foreignName" value="${(personal.foreignName)!''}" placeholder="请输入英文名字">
        </div>
      </div>
      <div class="form-group">
        <label for="inputWebSite" class="col-lg-3 control-label">出生地</label>
        <div class="col-lg-2">
          <input type="text" class="form-control" id="inputBirthplace" name="birthplace" value="${(personal.birthplace)!''}">
        </div>
      </div>
      <div class="form-group">
        <label for="inputWebSite" class="col-lg-3 control-label">手机</label>
        <div class="col-lg-2">
          <input type="text" class="form-control" id="inputCellphone" name="cellphone" value="${(personal.cellphone)!''}">
        </div>
      </div>
      <div class="form-group">
        <label for="inputWebSite" class="col-lg-3 control-label">开始工作年份</label>
        <div class="col-lg-2">
          <select class="form-control" id="selectStartWorkYear" name="startWorkYear">
            <option>--请选择--</option>
          </select>
        </div>
      </div>
      <div class="form-group">
        <label for="inputWebSite" class="col-lg-3 control-label">户口所在地城市</label>
        <div class="col-lg-1">
          <select class="form-control" id="selectReProvince" onChange="changeSelectReArea(this,'province')">
              <option value="1">请选择省份</option>
              <#list proList.records as temp>
                <option value="${temp.value}" <#if (reProCode??) && (reProCode?exists) && (temp.value==reProCode)>selected</#if> >${temp.name}</option>
              </#list>
          </select>
        </div>
        <div class="col-lg-1" id="divCity">
          <select class="form-control" id="selectReCity" name="residentCity">
              <option>请选择市</option>
              <#list reCityList.records as temp>
                <option value="${temp.value}" <#if (personal.residentCity??) && (personal.residentCity?exists) && (temp.value==personal.residentCity)>selected</#if> >${temp.name}</option>
              </#list>
          </select>
        </div>
      </div>
      <div class="form-group">
        <div class="col-lg-offset-3 col-lg-2">
          <button  type="button" onclick="save()" class="btn btn-success btn-block">提交</button>
        </div>
      </div>
    </form>
</body>
</html>