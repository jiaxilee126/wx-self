<#include "include/macro.ftl">
    <@header>
    </@header>
    <@sidebar></@sidebar>
<style type="text/css">
    .wx-image{
        width: 100%;
    }
</style>
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
                <div class="col-md-12">
                    <div class="box">
                        <div class="box-header with-border">
                            <h3 class="box-title">项目介绍</h3>

                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                </button>

                                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                            </div>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <div class="row">
                                <div class="col-md-10">
                                    这是一个集成微信小程序及web前后端统一博客展示系统<br>
                                    前端使用小程序展示博客列表，技能列表及工作经历<br>
                                    管理后台采用了SpringBoot，redis，jpa，swagger-ui等技术<br>
                                    项目主要包含4个模块：wxapi/admin/core/common；<br>
                                    &nbsp;&nbsp;&nbsp;&nbsp; wxapi主要是提供给小程序的接口;<br>
                                    &nbsp;&nbsp;&nbsp;&nbsp; admin是管理后台;<br>
                                    &nbsp;&nbsp;&nbsp;&nbsp; core主要针对数据的映射实体类及dao接口;<br>
                                    &nbsp;&nbsp;&nbsp;&nbsp; common是一些公共类包<br>
                                    管理后台示例网址（用户名root，密码123456）：<br>
                                    主要是对个人博客知识点及项目内容的一种管理及展示系统<br>
                                </div>
                                <div class="col-md-2">
                                    <h2>小程序二维码</h2>
                                    <div class="wx-image">
                                        <img class="wx-image" src="/images/wx-chengxu.jpg" >
                                    </div>

                                </div>
                            </div>
                            <div class="row">
                                <!-- /.col -->
                                <div class="col-md-12 pull-right">
                                    <div class="pull-right">
                                        <a class="btn btn-app " href="https://github.com/jiaxilee126/wx-self">
                                            <i class="fa fa-github"></i> GitHub
                                        </a>
                                        <a class="btn btn-app">
                                            <i class="fa fa-google"></i> Gitee
                                        </a>
                                        <a class="btn btn-app">
                                            <i class="fa fa-commenting"></i> CSDN
                                        </a>
                                    </div>

                                </div>
                            </div>

                            <!-- /.row -->
                        </div>
                    </div>
                    <!-- /.box -->
                </div>
                <!-- /.col -->
            </div>
            <#--/.row-->
            <div class="row">
                <div class="col-md-8">
                    <!-- MAP & BOX PANE -->
                    <div class="box box-success">
                        <div class="box-header with-border">
                            <h3 class="box-title">最新文章</h3>

                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                </button>
                                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                            </div>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body no-padding">
                            <div class="row">
                                <div class="col-md-12">
                                    <!-- The time line -->
                                    <ul class="timeline">
                                        <!-- timeline time label -->
                                        <li class="time-label">
                                          <span class="bg-red">
                                            ${.now}
                                          </span>
                                        </li>
                                        <!-- /.timeline-label -->
                                        <!-- timeline item -->
                                        <@blogTag method="recentBlog" pageSize="5">
                                            <#list recentBlog?sort_by('createtime')?reverse as blog>
                                                <li>
                                                    <i class="fa fa-comments"></i>

                                                    <div class="timeline-item">
                                                        <span class="time"><i class="fa fa-clock-o"></i> ${blog.createtime}</span>

                                                        <h3 class="timeline-header"> ${blog.title}</h3>

                                                        <#--<div class="timeline-footer">
                                                            <a class="btn btn-warning btn-flat btn-xs">View comment</a>
                                                        </div>-->
                                                    </div>
                                                </li>

                                            </#list>

                                        </@blogTag>

                                        <!-- END timeline item -->

                                        <!-- END timeline item -->
                                        <li>
                                            <i class="fa fa-clock-o bg-gray"></i>
                                        </li>
                                    </ul>
                                </div>
                                <!-- /.col -->
                                <!-- /.col -->
                            </div>
                            <!-- /.row -->
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <!-- PRODUCT LIST -->
                            <div class="box box-primary">
                                <div class="box-header with-border">
                                    <h3 class="box-title">联系方式</h3>

                                    <div class="box-tools pull-right">
                                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                        </button>
                                        <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>
                                <!-- /.box-header -->
                                <div class="box-body">
                                    <ul class="products-list product-list-in-box">
                                        <li class="item">
                                            <p>邮箱: jiaxiwuli@126.com</p>
                                        </li>
                                        <li class="item">
                                            <p>官网: admin.lijiaxi.com.cn</p>
                                        </li>
                                        <li class="item">
                                            <p>QQ群: 984359427</p>
                                        </li>
                                        <li class="item">
                                            <p>微信: ****</p>
                                        </li>

                                        <!-- /.item -->
                                    </ul>
                                </div>
                                <#--<!-- /.box-body &ndash;&gt;
                                <div class="box-footer text-center">
                                    <a href="javascript:void(0)" class="uppercase">View All Products</a>
                                </div>-->
                                <!-- /.box-footer -->
                            </div>
                            <!-- /.box -->
                        </div>
                        <div class="col-md-6">
                            <!-- PRODUCT LIST -->
                            <div class="box box-primary">
                                <div class="box-header with-border">
                                    <h3 class="box-title">更新日志</h3>

                                    <div class="box-tools pull-right">
                                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                        </button>
                                        <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>
                                <!-- /.box-header -->
                                <div class="box-body">
                                    <ul class="products-list product-list-in-box">
                                        <#--<li class="item">
                                            <div class="product-img">
                                                <img src="dist/img/default-50x50.gif" alt="Product Image">
                                            </div>
                                            <div class="product-info">
                                                <a href="javascript:void(0)" class="product-title">Samsung TV
                                                    <span class="label label-warning pull-right">$1800</span></a>
                                                <span class="product-description">
                                                  Samsung 32" 1080p 60Hz LED Smart HDTV.
                                                </span>
                                            </div>
                                        </li>-->

                                    </ul>
                                </div>
                            </div>
                            <!-- /.box -->
                        </div>
                    </div>
                    <!-- /.box -->
                </div>
                <div class="col-md-4">
                    <!-- Info Boxes Style 2 -->
                    <div class="box box-default">
                        <div class="box-header with-border">
                            <h3 class="box-title">技术选型</h3>

                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                </button>
                                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                            </div>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <div class="row">
                                <div class="col-md-12">
                                    <ul class="chart-legend clearfix">
                                        <li><i class="fa fa-circle-o text-red"></i> SpringBoot</li>
                                        <li><i class="fa fa-circle-o text-green"></i> AdminLTE</li>
                                        <li><i class="fa fa-circle-o text-yellow"></i> Mysql</li>
                                        <li><i class="fa fa-circle-o text-aqua"></i> Redis</li>
                                        <li><i class="fa fa-circle-o text-light-blue"></i> MongoDB</li>
                                        <li><i class="fa fa-circle-o text-gray"></i> 小程序</li>
                                    </ul>
                                </div>

                                <!-- /.col -->
                            </div>
                            <!-- /.row -->
                        </div>
                        <!-- /.box-body -->

                    </div>
                    <div class="box box-default">
                        <div class="box-header with-border">
                            <h3 class="box-title">捐赠</h3>

                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                </button>
                                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                            </div>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <div class="callout bg-gray color-palette">
                                <h4>请作者喝杯咖啡吧！！！</h4>

                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="wx-image">
                                        <img class="wx-image" src="/images/wx-pay.png" >
                                    </div>
                                </div>
                                <!-- /.col -->
                            </div>
                            <!-- /.row -->
                        </div>

                    </div>
                </div>
            </div>

        </section>
        <!-- /.content -->
    </div>
<@footer></@footer>