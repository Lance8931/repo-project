<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>成都高新区人力资源产业园 后台管理</title>
    <#include "../../common/base.ftl"/>
    <@js src="js/siping/admin/user/enterprise-view.js" />
    <style type="text/css">
            .text{
                text-align: left;
            }
     </style>
</head>
<body>
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
            <div class="inline-row col-sm-offset-2">
                <div class=" col-sm-10" style="text-align:center; ">
                    <span class="glyphicon glyphicon-th-list">
                        <font style="font-size: 30pt; filter: shadow(color=#9370db); width: 100%; color: #1E90FF; line-height: 150%; font-family: 隶书">${(org.orgName)!''}</font>
                    </span>
                </div>
            </div>
        </div>
        
        <div class="form-group">
            <div class="inline-row col-sm-offset-2">
                <label class=" col-sm-2 control-label">账号</label>
                <div class="col-sm-2  control-label" style="text-align: left">
                    <span>${(org.username)!''}</span> 
                </div>
                <label class="col-sm-2 control-label">工商注册号</label>
                <div class="col-sm-2 control-label" style="text-align: left">
                    <span>${(org.registeredNo)!''}</span> 
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row col-sm-offset-2">
                <label class=" col-sm-2 control-label">企业类型</label>
                <div class="col-sm-2 control-label " style="text-align: left">
                    <span>${(org.orgTypeId)!''}</span> 
                </div>
                <label class="col-sm-2 control-label">高新企业</label>
                <div class="col-sm-2 control-label " style="text-align: left">
                    <span>是</span> 
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row col-sm-offset-2">
                <label class=" col-sm-2 control-label">成立时间</label>
                <div class="col-sm-2 control-label " style="text-align: left">
                    <span>${org.foundDate?datetime?string('yyyy-MM-dd')}</span> 
                </div>
                <label class="col-sm-2 control-label">所属地区</label>
                <div class="col-sm-2 control-label " style="text-align: left">
                    <span>成都市高新区</span> 
                </div>
            </div>
        </div>
        
        <div class="form-group">
            <div class="inline-row col-sm-offset-2">
                <label class="col-sm-2 control-label">办公地点</label>
                <div class="col-sm-8 control-label " style="text-align: left">
                    <span >${(org.address)!''}</span>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row col-sm-offset-2">
                <label class="col-sm-2 control-label">营业执照</label>
                <div class="col-sm-8 control-label " style="text-align: left">
                    <img alt="营业执照" style="cursor:pointer;width: 120px;height: 67px"
                    src="../../../static/imgs/${(org.licensePic)!''}" onclick="previewPic(this)" title="单击预览">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row col-sm-offset-2">
                <label class="col-sm-2 control-label">主营行业</label>
                <div class="col-sm-8 control-label " style="text-align: left">
                    <span >${(org.industry)!''}</span>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row col-sm-offset-2">
                <label class="col-sm-2 control-label">业务范围</label>
                <div class="col-sm-8 control-label " style="text-align: left">
                    <span >${(org.businessScope)!''}</span>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row col-sm-offset-2">
                <label class="col-sm-2 control-label">产品介绍</label>
                <div class="col-sm-8 control-label " style="text-align: left">
                    <span >${(org.product)!''}</span>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row col-sm-offset-2">
                <label class="col-sm-2 control-label">企业简介</label>
                <div class="col-sm-8 control-label " style="text-align: left">
                    <span >${(org.orgProfile)!''}</span>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row col-sm-offset-2">
                <label class="col-sm-2 control-label">联系人</label>
                <div class="col-sm-8 control-label " style="text-align: left">
                    <span >${(org.contacts)!''}</span>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row col-sm-offset-2">
                <label class="col-sm-2 control-label">联系电话</label>
                <div class="col-sm-8 control-label " style="text-align: left">
                    <span >${(org.telephone)!''}</span>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row col-sm-offset-2">
                <label class="col-sm-2 control-label">邮编</label>
                <div class="col-sm-8 control-label " style="text-align: left">
                    <span >${(org.postcode)!''}</span>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row col-sm-offset-2">
                <label class="col-sm-2 control-label">传真</label>
                <div class="col-sm-8 control-label " style="text-align: left">
                    <span >${(org.fax)!''}</span>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row col-sm-offset-2">
                <label class="col-sm-2 control-label">邮箱</label>
                <div class="col-sm-8 control-label " style="text-align: left">
                    <span >${(org.email)!''}</span>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row col-sm-offset-2">
                <label class="col-sm-2 control-label">网址</label>
                <div class="col-sm-8 control-label " style="text-align: left">
                    <span >${(org.website)!''}</span>
                </div>
            </div>
        </div>
        
        <div class="form-group">
            <div class="inline-row col-sm-offset-2">
                <label class="col-sm-2 control-label">审核说明</label>
                <div class="col-sm-8 control-label col-sm-8" style="text-align: left; height: 40px" >
                    <input type="text" class="form-control" id="explain" 
                        placeholder="审核不通过时必须输入该项"/>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row col-sm-offset-2">
                <label class="col-sm-2 control-label">审核意见</label>
                <div class="col-sm-8 control-label" style="text-align: left; height: 40px" >
                    <input type="radio" value="1" name="review" id="review1"><label for="review1">通过</label>
                    <input type="radio" id="review2" value="0" name="review" style="margin-left: 20px"><label for="review2">不通过</label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row col-sm-offset-2">
                <div class="col-sm-offset-4 col-sm-2">
                    <button  type="button" class="btn btn-success btn-block" onclick="review();">审核</button>
                </div>
            </div>
        </div>
    <img id="previewImg" style="width: 100%; height: 100%; display: none" src="" alt="">
    </form>
</div>
</div>
</body>

