
<div class="container-fluid">
    <div class="col-lg-3">
        <div class="input-group">
            <input type="text" class="form-control" name="title" placeholder="输入文章标题进行搜索"> <span class="input-group-btn">
                <button class="btn btn-default" type="button">
                    <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                </button>
            </span>
        </div>
    </div>
    <div class="col-lg-2">
        <select class="form-control" id="selectEnabled" onchange="search()">
            <option value="1">启用</option>
            <option value="0">禁用</option>
        </select>
    </div>
</div>
<div class="container-fluid">
    <div id="article_toolbar" class="btn-group">
        <button title="添加" type="button" class="btn btn-default" onClick="redirectAdd()">
            <i class="glyphicon glyphicon-plus"></i>
        </button>
        <button title="修改" id="edit" type="button" class="btn btn-default" onClick="redirectEdit()">
            <i class="glyphicon glyphicon-pencil"></i>
        </button>
        <button title="删除" id="delete" type="button" class="btn btn-default" onClick="changeStatus('delete')">
            <i class="glyphicon glyphicon-trash"></i>
        </button>
    </div>
    <table id="articleList"></table>
</div>