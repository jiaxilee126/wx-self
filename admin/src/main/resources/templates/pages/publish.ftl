<#include "include/macro.ftl">
<@header></@header>
<@sidebar></@sidebar>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                文章发布
            </h1>
            <#--<ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
                <li class="active">Here</li>
            </ol>-->
        </section>

        <!-- Main content -->
        <section class="content">
            <!-- Your Page Content Here -->

            <div class="row">
                <!-- left column -->
                <div class="col-md-12">
                    <!-- general form elements -->
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">文章发布中心</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form role="form">
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="title">文章标题</label>
                                    <input type="text" name="title" class="form-control" id="title" placeholder="我是标题">
                                </div>
                                <div class="form-group">
                                    <label for="discription">文章简述</label>
                                    <input type="text" class="form-control" name="description" id="description" placeholder="我是一段简短的描述">
                                </div>
                                <div class="form-group">
                                    <label for="articleBox">文章内容</label>
                                    <div>
                                        <div id="articleBox" style="width: 100%;height: 360px;"></div>
                                        <textarea class="form-control col-md-7 col-xs-12" id="content" name="content" style="display: none"></textarea>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="typeid">请选择类型</label>
                                    <select class="form-control" id="typeid" name="typeid">
                                        <@typeTag method="types">
                                            <#if types?exists && (types?size >0)>
                                                <#list types as type>
                                                    <option value="${type.id}">${type.title}</option>
                                                </#list>
                                            </#if>
                                        </@typeTag>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label >
                                        <input type="checkbox" name="recomand" id="recomand" >是否推荐</input>
                                    </label>
                                </div>
                                <div class="form-group">
                                    <label >
                                        <input type="checkbox" name="status" id="status" checked >是否发布</input>
                                    </label>
                                </div>

                            </div>
                            <!-- /.box-body -->

                            <div class="box-footer">
                                <button type="button" id="publish" class="btn btn-primary">Submit</button>
                            </div>
                        </form>
                    </div>
                    <!-- /.box -->

                </div>
                <#--/.left-->
            </div>
            <#-- /.row -->


        </section>
        <!-- /.content -->
        <#--消息提示框-->
        <div class="row" style="z-index: 1051;position:absolute;right:12px;bottom:12px;width: 100%">
            <div class="col-md-3 col-md-offset-9" id="tip"></div>
        </div>
    </div>
<@footer></@footer>

<script src="/editor/wangEditor.min.js"></script>

<script>

    var E = window.wangEditor;
    var editor = new E('#articleBox');
    // debug模式下，有 JS 错误会以throw Error方式提示出来
    editor.customConfig.debug = true;
    // 关闭粘贴样式的过滤
    editor.customConfig.pasteFilterStyle = false;
    // 插入网络图片的回调
    editor.customConfig.linkImgCallback = function(url) {
        console.log(url) // url 即插入图片的地址
    };
    editor.customConfig.zIndex = 100;

    var $content = $('#content');
    editor.customConfig.onchange = function (html) {
        // 监控变化，同步更新到 textarea
        $content.val(html);
        console.log(html);
    };

    // 下面两个配置，使用其中一个即可显示“上传图片”的tab。但是两者不要同时使用！！！
    // editor.customConfig.uploadImgShowBase64 = true   // 使用 base64 保存图片
    // 上传图片到服务器
    editor.customConfig.uploadImgServer = '/qiniu/upload';
    editor.customConfig.uploadFileName = 'file';
    // 将图片大小限制为 5M
    editor.customConfig.uploadImgMaxSize = 5 * 1024 * 1024;
    editor.customConfig.customAlert = function (info) {
        // info 是需要提示的内容
        $.alert.error(info);
    }
    editor.customConfig.uploadImgHooks = {
        error: function (xhr, editor) {
            alert("图片上传出错");
        },
        timeout: function (xhr, editor) {
            alert("请求超时");
        },
        customInsert: function (insertImg, result, editor) {
            // 图片上传并返回结果，自定义插入图片的事件（而不是编辑器自动插入图片！！！）
            // insertImg 是插入图片的函数，editor 是编辑器对象，result 是服务器端返回的结果
            console.log(result)
            console.log('customInsert：' + insertImg, result, editor);
            if(result.status == 0){
                console.log(result.data);
                var imgFullPath = result.data;
                // editor.txt.append(' <a href="' + imgFullPath + '" class="showImage" title="" rel="external nofollow"><img src="' + imgFullPath + '" class="img-responsive  img-rounded" alt="" style="width: 95%;"/></a>');
                editor.txt.append('<img src="' + imgFullPath + '" alt="" style="border-radius: 6px;"/>');
            } else {
                alert(result.message);
            }
        }
    };

    editor.create();


    $('#publish').on('click', function () {
        var blog = {
            title: $('#title').val(),
            description: $('#description').val(),
            content: $('#content').val(),
            recomand: $('#recomand').val(),
            status: $('#status').val()
        }
        console.log(blog)
        $.ajax({
            data: blog,
            url: "/blog/publish",
            method: 'POST'
        }).done(function (res) {
            if(res.status == 0){

                tip('alert-success', '保存成功');
                location.reload();
            }else {
                tip('alert-danger', res.msg);
            }
        })
    })

    function tip(color,content) {
        var html = '<div class="alert ' +
                color +
                ' alert-dismissible">\n' +
                '                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>\n' +
                '                <h4><i class="icon fa fa-ban"></i> Alert!</h4>\n' +
                content +
                '              </div>';
        $('#tip').html(html);
    }



</script>