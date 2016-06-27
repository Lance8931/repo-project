<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>成都高新区人力资源产业园 后台管理</title>
    <#include "../../common/base.ftl"/>
    <@js src="js/jquery/jquery.form.js"/>
    <@js src="js/layer/layer.js" />
    <@js src="js/siping/admin/user/enterprise-apply.js" />
    <style type="text/css">
        .required{
            color: red;
        }
        .binsinss{
            padding-left: 1%;
        }
    </style>
</head>
<body onkeydown="if(event.keyCode==13){return false}">
<div>
    <ol class="breadcrumb">
        <li><a>系统管理</a></li>
        <li><a href="#">企业用户</a></li>
        <li class="active">企业详情</li>
    </ol>
</div>

<div class="layer-body">
<div class="container-fluid">
    <form class="form-horizontal" role="form" method="post" id='applyForm' 
        action="" enctype="multipart/form-data">
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label ">企业名称(全称)<span class='required'> *</span></label>
                <div class="col-sm-4">
                    <input type="text" id="username" name="username" class="form-control input-sm" required placeholder="企业名称，必填">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label ">企业注册地<span class='required'> *</span></label>
                <div class="col-sm-4">
                    <input type="radio" value="1" id="regist_p1" name="registPlace"><label for="regist_p1">本企业已在成都注册</label><br>
                    <input type="radio" value="2" id="regist_p2" name="registPlace"><label for="regist_p2">本企业已在国内注册，但未入住成都</label><br>
                    <input type="radio" value="3" id="regist_p3" name="registPlace"><label for="regist_p3">本企业未入住中国</label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label ">本企业在成都注册地<span class='required'> *</span></label>
                <div class="col-sm-2">
                    <select id="enabled" class="form-control" onchange="refresh();">
                        <option value="">--请选择--</option>
                        <option value="1">高新区</option>
                        <option value="2">锦江区</option>
                        <option value="3">成华区</option>
                        <option value="4">武侯区</option>
                        <option value="5">金牛区</option>
                        <option value="6">青羊区</option>
                        <option value="7">其他</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label ">本企业在国内总部所在地<span class='required'> *</span></label>
                <div class="col-sm-4">
                    <input type="text" id="username" name="username" class="form-control input-sm" required placeholder="企业总部在国内所在地，必填">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label ">本企业总部所在国家<span class='required'> *</span></label>
                <div class="col-sm-4">
                    <input type="text" id="username" name="username" class="form-control input-sm" required placeholder="企业总部所在国家，必填">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label ">联系人<span class='required'> *</span></label>
                <div class="col-sm-4">
                    <input type="text" id="username" name="username" class="form-control input-sm" required placeholder="联系人，必填">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label ">联系人职务<span class='required'> *</span></label>
                <div class="col-sm-4">
                    <input type="text" id="username" name="username" class="form-control input-sm" required placeholder="联系人职务，必填">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label ">联系电话<span class='required'> *</span></label>
                <div class="col-sm-4">
                    <input type="text" id="username" name="username" class="form-control input-sm" required placeholder="联系电话，必填">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label ">联系人Email<span class='required'> *</span></label>
                <div class="col-sm-4">
                    <input type="text" id="username" name="username" class="form-control input-sm" required placeholder="联系人邮箱，必填">
                </div>
            </div>
        </div>
        <!-- 企业经营情况 -->
        <div class="form-group">
            <div class="inline-row">
                <label class="col-sm-4 control-label ">本企业主营业务方向<span class='required'> *</span></label>
                <div class="col-sm-1">
                    <input type="checkbox" id="bs_1" name="businessScope" value="" class="col-sm-offset-4 binsinss"><label for="bs_1">在线招聘</label>
                </div>
                <div class="col-sm-1">
                    <input type="checkbox" id="bs_2" name="businessScope" value="">
                    <label for="bs_2">猎头</label>
                </div>
                <div class="col-sm-1">
                    <input type="checkbox" id="bs_3" name="businessScope" value="">
                    <label for="bs_3">培训</label>
                </div>
                <div class="col-sm-1">
                    <input type="checkbox" id="bs_4" name="businessScope" value="">
                    <label for="bs_4">人才派遣</label>
                </div>
            </div>
            
        </div>
        <div class="form-group">
            <label class="col-sm-4 control-label "></label>
            <div class="inline-row">
                <div class="inline-row">
	                <div class="col-sm-1">
	                    <input type="checkbox" id="bs_5" name="businessScope" value="">
	                    <label for="bs_5">人事代理</label>
	                </div>
	                <div class="col-sm-1">
	                    <input type="checkbox" id="bs_6" name="businessScope" value="">
	                    <label for="bs_6">招聘流程外包</label>
	                </div>
	                <div class="col-sm-1">
	                    <input type="checkbox" id="bs_7" name="businessScope" value="">
	                    <label for="bs_7">薪酬外包</label>
	                </div>
	                <div class="col-sm-1">
	                    <input type="checkbox" id="bs_8" name="businessScope" value="" >
	                    <label for="bs_8">人力资源咨询</label>
	                </div>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-4 control-label "></label>
            <div class="inline-row">
                <div class="inline-row">
                    <div class="col-sm-1">
                        <input type="checkbox" id="bs_9" name="businessScope" value="">
                        <label for="bs_9">人才测评</label>
                    </div>
                    <div class="col-sm-1">
                        <input type="checkbox" id="bs_10" name="businessScope" value="">
                        <label for="bs_10">人才评鉴</label>
                    </div>
                    <div class="col-sm-1">
                        <input type="checkbox" id="bs_11" name="businessScope" value="">
                        <label for="bs_11">考试服务</label>
                    </div>
                    <div class="col-sm-1">
                        <input type="checkbox" id="bs_12" name="businessScope" value="" >
                        <label for="bs_12">背景调查</label>
                    </div>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-4 control-label "></label>
            <div class="inline-row">
                <div class="inline-row">
                    <div class="col-sm-1">
                        <input type="checkbox" id="bs_13" name="businessScope" value="">
                        <label for="bs_13">人力资源管理系统</label>
                    </div>
                    <div class="col-sm-1">
                        <input type="checkbox" id="bs_14" name="businessScope" value="">
                        <label for="bs_14">人才管理软件</label>
                    </div>
                    <div class="col-sm-1">
                        <input type="checkbox" id="bs_15" name="businessScope" value="">
                        <label for="bs_15">招聘管理软件</label>
                    </div>
                    <div class="col-sm-1">
                        <input type="checkbox" id="bs_16" name="businessScope" value="" >
                        <label for="bs_16">e-Learning</label>
                    </div>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-4 control-label ">本企业2015年营业额<span class='required'> *</span></label>
            <div class="inline-row">
                <div class="col-sm-2">
                    <input type="radio" value="一亿元以上" id="turnover_1" name="turnover">
                    <label for="turnover_1">一亿元以上</label>
                </div>
                <div class="col-sm-2">
                    <input type="radio" value="5000万 - 1亿元" id="turnover_2" name="turnover">
                    <label for="turnover_2">5000万 - 1亿元</label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-4 control-label "></label>
            <div class="inline-row">
                <div class="col-sm-2">
                    <input type="radio" value="1000万-5000万" id="turnover_3" name="turnover">
                    <label for="turnover_3">1000万-5000万</label>
                </div>
                <div class="col-sm-2">
                    <input type="radio" value="500万 - 1000万" id="turnover_4" name="turnover">
                    <label for="turnover_4">500万 - 1000万</label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-4 control-label "></label>
            <div class="inline-row">
                <div class="col-sm-2">
                    <input type="radio" value="200万 - 500万" id="turnover_5" name="turnover">
                    <label for="turnover_5">200万 - 500万</label>
                </div>
                <div class="col-sm-2">
                    <input type="radio" value="200万以下" id="turnover_6" name="turnover">
                    <label for="turnover_6">200万以下</label>
                </div>
            </div>
        </div>
        
        
        
    </form>
</div>
</div>
</body>

