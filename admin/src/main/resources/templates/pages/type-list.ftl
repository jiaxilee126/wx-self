<#include "include/macro.ftl">
<@header></@header>
<@sidebar></@sidebar>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            标签列表
        <#--<small>文章信息概览</small>-->
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 文章管理</a></li>
            <li class="active">文章标签</li>
        </ol>
    </section>

    <!-- Main content -->
    <section class="content">
        <!-- Your Page Content Here -->

        <div class="row">
            <div class="col-xs-12">
                <div class="box">
                    <div class="box-header">
                        <h3 class="box-title">文章标签</h3>
                        <#--<button type="button" class="btn btn-block btn-success btn-lg"> <span class="fa  fa-plus"></span>增加</button>-->
                    </div>
                    <div class="pull-right">
                        <button type="button" class="btn btn-success btn-sm" data-toggle="modal" data-target="#typeModal" id="addType"> <span class="fa  fa-plus"></span>增加</button>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body">
                        <table id="articles" class="table table-bordered table-striped">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>类型名称</th>
                                <th>图标</th>
                                <th>创建时间</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list types?sort_by('id')?reverse as type>
                            <tr>
                                <td>${type_index}</td>
                                <td>${type.title}
                                </td>
                                <td>${type.icon}</td>
                                <td>${type.createtime}</td>
                            </tr>
                            </#list>


                            </tbody>

                        </table>
                    </div>
                    <!-- /.box-body -->
                </div>
                <!-- /.box -->
            </div>
            <!-- /.col -->
        </div>
        <!-- /.row -->

    </section>
    <!-- /.content -->

    <#--消息提示框-->
    <div class="row" style="z-index: 1051;position:absolute;right:12px;bottom:12px;width: 100%">
        <div class="col-md-3 col-md-offset-9" id="tip"></div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="typeModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">增加标签</h4>
            </div>
            <div class="modal-body">
                <form id="dataform">
                    <div class="form-group">
                        <label for="recipient-name" class="control-label">标签名称:</label>
                        <input type="text" class="form-control" id="type-name" name="title">
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="control-label">标签图标:</label>
                        <input type="text" class="form-control" id="type-icon" name="icon">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>


<@footer></@footer>

<script>
    $(function () {
        $('#articles').DataTable({
            "paging": true,
            "lengthChange": false,
            "searching": false,
            "ordering": true,
            "info": true,
            "autoWidth": false
        });
    });

    //模态框的表单提交
    $('#typeModal').modal({
        backdrop: 'static',
        show: false
    }).on('click', ':submit', function () {
        saveType($(this));
        
    })
    
    function saveType($modal) {
        var type = {
            title: $('#type-name').val(),
            icon: $('#type-icon').val()
        }
        $.ajax({
            data: type,
            url: "/type/add",
            method: 'POST'
        }).done(function (res) {
            if(res.status == 0){
                $('#typeModal').modal('hide');
                tip('alert-success', '保存成功');
                location.reload();
            }else {
                tip('alert-danger', res.msg);
            }
        })
    }
    
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