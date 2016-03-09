$(function(){
	getProblemList(1,10);
	sipingUI.eventBinding($("*"));
});

var option;

function getProblemList(pageNo, pageSize){
	option = {
	        gridId : "problem_list_grid",
	        height : "520px",
	        ajax : {
	            type : "post",
	            url : "/problem/getlist/data",
	            async : true, 
	            data: {pageNo:pageNo, pageSize:pageSize, keyword: $("#problem_theme_search").val()},
	            contentType : 'application/json'
	        },
	        header : [
	              {width : "10%",name : "主题"},
	              {width : "10%",name : "内容"},
	              {width : "20%",name : "提问时间"},
	              {width : "10%",name : "提问人昵称"}
	        ],
	        column : ["theme","content","problemDate","nickName"],
	        page : {options : [10,20,30,50,80], fn : "getProblemList"},
	        rowNum : true,
	        checkBox : true,
	        idColomn : 'id'
	    };
    sipingUI.fillGridBySelf(option);
}
function submitProblem(){
	$.ajax({
        type : "POST",
        url : "/problem/add",
        async : false,
        data : JSON.stringify({theme:$("#problem_theme").val(),content:$("#problem_content").val()}),
        contentType : 'application/json',
        dataType : "json",
        success : function(data) {
            layer.alert(data.msg);
            getProblemList(1,10);
            /* var date = new Date();
            date.setTime(data.addTime);
            alert(date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate());*/
        }
    });
}

function problemDetail(id){
	window.location = "http://localhost:8080/problem/detail?id="+id;
}

function getOneProblem(){
	var checkNums = 0;
	var id;
	$("#problem_list_grid").find("tbody :checkbox").each(function(){
		if(this.checked){
			checkNums++;
			if(checkNums > 1){
				return false;
			}
			if(checkNums == 1){
				id = $(this).attr("keyid");
			}
		}
	});
	if(checkNums != 1){
		layer.alert("请选择一条数据"+id);
		return;
	} else {
		problemDetail(id);
	}
}