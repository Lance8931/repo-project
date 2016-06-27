    <div class="container-fluid">
        <div class="col-lg-3">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="输入文章标题关键字" id="focusListTitle">
                <span class="input-group-btn">
                    <button class="btn btn-default" type="button" onclick="search('focusList',103)"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
                </span>
            </div>
        </div>
        <div class="col-lg-1">
            <select class="form-control" id="focusListEnabled" onchange="search('focunList',103)">
                <option value="1">启用</option>
                <option value="0">禁用</option>
            </select>
        </div>
    </div>
    <div class="container-fluid">
        <div id="focus_toolbar" class="btn-group">
            <button type="button" class="btn btn-default" onClick="redirectAdd(103)">
                <i class="glyphicon glyphicon-plus"></i>
            </button>
            <button type="button" class="btn btn-default" onClick="redirectEdit('#focunList',103)">
                <i class="glyphicon glyphicon-heart"></i>
            </button>
            <button type="button" class="btn btn-default" onClick="changeStatus('#focunList','delete')">
                <i class="glyphicon glyphicon-trash"></i>
            </button>
            <button type="button" class="btn btn-default" onClick="changeStatus('#focunList','enabled')">
                <i class="glyphicon glyphicon-ok"></i>
            </button>
            <button type="button" class="btn btn-default" onClick="changeStatus('#focunList','disabled')">
                <i class="glyphicon glyphicon-remove"></i>
            </button>
        </div>
        <table id="focusList"></table>
    </div>
