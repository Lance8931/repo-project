var ue;
$(function() {
    ue = UE.getEditor('editor');
    initMsgType();
});

function initMsgType() {
    var datas = loadData('get', '/msgType/get');
    var optionsHtml = '<option value="0">请选择</option>';
    if (datas.length > 0) {
        for (var i = 0; i < datas.length; i++) {
            optionsHtml += '<option value="' + datas[i].id + '">' + datas[i].typeName + '</option>';
        }
    }
    $("#selectMsgType").append(optionsHtml);
}

function add() {
    var types = $("#hiddenType").val();
    $("#article").ajaxSubmit({
        url : "add",
        type : 'POST',
        contentType : 'multipart/form-data',
        data : {
            content : UE.getEditor('editor').getContent(),
            msgTypeId : $("#selectMsgType").val(),
            type : $("#hiddenType").val(),
            enabled : $("#selectEnabled").val(),
            title : $("#inputTitle").val(),
            author : $("#inputAuthor").val(),
            files : $("#uploadImage").val(),
            displayPosition : $("#inputDisplayPosition").val()
        },
        success : function(result) {
            if (result.success) {
                layer.alert(result.msg, {
                    icon : 1
                }, function() {
                    if ($("#hiddenType").val() == '001' || $("#hiddenType").val() == '002') {
                        window.location = createUrl("article/redirectArticle?type=1");
                    } else {
                        window.location = createUrl("article/redirectArticle?type=2");
                    }
                });
            } else {
                layer.alert(result.msg, {
                    icon : 2
                });
            }
        },
        error : function(result) {
            layer.alert("操作发生错误！", {
                icon : 2
            });
        }
    });
}

/**
 * 图片上传
 */
$(function() {
    initFileUpload('#uploadImage');
});
function _getOtherData() {// 获取表单其他数据
    var inputList = document.getElementsByTagName("input");
    var inputValue = {};
    for (var i = 0; (inputList != null) && (i < inputList.length); i++) {
        inputValue[inputList[i].name] = inputList[i].value;
    }
    inputValueArr = JSON.stringify(inputValue)
    return inputValueArr;
}

/**
 * 判断图片尺寸
 * 
 * @param files
 */
function handleFiles(files) {
    var img = new Image(), url = img.src = URL.createObjectURL(files[0]);
    layer.open({
           type: 1,
           title: false,
           closeBtn: 1,
           area: '80%',
           skin: 'layui-layer-nobg', //没有背景色
           content: $('#clipping')
      });
    
    return false;
    /* for (i = 0; i < files.length; i++) {
        file = files[i]
        var reader = new FileReader()
        ret = []
        reader.onload = function(theFile) {
            var image = new Image();

            image.onload = function() {
                if (0.6 < (this.height / this.width) || (this.height / this.width) < 0.5) {
                    layer.alert("图片尺寸不准确，请上传 1 : 0.5-0.6 的图片</br>如：</br>长：85-100px</br>宽：50px-60px </br>", {
                        icon : 2
                    }, function(index) {
                        $(".hidden-xs").trigger("click");
                        layer.close(index);
                    });
                }
            };
            image.src = theFile.target.result;
        }
        reader.onerror = function(stuff) {
            console.log("error", stuff)
            console.log(stuff.getMessage())
        }
        reader.readAsDataURL(file);
    }*/
}
function initFileUpload(ctrlName) {
    $(ctrlName).fileinput({
        language : 'zh', // 设置语言
        maxFileCount : 1, // 表示允许同时上传的最大文件个数
        allowedFileExtensions : [ 'jpeg', 'jpg', 'png', 'gif', 'bmp', 'tif' ],// 接收的文件后缀
        autoReplace : true,// 超过最大上传个数 覆盖
        showPreview : false, // 是否显示预览
        showUpload : false, // 是否显示上传按钮
        showCaption : true, // 是否显示标题
        showClose : true, // 关闭窗口
        showUploadedThumbs : false,
        dropZoneEnabled : true, // 是否允许拖拽
        initialPreviewShowDelete : true, // 修改初始化时显示删除按钮
        overwriteInitial : false, // 修改时不覆盖原有文件
        maxImageWidth : 2160,
        maxImageHeight : 1200,
    })
}


