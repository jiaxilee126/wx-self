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
                <form>
                    <div class="form-group">
                        <label for="tech-name" class="control-label">技能名称:</label>
                        <input type="text" class="form-control" id="tech-name" name="title">
                    </div>
                    <div class="form-group">
                        <label for="tech-icon" class="control-label">标签图标:</label>
                        <input type="file" class="form-control" id="tech-icon" name="icon">
                    </div>
                    <div class="form-group">
                        <label for="tech-content" class="control-label">技能描述:</label>
                        <textarea class="form-control" id="tech-content" name="content"></textarea>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
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
</script>