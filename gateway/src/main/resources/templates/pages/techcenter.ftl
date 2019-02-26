<#include "include/macro.ftl">
    <@header></@header>
    <@sidebar></@sidebar>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                技能描述
                <small>技能总览概览</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 技能中心</a></li>
                <li class="active">技能描述</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <!-- Your Page Content Here -->

            <h2 class="page-header">Social Widgets</h2>

            <#list techs as x>
                <#if x_index%3 == 0 >
                    <div  class="row">
                        <#list techs as tech>
                            <#if tech_index == x_index || tech_index == x_index+1 || tech_index==x_index+2>
                                <!-- /.col -->
                                <div class="col-md-4">
                                    <!-- Widget: user widget style 1 -->
                                    <div class="box box-widget widget-user">
                                        <!-- Add the bg color to the header using any of the bg-* classes -->
                                        <div class="widget-user-header bg-aqua-active" style="background: url('../dist/img/photo1.png') center center;">
                                            <h3 class="widget-user-username">${tech.title}</h3>
                                            <h5 class="widget-user-desc">${tech.level}</h5>
                                        </div>
                                        <div class="widget-user-image">
                                            <img class="img-circle" src="${tech.icon}" alt="User Avatar">
                                        </div>
                                        <div class="box-footer">
                                            <div class="row">
                                                <div class="col-sm-12">
                                                    ${tech.content}
                                                </div>
                                            </div>
                                            <!-- /.row -->
                                        </div>
                                    </div>
                                    <!-- /.widget-user -->
                                </div>
                                <!-- /.col -->
                            </#if>

                        </#list>
                    </div>
                </#if>
            </#list>



        </section>
        <!-- /.content -->
    </div>
<@footer></@footer>