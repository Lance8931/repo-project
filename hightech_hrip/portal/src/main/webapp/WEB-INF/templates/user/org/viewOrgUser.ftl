<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>成都高新区人力资源产业园 后台管理</title>
    <#include "../../common/base.ftl"/>
    <#include "../../common/table.ftl"/>
    <@js src="js/jquery/jquery.form.js"/>
    <@js src="js/siping/admin/user/personal-userOrgEdit.js" />
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
            input{
                border: none;
            }
     </style>
</head>
<body>
<script type="text/javascript">
    $(function(){
        $('input').attr('disabled', 'true');
        //$('#org_editForm').form('load', createUrl('userOrg/getUserOrg'));
    });
</script>
<div>
        <ol class="breadcrumb">
            <li><a>系统管理</a></li>
            <li><a href="#">企业用户</a></li>
            <li class="active">企业详情</li>
        </ol>
    </div>
<div class="layer-body">
<div class="container-fluid">
    <form class="form-horizontal" role="form" id='org_detailForm' >
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label ">账号</label>
                <div class="col-sm-4">
                    <span>${(org.orgCode)!''}</span>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label ">工商注册号</label>
                <div class="col-sm-4">
                    <input type="text" id="registeredNo" name="registeredNo" value="${(org.registeredNo)!''}">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label ">企业名称</label>
                <div class="col-sm-4">
                    <input type="text" id="orgName" name="orgName"  value="${(org.orgName)!''}">
                </div>
            </div>
        </div>
        
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label">企业类型</label>
                <div class="col-sm-4">
                    <input type="text" id="orgTypeId" name="orgTypeId" value="${(org.orgTypeId)!''}">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label ">是否是高新企业</label>
               
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label">主营行业</label>
                <div class="col-sm-4">
                    <input type="text" id="industry" name="industry"value="${(org.industry)!''}">
                </div>
            </div>
        </div>
     
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label">企业成立时间</label>
                <div class="col-sm-4">
                    <input value="${(org.foundDate)!''}" name="foundDate"> 
                </div>
            </div>
        </div>
     
        <div class="form-group">
            <div class="inline-row">
                <label class="col-xs-4 control-label">企业所属地区</label>
                <div class="col-xs-4">
                        <input value="${(org.foundDate)!''}"> 
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label ">办公地点</label>
                <div class="col-sm-4">
                    <input type="text" id="address" name="address" value="${(org.address)!''}" >
                </div>
            </div>
        </div>
        
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label">企业简介</label>
                <div class="col-sm-4">
                    <input id='orgProfile'name='orgProfile' type="text"value="${(org.orgProfile)!''}"> 
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label">产品介绍</label>
                <div class="col-sm-4">
                    <input  id='product'name='product' type="text" value="${(org.product)!''}">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label">业务范围</label>
                <div class="col-sm-4">
                     <input  id='businessScope'name='businessScope' type="text" value="${(org.businessScope)!''}">
                </div>
            </div>
        </div>
        
        <div class="form-group">
            <div class="inline-row">
                <label class="control-label col-xs-4">营业执照</label>
                <div class="col-xs-4">
                    
                </div>
            </div>
        </div>
        
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label ">联系人</label>
                <div class="col-sm-4">
                    <input type="text" id="contacts" name="contacts" value="${(org.contacts)!''}">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label ">联系电话</label>
                <div class="col-sm-4">
                    <input type="text" id="telephone" name="telephone"value="${(org.telephone)!''}">
                </div>
            </div>
        </div>
        
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label ">传真</label>
                <div class="col-sm-4">
                    <input type="text" id="fax" name="fax" value="${(org.fax)!''}">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label">邮箱</label>
                <div class="col-sm-4">
                    <input type="email" id="email" name="email"value="${(org.email)!''}" >
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label ">邮编</label>
                <div class="col-sm-4">
                    <input type="text" id="postcode" name="postcode" value="${(org.postcode)!''}">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label ">网址</label>
                <div class="col-sm-4">
                    <input type="text" id="website" name="website" 
                    value="${(org.website)!''}">
                </div>
            </div>
        </div>
    </form>
</div>
</div>
</body>

