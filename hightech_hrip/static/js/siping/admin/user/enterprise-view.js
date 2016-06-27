function previewPic(obj){
    $('#previewImg').attr('src', $(obj).attr('src'));
    layer.open({
        type: 1,
        title: false,
        closeBtn: 1,
        area: ['50%', '60%'],
        skin: 'layui-layer-nobg', //没有背景色
        shadeClose: true,
        content: $('#previewImg')
      });
}

function review(){
    var explain = $('#explain').val();
    var review = $('radio');
    console.log(review);
}