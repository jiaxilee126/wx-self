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
            <#-- <@articleTag method="recommendedList" pageSize="8">-->
           <@blogTag  method="recentBlog"  pageSize="3" >
               <#list recentBlog as blog>
                   <div>
                       ${blog_index} ---${blog.title}
                   </div>
               </#list>
           </@blogTag>
            <!-- Your Page Content Here -->

        </section>
        <!-- /.content -->
    </div>
<@footer></@footer>