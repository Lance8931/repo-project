function initDetailGrid(){
	$('#dg1').datagrid({
		fit : true,
	    fitColumns : true,
	    rownumbers : true,
	    singleSelect : true,
	    iconCls : 'icon-edit',
	    idField : 'id',
	    loadMsg : '加载中',
	    onClickCell: onClickCell,
	    onEndEdit: onEndEdit,
	    toolbar: [{
					iconCls: 'icon-add',
					text: '新增一行',
					handler: function(){
						append();
					}
				},'-',
				{
					iconCls: 'icon-remove',
					text:'移除',
					handler: function(){
						removeit();
					}
				}],
	    columns:[
	             [    
			        {field:'phoneId', title:'phoneId', hidden:true },
			        {field:'imeiNo', title:'手机串号', width:1,
			        		editor:{
			        			type:'textbox',
			        			options:{required:true}
			        		}
			        },    
			        {field:'brandId', title:'手机牌子', width:1, 
			        		formatter: function(value,row){return row.brand;},
			        		editor:{
			        			type:'combobox',
			        			options:{
			        				valueField:'id',
	                				textField:'text',
	                				method:'get',
	                				url:'../resources/json/brand.json',
	                				required:true
			        			}
			        	    }
			        },    
			        {field:'colorId', title:'手机颜色', width:1, 
			        		formatter: function(value,row){return row.color;},
			        		editor:{
			        			type:'combobox',
			        			options:{
			        				valueField:'id',
	                				textField:'text',
	                				method:'get',
	                				url:'../resources/json/color.json',
	                				required:true
			        			}
			        		}
			        },    
			        {field:'modelId', title:'手机型号', width:1,
			        		formatter:function(value,row){
	                			return row.model;
	                		},
	                		editor:{
	                			type:'combobox',
	                			options:{
	                				valueField:'id',
	                				textField:'text',
	                				method:'get',
	                				url:'../resources/json/model.json',
	                				required:true
	                			}
	                		}
	                },    
			        {field:'price', title:'价格', width:1,
			        		editor:{
			        			type:'numberbox',
			        			options:{
			        				precision:1,
			        				required:true
			        			}
			        		}
			        }
	              ]
	            ]  ,
	    loading:true 
	});
}

var editIndex = undefined;
function endEditing(){
    if (editIndex == undefined){return true}
    if ($('#dg1').datagrid('validateRow', editIndex) && !isExist){
        $('#dg1').datagrid('endEdit', editIndex);
        editIndex = undefined;
        return true;
    } else {
        return false;
    }
}
function onClickCell(index, field){
    if (editIndex != index){
        if (endEditing()){
            $('#dg1').datagrid('selectRow', index)
                    .datagrid('beginEdit', index);
            var ed = $('#dg1').datagrid('getEditor', {index:index,field:field});
            if (ed){
                ($(ed.target).data('textbox') ? $(ed.target).textbox('textbox') : $(ed.target)).focus();
            }
            editIndex = index;
        } else {
            setTimeout(function(){
                $('#dg1').datagrid('selectRow', editIndex);
            },0);
        }
    }
}
function onEndEdit(index, row){
	if(imeiNoCheck(row.imeiNo)){
		alert("该串号已经存在。");
	}
    var ed = $(this).datagrid('getEditor', {
        index: index,
        field: 'colorId'
    });
    row.color = $(ed.target).combobox('getText');
    ed = $(this).datagrid('getEditor', {
        index: index,
        field: 'brandId'
    });
    row.brand = $(ed.target).combobox('getText');
    ed = $(this).datagrid('getEditor', {
        index: index,
        field: 'modelId'
    });
    row.model = $(ed.target).combobox('getText');
    ed = $(this).datagrid('getEditor', {
        index: index,
        field: 'brandId'
    });
}
function append(){
    if (endEditing()){
        $('#dg1').datagrid('appendRow',{});
        editIndex = $('#dg1').datagrid('getRows').length-1;
        $('#dg1').datagrid('selectRow', editIndex)
                .datagrid('beginEdit', editIndex);
    }
}
function removeit(){
    if (editIndex == undefined){return}
    $('#dg1').datagrid('cancelEdit', editIndex)
            .datagrid('deleteRow', editIndex);
    editIndex = undefined;
}
function accept(){
    if (endEditing()){
        console.info($('#dg1').datagrid('acceptChanges'));
    }
}
function reject(){
    $('#dg1').datagrid('rejectChanges');
    editIndex = undefined;
}
function getChanges(){
    var rows = $('#dg1').datagrid('getChanges');
    alert(rows.length+' rows are changed!');
}

var isExist;
function imeiNoCheck(imeiNo){
	$.getJSON("../phone/imeiNoCheck?imeiNo="+imeiNo,function(result){
		isExist = result.success;
	});
	return isExist;
}