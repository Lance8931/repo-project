<div class="container-fluid">
    <div class="col-lg-3">
        <div class="input-group">
            <input type="text" class="form-control" placeholder="输入文章标题关键字" id="title">
            <span class="input-group-btn">
                <button class="btn btn-default" type="button" onclick="search()"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
            </span>
        </div>
    </div>
    <div class="col-lg-1">
        <select class="form-control" id="selectEnabled" onchange="search()">
            <option value="1">启用</option>
            <option value="0">禁用</option>
        </select>
    </div>
</div>
<div class="container-fluid">
    <div id="table_toolbar" class="btn-group">
        <button type="button" class="btn btn-default" id="add" title="添加" onClick="redirectAdd()">
            <i class="glyphicon glyphicon-plus"></i>
        </button>
        <button type="button" class="btn btn-default" id="edit" title="修改" onClick="redirectEdit()">
            <i class="glyphicon glyphicon-pencil"></i>
        </button>
        <button type="button" class="btn btn-default" id="delete" title="删除" onClick="changeStatus('delete')">
            <i class="glyphicon glyphicon-trash"></i>
        </button>
        <button type="button" class="btn btn-default" id="use" title="启用" onClick="changeStatus('enabled')">
            <i class="glyphicon glyphicon-ok-circle"></i>
        </button>
        <button type="button" class="btn btn-default" id="ban" title="禁用" onClick="changeStatus('disabled')">
            <i class="glyphicon glyphicon-ban-circle"></i>
        </button>
    </div>
    <table id="tableList"></table>
    <img id="previewImg" style="width: 100%; height: 60%; display: none" src="" alt="">
</div>