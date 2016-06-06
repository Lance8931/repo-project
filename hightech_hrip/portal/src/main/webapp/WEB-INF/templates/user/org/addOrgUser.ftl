<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>成都高新区人力资源产业园 后台管理</title>
    <#include "../../common/base.ftl"/>
    <#include "../../common/table.ftl"/>
    <@js src="js/jquery/jquery.form.js"/>
    <@js src="js/layer/layer.js" />
    <@js src="js/laydate/laydate.js" />
    <@js src="js/siping/admin/user/personal-userOrgAdd.js" />
    <style type="text/css">
            .fileinput-button input {
                position: absolute;
                top: 0;
                right: 0;
                margin: 0;
                opacity: 0;
                -ms-filter: 'alpha(opacity=0)';
                font-size: 30px;
                direction: ltr;
                cursor: pointer;
            }
            .fileinput-button {
                position: relative;
                overflow: hidden;
            }
     </style>
</head>
<body onkeydown="if(event.keyCode==13){return false}">
    <div>
        <ol class="breadcrumb">
            <li><a href="">系统管理</a></li>
            <li><a href="<@url value='/view/user/org/list' />">企业用户</a></li>
            <li class="active">添加企业用户</li>
        </ol>
    </div>
<div class="layer-body">
<div class="container-fluid">
    <form class="form-horizontal" role="form" method="post" id='org_addForm' target="post_frame"
        action="<@url value='/userOrg/add'/>" data-bv-message="必填字段" enctype="multipart/form-data">
        
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label ">用户名</label>
                <div class="col-sm-4">
                    <input type="text" id="username" name="username" class="form-control input-sm" required placeholder="请输入用户名">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label ">组织机构代码</label>
                <div class="col-sm-4">
                    <input type="text" id="orgCode" name="orgCode" class="form-control input-sm" required placeholder="请输入组织机构代码">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label ">工商注册号</label>
                <div class="col-sm-4">
                    <input type="text" id="registeredNo" name="registeredNo" class="form-control input-sm" 
                    required placeholder="工商注册号">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label ">企业名称</label>
                <div class="col-sm-4">
                    <input type="text" id="orgName" name="orgName" class="form-control input-sm" 
                        required placeholder="企业名称">
                </div>
            </div>
        </div>
        
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label">企业类型</label>
                <div class="col-sm-4">
                    <select class="form-control input-sm" id="orgTypeId" name="orgTypeId">

                    </select>
                </div>
            </div>
        </div>

        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label">主营行业</label>
                <div class="col-sm-4">
                    <input type="text" id="mianIndustry" name="mainIndustry" class="form-control input-sm" 
                    placeholder="请输入公司主营行业">
                </div>
            </div>
        </div>
        
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label">次营行业</label>
                <div class="col-sm-4">
                    <input type="text" id="secondaryIndustry" name="secondaryIndustry" class="form-control input-sm" 
                    placeholder="请输入公司所属次要行业">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label">公司规模</label>
                <div class="col-sm-4">
                    <input type="text" id="secondaryIndustry" name="secondaryIndustry" class="form-control input-sm" 
                    placeholder="请输入公司规模">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row">
                    <label for="selectProvince" class="col-sm-4 control-label">企业所属地区</label>
                    <div class="col-sm-4">
                        <div class="btn-group col-sm" id='divProvince'>
                            <select id="selectProvince" class="form-control" name='province' 
                                onchange='chgOrgSelectArea(this, "province");'>
                                <option value=" ">--所属省--</option>
                            </select>
                         </div>
                         <div class="btn-group col-sm" id="divCity">
                               <select id="selectCity" class="form-control" name='city'
                               onchange='chgOrgSelectArea(this, "city");'>
                                    <option value=" ">--所属市--</option>
                                </select>
                         </div>
                         <div class="btn-group col-sm">
                                <select id="selectCounty" class="form-control" name='county'>
                                    <option value=" ">--所属区--</option>
                                </select>
                          </div>
                 </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label ">企业注册街道</label>
                <div class="col-sm-4">
                    <input type="text" id="street" name="street" class="form-control input-sm"  placeholder="请输入企业注册街道">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label">企业简介</label>
                <div class="col-sm-4">
                    <input class="form-control input-sm"  id='orgProfile'
                    name='orgProfile' type="text" placeholder="企业简介"> 
                </div>
            </div>
        </div>
     
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label ">联系人</label>
                <div class="col-sm-4">
                    <input type="text" id="contacts" name="contacts" class="form-control input-sm" placeholder="联系人">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label ">联系电话</label>
                <div class="col-sm-4">
                    <input type="text" id="telephone" name="telephone" class="form-control input-sm" placeholder="联系电话">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label ">手机号码</label>
                <div class="col-sm-4">
                    <input type="text" id="cellphone" name="cellphone" class="form-control input-sm" placeholder="请输入手机号码">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label ">传真</label>
                <div class="col-sm-4">
                    <input type="text" id="fax" name="fax" class="form-control input-sm"
                        placeholder="传真">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label">邮箱</label>
                <div class="col-sm-4">
                    <input type="email" id="email" name="email" class="form-control input-sm" placeholder="邮箱">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label ">邮编</label>
                <div class="col-sm-4">
                    <input type="text" id="postcode" name="postcode" class="form-control input-sm" 
                        placeholder="邮编">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label ">网址</label>
                <div class="col-sm-4">
                    <input type="text" id="website" name="website" class="form-control input-sm"  placeholder="网址">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label ">公司地址</label>
                <div class="col-sm-4">
                    <input type="text" id="address" name=""address"" class="form-control input-sm"  placeholder="请输入公司地址">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label">招聘联系人</label>
                <div class="col-sm-4">
                    <input type="text" id="hrContacts" name="hrContacts" class="form-control input-sm" placeholder="请输入招聘联系人">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label ">招聘联系电话</label>
                <div class="col-sm-4">
                    <input type="text" id="hrTelephone" name="hrTelephone" class="form-control input-sm" 
                        placeholder="请输入招聘联系电话">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label ">招聘联系手机号</label>
                <div class="col-sm-4">
                    <input type="text" id="cellphone" name=""cellphone"" class="form-control input-sm"  placeholder="请输入招聘联系手机号">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label ">招聘联系邮箱</label>
                <div class="col-sm-4">
                    <input type="text" id="hrEmail" name="hrEmail" class="form-control input-sm"  placeholder="请输入招聘联系邮箱">
                </div>
            </div>
        </div>
        
        <div class="form-group">
            <div class="inline-row">
                <label class="control-label col-xs-4">上传营业执照</label>
                <div class="col-xs-3">
                    <input class="form-control input-sm col-xs-2" id="licenseImagePath" type="text" readonly="readonly" >
                </div>
                <div class="btn btn-success fileinput-button" style="float: left;" id = "licenseImageSpan">
                        <i class="glyphicon glyphicon-plus"></i>
                        <span>浏览...</span>
                        <input type="file" name="licenseImage" id='licenseImage'>              
                </div>
            </div>
        </div>
        
        <div class="form-group">
            <div class="inline-row">
                <label class="control-label col-xs-4">上传公司logo图片</label>
                <div class="col-xs-3">
                    <input class="form-control input-sm col-xs-2" id='logoImagePath' type="text" readonly="readonly" >
                </div>
                <div class="btn btn-success fileinput-button" style="float: left;" id = "logoImageSpan">
                        <i class="glyphicon glyphicon-plus"></i>
                        <span>浏览...</span>
                        <input type="file" name="logoImage" id='logoImage'>              
                </div>
            </div>
        </div>
        
          <div class="form-group">
              <div class="col-sm-offset-5 col-sm-2">
                 <button  type="button" onclick="add();" class="btn btn-success btn-block">提交</button>
              </div>
           </div>
        <iframe name='post_frame' id="post_frame" style="display:none;" style="display:none;"></iframe> 
    </form>
</div>
</div>
</body>

