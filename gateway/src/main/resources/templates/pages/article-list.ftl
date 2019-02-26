<#include "include/macro.ftl">
<@header></@header>
<@sidebar></@sidebar>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            文章列表
            <#--<small>文章信息概览</small>-->
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 文章管理</a></li>
            <li class="active">文章列表</li>
        </ol>
    </section>

    <!-- Main content -->
    <section class="content">
        <!-- Your Page Content Here -->
        <div class="row">
            <div class="col-xs-12">
                <div class="box">
                    <div class="box-header">
                        <h3 class="box-title">Data Table With Full Features</h3>
                    </div>

                    <!-- /.box-header -->
                    <div class="box-body">
                        <table id="articles" class="table table-bordered table-striped">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>博文名称</th>
                                <th>是否推荐</th>
                                <th>发布日期</th>
                                <th>类型</th>
                            </tr>
                            </thead>
                            <tbody>


                            <#list blogs as blog>
                            <tr>
                                <td>${blog_index}</td>
                                <td>${blog.title}
                                </td>
                                <#if "${blog.recomand}" >
                                    <td> <span class="label label-success">是</span></td>
                                <#else>
                                    <td> <span class="label label-default">否</span></td>
                                </#if>
                                <td>${blog.createtime}</td>
                                <td> <span class="label label-primary">${blog.type}</span></td>
                            </tr>
                            </#list>



                            </tfoot>
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
</script>