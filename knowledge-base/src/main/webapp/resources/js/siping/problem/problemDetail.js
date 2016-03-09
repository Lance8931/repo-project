$(function(){
	getAnswerList(1,10);
	sipingUI.eventBinding($("*"));
});

var option;

function getAnswerList(pageNo, pageSize){
	option = {
	        gridId : "problem_list_grid",
	        height : "520px",
	        ajax : {
	            type : "post",
	            url : "/problem/getlist/data",
	            async : true, 
	            data: {pageNo:pageNo, pageSize:pageSize, keyword: $("#problem_id").val()},
	            contentType : 'application/json'
	        },
	        header : [
	              {width : "10%",name : "答案内容"},
	              {width : "10%",name : "答题人昵称"},
	              {width : "20%",name : "答题时间"}
	        ],
	        column : ["content","nickName","answerDate"],
	        page : {options : [10,20,30,50,80], fn : "getAnswerList"},
	        rowNum : true,
	        checkBox : true,
	        idColomn : 'id'
	    };
    sipingUI.fillGridBySelf(option);
}
function submitAnswer(){
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