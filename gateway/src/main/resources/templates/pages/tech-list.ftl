<#include "include/macro.ftl">
    <@header></@header>
    <@sidebar></@sidebar>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                博客中心
                <small>文章信息概览</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
                <li class="active">Here</li>
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
                            <button type="button" class="btn btn-success btn-sm" data-toggle="modal" data-target="#techModal" id="addTech"> <span class="fa  fa-plus"></span>增加</button>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="techs" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>技能名称</th>
                                    <th>图标</th>
                                    <th>熟练级别</th>
                                </tr>
                                </thead>
                                <tbody>
                                <#list techs as tech>
                                <tr>
                                    <td>${tech_index}</td>
                                    <td>${tech.title}</td>
                                    <td>${tech.icon}</td>
                                    <td>${tech.level}</td>
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
<div class="modal fade" id="techModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">增加技能</h4>
            </div>
            <div class="modal-body">
                <form id="tech-form">
                    <div class="form-group">
                        <label for="tech-name" class="control-label">技能名称:</label>
                        <input type="text" class="form-control" id="tech-name" name="title" required>
                    </div>
                    <div class="form-group">
                        <label for="tech-icon" class="control-label">标签图标:</label>
                        <input type="file" class="form-control" id="tech-icon" name="icon" required>
                    </div>
                    <div class="form-group">
                        <label for="tech-content" class="control-label">技能描述:</label>
                        <textarea class="form-control" id="tech-content" name="description" required></textarea>
                    </div>
                    <div class="form-group">
                        <label >
                            <input type="checkbox" name="status" id="status" checked required >是否发布</input>
                        </label>
                    </div>
                    <div class="form-group">
                        <label for="tech-level" class="control-label">熟练级别:</label>
                        <select id="tech-level" class="form-control" name="level">
                            <option value="1">了解</option>
                            <option value="2">一般</option>
                            <option value="3">熟练</option>
                            <option value="4">精通</option>
                        </select>
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
        $('#techs').DataTable({
            "paging": true,
            "lengthChange": false,
            "searching": false,
            "ordering": true,
            "info": true,
            "autoWidth": false
        });
    });

    //模态框的表单提交
    $('#techModal').modal({
        backdrop: 'static',
        show: false
    }).on('click', ':submit', function () {
        $('#tech-form').bootstrapValidator('validate');
        if ($("#tech-form").data('bootstrapValidator').isValid()) {//获取验证结果，如果成功，执行下面代码
            //alert("yes");//验证成功后的操作，如ajax
            saveTech();
        }

    });

    function saveTech() {

        var formData = new FormData();
        formData.append("title",$("#tech-name").val());
        formData.append("description", $('#tech-content').val());
        formData.append("level", $('#tech-level').val());
        formData.append("status",$('#status').is(":checked")?1:0);
        formData.append("file", $('#tech-icon')[0].files[0]);

        $.ajax({
            data: formData ,
            url: "/tech/add",
            method: 'POST',
            cache: false,
            processData: false,
            contentType: false,
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


        $('#tech-form').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                title: {
                    message: '名称验证失败',
                    validators: {
                        notEmpty: {
                            message: '名称不能为空'
                        },
                        stringLength: {
                            min: 6,
                            max: 20,
                            message: "长度为6~20"
                        }
                    }
                },
                description: {
                    validators: {
                        notEmpty: {
                            message: '内容不能为空'
                        }
                    }
                },
                icon: {
                    validators: {
                        notEmpty: {
                            message: '请选择文件'
                        }
                    }
                }

            }
        });

</script>