$(function () {

    'use strict';

    var console = window.console || { log: function () {} },
        $alert = $('.docs-alert'),
        $message = $alert.find('.message'),
        showMessage = function (message, type) {
          $message.text(message);

          if (type) {
            $message.addClass(type);
          }

          $alert.fadeIn();

          setTimeout(function () {
            $alert.fadeOut();
          }, 3000);
        };

    // Demo
    // -------------------------------------------------------------------------

    (function () {
      var $image = $('.img-container > img'),
          $dataX = $('#dataX'),
          $dataY = $('#dataY'),
          $dataHeight = $('#dataHeight'),
          $dataWidth = $('#dataWidth'),
          $dataRotate = $('#dataRotate'),
          options = {
            
            aspectRatio: 16 / 9,//设置截图框比例
            preview: '.img-preview',
            crop: function (data) {
              $dataX.val(Math.round(data.x));
              $dataY.val(Math.round(data.y));
              $dataHeight.val(Math.round(data.height));
              $dataWidth.val(Math.round(data.width));
              $dataRotate.val(Math.round(data.rotate));
            }
            
          };

      $image.on({
        'build.cropper': function (e) {
          //console.log(e.type);
        },
        'built.cropper': function (e) {
          //console.log(e.type);
        },
        'dragstart.cropper': function (e) {
          //console.log(e.type, e.dragType);
        },
        'dragmove.cropper': function (e) {
          //console.log(e.type, e.dragType);
        },
        'dragend.cropper': function (e) {
          //console.log(e.type, e.dragType);
        },
        'zoomin.cropper': function (e) {
          //console.log(e.type);
        },
        'zoomout.cropper': function (e) {
          //console.log(e.type);
        }
      }).cropper(options);


      // Methods
      $(document.body).on('click', '[data-method]', function () {
        var data = $(this).data(),
            $target,
            result;

        if (data.method) {
          data = $.extend({}, data); // Clone a new one

          if (typeof data.target !== 'undefined') {
            $target = $(data.target);

            if (typeof data.option === 'undefined') {
              try {
                data.option = JSON.parse($target.val());
              } catch (e) {
                console.log(e.message);
              }
            }
          }

          result = $image.cropper(data.method, data.option);

          if (data.method === 'getCroppedCanvas') {
            $('#getCroppedCanvasModal').modal().find('.modal-body').html(result);
          }

          if ($.isPlainObject(result) && $target) {
            try {
              $target.val(JSON.stringify(result));
            } catch (e) {
              console.log(e.message);
            }
          }

        }
      }).on('keydown', function (e) {

        switch (e.which) {
          case 37:
            e.preventDefault();
            $image.cropper('move', -1, 0);
            break;

          case 38:
            e.preventDefault();
            $image.cropper('move', 0, -1);
            break;

          case 39:
            e.preventDefault();
            $image.cropper('move', 1, 0);
            break;

          case 40:
            e.preventDefault();
            $image.cropper('move', 0, 1);
            break;
        }

      });


      // Import image
      var $inputImage = $('#uploadImage'),
          URL = window.URL || window.webkitURL,
          blobURL;

      if (URL) {
        $inputImage.change(function () {
          var files = this.files, file;
          if (files && files.length) {
              $('#clipping').attr('style', 'display: table;');
            file = files[0];
            if (/^image\/\w+$/.test(file.type)) {
              blobURL = URL.createObjectURL(file);
              /*出错*/
              $image.one('built.cropper', function () {
                URL.revokeObjectURL(blobURL); // Revoke when load complete
              }).cropper('reset', true).cropper('replace', blobURL);
              
              //$inputImage.val('');
            } else {
              showMessage('请选择一个文件');
            }
            
            layer.open({
                type: 1,
                title: false,
                closeBtn: 0,
                area: '60%',
                skin: 'layui-layer-nobg', //没有背景色
                content: $('#clipping'),
                end : function(){
                    $('.fileinput-remove-button').on('click', function(){
                        $('#previewDiv').attr('style', 'display: none;');
                    });
                    $('#previewDiv').attr('style', 'display: table;');
                }
              });
          }
        });
      } else {
        $inputImage.parent().remove();
      }

    }());

  });

function getImage(){
    layer.closeAll('page');
}