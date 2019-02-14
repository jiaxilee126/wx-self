<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

        <!-- Sidebar user panel (optional) -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="adminlte/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>Jussi Lee</p>
                <!-- Status -->
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>

        <!-- search form (Optional) -->
        <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
                <input type="text" name="q" class="form-control" placeholder="Search...">
                <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
            </div>
        </form>
        <!-- /.search form -->

        <!-- Sidebar Menu -->
        <ul class="sidebar-menu">
            <li class="header">HEADER</li>
            <!-- Optionally, you can add icons to the links -->
            <li class="active"><a href="/"><i class="fa fa-home"></i> <span>主页</span></a></li>
            <li><a href="/self"><i class="fa fa-heartbeat"></i> <span>个人中心</span></a></li>
            <li class="treeview">
                <a href="#"><i class="fa  fa-file-text-o"></i> <span>文章管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/articles"><i class="fa fa-circle-o"></i> 文章列表</a></li>
                    <li><a href="/types"><i class="fa fa-circle-o"></i> 文章标签</a></li>
                    <li><a href="/publish"><i class="fa fa-circle-o"></i> 文章发布</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#"><i class="fa fa-gears"></i> <span>技能中心</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/techcenter"><i class="fa fa-circle-o"></i> 技能面板</a></li>
                    <li><a href="/techs"><i class="fa fa-circle-o"></i> 技能管理</a></li>
                </ul>
            </li>
        </ul>
        <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
</aside>